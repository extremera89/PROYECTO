package vistas.Ventanas;

import Interfaces.InterfaceExposicion;
import controladores.ControladorExposicion;
import dao.DAOexposicion;
import vistas.Paneles.VistaExposicion;
import vistas.Paneles.VistaModalExp;
import vistas.Paneles.VistaModalExposicion;

import javax.swing.*;
import javax.swing.undo.AbstractUndoableEdit;

public class VentanaExposicion extends JFrame implements InterfaceExposicion.InterfaceVistaExposicion {
    private ControladorExposicion controlador;
    private VistaExposicion vista;


    public VentanaExposicion(){
        vista = new VistaExposicion();
        this.setContentPane(vista.getPanelPrincipal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Exposiciones.");
        vista.getBtnInsertar().setActionCommand("Insertar");
        vista.getVolver().setActionCommand("Volver");
        this.pack();
        this.setVisible(true);
    }


    public ControladorExposicion getControlador() {
        return controlador;
    }

    public void setControlador(ControladorExposicion controlador) {
        this.controlador = controlador;
    }

    public VistaExposicion getVista() {
        return vista;
    }

    public void setVista(VistaExposicion vista) {
        this.vista = vista;
    }

    @Override
    public void setControler(ControladorExposicion controlador) {
        this.vista.getVolver().addActionListener(controlador);
        this.vista.getBtnInsertar().addActionListener(controlador);
    }





    public static void main(String[] args) {
        DAOexposicion dao = new DAOexposicion();
        VentanaExposicion menu = new VentanaExposicion();
        VistaModalExp modal = new VistaModalExp(menu, true);
        ControladorExposicion controlador = new ControladorExposicion(dao, menu, modal);
        menu.setControler(controlador);


    }

}
