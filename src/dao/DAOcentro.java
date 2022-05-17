package dao;

import Interfaces.InterfaceCentro;
import conexion.Conexion;
import modelo.Centro;
import otros.PropertiesBBDD;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DAOcentro implements InterfaceCentro.InterfaceDAOCentro {

    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;

    public DAOcentro() {
        try {
            conexion = Conexion.getConexion();
            propiedadesBBDD = new PropertiesBBDD();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void insertarCentro(Centro centro) {
        String sql = "INSERT INTO " + propiedadesBBDD.getTblCentro() + " (codCentro,nombre,numVisita,DNI_cliente,DNI_monitor) values (?, ?, ?, ?, ?)";
        int filasAfectadas = 0;

        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {

            pStatement.setString(1, centro.getCodCentro());
            pStatement.setString(2, centro.getNombre());
            pStatement.setInt(3, centro.getNumVisita());
            pStatement.setString(4, centro.getDniCliente());
            pStatement.setString(5, centro.getDniMonitor());
            filasAfectadas = pStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se ha podido realizar el registro", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void eliminarCentro(String codCentro) {
        String sql = "Delete from " + propiedadesBBDD.getTblCentro() + " where codCentro=?";
        int filasAfectadas = 0;

        try (PreparedStatement pStatement = conexion.prepareStatement(sql);){
            pStatement.setString(1, codCentro);
            filasAfectadas = pStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se ha podido realizar el registro", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Centro buscarCentro(String codCentro) {

        Centro centro = null;
        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblCentro() + " WHERE codCentro='" + codCentro + "'");

            while (rs.next()) {
                centro = new Centro();
                centro.setCodCentro(rs.getString("codCentro"));
                centro.setNombre(rs.getString("nombre"));
                centro.setNumVisita(Integer.parseInt(rs.getString("numVisita")));
                centro.setDniCliente(rs.getString("dni_cliente"));
                centro.setDniMonitor(rs.getString("dni_monitor"));
            }
            rs.close();
            consulta.close();
            return centro;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error el encontrar dicho centro");
        }

        return null;
    }

    @Override
    public void modificarCentro(String codCentro, String nombre, int numVisita, String dniCliente, String dniMonitor) {

        PreparedStatement pStatement=null;
        try {
            String sql = "UPDATE " + propiedadesBBDD.getTblCentro() + " SET " + "codCentro=?, nombre=?,numVisita=?,DNI_cliente=?,DNI_monitor=?, WHERE codCentro='" + codCentro + "'";
            pStatement = conexion.prepareStatement(sql);

            pStatement.setString(1, codCentro);
            pStatement.setString(2, nombre);
            pStatement.setInt(3, numVisita);
            pStatement.setString(4, dniCliente);
            pStatement.setString(5, dniMonitor);

            pStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el centro");
        }
    }

    @Override
    public ArrayList<Centro> listarCentros() {

        Centro centro;
        ArrayList<Centro> listaCentros = new ArrayList<Centro>();

        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblCentro());

            while (rs.next()) {
                centro = new Centro();
                centro.setCodCentro(rs.getString("codCentro"));
                centro.setNombre(rs.getString("nombre"));
                centro.setNumVisita(Integer.parseInt(rs.getString("numVisita")));
                centro.setDniCliente(rs.getString("DNI_cliente"));
                centro.setDniMonitor(rs.getString("DNI_monitor"));

                listaCentros.add(centro);
            }
            rs.close();
            consulta.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return listaCentros;
    }

    public void listarCen() {
        ArrayList<Centro> centr = listarCentros();
        for (int i = 0; i < centr.size(); i++) {
            System.out.println(centr.get(i));
        }
    }

    public static void main(String[] args) {

        Centro c1= new Centro("acfwe","virgen del carmen",0,"94465347T","12345678A");
        DAOcentro dao=new DAOcentro();

        //dao.insertarCentro(c1);
        //dao.eliminarCentro("cen12");
        //System.out.println(dao.buscarCentro("cen12"));
        dao.modificarCentro("cen12","virgen del carmen",2,"94465347T","12345678A");
        //dao.listarCen();
    }
}
