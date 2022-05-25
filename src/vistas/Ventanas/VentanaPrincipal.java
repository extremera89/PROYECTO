package vistas.Ventanas;

import principal.GuiCliente;
import vistas.Paneles.VistaPrincipal;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VistaPrincipal guiPrincipal;


    public void activar(){
        this.setVisible(true);
    }
    public VentanaPrincipal(){
        int tipoperfil = VentanaLogin.tipoPerfil;
        guiPrincipal=new VistaPrincipal();
        this.setContentPane(guiPrincipal.PanelPrincipal);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(tipoperfil==0){
            this.setTitle("Proyecto Museo - INVITADO");
        }
        else
            this.setTitle("Proyecto Museo - ADMINISTRADOR");
        activar();
        this.setSize(900,600);

    }

    public void añadirPestaña(JPanel vista, String titulo){
        guiPrincipal.addPestania(vista,titulo);
    }

}
