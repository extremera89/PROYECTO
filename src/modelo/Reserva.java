package modelo;

import java.sql.Date;

public class Reserva {

    private String CodigoReserva; //pk
    private String DNI; // foranea de persona
    private int NumSala; // foranea de sala
    private java.sql.Date FechaReserva;
    private java.sql.Date FechaFin;
    private int Confirmado;
    private String MotivoReserva;

    public Reserva() {
    }

    public Reserva(String codigoReserva, String DNI, int numSala, Date fechaReserva, Date fechaFin, int confirmado, String motivoReserva) {
        CodigoReserva = codigoReserva;
        this.DNI = DNI;
        NumSala = numSala;
        FechaReserva = fechaReserva;
        FechaFin = fechaFin;
        Confirmado = confirmado;
        MotivoReserva = motivoReserva;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getNumSala() {
        return NumSala;
    }

    public void setNumSala(int numSala) {
        NumSala = numSala;
    }

    public Date getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        FechaReserva = fechaReserva;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    public int getConfirmado() {
        return Confirmado;
    }

    public void setConfirmado(int confirmado) {
        Confirmado = confirmado;
    }

    public String getMotivoReserva() {
        return MotivoReserva;
    }

    public void setMotivoReserva(String motivoReserva) {
        MotivoReserva = motivoReserva;
    }

    public String getCodigoReserva() {
        return CodigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        CodigoReserva = codigoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "CodigoReserva='" + CodigoReserva + '\'' +
                ", DNI='" + DNI + '\'' +
                ", NumSala=" + NumSala +
                ", FechaReserva=" + FechaReserva +
                ", FechaFin=" + FechaFin +
                ", Confirmado=" + Confirmado +
                ", MotivoReserva='" + MotivoReserva + '\'' +
                '}';
    }
}
