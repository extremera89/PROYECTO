package controladores;

import Interfaces.InterfaceExposicion;
import dao.DAOexposicion;
import modelo.Exposicion;
import modelotablas.ModeloTablasExposicion;
import vistas.Ventanas.VentanaExposicion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorExposicion implements ActionListener, MouseListener, InterfaceExposicion.InterfaceControladorExposicion {
    private DAOexposicion dao;
    private VentanaExposicion ventana;
    private ModeloTablasExposicion tabla;
    private int filapul = -1;
    int contador = 1;


    public ControladorExposicion(DAOexposicion dao, VentanaExposicion vista){
        this.dao = dao;
        this.ventana = vista;
        this.tabla = new ModeloTablasExposicion(dao);
        ventana.getVista().getTable1().setModel(this.tabla);


    }

    public void anyadirExposicion(){
        ventana.getVista().limpiarCampoTxt();
        ventana.getVista().activaCamposTxt();
        ventana.getVista().activarBotonGuardar();
    }



    public void nuevaExposicion(){
        this.ventana.getVista().desactivarBotonEliminar();
        this.ventana.getVista().limpiarCampoTxt();
        this.ventana.getVista().desactivarBotonGuardar();
    }




    @Override
    public void crearExposicion() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String nombre = this.ventana.getVista().getTxtNombre().getText();
        String tematica = this.ventana.getVista().getTxtTematica().getText();
        System.out.println(this.ventana.getVista().getTxtFechainicio().getText());

        Date fechain = format.parse(this.ventana.getVista().getTxtFechainicio().getText());
        Date fechaf = format.parse(this.ventana.getVista().getTxtFechafin().getText());

        java.sql.Date fechainicio = new java.sql.Date(fechain.getTime());
        java.sql.Date fechafin = new java.sql.Date(fechaf.getTime());

        String descripcion = this.ventana.getVista().getTxtDescripcion().getText();
        String numsala = this.ventana.getVista().getTxtNumsala().getText();


    try {
        if (!nombre.equals("") && !tematica.equals("") && !fechainicio.equals("") && !fechafin.equals("") && !descripcion.equals("") && !numsala.equals("")) {
            if (dao.buscarExposicion(nombre) == null) {
                int numSala = Integer.parseInt(numsala);
                Exposicion prueba = new Exposicion(nombre, tematica, fechainicio, fechafin, descripcion, numSala);
                dao.insertarExposicion(prueba);
                ventana.getVista().limpiarCampoTxt();
                if(dao.buscarExposicion(prueba.getNombre())!=null) {
                    prueba.setNumExp(dao.getNumExp(prueba));
                    tabla.crearExposicion(prueba);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ya existe esa exposición");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "No has rellenado el campo numérico con un número");
    }


    }

   public void modificarExposicion() throws ParseException {

        try {
            String nombre = ventana.getVista().getTxtNombre().getText();
            String tematica = ventana.getVista().getTxtTematica().getText();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date fechain = format.parse(this.ventana.getVista().getTxtFechainicio().getText());
            Date fechaf = format.parse(this.ventana.getVista().getTxtFechafin().getText());
            java.sql.Date fechainicio = new java.sql.Date(fechain.getTime());
            java.sql.Date fechafin = new java.sql.Date(fechaf.getTime());
            String desc = ventana.getVista().getTxtDescripcion().getText();
            int numsala = Integer.parseInt(ventana.getVista().getTxtNumsala().getText());
            Exposicion prueba = new Exposicion(nombre, tematica, fechainicio, fechafin, desc, numsala);
            dao.modificarExposicion(prueba);
            tabla.actualizarExposicion(filapul, prueba);
        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Has introducido un carácter que no es un número");
        }




    }

    public void listarExposiciones(){
        tabla.setExposiciones(dao.listarExposiciones());
    }



    @Override
    public void eliminarExposicion() {
        Exposicion prueba = new Exposicion();
        prueba.setNumExp(Integer.parseInt(ventana.getVista().getTable1().getValueAt(filapul, 0).toString()));
        dao.eliminarExposicion(prueba);
        tabla.eliminarExposicion(filapul);
        ventana.getVista().desactivarBotonEliminar();
        ventana.getVista().activaCamposTxt();
        filapul = -1;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NUEVO")){
            anyadirExposicion();
            ventana.getVista().activarBotonLimpiar();
        }
        else if(e.getActionCommand().equals("GUARDAR")){
            try {
                crearExposicion();
                ventana.getVista().activarBotonLimpiar();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
        else if(e.getActionCommand().equals("ELIMINAR")){
            eliminarExposicion();
            ventana.getVista().activarBotonLimpiar();
        }
        else if(e.getActionCommand().equals("ACTUALIZAR")){
            ventana.getVista().activaCamposTxt();
            try {
                modificarExposicion();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
        else if(e.getActionCommand().equals("LIMPIAR")){
            ventana.getVista().limpiarCampoTxt();
        }
        else if(e.getActionCommand().equals("ACTUALIZAR TABLA")){
            tabla.actualizarTabla();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = ventana.getVista().getTable1().rowAtPoint(e.getPoint());
        ventana.getVista().getTxtNumExp().setText(ventana.getVista().getTable1().getValueAt(row,0).toString());
        ventana.getVista().getTxtNombre().setText(ventana.getVista().getTable1().getValueAt(row, 1).toString());
        ventana.getVista().getTxtTematica().setText(ventana.getVista().getTable1().getValueAt(row, 2).toString());
        ventana.getVista().getTxtFechainicio().setText(ventana.getVista().getTable1().getValueAt(row, 3).toString());
        ventana.getVista().getTxtFechafin().setText(ventana.getVista().getTable1().getValueAt(row, 4).toString());
        ventana.getVista().getTxtDescripcion().setText(ventana.getVista().getTable1().getValueAt(row, 5).toString());
        ventana.getVista().getTxtNumsala().setText(ventana.getVista().getTable1().getValueAt(row, 6).toString());
        ventana.getVista().activarBotonActualizar();
        ventana.getVista().activarBotonEliminar();
        ventana.getVista().desactivarBotonGuardar();
        ventana.getVista().activaCamposTxt();
        ventana.getVista().desactivarBotonLimpiar();
        ventana.getVista().desactivarNumExp();



        filapul = row;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



}
