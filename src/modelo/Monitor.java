package modelo;

public class Monitor extends Persona{

    private String titulacion;

    public Monitor(){}

    public Monitor(String DNI, String nombre, String apellido1, String apellido2, String telefono, String email, String titulacion) {
        super(DNI, nombre, apellido1, apellido2, telefono, email);
        this.titulacion = titulacion;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString() {
        return "Monitor{" + super.toString()+"titulación='" + titulacion + '\'' +"} ";
    }
}
