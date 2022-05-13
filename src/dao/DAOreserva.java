package dao;

import Interfaces.InterfaceReserva;
import conexion.Conexion;
import modelo.Reserva;
import modelo.Sala;
import otros.PropertiesBBDD;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DAOreserva implements InterfaceReserva {
    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;

    public DAOreserva(){
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

    public void insertarReserva(Reserva reserva) {

        String insert = "INSERT INTO "+propiedadesBBDD.getTblReserva()+" (CodigoReserva,DNI, NumSala, FechaReserva,FechaFin,Confirmado,MotivoReserva) " + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conexion.prepareStatement(insert);
            ps.setString(1, reserva.getCodigoReserva());
            ps.setString(2, reserva.getDNI());
            ps.setInt(3, reserva.getNumSala());
            ps.setDate(4, reserva.getFechaReserva());
            ps.setDate(5, reserva.getFechaFin());
            ps.setInt(6, reserva.getConfirmado());
            ps.setString(7, reserva.getMotivoReserva());
            ps.executeUpdate();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar la reserva");
        }
    }

    /*
    public void actualizarReserva(String CodigoReserva,String DNI, int numSala, Date fechaReserva, Date fecahFin, int confirmado, String motivoReserva) {

        PreparedStatement ps = null;
        try{
            String update = "UPDATE "+propiedadesBBDD.getTblReserva()+" SET " + "DNI=?,NumSala=?,FechaReserva=?, FechaFin=?,Confirmado=?,MotivoReserva=? " +
                    " where CodigoReserva=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, DNI);
            ps.setInt(2, numSala);
            ps.setDate(3, fechaReserva);
            ps.setDate(4, fecahFin);
            ps.setInt(5, confirmado);
            ps.setString(6, motivoReserva);
            ps.setString(7,CodigoReserva);
            ps.executeUpdate();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar la reserva");
        }
    }*/

    public void eliminarReserva(String codigoReserva) {
        try{
            String sql = "DELETE FROM "+propiedadesBBDD.getTblReserva()+" WHERE CodigoReserva = '"+codigoReserva+"'";
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate(sql);

        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar la reserva");
        }
    }



    public Reserva buscarReserva(String CodigoReserva){
        Reserva reser= new Reserva();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("Select * from "+propiedadesBBDD.getTblReserva()+" where CodigoReserva like '"+CodigoReserva+"'");

            while (rs.next()){
                reser = new Reserva();
                reser.setDNI(rs.getString("DNI"));
                reser.setNumSala(rs.getInt("NumSala"));
                reser.setFechaReserva(rs.getDate("FechaReserva"));
                reser.setFechaFin(rs.getDate("FechaFin"));
                reser.setConfirmado(rs.getInt("Confirmado"));
                reser.setMotivoReserva(rs.getString("MotivoReserva"));

            }
            if (reser.getCodigoReserva()==null){
                //JOptionPane.showMessageDialog(null,"No se ha encotrado la reserva");
                return null;
            }
            return  reser;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se ha encontrado esa reserva");
        }
        return null;
    }


    public void modificarReserva(Reserva reserva) {
        PreparedStatement ps = null;
        String sql = "UPDATE "+ propiedadesBBDD.getTblReserva()+ " SET CodigoReserva=?, DNI=?, NumSala=?, FechaReserva=?, FechaFin=?, Confirmado=?,MotivoReserva=? WHERE CodigoReserva=?";

        try{
            ps = conexion.prepareStatement(sql);

            ps.setString(1, reserva.getCodigoReserva());
            ps.setString(2, reserva.getDNI());
            ps.setInt(3, reserva.getNumSala());
            ps.setDate(4, new java.sql.Date(reserva.getFechaReserva().getTime()));
            ps.setDate(5, new java.sql.Date(reserva.getFechaFin().getTime()));
            ps.setInt(6, reserva.getConfirmado());
            ps.setString(7, reserva.getMotivoReserva());
            ps.setString(8, reserva.getCodigoReserva());


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha modificado la reserva", "Información", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar la reserva");

        }
    }

    public ArrayList<Reserva> listarReserva() {
        ArrayList<Reserva> miLista = new ArrayList<>();
        Reserva reserva;
        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("select * from " + propiedadesBBDD.getTblReserva());

            while (rs.next()) {
                reserva = new Reserva();

                reserva.setCodigoReserva(rs.getString("CodigoReserva"));
                reserva.setDNI(rs.getString("DNI"));
                reserva.setNumSala(Integer.parseInt(rs.getString("NumSala")));
                reserva.setFechaReserva((rs.getDate("FechaReserva")));
                reserva.setFechaFin((rs.getDate("FechaFin")));
                reserva.setConfirmado(Integer.parseInt(rs.getString("Confirmado")));
                reserva.setMotivoReserva(rs.getString("MotivoReserva"));
                miLista.add(reserva);
            }
            rs.close();
            consulta.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
        return miLista;
    }


    public static void main(String[] args) {

        DAOreserva reservin = new DAOreserva();

        Date inicio = new Date(2010,3,21);
        Date fin = new Date(2010,5,10);

        Reserva reserv = new Reserva("POPOL","04276694M",5,inicio,fin,1,"Reserva para exponer arte");

        //reservin.insertarReserva(reserv);
        //reservin.actualizarReserva("POPOL","94465347T",15,inicio,fin,0,"Reserva para AAAAAAAAA");
        //reservin.eliminarReserva("POPOL");

        System.out.println(reservin.buscarReserva("sdffd"));



    }
}
