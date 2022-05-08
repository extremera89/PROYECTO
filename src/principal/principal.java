package principal;

import controladores.ControladorLogin;
import dao.DAOlogin;
import modelo.Login;
import vistas.Paneles.VistaLogin;
import vistas.Ventanas.VentanaLogin;

import javax.swing.*;

public class principal {
    public static void main(String[] args) {

        GuiLogin gl=new GuiLogin();

        DAOlogin dao=new DAOlogin();

        //System.out.println(dao.comprobarExistenciaUsuario("juan"));



    }
}
