package principal;

import controladores.ControladorCentro;
import dao.DAOcentro;
import vistas.Ventanas.VentanaCentro;

public class GuiCentro {

    VentanaCentro ventanaCentro;


    public GuiCentro(){
        ventanaCentro=new VentanaCentro();
        DAOcentro dao=new DAOcentro();
        ControladorCentro controller=new ControladorCentro(dao, ventanaCentro);
        ventanaCentro.setController(controller);
        ventanaCentro.iniciar();
    }
}
