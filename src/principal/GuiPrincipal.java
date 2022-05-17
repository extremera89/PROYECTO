package principal;

import vistas.Ventanas.VentanaPrincipal;

public class GuiPrincipal {

    VentanaPrincipal ventanaPrincipal;
    GuiCliente guiCliente=new GuiCliente();
    GuiMonitor guiMonitor=new GuiMonitor();

    GuiSalas guiSalas=new GuiSalas();
    GuiReserva guiReserva=new GuiReserva();

    GuiExposicion guiExposicion=new GuiExposicion();
    GuiVisita guiVisita=new GuiVisita();

    public GuiPrincipal() {
        ventanaPrincipal=new VentanaPrincipal();
        ventanaPrincipal.añadirPestaña(guiExposicion.menu.getVista().getPanelPrincipal(), "Exposición");
        ventanaPrincipal.añadirPestaña(guiVisita.menu.getVista().getPanelPrincipal(),"Visita");
        ventanaPrincipal.añadirPestaña(guiReserva.ventanaReserva.guiReservas.getPanelPrincipal(),"Reservas");
        ventanaPrincipal.añadirPestaña(guiSalas.ventanaSalas.guiSalas.getPanelPrincipal(),"Salas");
        ventanaPrincipal.añadirPestaña(guiCliente.ventanaCliente.guiClientes.getPanelPrincipal(),"Clientes");
        ventanaPrincipal.añadirPestaña(guiMonitor.ventanaMonitor.guiMonitor.getPanelPrincipal(),"Monitores");

    }


}
