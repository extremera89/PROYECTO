package principal;

import controladores.ControladorExposicion;
import controladores.ControladorVisita;
import dao.DAOvisitaguiada;
import vistas.Ventanas.VentanaVisita;

public class GuiVisita {

    VentanaVisita menu;

    public GuiVisita() {
        DAOvisitaguiada dao = new DAOvisitaguiada();
        menu = new VentanaVisita();
        ControladorVisita controlador = new ControladorVisita(dao, menu);
        menu.setControler(controlador);
        menu.iniciar();
    }
}
