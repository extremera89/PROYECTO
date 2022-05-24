package dao;

import conexion.Conexion;
import modelo.Sala;
import otros.PropertiesBBDD;
import Interfaces.InterfaceSalas;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DAOsala implements InterfaceSalas.InterfaceDAOSala{
    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;
    public boolean error;

    public DAOsala(){
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

    public void insertarSala(Sala sala) {

            String insert = "INSERT INTO "+propiedadesBBDD.getTblSala()+" (NumSala, DadaAlta, Tamanio,Aforo,Numplanta) " + "VALUES (?,?,?,?,?)";
            PreparedStatement ps = null;
            try{
                ps = conexion.prepareStatement(insert);
                ps.setInt(1, sala.getNumSala());
                ps.setInt(2, sala.getDadaAlta());
                ps.setInt(3, sala.getTamanio());
                ps.setInt(4,sala.getAforo());
                ps.setInt(5,sala.getNumPlanta());
                ps.executeUpdate();

        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar la sala");
        }
    }

    /*
    public void actualizarSala(int numSala,int DadaAlta,int Tamanio) {

        PreparedStatement ps = null;
        try{
            String update = "UPDATE "+propiedadesBBDD.getTblSala()+" SET " + "DadaAlta=?,Tamanio=? where NumSala= "+ numSala ;
            ps = conexion.prepareStatement(update);
            ps.setInt(1, DadaAlta);
            ps.setInt(2, Tamanio);
            ps.executeUpdate();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar la sala");
        }
    }*/

    public void modificarSala(Sala sala) {
        PreparedStatement ps = null;
        String sql = "UPDATE "+ propiedadesBBDD.getTblSala()+ " SET NumSala=?, DadaAlta=?, Tamanio=?, Aforo=?, Numplanta=? WHERE NumSala=?";

        try{
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, sala.getNumSala());
            ps.setInt(2, sala.getDadaAlta());
            ps.setInt(3, sala.getTamanio());
            ps.setInt(4,sala.getAforo());
            ps.setInt(5,sala.getNumPlanta());
            ps.setInt(6, sala.getNumSala());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha modificado la sala", "Información", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar la sala");
            this.error=true;
        }
    }

    public void eliminarSala(int NumSala) {
        try{
            String sql = "DELETE FROM "+propiedadesBBDD.getTblSala()+" WHERE NumSala = "+NumSala;
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate(sql);


        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar la sala");
        }
    }


    public ArrayList<Sala> listarSala() {
        ArrayList<Sala> miLista = new ArrayList<>();
        Sala sala;
        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("select * from " + propiedadesBBDD.getTblSala());

            while (rs.next()) {
                sala = new Sala();
                sala.setNumSala(Integer.parseInt(rs.getString("NumSala")));
                sala.setDadaAlta(Integer.parseInt(rs.getString("DadaAlta")));
                sala.setTamanio(Integer.parseInt(rs.getString("Tamanio")));
                sala.setAforo(Integer.parseInt(rs.getString("Aforo")));
                sala.setNumPlanta(Integer.parseInt(rs.getString("Numplanta")));
                miLista.add(sala);
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

    public Sala buscarSala(int Numsala){
        Sala sala = new Sala();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("Select * from "+propiedadesBBDD.getTblSala()+" where NumSala = "+Numsala);

            while (rs.next()){
                sala = new Sala();
                sala.setNumSala(rs.getInt("NumSala"));
                sala.setDadaAlta(rs.getInt("DadaAlta"));
                sala.setTamanio(rs.getInt("Tamanio"));
                sala.setAforo(rs.getInt("Aforo"));
                sala.setNumSala(rs.getInt("Numplanta"));

            }
            if (sala.getNumSala()==0 && sala.getTamanio()==0){
                //JOptionPane.showMessageDialog(null,"No se ha encotrado la sala error buscar sala");
                return null;
            }

            return  sala;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se ha encontrado esa sala");
        }
        return null;
    }


}
