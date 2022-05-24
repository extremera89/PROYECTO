package modelo;

public class Centro {

    private String codCentro;
    private String nombre;
    private int numVisita;
    private Cliente dniCliente;
    private Monitor dniMonitor;

    public Centro(){
        this.dniCliente = new Cliente();
        this.dniMonitor = new Monitor();
    }

    public Centro(String codCentro, String nombre, int numVisita, Cliente dniCliente, Monitor dniMonitor) {
        this.codCentro = codCentro;
        this.nombre = nombre;
        this.numVisita = numVisita;
        this.dniCliente = dniCliente;
        this.dniMonitor = dniMonitor;
    }

    public String getCodCentro() {
        return codCentro;
    }

    public void setCodCentro(String codCentro) {
        this.codCentro = codCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumVisita() {
        return numVisita;
    }

    public void setNumVisita(int numVisita) {
        this.numVisita = numVisita;
    }

    public Cliente getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(Cliente dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Monitor getDniMonitor() {
        return dniMonitor;
    }

    public void setDniMonitor(Monitor dniMonitor) {
        this.dniMonitor = dniMonitor;
    }

    @Override
    public String toString() {
        return "Centro{" +
                "codCentro='" + codCentro + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numVisita=" + numVisita +
                ", dniCliente='" + dniCliente + '\'' +
                ", dniMonitor='" + dniMonitor + '\'' +
                '}';
    }
}
