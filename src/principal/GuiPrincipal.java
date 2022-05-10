package principal;

import vistas.Ventanas.VentanaPrincipal;

public class GuiPrincipal {

    VentanaPrincipal ventanaPrincipal;
    GuiCliente guiCliente=new GuiCliente();
    GuiMonitor guiMonitor=new GuiMonitor();

    public GuiPrincipal() {
        ventanaPrincipal=new VentanaPrincipal();
        ventanaPrincipal.añadirPestaña(guiCliente.ventanaCliente.guiClientes.getPanelPrincipal(),"Clientes");
        ventanaPrincipal.añadirPestaña(guiMonitor.ventanaMonitor.guiMonitor.getPanelPrincipal(),"Monitores");
    }


}
