package Interfaces;



import controladores.ControladorSala;
import modelo.Sala;

import java.util.ArrayList;

public interface InterfaceSalas {



    public interface InterfaceDAOSala{
        public void insertarSala(Sala sala);
        public void eliminarSala(int NumSala);
        public Sala buscarSala(int NumSala);
        public void actualizarSala(int numSala,int DadaAlta,int Tamanio);
        public ArrayList<Sala> listarSala();
    }

    public interface InterfaceVistaSala{
        public void setController(ControladorSala controller);
        public void iniciar();
    }

    public interface InterfaceControladorSala{
        public void crearSala();
        public void eliminarSala();
        public void actualizarSala();
        public void listarSala();
    }

}
