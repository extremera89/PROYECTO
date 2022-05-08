package modelo;

import java.sql.Time;
import java.util.Date;

public class Reserva {

    private String DNI; // foranea de persona pk
    private int NumSala; // foranea de sala pk
    private Date FechaReserva; // pk
    private Date FecahFin;
    private boolean Confirmado;
    private Time HoraApetrua;
    private Time HoraCierre;
    private String MotivoReserva;

    public Reserva(String DNI, int numSala, Date fechaReserva, Date fecahFin, boolean confirmado, Time horaApetrua, Time horaCierre, String motivoReserva) {
        this.DNI = DNI;
        NumSala = numSala;
        FechaReserva = fechaReserva;
        FecahFin = fecahFin;
        Confirmado = confirmado;
        HoraApetrua = horaApetrua;
        HoraCierre = horaCierre;
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

    public Date getFecahFin() {
        return FecahFin;
    }

    public void setFecahFin(Date fecahFin) {
        FecahFin = fecahFin;
    }

    public boolean isConfirmado() {
        return Confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        Confirmado = confirmado;
    }

    public Time getHoraApetrua() {
        return HoraApetrua;
    }

    public void setHoraApetrua(Time horaApetrua) {
        HoraApetrua = horaApetrua;
    }

    public Time getHoraCierre() {
        return HoraCierre;
    }

    public void setHoraCierre(Time horaCierre) {
        HoraCierre = horaCierre;
    }

    public String getMotivoReserva() {
        return MotivoReserva;
    }

    public void setMotivoReserva(String motivoReserva) {
        MotivoReserva = motivoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "DNI='" + DNI + '\'' +
                ", NumSala=" + NumSala +
                ", FechaReserva=" + FechaReserva +
                ", FecahFin=" + FecahFin +
                ", Confirmado=" + Confirmado +
                ", HoraApetrua=" + HoraApetrua +
                ", HoraCierre=" + HoraCierre +
                ", MotivoReserva='" + MotivoReserva + '\'' +
                '}';
    }
}
