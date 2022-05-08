package vistas.Ventanas;

import Interfaces.InterfaceLogin;
import controladores.ControladorLogin;
import vistas.Paneles.VistaLogin;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame  implements InterfaceLogin.InterfaceVistaLogin {

    public ControladorLogin adapter;
    public VistaLogin guiLogin;


    public VentanaLogin(){
        guiLogin=new VistaLogin();
        guiLogin.asignaCommandBotones();
        this.setContentPane(guiLogin.PanelPrincipal);
        this.pack();

    }



    public void setControler(ControladorLogin adapter){
        this.adapter=adapter;
        guiLogin.getBtnIniciarSesion().addActionListener((ActionListener) adapter);
        guiLogin.btnLimpiar.addActionListener((ActionListener) adapter);
    }


    public void iniciar(){
        this.setVisible(true);
    }

    public void errorAutenticacion() {
        JOptionPane.showMessageDialog(this, "Error de Autenticación");

    }

    @Override
    public void validaAdmin(){

        if (adapter.validadAdmin()){
            this.setVisible(false);
            //controladorLogin.inicializaControlerPrincipal();
        }
        else{
            errorAutenticacion();
        }

    }

}
