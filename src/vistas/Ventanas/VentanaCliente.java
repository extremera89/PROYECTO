package vistas.Ventanas;

import Interfaces.InterfaceCliente;
import controladores.ControladorCliente;
import controladores.ControladorLogin;
import dao.DAOlogin;
import vistas.Paneles.VistaClientes;

import javax.swing.*;

public class VentanaCliente extends JFrame implements InterfaceCliente.InterfaceVistaCliente {


    private ControladorCliente controller;
    public VistaClientes guiClientes;

    DAOlogin daOlogin=new DAOlogin();
    VentanaLogin ventanaLogin=new VentanaLogin();
    ControladorLogin controladorLogin=new ControladorLogin(daOlogin,ventanaLogin);

    public VentanaCliente(){
        guiClientes=new VistaClientes();
        guiClientes.asignaCommandBotones();
        guiClientes.dasactivarCampoTxt();
        guiClientes.desactivarBotonGuardar();
        guiClientes.desactivarBotonEliminar();
        guiClientes.desactivarBotonActualizar();
        this.setContentPane(guiClientes.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clientes");
        this.pack();
        desactivarBotones();

    }


    @Override
    public void setController(ControladorCliente controller) {
        this.controller=controller;
        guiClientes.getBtnEliminar().addActionListener(controller);
        guiClientes.getBtnGuardar().addActionListener(controller);
        guiClientes.getBtnLimpiar().addActionListener(controller);
        guiClientes.getBtnNuevo().addActionListener(controller);
        guiClientes.getBtnActualizarTabla().addActionListener(controller);
        guiClientes.getBtnActulizarDatos().addActionListener(controller);
        guiClientes.getTablaClientes().addMouseListener(controller);
    }

    @Override
    public void iniciar() {
        controller.listarClietes();
        //this.setVisible(true);
    }

    public void desactivarBotones(){
        System.out.println(controladorLogin.getPerfilAdministrador());
        if (controladorLogin.getPerfilAdministrador()==0){
            guiClientes.getBtnNuevo().setEnabled(false);
        }
    }
}
