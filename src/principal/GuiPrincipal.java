package principal;

import vistas.Ventanas.VentanaInformacion;
import vistas.Ventanas.VentanaPrincipal;

public class GuiPrincipal {

    VentanaPrincipal ventanaPrincipal;
    GuiCliente guiCliente=new GuiCliente();
    GuiMonitor guiMonitor=new GuiMonitor();

    GuiSalas guiSalas=new GuiSalas();
    GuiReserva guiReserva=new GuiReserva();

    GuiExposicion guiExposicion=new GuiExposicion();
    GuiVisita guiVisita=new GuiVisita();

    GuiCentro guiCentro=new GuiCentro();

    VentanaInformacion ventanaInformacion= new VentanaInformacion();

    public GuiPrincipal() {
        ventanaPrincipal=new VentanaPrincipal();
        ventanaPrincipal.añadirPestaña(guiExposicion.menu.getVista().getPanelPrincipal(), "Exposición");
        ventanaPrincipal.añadirPestaña(guiVisita.menu.getVista().getPanelPrincipal(),"Visita");
        ventanaPrincipal.añadirPestaña(guiReserva.ventanaReserva.guiReservas.getPanelPrincipal(),"Reservas");
        ventanaPrincipal.añadirPestaña(guiSalas.ventanaSalas.guiSalas.getPanelPrincipal(),"Salas");
        ventanaPrincipal.añadirPestaña(guiCentro.ventanaCentro.guiCentro.getPanelPrincipal(),"Centros");
        ventanaPrincipal.añadirPestaña(guiCliente.ventanaCliente.guiClientes.getPanelPrincipal(),"Clientes");
        ventanaPrincipal.añadirPestaña(guiMonitor.ventanaMonitor.guiMonitor.getPanelPrincipal(),"Monitores");
        ventanaPrincipal.añadirPestaña(ventanaInformacion.guiInformacion.getPanelPrincipal(),"Informacion");

    }


}
