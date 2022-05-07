package Interfaces;
import modelo.Login;


/**
*Crearemos una interfaz por cada modelo.
*El modelo, deberá de tener su:
        1.- Vista
        2.- Controller
        3.- Dao
 */
public interface InterfaceLogin {

    /**
     * Interface para el AdministradorDao
     */
        public interface InterfaceLoginDao {

            public boolean insertarNuevoUsuario(Login administrador);

            public boolean actualizarContrasenia(String usuarioAactualizar, String nuevaContrasenia);

            public boolean borrarUsuario(Login administrador);

            public String obtenerContraseniaPorUsuario(String usuario);

            public Login comprobarExistenciaUsuario(String usuario);
        }

    /**
     * Interface para la vista
     */
    public interface InterfaceVistaLogin {
            public void validaAdmin();
        }

        public  interface InterfaceControllerLogin {
            public boolean validadAdmin();
        }



}



