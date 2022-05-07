package dao;

import Interfaces.InterfaceExposicion;
import conexion.Conexion;
import modelo.Exposicion;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import otros.PropertiesBBDD;


public class DAOexposicion implements InterfaceExposicion.InterfaceDAOExposicion {
    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;



    public DAOexposicion(){
        try{

            conexion = Conexion.getConexion();
            propiedadesBBDD = new PropertiesBBDD();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void insertarExposicion(Exposicion exposicion) {
        try{
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("INSERT INTO "+propiedadesBBDD.getTblExposicion()+" values ("+exposicion.getNombre()+", "+exposicion.getTematica()+","
            +exposicion.getFechainicio()+", "+exposicion.getFechafin()+", "+exposicion.getDescripcion()+", "+exposicion.getNumsala()+" )" );
            JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            consulta.close();


        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar ese cliente");
        }
    }

    @Override
    public void eliminarExposicion() {

    }

    @Override
    public ArrayList<Exposicion> listarExposiciones() {
        return null;
    }

    @Override
    public Exposicion buscarExposicion() {
        return null;
    }
}
