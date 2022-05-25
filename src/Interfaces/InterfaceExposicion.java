package Interfaces;

import controladores.ControladorExposicion;
import modelo.Exposicion;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface InterfaceExposicion {

    public interface InterfaceDAOExposicion{
        public void insertarExposicion(Exposicion exposicion);
        public void eliminarExposicion(Exposicion exposicion);
        public ArrayList<Exposicion> listarExposiciones();
        public Exposicion buscarExposicion(String nombre);
        public void modificarExposicion(Exposicion exposicion);
        public int getNumExp(Exposicion exposicion);
        public ArrayList<Integer> salasDadasAlta();
        public ArrayList<Integer> salasNoDisponibles(Date fechainic, Date fechafi);
    }

    public interface InterfaceVistaExposicion{
        public void setControler(ControladorExposicion controlador);
        public void iniciar();


        }


    public interface InterfaceControladorExposicion{
        public void actualizarTabla();
        public void crearExposicion() throws ParseException;
        public void eliminarExposicion();
        public void anyadirExposicion();
        public void seleccionaSala();
        public void modificarExposicion() throws ParseException;
        public void listarExposiciones();
        public void cargarSalas(String fechainicio, String fechafin);
    }



}
