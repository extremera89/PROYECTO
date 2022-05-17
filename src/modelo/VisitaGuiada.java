package modelo;

import java.util.Date;

public class VisitaGuiada {
    private int numvisita;
    private int numpersonas;
    private Date fecha;
    private String centro;
    private String dnimonitor;
    private String dnicliente;


    public VisitaGuiada() {
    }

    public VisitaGuiada( int numpersonas, Date fecha, String centro, String dnimonitor, String dnicliente) {
        this.numpersonas = numpersonas;
        this.fecha = fecha;
        this.centro = centro;
        this.dnimonitor = dnimonitor;
        this.dnicliente = dnicliente;
    }

    public VisitaGuiada(int numpersonas, Date fecha, String centro) {
        this.numpersonas = numpersonas;
        this.fecha = fecha;
        this.centro = centro;
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

    public String getDnicliente() {
        return dnicliente;
    }

    public void setDnicliente(String dnicliente) {
        this.dnicliente = dnicliente;
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
