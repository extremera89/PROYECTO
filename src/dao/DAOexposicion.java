package dao;

import Interfaces.InterfaceExposicion;
import conexion.Conexion;
import modelo.Exposicion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.undo.AbstractUndoableEdit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import otros.PropertiesBBDD;
import java.util.Locale;


public class DAOexposicion implements InterfaceExposicion.InterfaceDAOExposicion {
    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;


    public DAOexposicion() {
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
    public int getNumExp(Exposicion exposicion) {
        int numexp=0;
        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT NumExp FROM Exposicion WHERE Nombre='" + exposicion.getNombre() + "' AND Tematica='" + exposicion.getTematica() + "' AND NumSala=" + exposicion.getNumsala());
                while (rs.next()) {
                    exposicion.setNumExp(rs.getInt("NumExp"));
                    numexp = exposicion.getNumExp();
                }
            rs.close();
            consulta.close();
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERROR, no tiene numEXP");
            }
        System.out.println(numexp);
        return numexp;

    }
    @Override
    public void insertarExposicion(Exposicion exposicion) {

        PreparedStatement ps = null;
        String sql = "INSERT INTO "+ propiedadesBBDD.getTblExposicion()+ "(NumExp, Nombre, Tematica, FechaInicio, FechaFin, Descripcion, NumSala) VALUES (NUMEXP.nextval,?,?,?,?,?,?)";

        try{
            ps = conexion.prepareStatement(sql);

            ps.setString(1, exposicion.getNombre());
            ps.setString(2, exposicion.getTematica());
            ps.setDate(3, new java.sql.Date(exposicion.getFechainicio().getTime()));
            ps.setDate(4, new java.sql.Date(exposicion.getFechafin().getTime()));
            ps.setString(5, exposicion.getDescripcion());
            ps.setInt(6, exposicion.getNumsala());


            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha insertado la exposición exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar esa exposición");


        }
    }



    @Override
    public void eliminarExposicion(Exposicion exposicion) {
        PreparedStatement ps = null;
        String sql = "DELETE FROM "+propiedadesBBDD.getTblExposicion()+" WHERE NumExp=?";

        try{
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, exposicion.getNumExp());
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha eliminado la exposición exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);


        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar esa exposición");
        }
    }

    @Override
    public ArrayList<Exposicion> listarExposiciones() {
        ArrayList<Exposicion> milista = new ArrayList<>();
        Exposicion exposicion = null;

        try{
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM "+propiedadesBBDD.getTblExposicion());

            while(rs.next()){
                exposicion = new Exposicion();
                exposicion.setNumExp(rs.getInt("NumExp"));
                exposicion.setNombre(rs.getString("Nombre"));
                exposicion.setTematica(rs.getString("Tematica"));
                exposicion.setFechainicio(rs.getDate("FechaInicio"));
                exposicion.setFechafin(rs.getDate("FechaFin"));
                exposicion.setDescripcion(rs.getString("Descripcion"));
                exposicion.setNumsala(Integer.parseInt(rs.getString("NumSala")));

                milista.add(exposicion);

            }
            rs.close();
            consulta.close();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar esa exposición");
        }

        return milista;
    }

    @Override
    public Exposicion buscarExposicion(String nombre) {
        Exposicion exposicion = null;

        try{
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM "+propiedadesBBDD.getTblExposicion()+" WHERE Nombre = '"+nombre+"'");

            while(rs.next()){
                exposicion = new Exposicion();
                exposicion.setNombre(rs.getString("Nombre"));
                exposicion.setTematica(rs.getString("Tematica"));
                exposicion.setFechainicio(rs.getDate("FechaInicio"));
                exposicion.setFechafin(rs.getDate("FechaFin"));
                exposicion.setDescripcion(rs.getString("Descripcion"));
                exposicion.setNumsala(Integer.parseInt(rs.getString("NumSala")));

            }
            rs.close();
            consulta.close();
            return exposicion;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar esa exposición");
        }

        return null;
    }

    @Override
    public void modificarExposicion(Exposicion exposicion) {
        PreparedStatement ps = null;
        String sql = "UPDATE "+ propiedadesBBDD.getTblExposicion()+ " SET Nombre=?, Tematica=?, FechaInicio=?, FechaFin=?, Descripcion=?, NumSala=? WHERE NumExp=?";

        try{
            ps = conexion.prepareStatement(sql);

            ps.setString(1, exposicion.getNombre());
            ps.setString(2, exposicion.getTematica());
            ps.setDate(3, new java.sql.Date(exposicion.getFechainicio().getTime()));
            ps.setDate(4, new java.sql.Date(exposicion.getFechafin().getTime()));
            ps.setString(5, exposicion.getDescripcion());
            ps.setInt(6, exposicion.getNumsala());
            ps.setInt(7, exposicion.getNumExp());


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha modificado la exposición exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar esa exposición");

        }
    }

    public static void main(String[] args) {

    }






}
