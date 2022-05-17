package Interfaces;

import controladores.ControladorVisita;

public interface InterfaceVisitaGuiada {

    public interface InterfaceVistaVisita{
        public void setControler(ControladorVisita controlador);
        public void iniciar();


    }
}
