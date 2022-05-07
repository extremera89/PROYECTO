package Interfaces;

import modelo.Exposicion;

import java.util.ArrayList;

public interface InterfaceExposicion {

    public interface InterfaceDAOExposicion{
        public void insertarExposicion(Exposicion exposicion);
        public void eliminarExposicion(Exposicion exposicion);
        public ArrayList<Exposicion> listarExposiciones();
        public Exposicion buscarExposicion(Exposicion exposicion);
    }
}
