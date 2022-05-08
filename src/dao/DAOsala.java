package dao;

import conexion.Conexion;
import modelo.Exposicion;
import modelo.Sala;
import otros.PropertiesBBDD;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class DAOsala {
    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;

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

            String insert = "INSERT INTO "+propiedadesBBDD.getTblSala()+" (NumSala, DadaAlta, Tamanio) " + "VALUES (?,?,?)";
            PreparedStatement ps = null;
            try{
                ps = conexion.prepareStatement(insert);
                ps.setInt(1, sala.getNumSala());
                ps.setInt(2, sala.getDadaAlta());
                ps.setInt(3, sala.getTamanio());
                ps.executeUpdate();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar la sala");
        }
    }

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

            }
            if (sala.getNumSala()==0 && sala.getTamanio()==0){
                JOptionPane.showMessageDialog(null,"No se ha encotrado la sala");
                return null;
            }
            return  sala;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se ha encontrado esa sala");
        }
        return null;
    }

    public static void main(String[] args) {

            DAOsala salin = new DAOsala();

            System.out.println(salin.buscarSala(30));

            Sala sal = new Sala(10,1,30);

            //salin.actualizarSala(10,0,100);

    }


}
