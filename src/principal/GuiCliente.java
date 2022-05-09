package principal;

import controladores.ControladorCliente;
import dao.DAOcliente;
import vistas.Ventanas.VentanaCliente;

public class GuiCliente {

    VentanaCliente ventanaCliente;

    public GuiCliente(){
        ventanaCliente=new VentanaCliente();
        DAOcliente dao=new DAOcliente();
        ControladorCliente controller=new ControladorCliente(dao, ventanaCliente);
        ventanaCliente.setController(controller);
        ventanaCliente.iniciar();
    }
}
