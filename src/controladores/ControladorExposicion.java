package controladores;

import Interfaces.InterfaceExposicion;
import dao.DAOexposicion;
import modelotablas.ModeloTablasExposicion;
import vistas.Paneles.VistaModalExp;
import vistas.Paneles.VistaModalExposicion;
import vistas.Ventanas.VentanaExposicion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorExposicion implements ActionListener, MouseListener, InterfaceExposicion.InterfaceControladorExposicion {
    private DAOexposicion dao;
    private VentanaExposicion ventana;
    private ModeloTablasExposicion tabla;
    private int filapul = -1;
    private VistaModalExp modal;


    public ControladorExposicion(DAOexposicion dao, VentanaExposicion vista, VistaModalExp modal){
        this.dao = dao;
        this.ventana = vista;
        this.modal = modal;
        /*tabla = new ModeloTablasExposicion(dao);
        ventana.getVista().getTblExposicion().setModel(tabla);*/
    }

    @Override
    public void crearExposicion() {

    }

    @Override
    public void eliminarExposicion() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contentEquals("Insertar")) {
            System.out.println ("Se actualizará la exposición ");
            this.modal.setVisible(true);
        }
        if(e.getActionCommand().contentEquals("Volver")){
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
