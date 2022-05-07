package principal;

import modelo.Login;

public class principal {
    public static void main(String[] args) {
        DAO.LoginDAO lg=new DAO.LoginDAO();

        Login l1=new Login("juan","juan",1);
        //lg.insertarNuevoUsuario(l1);
        //lg.borrarUsuario("juan");
        lg.cambiarContraseña("juan","paquito");
        System.out.println(lg.comprobarExistenciaUsuario("juan"));
        lg.actualizarTipoUsuario("juan",0);

    }
}
