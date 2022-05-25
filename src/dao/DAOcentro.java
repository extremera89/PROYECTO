package dao;

import Interfaces.InterfaceCentro;
import conexion.Conexion;
import modelo.Centro;
import modelo.Cliente;
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

        String sql = "INSERT INTO " + propiedadesBBDD.getTblCentro() + " (codCentro,nombre,numVisita,DNI_cliente,DNI_monitor) values (?, ?, ?, ?)";
        int filasAfectadas = 0;

        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {

            pStatement.setString(1, centro.getCodCentro());
            pStatement.setString(2, centro.getNombre());
            pStatement.setString(3, centro.getDniCliente().getDNI());
            pStatement.setString(4, centro.getDniMonitor().getDNI());
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
        Cliente dni_cliente=new Cliente();

        Centro centro = null;
        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblCentro() + " WHERE codCentro='" + codCentro + "'");

            while (rs.next()) {
                centro = new Centro();
                centro.setCodCentro(rs.getString("codCentro"));
                centro.setNombre(rs.getString("nombre"));
                centro.getDniCliente().setDNI(rs.getString("dni_cliente"));
                centro.getDniMonitor().setDNI(rs.getString("dni_monitor"));
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
    public void modificarCentro(Centro centro) {

        PreparedStatement pStatement=null;
        try {
            String sql = "UPDATE " + propiedadesBBDD.getTblCentro() + " SET " + "CODCENTRO=?, NOMBRE=?,DNI_CLIENTE=?,DNI_MONITOR=? WHERE CODCENTRO='" + centro.getCodCentro() + "'";
            pStatement = conexion.prepareStatement(sql);

            pStatement.setString(1, centro.getCodCentro());
            pStatement.setString(2, centro.getNombre());
            pStatement.setString(3, centro.getDniCliente().getDNI());
            pStatement.setString(4, centro.getDniMonitor().getDNI());

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
                centro.getDniCliente().setDNI(rs.getString("dni_cliente"));
                centro.getDniMonitor().setDNI(rs.getString("dni_monitor"));

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

}
