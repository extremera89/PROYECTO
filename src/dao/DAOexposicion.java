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
        //DATESQL hola = new DATESQL(DATEJAVA.getTime());
        /*String sql = "INSERT INTO "+propiedadesBBDD.getTblExposicion()+" values ('"+nombre+"', '"+tematica+"','"
                +formato.format(fechainicio)+"', '"+formato.format(fechafin)+"', '"+desc+"', "+numsala+")" ;*/




        PreparedStatement ps = null;
        String sql = "INSERT INTO "+ propiedadesBBDD.getTblExposicion()+ "(Nombre, Tematica, FechaInicio, FechaFin, Descripcion, NumSala) VALUES (?,?,?,?,?,?)";

        try{
            ps = conexion.prepareStatement(sql);

            ps.setString(1, exposicion.getNombre());
            ps.setString(2, exposicion.getDescripcion());
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
        String sql = "DELETE FROM "+propiedadesBBDD.getTblExposicion()+" WHERE Nombre=?";

        try{
            ps = conexion.prepareStatement(sql);
            ps.setString(1, exposicion.getNombre());
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha eliminado la exposición exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);


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
        PreparedStatement ps = null;
        String sql = "UPDATE "+ propiedadesBBDD.getTblExposicion()+ " SET Nombre=?, Tematica=?, FechaInicio=?, FechaFin=?, Descripcion=?, NumSala=? WHERE Nombre=?";

        try{
            ps = conexion.prepareStatement(sql);

            ps.setString(1, exposicion.getNombre());
            ps.setString(2, exposicion.getDescripcion());
            ps.setDate(3, new java.sql.Date(exposicion.getFechainicio().getTime()));
            ps.setDate(4, new java.sql.Date(exposicion.getFechafin().getTime()));
            ps.setString(5, exposicion.getDescripcion());
            ps.setInt(6, exposicion.getNumsala());
            ps.setString(7, exposicion.getNombre());


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha modificado la exposición exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar esa exposición");

        }
    }





    public static void main(String[] args) throws ParseException {
        DAOexposicion dao = new DAOexposicion();
        //Date fechainicio = new Date(System.currentTimeMillis());
        /*long input = 1220227200;
        long milliseconds = ( input * 10000L );



        Date fechafin = new Date(milliseconds);*/
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = format.parse("20/10/2001");
        Date parseds = format.parse("20/10/2002");

        java.sql.Date fechainicio = new java.sql.Date(parsed.getTime());
        java.sql.Date fechafin = new java.sql.Date(parseds.getTime());

        System.out.println(fechafin);
        dao.insertarExposicion(new Exposicion("Prueba22", "Prueba", fechainicio, fechafin, "prueba", 5 ));
        //dao.modificarExposicion(new Exposicion("Prueba2", "Prueba2", fechainicio, fechafin, "prueba2222", 6));
        //dao.eliminarExposicion(new Exposicion("Prueba"));
    }


}
