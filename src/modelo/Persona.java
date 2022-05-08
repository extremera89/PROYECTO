package modelo;

public class Persona {

    private String DNI;
    private String nombre;
    private String Apellido1;
    private String Apellido2;
    private String telefono;
    private String email;

    public Persona(){}

    public Persona(String DNI, String nombre, String apellido1, String apellido2, String telefono, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        Apellido1 = apellido1;
        Apellido2 = apellido2;
        this.telefono = telefono;
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", Apellido1='" + Apellido1 + '\'' +
                ", Apellido2='" + Apellido2 + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
