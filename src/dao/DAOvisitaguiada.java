package dao;

import Interfaces.InterfaceVisitaGuiada;
import conexion.Conexion;
import modelo.Exposicion;
import modelo.VisitaGuiada;
import otros.PropertiesBBDD;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DAOvisitaguiada implements InterfaceVisitaGuiada.InterfaceDAOVisita {

    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;


    public DAOvisitaguiada() {
        try {

            conexion = Conexion.getConexion();
            propiedadesBBDD = new PropertiesBBDD();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void insertarvisita(VisitaGuiada visita) {

        PreparedStatement ps = null;
        String sql = "INSERT INTO "+ propiedadesBBDD.getTblVisita()+ "(numVisita, numPersonas, fecha, centro, DNI_monitor, DNI_cliente, NumExp) VALUES (numVisita.nextval,?,?,?,?,?,?)";

        try{
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, visita.getNumpersonas());
            ps.setDate(2, new java.sql.Date(visita.getFecha().getTime()));
            ps.setString(3, visita.getCentro().getCodCentro());
            ps.setString(4, visita.getDnimonitor().getDNI());
            ps.setString(5, visita.getDnicliente().getDNI());
            ps.setInt(6, visita.getNumExp().getNumExp());


            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha insertado la visita exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar esa visita");


        }
    }
    @Override
    public void eliminarVisita(VisitaGuiada visita) {
        PreparedStatement ps = null;
        String sql = "DELETE FROM "+propiedadesBBDD.getTblVisita()+" WHERE NumVisita=?";

        try{
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, visita.getNumvisita());
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha eliminado la visita exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);


        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar esa visita");
        }
    }
    @Override
    public ArrayList<Integer> expNoDisponibles(java.util.Date fecha){
        ArrayList<Integer> expnodisp = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Statement consulta = conexion.createStatement();
            String fecha2 = format.format(fecha);

            ResultSet rs = consulta.executeQuery("SELECT NumExp FROM "+propiedadesBBDD.getTblExposicion()+" WHERE FechaInicio<= '"+fecha2+"' AND FechaFin >= '"+fecha2+"'"  );
            expnodisp = new ArrayList<>();

            while(rs.next()){
                int exp = Integer.parseInt(rs.getString("NumExp"));
                expnodisp.add(exp);

            }
            rs.close();
            consulta.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar esa exposición");
        }

        return expnodisp;
    }

    @Override
    public ArrayList<VisitaGuiada> listarVisitas() {
        ArrayList<VisitaGuiada> milista = new ArrayList<>();
        VisitaGuiada visita = null;

        try{
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM "+propiedadesBBDD.getTblVisita());

            while(rs.next()){
                visita = new VisitaGuiada();
                visita.setNumvisita(rs.getInt("numVisita"));
                visita.setNumpersonas(rs.getInt("numPersonas"));
                visita.setFecha(rs.getDate("fecha"));
                visita.getCentro().setCodCentro(rs.getString("centro"));
                visita.getDnimonitor().setDNI(rs.getString("DNI_monitor"));
                visita.getDnicliente().setDNI(rs.getString("DNI_cliente"));
                visita.getNumExp().setNumExp(rs.getInt("NumExp"));

                milista.add(visita);
            }
            rs.close();
            consulta.close();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar esa visita");
        }

        return milista;
    }


    @Override
    public VisitaGuiada buscarvisita(int numExp) {
        VisitaGuiada visita = null;

        try{
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM "+propiedadesBBDD.getTblVisita()+" WHERE NumExp = '"+numExp+"'");

            while(rs.next()){
                visita = new VisitaGuiada();
                visita.setNumpersonas(rs.getInt("numPersonas"));
                visita.setFecha(rs.getDate("fecha"));
                visita.getCentro().setCodCentro(rs.getString("centro"));
                visita.getDnimonitor().setDNI(rs.getString("DNI_monitor"));
                visita.getDnicliente().setDNI(rs.getString("DNI_cliente"));
                visita.getNumExp().setNumExp(rs.getInt("NumExp"));

            }
            rs.close();
            consulta.close();
            return visita;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar esa visita");
        }

        return visita;
    }

    @Override
    public int buscarSala(Exposicion exposicion){
        try{
            Exposicion exp = new Exposicion();
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT NumSala FROM "+propiedadesBBDD.getTblExposicion()+" WHERE NumExp = '"+exposicion.getNumExp()+"'");

            while(rs.next()){
                exp.getNumsala().setNumSala(rs.getInt("NumSala"));

            }
            rs.close();
            consulta.close();
            return exp.getNumsala().getNumSala();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar esa visita");
        }

        return 0;
    }

    @Override
    public void modificarVisita(VisitaGuiada visita) {
        PreparedStatement ps = null;
        String sql = "UPDATE "+ propiedadesBBDD.getTblVisita()+ " SET numPersonas=?, fecha=?, centro=?, DNI_monitor=?, DNI_cliente=?, NumExp=? WHERE NumVisita=?";

        try{
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, visita.getNumpersonas());
            ps.setDate(2, new java.sql.Date(visita.getFecha().getTime()));
            ps.setString(3, visita.getCentro().getCodCentro());
            ps.setString(4, visita.getDnimonitor().getDNI());
            ps.setString(5, visita.getDnicliente().getDNI());
            ps.setInt(6, visita.getNumExp().getNumExp());
            ps.setInt(7, visita.getNumvisita());



            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha modificado la visita exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar esa visita");

        }
    }
    @Override
    public VisitaGuiada saberDatos(int numvisita, int numPersonas){
        VisitaGuiada visita = new VisitaGuiada();
        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM "+propiedadesBBDD.getTblVisita() +" WHERE numVisita='" + numvisita + "' AND numPersonas='" + numPersonas+"'");
            while (rs.next()) {
                visita.setNumvisita(rs.getInt("numVisita"));
                visita.setNumpersonas(rs.getInt("numPersonas"));
                visita.setFecha(rs.getDate("fecha"));
                visita.getCentro().setCodCentro(rs.getString("centro"));
                visita.getDnimonitor().setDNI(rs.getString("DNI_monitor"));
                visita.getDnicliente().setDNI(rs.getString("DNI_cliente"));
                visita.getNumExp().setNumExp(rs.getInt("NumExp"));

            }
            rs.close();
            consulta.close();
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR, no tiene número de visita");
        }
        return visita;


    }
    @Override
    public int getNumVisita(VisitaGuiada visita) {
        int numvisita=0;
        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT NumVisita FROM "+propiedadesBBDD.getTblVisita() +" WHERE NumExp='" + visita.getNumExp().getNumExp() + "' AND DNI_monitor='" + visita.getDnimonitor().getDNI() + "' AND DNI_Cliente='" + visita.getDnicliente().getDNI() +"'");
            while (rs.next()) {
                visita.setNumvisita(rs.getInt("NumVisita"));
                numvisita = visita.getNumvisita();
            }
            rs.close();
            consulta.close();
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR, no tiene número de visita");
        }
        return numvisita;

    }



}
