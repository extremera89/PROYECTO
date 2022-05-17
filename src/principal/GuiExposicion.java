package principal;

import controladores.ControladorExposicion;
import dao.DAOexposicion;
import vistas.Ventanas.VentanaExposicion;

public class GuiExposicion {

    VentanaExposicion menu;

    public GuiExposicion(){
        DAOexposicion dao = new DAOexposicion();
        menu = new VentanaExposicion();
        ControladorExposicion controlador = new ControladorExposicion(dao, menu);
        menu.setControler(controlador);
        menu.iniciar();
    }

}
