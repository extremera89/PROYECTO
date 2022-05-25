package Interfaces;

import controladores.ControladorVisita;
import modelo.Exposicion;
import modelo.VisitaGuiada;

import java.util.ArrayList;

public interface InterfaceVisitaGuiada {

    public interface InterfaceVistaVisita{
        public void setControler(ControladorVisita controlador);
        public void iniciar();
    }

    public interface InterfaceDAOVisita{

        public void insertarvisita(VisitaGuiada visita);
        public void eliminarVisita(VisitaGuiada visita);
        public ArrayList<Integer> expNoDisponibles(java.util.Date fecha);
        public ArrayList<VisitaGuiada> listarVisitas();
        public VisitaGuiada buscarvisita(int numExp);
        public int buscarSala(Exposicion exposicion);
        public void modificarVisita(VisitaGuiada visita);
        public VisitaGuiada saberDatos(int numvisita, int numPersonas);
        public int getNumVisita(VisitaGuiada visita);
    }

    public interface InterfaceControladorVisita{

        public void cargarDNIClientes();
        public void cargarDNIMonitores();
        public void cargarExposiciones();
        public void crearVisita();
        public void modificarVisita();
        public void listarVisitas();
        public void eliminarVisita();
        public void ponerDatosModal();
        public void actualizarTabla();
    }

}
