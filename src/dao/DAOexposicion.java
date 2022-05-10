package dao;

import Interfaces.InterfaceExposicion;
import conexion.Conexion;
import modelo.Exposicion;

import javax.swing.*;
import javax.swing.undo.AbstractUndoableEdit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import otros.PropertiesBBDD;
import java.util.Date;


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
        String nombre = exposicion.getNombre();
        String tematica = exposicion.getTematica();
        Date fechainicio = exposicion.getFechainicio();
        Date fechafin = exposicion.getFechafin();
        String desc = exposicion.getDescripcion();
        int numsala = exposicion.getNumsala();


        String sql = "INSERT INTO "+propiedadesBBDD.getTblExposicion()+" values ('"+nombre+"', '"+tematica+"','"
                +fechainicio+"', '"+fechafin+"', '"+desc+"', '"+numsala+"')" ;
        try{
            Statement consulta = conexion.createStatement();
            consulta.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Se ha actualizado la exposición exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            consulta.close();


        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar esa exposición");

        }
    }

    @Override
    public void eliminarExposicion(Exposicion exposicion) {
        try{
            String sql = "DELETE FROM "+propiedadesBBDD.getTblExposicion()+" WHERE Nombre = "+exposicion.getNombre();
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate(sql);
            consulta.close();


        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar esa exposición");
        }
    }

    @Override
    public ArrayList<Exposicion> listarExposiciones() {
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Exposicion> milista = new ArrayList<>();
        Exposicion exposicion = null;

        try{
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM "+propiedadesBBDD.getTblExposicion());

            while(rs.next()){
                System.out.println("prueba listar exposiciones");
                exposicion = new Exposicion();
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
        String nombre = exposicion.getNombre();
        String tematica = exposicion.getTematica();
        Date fechainicio = exposicion.getFechainicio();
        Date fechafin = exposicion.getFechafin();
        String desc = exposicion.getDescripcion();
        int numsala = exposicion.getNumsala();

        String sql = "UPDATE "+propiedadesBBDD+" SET Nombre="+nombre+", Tematica="+tematica+", FechaInicio="+fechainicio+", FechaFin="+fechafin+", Descripcion="+desc+", NumSala="+numsala+
                " WHERE Nombre="+nombre;
        PreparedStatement update = null;
        try{
            update = conexion.prepareStatement(sql);
            update.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha actualizado la exposición exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            update.close();


        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar esa exposición");

        }
    }





    public static void main(String[] args) {
        DAOexposicion dao = new DAOexposicion();
        dao.insertarExposicion(new Exposicion("Prueba", "Prueba", new Date(23/7/1998),new Date(23/9/1998), "prueba", 5 ));
    }

}
