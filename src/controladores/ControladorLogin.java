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
    Login log;

    public Login getLog() {
        return log;
    }

    public void setLog(Login log) {
        this.log = log;
    }

    private int getUser=1;

    public int getGetUser() {
        return getUser;
    }

    public void setGetUser(int getUser) {
        this.getUser = getUser;
    }

    public ControladorLogin(DAOlogin dao, VentanaLogin ventanaLogin){
        this.ventanaLogin=ventanaLogin;
        this.dao=dao;
    }

    @Override
    public boolean validadAdmin(){

        String usuario = ventanaLogin.guiLogin.getTxtUsuario().getText();
        String password = ventanaLogin.guiLogin.getTxtContrasenia().getText();

        if ((usuario !=null) && (password != null)){
            if ((login=dao.comprobarExistenciaUsuario(usuario))!=null && (login.getContrasenia().matches(password)==true)){
                this.getUser=(dao.obtenerContraseniaTipoUsuario(login));
                setGetUser(dao.obtenerContraseniaTipoUsuario(login));
                return true;
            }
            else{
                login = null;
            }
        }
        return false;
    }

    public int getTipoUser(){
        String usuario = ventanaLogin.guiLogin.getTxtUsuario().getText();
        String password = ventanaLogin.guiLogin.getTxtContrasenia().getText();

        if ((usuario !=null) && (password != null)){
            if ((login=dao.comprobarExistenciaUsuario(usuario))!=null && (login.getContrasenia().matches(password)==true)){
                this.getUser=(dao.obtenerContraseniaTipoUsuario(login));

                System.out.println(getUser);
                return getUser;

            }
            else{
                login = null;
            }
        }
        return getUser;
    }



    public int getPerfilAdministrador(){
        System.out.println(getTipoUser());
        return getTipoUser();
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
