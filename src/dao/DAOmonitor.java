package dao;

import Interfaces.InterfaceMonitor;
import conexion.Conexion;
import modelo.Monitor;
import otros.PropertiesBBDD;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DAOmonitor implements InterfaceMonitor.InterfaceDaoMonitor {

    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;

    public DAOmonitor() {
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
    public void insertarMonitor(Monitor monitor) {

        String sqlPersona = "INSERT INTO " + propiedadesBBDD.getTblPersona() + " (DNI,NOMBRE,APELLIDO1,APELLIDO2,TELEFONO,EMAIL) values (?, ?, ?, ?, ?, ?)";
        String sqlMonitor = "INSERT INTO " + propiedadesBBDD.getTblMonitor() + " values (?, ? )";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sqlPersona);) {
            pStatement.setString(1, monitor.getDNI());
            pStatement.setString(2, monitor.getNombre());
            pStatement.setString(3, monitor.getApellido1());
            pStatement.setString(4, monitor.getApellido2());
            pStatement.setString(5, monitor.getTelefono());
            pStatement.setString(6, monitor.getEmail());
            filasAfectadas = pStatement.executeUpdate();


            if (filasAfectadas == 1) {
                filasAfectadas = 0;
                try (PreparedStatement pStament = conexion.prepareStatement(sqlMonitor);) {
                    System.out.println("p");
                    pStament.setString(1, monitor.getTitulacion());
                    pStament.setString(2, monitor.getDNI());

                    filasAfectadas = pStament.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "No se ha podido realizar el registro", "error", JOptionPane.ERROR_MESSAGE);
                }
            }

            //JOptionPane.showMessageDialog(null,"Se ha registrado Exitosamente", "Información",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se ha podido realizar el registro", "error", JOptionPane.ERROR_MESSAGE);
        }

        filasAfectadas = 0;

    }

    @Override
    public void eliminarMonitor(String DNI) {
        String sql = "Delete from " + propiedadesBBDD.getTblMonitor() + " where DNI=?";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setString(1, DNI);
            filasAfectadas = pStatement.executeUpdate();
            if (filasAfectadas == 1) {
                filasAfectadas = 0;
                String sqlPersona = "Delete from " + propiedadesBBDD.getTblPersona() + " where DNI=?";
                try (PreparedStatement pStatemt = conexion.prepareStatement(sqlPersona);) {
                    pStatemt.setString(1, DNI);
                    filasAfectadas = pStatemt.executeUpdate();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Monitor buscarMonitor(String DNI) {

        Monitor monitor = null;

        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblMonitor() + " WHERE DNI='" + DNI + "'");
            while (rs.next()) {
                monitor = new Monitor();
                monitor.setTitulacion(rs.getString("titulacion"));
                monitor.setDNI(rs.getString("dni"));
                try {
                    Statement consulta2 = conexion.createStatement();
                    ResultSet rs2 = consulta2.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblPersona() + " WHERE DNI='" + DNI + "'");
                    while (rs2.next()) {
                        monitor.setNombre(rs2.getString("Nombre"));
                        monitor.setApellido1(rs2.getString("Apellido1"));
                        monitor.setApellido2(rs2.getString("apellido2"));
                        monitor.setTelefono(rs2.getString("Telefono"));
                        monitor.setEmail(rs2.getString("email"));
                    }
                    rs2.close();
                    consulta2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            rs.close();
            consulta.close();
            return monitor;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error el encontrar dicho monitor");
        }

        return null;
    }

    @Override
    public void modificarMonitor(String DNI, String nombre, String apellido1, String apellido2, String telefono, String email, String titulación){
        PreparedStatement pStatement=null;
        try {
            String sqlPersona="UPDATE "+propiedadesBBDD.getTblPersona()+" SET "+ "DNI=?, NOMBRE=?,APELLIDO1=?,APELLIDO2=?,TELEFONO=?,EMAIL=? WHERE DNI='"+DNI+"'";
            pStatement=conexion.prepareStatement(sqlPersona);
            pStatement.setString(1,DNI);
            pStatement.setString(2,nombre);
            pStatement.setString(3,apellido1);
            pStatement.setString(4,apellido2);
            pStatement.setString(5,telefono);
            pStatement.setString(6,email);

            pStatement.executeUpdate();

            try {
                PreparedStatement pStatement2=null;
                String sqlMonitor="UPDATE "+propiedadesBBDD.getTblMonitor()+" SET "+ "DNI=?, TITULACION=? WHERE DNI='"+DNI+"'";
                pStatement2=conexion.prepareStatement(sqlMonitor);
                pStatement2.setString(1,DNI);
                pStatement2.setString(2,titulación);

                pStatement2.executeUpdate();
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente");
        }
    }

    @Override
    public ArrayList<Monitor> listarMonitores() {
        Monitor monitor;
        ArrayList<Monitor> listarMonitor = new ArrayList<Monitor>();

        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblMonitor());

            while (rs.next()) {
                monitor = new Monitor();
                monitor.setTitulacion(rs.getString("titulacion"));
                monitor.setDNI(rs.getString("dni"));

                try {
                    Statement consulta2 = conexion.createStatement();
                    ResultSet rs2 = consulta2.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblPersona() + " WHERE DNI='" + monitor.getDNI() + "'");
                    while (rs2.next()) {
                        monitor.setNombre(rs2.getString("Nombre"));
                        monitor.setApellido1(rs2.getString("Apellido1"));
                        monitor.setApellido2(rs2.getString("apellido2"));
                        monitor.setTelefono(rs2.getString("Telefono"));
                        monitor.setEmail(rs2.getString("email"));
                        listarMonitor.add(monitor);
                    }
                    rs2.close();
                    consulta2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            rs.close();
            consulta.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return listarMonitor;
    }

    public void listarMonis() {
        ArrayList<Monitor> prueba = listarMonitores();
        for (int i = 0; i < prueba.size(); i++) {
            System.out.println(prueba.get(i));
        }
    }
}