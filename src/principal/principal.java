package principal;

import controladores.ControladorLogin;
import dao.DAOlogin;
import modelo.Login;
import vistas.Paneles.VistaLogin;
import vistas.Ventanas.VentanaLogin;

import javax.swing.*;

public class principal {
    public static void main(String[] args) {
        /*
        VentanaLogin vl=new VentanaLogin();
        vl.iniciar();
        */

        //GuiSalas gs = new GuiSalas();
        GuiReserva gr = new GuiReserva();

    }
}
