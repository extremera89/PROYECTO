package vistas.Ventanas;

import vistas.Paneles.VistaPrincipal;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VistaPrincipal guiPrincipal;

    public void activar(){
        this.setVisible(true);
    }
    public VentanaPrincipal(){
        guiPrincipal=new VistaPrincipal();
        this.setContentPane(guiPrincipal.PanelPrincipal);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Proyecto Museum");
        activar();
    }

    public void añadirPestaña(JPanel vista, String titulo){
        guiPrincipal.addPestania(vista,titulo);
    }

}
