package Interfaces;

import modelo.Cliente;
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


}
