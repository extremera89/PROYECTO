package modelo;

public class Cliente extends Persona{
    private int Es_Expositor;

    public Cliente(){

    }

    public Cliente(String DNI, String nombre, String apellido1, String apellido2, String telefono, String email, int es_Expositor) {
        super(DNI, nombre, apellido1, apellido2, telefono, email);
        Es_Expositor = es_Expositor;
    }

    public void setEs_Expositor(int es_Expositor) {
        Es_Expositor = es_Expositor;
    }

    public int getEs_Expositor() {
        return Es_Expositor;
    }

    @Override
    public String toString() {
        return "Cliente{" +super.toString() +"Es_Expositor=" + Es_Expositor + "} ";
    }
}
