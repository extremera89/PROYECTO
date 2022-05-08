package principal;

import controladores.ControladorLogin;
import dao.DAOlogin;
import vistas.Ventanas.VentanaLogin;

public class GuiLogin {

    VentanaLogin ventanaLogin;

    public GuiLogin(){
        ventanaLogin=new VentanaLogin();
        DAOlogin dao=new DAOlogin();
        ControladorLogin controller=new ControladorLogin(dao,ventanaLogin);
        ventanaLogin.setControler(controller);
        ventanaLogin.iniciar();
    }

}
