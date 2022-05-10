package Interfaces;

import controladores.ControladorCliente;
import controladores.ControladorMonitor;
import modelo.Monitor;

import java.util.ArrayList;

public interface InterfaceMonitor {

    public interface InterfaceDaoMonitor{
        public void insertarMonitor(Monitor monitor);
        public void eliminarMonitor(String DNI);
        public Monitor buscarMonitor(String DNI);
        public Monitor modificarMonitor(Monitor monitor);
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
