package principal;

import controladores.ControladorLogin;
import dao.DAOlogin;
import modelo.Login;
import vistas.Paneles.VistaClientes;
import vistas.Paneles.VistaLogin;
import vistas.Paneles.VistaMonitor;
import vistas.Ventanas.VentanaCliente;
import vistas.Ventanas.VentanaLogin;
import vistas.Ventanas.VentanaMonitor;

import javax.swing.*;
import java.util.regex.Pattern;

public class principal {
    public static void main(String[] args) {
        GuiLogin gl=new GuiLogin();
    }
}
