package modelo;

public class Monitor extends Persona{

    private String titulación;

    public Monitor(){}

    public Monitor(String DNI, String nombre, String apellido1, String apellido2, String telefono, String email, String titulación) {
        super(DNI, nombre, apellido1, apellido2, telefono, email);
        this.titulación = titulación;
    }

    public String getTitulación() {
        return titulación;
    }

    public void setTitulación(String titulación) {
        this.titulación = titulación;
    }

    @Override
    public String toString() {
        return "Monitor{" + super.toString()+"titulación='" + titulación + '\'' +"} ";
    }
}
