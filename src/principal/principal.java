package principal;

import controladores.ControladorExposicion;
import controladores.ControladorLogin;
import dao.DAOexposicion;
import dao.DAOlogin;
import modelo.Exposicion;
import modelo.Login;
import vistas.Paneles.VistaLogin;
import vistas.Ventanas.VentanaExposicion;
import vistas.Ventanas.VentanaLogin;

import javax.swing.*;

public class principal {
    public static void main(String[] args) {
        new GuiVisita();
    }
}
