package Interfaces;

import controladores.ControladorMonitor;
import modelo.Monitor;

import java.util.ArrayList;

public interface InterfaceMonitor {

    public interface InterfaceDaoMonitor{
        public void insertarMonitor(Monitor monitor);
        public void eliminarMonitor(String DNI);
        public Monitor buscarMonitor(String DNI);
        public void modificarMonitor(String DNI, String nombre, String apellido1, String apellido2, String telefono, String email, String titulación);
        public ArrayList<Monitor> listarMonitores();
    }
    public interface InterfaceControladorMonitor{
        public void crearMonitor();
        public void eliminarMonitor();
        public void actualizarMonitor();
        public void listarMonitores();
    }

    public interface InterfaceVistaMonitor{
        public void setController(ControladorMonitor controller);
        public void iniciar();
    }

}
