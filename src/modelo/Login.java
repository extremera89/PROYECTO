package modelo;

public class Login {

    private String usuario;
    private String contrasenia;
    private int perUsuario;

    public Login(String usuario, String contrasenia, int perUsuario) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.perUsuario = perUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getPerUsuario() {
        return perUsuario;
    }

    public void setPerUsuario(int perUsuario) {
        this.perUsuario = perUsuario;
    }

    @Override
    public String toString() {
        return "Login{" +
                "usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", perUsuario=" + perUsuario +
                '}';
    }
}
