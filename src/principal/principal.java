package principal;

import dao.DAOlogin;
import modelo.Login;

public class principal {
    public static void main(String[] args) {
        DAOlogin lg=new DAOlogin();

        Login l1=new Login("juan","juan",1);
        //lg.insertarNuevoUsuario(l1);
        //lg.borrarUsuario("juan");
        lg.cambiarContrasenia("juan","paquito");
        System.out.println(lg.comprobarExistenciaUsuario("juan"));
        lg.actualizarTipoUsuario("juan",0);

    }
}
