package dao;

import Interfaces.InterfaceMonitor;
import conexion.Conexion;
import modelo.Cliente;
import modelo.Monitor;
import otros.PropertiesBBDD;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

        String sqlPersona="INSERT INTO "+propiedadesBBDD.getTblPersona()+" (DNI,NOMBRE,APELLIDO1,APELLIDO2,TELEFONO,EMAIL) values (?, ?, ?, ?, ?, ?)";
        String sqlMonitor = "Insert into " + propiedadesBBDD.getTblMonitor() + " values (?, ?)";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sqlPersona);) {
            pStatement.setString(1, monitor.getDNI());
            pStatement.setString(2, monitor.getNombre());
            pStatement.setString(3, monitor.getApellido1());
            pStatement.setString(4, monitor.getApellido2());
            pStatement.setString(5, monitor.getTelefono());
            pStatement.setString(6, monitor.getEmail());
            filasAfectadas = pStatement.executeUpdate();


            if (filasAfectadas==1){
                filasAfectadas=0;
                try(PreparedStatement pStament = conexion.prepareStatement(sqlMonitor);) {
                    System.out.println("p");
                    pStament.setString(1,monitor.getDNI());
                    System.out.println("p");

                    pStament.setString(2, monitor.getTitulación());
                    filasAfectadas = pStament.executeUpdate();
                }
                catch(SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null,"No se ha podido realizar el registro","error",JOptionPane.ERROR_MESSAGE);
                }
            }

            //JOptionPane.showMessageDialog(null,"Se ha registrado Exitosamente", "Información",JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"No se ha podido realizar el registro","error",JOptionPane.ERROR_MESSAGE);
        }

        filasAfectadas = 0;

    }

    @Override
    public void eliminarMonitor(String DNI) {

    }

    @Override
    public Cliente buscarMonitor(String DNI) {
        return null;
    }

    @Override
    public Cliente modificarMonitor(Monitor monitor) {
        return null;
    }

    @Override
    public ArrayList<Cliente> listarMonitores() {
        return null;
    }

    public static void main(String[] args) {
        Monitor m=new Monitor("77777777L","pepe","mesa","martinez","687532894","email@email.com","Físico");
        DAOmonitor dao=new DAOmonitor();
        dao.insertarMonitor(m);
    }
}
