package principal;

import controladores.ControladorReserva;
import dao.DAOreserva;

import vistas.Ventanas.VentanaReserva;

public class GuiReserva {

    VentanaReserva ventanaReserva;

    public GuiReserva(){
        ventanaReserva = new VentanaReserva();
        DAOreserva dao = new DAOreserva();
        ControladorReserva controller=new ControladorReserva(dao, ventanaReserva);
        ventanaReserva.setController(controller);
        ventanaReserva.iniciar();
    }
}
