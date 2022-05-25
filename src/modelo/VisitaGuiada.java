package modelo;

import java.util.Date;

public class VisitaGuiada {
    private int numvisita;
    private int numpersonas;
    private Date fecha;
    private Centro centro;
    private Monitor dnimonitor;
    private Cliente dnicliente;
    private Exposicion numExp;


    public VisitaGuiada() {
        this.centro = new Centro();
        this.dnimonitor = new Monitor();
        this.dnicliente = new Cliente();
        this.numExp = new Exposicion();
    }
    public VisitaGuiada(int numvisita, int numpersonas, Date fecha, Centro centro, Monitor dnimonitor, Cliente dnicliente, Exposicion numExp) {
        this.centro = new Centro();
        this.dnimonitor = new Monitor();
        this.numExp = new Exposicion();
        this.dnicliente = new Cliente();

        this.numvisita = numvisita;
        this.centro = new Centro();
        this.dnicliente = new Cliente();
        this.dnimonitor = new Monitor();
        this.numExp = new Exposicion();
        this.numpersonas = numpersonas;
        this.fecha = fecha;
        this.centro.setCodCentro(centro.getCodCentro());
        this.dnimonitor.setDNI(dnimonitor.getDNI());
        this.dnicliente.setDNI(dnicliente.getDNI());
        this.numExp.setNumExp(numExp.getNumExp());
    }

    public VisitaGuiada(int numpersonas, Date fecha, Centro centro, Monitor dnimonitor, Cliente dnicliente, Exposicion numExp) {
        this.centro = new Centro();
        this.dnimonitor = new Monitor();
        this.numExp = new Exposicion();
        this.dnicliente = new Cliente();


        this.centro = new Centro();
        this.dnicliente = new Cliente();
        this.dnimonitor = new Monitor();
        this.numExp = new Exposicion();
        this.numpersonas = numpersonas;
        this.fecha = fecha;
        this.centro.setCodCentro(centro.getCodCentro());
        this.dnimonitor.setDNI(dnimonitor.getDNI());
        this.dnicliente.setDNI(dnicliente.getDNI());
        this.numExp.setNumExp(numExp.getNumExp());
    }

    public VisitaGuiada(int numpersonas, Date fecha, Centro centro) {
        this.centro = new Centro();
        this.numpersonas = numpersonas;
        this.fecha = fecha;
        this.centro.setCodCentro(centro.getCodCentro());
    }

    public VisitaGuiada(int numvisita, int numpersonas) {
        this.numpersonas = numpersonas;
        this.numvisita = numvisita;
    }

    public VisitaGuiada(VisitaGuiada saberDatos) {
        this.numpersonas = saberDatos.getNumpersonas();
        this.numvisita = saberDatos.getNumvisita();
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

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    public Monitor getDnimonitor() {
        return dnimonitor;
    }

    public void setDnimonitor(Monitor dnimonitor) {
        this.dnimonitor = dnimonitor;
    }

    public Cliente getDnicliente() {
        return dnicliente;
    }

    public void setDnicliente(Cliente dnicliente) {
        this.dnicliente = dnicliente;
    }

    public Exposicion getNumExp() {
        return numExp;
    }

    public void setNumExp(Exposicion numExp) {
        this.numExp = numExp;
    }

    @Override
    public String toString() {
        return "VisitaGuiada{" +
                "numvisita=" + numvisita +
                ", numpersonas=" + numpersonas +
                ", fecha=" + fecha +
                ", centro='" + centro + '\'' +
                ", dnimonitor='" + dnimonitor + '\'' +
                ", dnicliente='" + dnicliente + '\'' +
                ", numExp=" + numExp +
                '}';
    }
}
