package controladores;

import Interfaces.InterfaceLogin;
import dao.DAOlogin;
import modelo.Login;
import vistas.Ventanas.VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements InterfaceLogin.InterfaceControllerLogin, ActionListener {

    private VentanaLogin ventanaLogin;

    private DAOlogin dao;

    private Login login;

    public String getUser() {
        return user;
    }

    boolean prueba = false;

    public void setUser(String user) {
        this.user = user;
    }

    String user;


    private int getUser;

    public int getGetUser() {
        return getUser;
    }

    public void setGetUser(int getUser) {
        this.getUser = getUser;
    }

    public ControladorLogin(DAOlogin dao, VentanaLogin ventanaLogin) {
        this.ventanaLogin = ventanaLogin;
        this.dao = dao;
    }

    @Override
    public int validadAdmin() {

        String usuario = ventanaLogin.guiLogin.getTxtUsuario().getText();
        String password = ventanaLogin.guiLogin.getTxtContrasenia().getText();
        int tipoUsuario = -1;

        if ((usuario != null) && (password != null)) {
            if ((login = dao.comprobarExistenciaUsuario(usuario)) != null && (login.getContrasenia().matches(password) && login.getPerUsuario() == 1)) {
                tipoUsuario = 1;
            } else if ((login = dao.comprobarExistenciaUsuario(usuario)) != null && (login.getContrasenia().matches(password) && login.getPerUsuario() == 0)) {
                tipoUsuario = 0;
            }
        }
        return tipoUsuario;
    }

    public void g() {
        System.out.println(prueba);
    }


    public int getPerfilAdministrador() {
        g();
        return this.getUser;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("LOGUEAR")) {
            ventanaLogin.validaAdmin();

        } else if (e.getActionCommand().equals("LIMPIAR")) {
            ventanaLogin.guiLogin.limpiarCampos();
        }

    }

}
