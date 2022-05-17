package Interfaces;

import controladores.ControladorCentro;
import modelo.Centro;

import java.util.ArrayList;

public class InterfaceCentro {

    public interface InterfaceDAOCentro{
        public void insertarCentro(Centro centro);
        public void eliminarCentro(String codCentro);
        public Centro buscarCentro(String codCentro);
        public void modificarCentro(String codCentro, String nombre, int numVisita, String dniCliente, String dniMonitor);
        public ArrayList<Centro> listarCentros();
    }
    public interface InterfaceControladorCentro{
        public void crearCentro();
        public void eliminarCentro();
        public void actualizarCentro();
        public void listarCentros();
    }

    public interface InterfaceVistaCentro{
        public void setController(ControladorCentro controller);
        public void iniciar();
    }

}
