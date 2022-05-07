package Interfaces;

import modelo.Exposicion;

import java.util.ArrayList;

public interface InterfaceExposicion {

    public interface InterfaceDAOExposicion{
        public void insertarExposicion();
        public void eliminarExposicion();
        public ArrayList<Exposicion> listarExposiciones();
        public Exposicion buscarExposicion();
    }
}
