package principal;

import controladores.ControladorCliente;
import controladores.ControladorMonitor;
import dao.DAOcliente;
import dao.DAOmonitor;
import vistas.Ventanas.VentanaCliente;
import vistas.Ventanas.VentanaMonitor;

public class GuiMonitor {

    VentanaMonitor ventanaMonitor;

    public GuiMonitor(){
        ventanaMonitor=new VentanaMonitor();
        DAOmonitor dao=new DAOmonitor();
        ControladorMonitor controller=new ControladorMonitor(dao, ventanaMonitor);
        ventanaMonitor.setController(controller);
        ventanaMonitor.iniciar();
    }
}
