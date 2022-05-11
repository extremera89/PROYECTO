package modelo;

import java.util.Date;

public class VisitaGuiada {
    private int numvisita;
    private int numpersonas;
    private Date fecha;
    private String centro;
    private String dnimonitor;
    //private Monitor monitor;


    public VisitaGuiada() {
    }

    public VisitaGuiada(int numvisita, int numpersonas, Date fecha, String centro, String dnimonitor) {
        this.numvisita = numvisita;
        this.numpersonas = numpersonas;
        this.fecha = fecha;
        this.centro = centro;
        this.dnimonitor = dnimonitor;
    }

    public int getNumvisita() {
        return numvisita;
    }

    public void setNumvisita(int numvisita) {
        this.numvisita = numvisita;
    }

    public int getNumpersonas() {
        return numpersonas;
    }

    public void setNumpersonas(int numpersonas) {
        this.numpersonas = numpersonas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getDnimonitor() {
        return dnimonitor;
    }

    public void setDnimonitor(String dnimonitor) {
        this.dnimonitor = dnimonitor;
    }

    /*public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }*/

    @Override
    public String toString() {
        return "VisitaGuiada{" +
                "numvisita=" + numvisita +
                ", numpersonas=" + numpersonas +
                ", fecha=" + fecha +
                ", centro='" + centro + '\'' +
                ", dnimonitor='" + dnimonitor + '\'' +
                '}';
    }
}
