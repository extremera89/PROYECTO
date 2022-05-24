package dao;

import conexion.Conexion;
import Interfaces.InterfaceCliente;
import modelo.Cliente;
import modelo.Monitor;
import otros.PropertiesBBDD;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DAOcliente implements InterfaceCliente.InterfaceDAOCliente {

    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;

    public DAOcliente() {
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
    public void insertarCliente(Cliente cliente) {

        String sqlPersona = "INSERT INTO " + propiedadesBBDD.getTblPersona() + " (DNI,NOMBRE,APELLIDO1,APELLIDO2,TELEFONO,EMAIL) values (?, ?, ?, ?, ?, ?)";
        String sqlCliente = "Insert into " + propiedadesBBDD.getTblCliente() + " values (?, ?)";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sqlPersona);) {
            pStatement.setString(1, cliente.getDNI());
            pStatement.setString(2, cliente.getNombre());
            pStatement.setString(3, cliente.getApellido1());
            pStatement.setString(4, cliente.getApellido2());
            pStatement.setString(5, cliente.getTelefono());
            pStatement.setString(6, cliente.getEmail());
            filasAfectadas = pStatement.executeUpdate();

            if (filasAfectadas == 1) {
                filasAfectadas = 0;
                try (PreparedStatement pStament = conexion.prepareStatement(sqlCliente);) {
                    pStament.setString(1, cliente.getDNI());
                    pStament.setInt(2, cliente.getEs_Expositor());
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
    public void eliminarCliente(String DNI) {
        String sql = "Delete from " + propiedadesBBDD.getTblCliente() + " where DNI=?";
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
    public Cliente buscarCliente(String DNI) {

        Cliente cliente = null;

        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblCliente() + " WHERE DNI='" + DNI + "'");
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setDNI(rs.getString("DNI"));
                cliente.setEs_Expositor(Integer.parseInt(rs.getString("EsExpositor")));
                try {
                    Statement consulta2 = conexion.createStatement();
                    ResultSet rs2 = consulta2.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblPersona() + " WHERE DNI='" + DNI + "'");
                    while (rs2.next()) {
                        cliente.setNombre(rs2.getString("Nombre"));
                        cliente.setApellido1(rs2.getString("Apellido1"));
                        cliente.setApellido2(rs2.getString("apellido2"));
                        cliente.setTelefono(rs2.getString("Telefono"));
                        cliente.setEmail(rs2.getString("email"));
                    }
                    rs2.close();
                    consulta2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            rs.close();
            consulta.close();
            return cliente;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error el encontrar dicho cliente");
        }

        return null;
    }

    @Override
    public void modificarCliente(String DNI, String nombre, String apellido1, String apellido2, String telefono, String email, int es_Expositor) {
        
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
                String sqlCliente="UPDATE "+propiedadesBBDD.getTblCliente()+" SET "+ "ESEXPOSITOR=?,DNI=? WHERE DNI='"+DNI+"'";
                pStatement2=conexion.prepareStatement(sqlCliente);
                pStatement2.setString(1,DNI);
                pStatement2.setInt(2,es_Expositor);

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
    public ArrayList<Cliente> listarClientes() {
        Cliente cliente;
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblCliente());

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setDNI(rs.getString("DNI"));
                cliente.setEs_Expositor(Integer.parseInt(rs.getString("ESEXPOSITOR")));

                try {
                    Statement consulta2 = conexion.createStatement();
                    ResultSet rs2 = consulta2.executeQuery("SELECT * FROM " + propiedadesBBDD.getTblPersona() + " WHERE DNI='" + cliente.getDNI() + "'");
                    while (rs2.next()) {
                        cliente.setNombre(rs2.getString("Nombre"));
                        cliente.setApellido1(rs2.getString("Apellido1"));
                        cliente.setApellido2(rs2.getString("apellido2"));
                        cliente.setTelefono(rs2.getString("Telefono"));
                        cliente.setEmail(rs2.getString("email"));
                        listaCliente.add(cliente);
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
        return listaCliente;
    }

    public void listarClien() {
        ArrayList<Cliente> prueba = listarClientes();
        for (int i = 0; i < prueba.size(); i++) {
            System.out.println(prueba.get(i));
        }
    }

}
