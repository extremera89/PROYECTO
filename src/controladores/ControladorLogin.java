package controladores;

import Interfaces.InterfaceLogin;
import dao.DAOlogin;
import modelo.Login;
import vistas.Paneles.VistaLogin;
import vistas.Ventanas.VentanaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControladorLogin implements InterfaceLogin.InterfaceControllerLogin {

    private VentanaLogin ventanaLogin;

    private DAOlogin administradorDAO;

    private Login login;

    private VistaLogin vistaLogin;

    public ControladorLogin(DAOlogin dao, VentanaLogin ventanaLogin){
        this.ventanaLogin=ventanaLogin;
        administradorDAO=new DAOlogin();
        ventanaLogin=new VentanaLogin();
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

        String usuario = vistaLogin.getTxtUsuario().getText();
        String password = vistaLogin.getTxtContrasenia().getText();

        if (
                (usuario !=null) && (password != null) &&((login=administradorDAO.comprobarExistenciaUsuario(usuario))!=null)
        ){
            if (login.getContrasenia().matches(password)){
                return true;
            }
            else{
                login = null;  //Ese usuario no es válido.
            }
        }
        return false;
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("LIMPIAR")){
            JOptionPane.showInputDialog(this,"hola");
        }
    }

}
