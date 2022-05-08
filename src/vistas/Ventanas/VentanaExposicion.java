package vistas.Ventanas;

import Interfaces.InterfaceExposicion;
import controladores.ControladorExposicion;
import vistas.Paneles.VistaExposicion;

import javax.swing.*;

public class VentanaExposicion extends JFrame implements InterfaceExposicion.InterfaceVistaExposicion {
    public ControladorExposicion controlador;
    public VistaExposicion vista;


    public VentanaExposicion(){
        vista = new VistaExposicion();
        this.setContentPane(vista.getPanelPrincipal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Exposiciones.");
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaExposicion();
    }
}
