package vistas.Ventanas;

import Interfaces.InterfaceLogin;
import controladores.ControladorLogin;
import principal.GuiPrincipal;
import vistas.Paneles.VistaLogin;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame  implements InterfaceLogin.InterfaceVistaLogin {

    public ControladorLogin adapter;
    public VistaLogin guiLogin;
    public static int tipoPerfil;



    public VentanaLogin(){
        guiLogin=new VistaLogin();
        guiLogin.asignaCommandBotones();
        guiLogin.insertarImagenes();
        this.setContentPane(guiLogin.PanelPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Inicio de sesión");
        this.pack();
        this.setResizable(false);

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

        if (adapter.validadAdmin()>-1 && adapter.validadAdmin()<2){
            tipoPerfil = adapter.validadAdmin();
            this.setVisible(false);
            GuiPrincipal guiPrincipal=new GuiPrincipal();
        }
        else{
            errorAutenticacion();
        }

    }

}
