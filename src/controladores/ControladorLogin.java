package controladores;

import Interfaces.InterfaceLogin;
import dao.DAOlogin;
import modelo.Login;
import vistas.Paneles.VistaLogin;
import vistas.Ventanas.VentanaLogin;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements InterfaceLogin.InterfaceControllerLogin, ActionListener {

    private VentanaLogin ventanaLogin;

    private DAOlogin dao;

    private Login login;


    public ControladorLogin(DAOlogin dao, VentanaLogin ventanaLogin){
        this.ventanaLogin=ventanaLogin;
        this.dao=dao;
    }


    public int getPerfilAdministrador(){
        if(login!=null){
            return login.getPerUsuario();
        }
        else
            return -1;
    }

    @Override
    public boolean validadAdmin(){

        String usuario = ventanaLogin.guiLogin.getTxtUsuario().getText();
        String password = ventanaLogin.guiLogin.getTxtContrasenia().getText();

        if ((usuario !=null) && (password != null)){
            if ((login=dao.comprobarExistenciaUsuario(usuario))!=null && (login.getContrasenia().matches(password)==true)){
                return true;
            }
            else{
                login = null;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("LOGUEAR")) {
            ventanaLogin.validaAdmin();
        }
        else if (e.getActionCommand().equals("LIMPIAR")){
            ventanaLogin.guiLogin.limpiarCampos();
        }

    }

}
