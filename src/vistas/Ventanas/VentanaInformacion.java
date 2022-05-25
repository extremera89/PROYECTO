package vistas.Ventanas;

import vistas.Paneles.VistaClientes;
import vistas.Paneles.VistaInformacion;

import javax.swing.*;

public class VentanaInformacion extends JFrame {

    public VistaInformacion guiInformacion;

    public VentanaInformacion(){
        guiInformacion =new VistaInformacion();

        this.setContentPane(guiInformacion.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Acerca de");
        this.pack();
    }

}
