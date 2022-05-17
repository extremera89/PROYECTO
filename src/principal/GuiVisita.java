package principal;

import controladores.ControladorExposicion;
import dao.DAOvisitaguiada;
import vistas.Ventanas.VentanaVisita;

public class GuiVisita {

    VentanaVisita menu;

    public GuiVisita() {
        /*DAOvisitaguiada dao = new DAOvisitaguiada();*/
        menu = new VentanaVisita();
        /*ControladorExposicion controlador = new ControladorExposicion(dao, menu);
        menu.setControler(controlador);*/
        menu.iniciar();
    }
}
