package principal;


import controladores.ControladorSala;
import dao.DAOsala;
import vistas.Ventanas.VentanaSalas;


public class GuiSalas {

    VentanaSalas ventanaSalas;

    public GuiSalas(){
        ventanaSalas = new VentanaSalas();
        DAOsala dao = new DAOsala();
        ControladorSala controller=new ControladorSala(dao, ventanaSalas);
        ventanaSalas.setController(controller);
        ventanaSalas.iniciar();
    }
}
