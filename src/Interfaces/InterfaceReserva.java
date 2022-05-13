package Interfaces;

import controladores.ControladorReserva;
import modelo.Reserva;

import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

public interface InterfaceReserva {

    public interface InterfaceDAOReserva{
        public void insertarReserva(Reserva Reserva);
        public void eliminarReserva(String codigoReserva);
        public Reserva buscarReserva(String codigoReserva);
        public void actualizarReserva(String codigoReserva, String DNI, int numSala, Date fechaReserva, Date fechaFin, int confirmado, String motivoReserva);
        public ArrayList<Reserva> listarReserva();
        public void modificarReserva(Reserva reserva);
    }

    public interface InterfaceVistaReserva{
        public void setController(ControladorReserva controller);
        public void iniciar();
    }

    public interface InterfaceControladorReserva{
        public void crearReserva();
        public void eliminarReserva();
        public void actualizarReserva() throws ParseException;
        public void listarReserva();
        public void mouseClicked(MouseEvent e);
    }

}
