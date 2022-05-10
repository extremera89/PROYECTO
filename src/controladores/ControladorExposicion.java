package controladores;

import Interfaces.InterfaceExposicion;
import dao.DAOexposicion;
import modelo.Exposicion;
import modelotablas.ModeloTablasExposicion;
import vistas.Ventanas.VentanaExposicion;
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
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        /*try {
            numSala = Integer.parseInt(this.ventana.getVista().getTxtNumsala().getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debes poner un campo numérico");
        }*/

        String nombre = this.ventana.getVista().getTxtNombre().getText();
        String tematica = this.ventana.getVista().getTxtTematica().getText();
        Date fechainicio = formatter1.parse(this.ventana.getVista().getTxtFechainicio().getText());
        Date fechafin = formatter1.parse(this.ventana.getVista().getTxtFechafin().getText());

        String descripcion = this.ventana.getVista().getTxtDescripcion().getText();
        String numsala = this.ventana.getVista().getTxtNumsala().getText();

        if(!nombre.equals("") && !tematica.equals("") && !fechainicio.equals("") && !fechafin.equals("") && !descripcion.equals("") && !numsala.equals("")){
            if(dao.buscarExposicion(nombre)==null){
                int numSala = Integer.parseInt(numsala);
                tabla.crearExposicion(nombre, tematica, fechainicio, fechafin, descripcion, numSala);
                dao.insertarExposicion(new Exposicion(nombre, tematica, fechainicio, fechafin, descripcion, numSala));
                ventana.getVista().limpiarCampoTxt();

            }
            else{
                JOptionPane.showMessageDialog(null, "Ya existe esa exposición");
            }

        }
        else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }


    }

    public void listarExposiciones(){
        tabla.setExposiciones(dao.listarExposiciones());
    }

    @Override
    public void eliminarExposicion() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NUEVO")){
            anyadirExposicion();
        }
        if(e.getActionCommand().equals("GUARDAR")){
            try {
                crearExposicion();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = ventana.getVista().getTable1().rowAtPoint(e.getPoint());
        ventana.getVista().getTxtNombre().setText(ventana.getVista().getTable1().getValueAt(row, 0).toString());
        ventana.getVista().getTxtTematica().setText(ventana.getVista().getTable1().getValueAt(row, 1).toString());
        ventana.getVista().getTxtFechainicio().setText(ventana.getVista().getTable1().getValueAt(row, 2).toString());
        ventana.getVista().getTxtFechafin().setText(ventana.getVista().getTable1().getValueAt(row, 3).toString());
        ventana.getVista().getTxtDescripcion().setText(ventana.getVista().getTable1().getValueAt(row, 4).toString());
        ventana.getVista().getTxtNumsala().setText(ventana.getVista().getTable1().getValueAt(row, 5).toString());

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
