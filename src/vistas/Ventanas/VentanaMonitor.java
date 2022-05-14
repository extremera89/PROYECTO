package vistas.Ventanas;

import Interfaces.InterfaceCliente;
import Interfaces.InterfaceMonitor;
import controladores.ControladorCliente;
import controladores.ControladorMonitor;
import vistas.Paneles.VistaClientes;
import vistas.Paneles.VistaMonitor;

import javax.swing.*;

public class VentanaMonitor extends JFrame implements InterfaceMonitor.InterfaceVistaMonitor {

    private ControladorMonitor controller;
    public VistaMonitor guiMonitor;

    public VentanaMonitor(){
        guiMonitor=new VistaMonitor();
        guiMonitor.asignaCommandBotones();
        guiMonitor.dasactivarCampoTxt();
        guiMonitor.desactivarBotonGuardar();
        guiMonitor.desactivarBotonEliminar();
        guiMonitor.desactivarBotonActualizar();
        guiMonitor.insertarImagenes();
        this.setContentPane(guiMonitor.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clientes");
        this.pack();
        this.desactivarBotones();
    }



    @Override
    public void setController(ControladorMonitor controller) {
        this.controller=controller;
        guiMonitor.getBtnEliminar().addActionListener(controller);
        guiMonitor.getBtnGuardar().addActionListener(controller);
        guiMonitor.getBtnLimpiar().addActionListener(controller);
        guiMonitor.getBtnNuevo().addActionListener(controller);
        guiMonitor.getBtnActualizarTabla().addActionListener(controller);
        guiMonitor.getTablaMonitores().addMouseListener(controller);
        guiMonitor.getBtnActulizarDatos().addActionListener(controller);

    }

    @Override
    public void iniciar() {
        controller.listarMonitores();
        //this.setVisible(true);
    }

    public void desactivarBotones(){
        int tipoperfil = VentanaLogin.tipoPerfil;
        if (tipoperfil==0){
            guiMonitor.dasactivarCampoTxt();
            guiMonitor.getBtnNuevo().setVisible(false);
            guiMonitor.getBtnEliminar().setVisible(false);
            guiMonitor.getBtnGuardar().setVisible(false);
            guiMonitor.getBtnLimpiar().setVisible(false);
            guiMonitor.getBtnActulizarDatos().setVisible(false);
            guiMonitor.getBtnActualizarTabla().setVisible(false);
        }
    }
}
