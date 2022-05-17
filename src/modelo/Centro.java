package modelo;

public class Centro {

    private String codCentro;
    private String nombre;
    private int numVisita;
    private String dniCliente;
    private String dniMonitor;

    public Centro(){}

    public Centro(String codCentro, String nombre, int numVisita, String dniCliente, String dniMonitor) {
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

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDniMonitor() {
        return dniMonitor;
    }

    public void setDniMonitor(String dniMonitor) {
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
