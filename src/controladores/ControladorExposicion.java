package controladores;

import Interfaces.InterfaceExposicion;
import dao.DAOexposicion;
import modelo.Exposicion;
import modelo.Sala;
import modelotablas.ModeloTablasExposicion;
import vistas.Ventanas.VentanaExposicion;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class ControladorExposicion implements ActionListener, MouseListener, InterfaceExposicion.InterfaceControladorExposicion {
    private DAOexposicion dao;
    private VentanaExposicion ventana;
    private ModeloTablasExposicion tabla;
    private int filapul = -1;

    public ControladorExposicion(DAOexposicion dao, VentanaExposicion vista){
        this.dao = dao;
        this.ventana = vista;
        this.tabla = new ModeloTablasExposicion(dao);
        ventana.getVista().getTable1().setModel(this.tabla);


    }
    @Override
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

    public void actualizarTabla(){
        tabla.fireTableDataChanged();
        listarExposiciones();
    }


    @Override
    public void crearExposicion(){
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            String nombre = this.ventana.getVista().getTxtNombre().getText();
            String tematica = this.ventana.getVista().getTxtTematica().getText();

            Date fechain = format.parse(this.ventana.getVista().getTxtFechainicio().getText());
            Date fechaf = format.parse(this.ventana.getVista().getTxtFechafin().getText());

            java.sql.Date fechainicio = new java.sql.Date(fechain.getTime());
            java.sql.Date fechafin = new java.sql.Date(fechaf.getTime());

            String descripcion = this.ventana.getVista().getTxtDescripcion().getText();
            String numsala = this.ventana.getVista().getComboSala().getSelectedItem().toString();


            if (!nombre.equals("") && !tematica.equals("") && !fechainicio.equals("") && !fechafin.equals("") && !descripcion.equals("") && !numsala.equals("")) {
                if (dao.buscarExposicion(nombre) == null) {
                    int numSala = Integer.parseInt(numsala);
                    Sala numerosala = new Sala();
                    numerosala.setNumSala(numSala);
                    Exposicion prueba = new Exposicion(nombre, tematica, fechainicio, fechafin, descripcion, numerosala);
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
        }catch (ParseException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Has introducido la fecha de manera incorrecta");
        }


    }


    public void seleccionaSala(){
        cargarSalas(this.ventana.getVista().getTxtFechainicio().getText(), this.ventana.getVista().getTxtFechafin().getText());
    }


    @Override
   public void modificarExposicion() throws ParseException {

        try {
            int numexp = Integer.parseInt(ventana.getVista().getTxtNumExp().getText());
            String nombre = ventana.getVista().getTxtNombre().getText();
            String tematica = ventana.getVista().getTxtTematica().getText();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date fechain = format.parse(this.ventana.getVista().getTxtFechainicio().getText());
            Date fechaf = format.parse(this.ventana.getVista().getTxtFechafin().getText());
            java.sql.Date fechainicio = new java.sql.Date(fechain.getTime());
            java.sql.Date fechafin = new java.sql.Date(fechaf.getTime());
            String desc = ventana.getVista().getTxtDescripcion().getText();
            int numsala = Integer.parseInt( ventana.getVista().getComboSala().getSelectedItem().toString());
            Sala numerosala = new Sala();
            numerosala.setNumSala(numsala);
            Exposicion prueba = new Exposicion(numexp, nombre, tematica, fechainicio, fechafin, desc, numerosala);


            dao.modificarExposicion(prueba);
            tabla.actualizarExposicion(filapul, prueba);
        }catch (ParseException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Has introducido la fecha de manera incorrecta");
        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Has introducido un carácter que no es un número");
        }
    }
    @Override
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
        ventana.getVista().limpiarCampoTxt();
        ventana.getVista().activaCamposTxt();
        filapul = -1;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NUEVO")){
            anyadirExposicion();
            ventana.getVista().activarBotonLimpiar();
            ventana.getVista().activarBotonSala();
        }
        else if(e.getActionCommand().equals("GUARDAR")){
            crearExposicion();
            ventana.getVista().activarBotonLimpiar();

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
            actualizarTabla();
        }
        else if(e.getActionCommand().equals("SALA")){
            seleccionaSala();
        }

    }

    public void cargarSalas(String fechainicio, String fechafin) {
        this.ventana.getVista().getComboSala().removeAllItems();
        ArrayList<Integer> salasnodisp = null;


        if(!fechainicio.equals("") && !fechafin.equals("")) {

            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                ArrayList<Integer> salas = new ArrayList<>(20);

                Date fechain = format.parse(fechainicio);
                java.sql.Date fechainic = new java.sql.Date(fechain.getTime());

                Date fechaf = format.parse(fechafin);
                java.sql.Date fechafi = new java.sql.Date(fechaf.getTime());

                salasnodisp = this.dao.salasNoDisponibles(fechainic, fechafi);

                int contador = 0;
                while(contador<21){
                    salas.add(contador);
                    contador++;
                }

                salas.removeAll(salasnodisp);

                for(int i : salas){
                    if(i > 0)
                        this.ventana.getVista().getComboSala().addItem(i);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERROR en la fecha");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debes rellenar los campos de FECHA");
        }


    }



    @Override
    public void mouseClicked(MouseEvent e) {
        ventana.getVista().activarBotonSala();
        int row = ventana.getVista().getTable1().rowAtPoint(e.getPoint());
        ventana.getVista().getTxtNumExp().setText(ventana.getVista().getTable1().getValueAt(row,0).toString());
        ventana.getVista().getTxtNombre().setText(ventana.getVista().getTable1().getValueAt(row, 1).toString());
        ventana.getVista().getTxtTematica().setText(ventana.getVista().getTable1().getValueAt(row, 2).toString());
        ventana.getVista().getTxtFechainicio().setText(ventana.getVista().getTable1().getValueAt(row, 3).toString());
        ventana.getVista().getTxtFechafin().setText(ventana.getVista().getTable1().getValueAt(row, 4).toString());
        ventana.getVista().getTxtDescripcion().setText(ventana.getVista().getTable1().getValueAt(row, 5).toString());


        ventana.getVista().getComboSala().addItem(ventana.getVista().getTable1().getValueAt(row, 6).toString());
        if(e.getClickCount() == 1){
            ventana.getVista().getComboSala().removeAllItems();
            ventana.getVista().getComboSala().addItem(ventana.getVista().getTable1().getValueAt(row, 6).toString());

        }

        ventana.getVista().activarBotonActualizar();
        ventana.getVista().activarBotonEliminar();
        ventana.getVista().desactivarBotonGuardar();
        ventana.getVista().activaCamposTxt();
        ventana.getVista().desactivarBotonLimpiar();
        ventana.getVista().desactivarNumExp();
        if(ventana.getVista().getTable1().isColumnSelected(5))
            ventana.getVista().getTable1().getColumnModel().getColumn(5).setPreferredWidth(1000);
        else {
            ventana.getVista().getTable1().getColumnModel().getColumn(5).setPreferredWidth(100);
        }
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
