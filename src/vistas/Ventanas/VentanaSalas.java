package vistas.Ventanas;

import Interfaces.InterfaceSalas;
import controladores.ControladorSala;
import vistas.Paneles.VistaSalas;
import javax.swing.*;

public class VentanaSalas extends JFrame implements InterfaceSalas.InterfaceVistaSala {


    private ControladorSala controller;
    public VistaSalas guiSalas;

    public VentanaSalas(){
        guiSalas =new VistaSalas();
        guiSalas.asignaCommandBotones();
        guiSalas.dasactivarCampoTxt();
        guiSalas.desactivarBotonGuardar();
        guiSalas.desactivarBotonEliminar();
        guiSalas.desactivarBotonActualizar();
        guiSalas.insertarImagenes();
        this.setContentPane(guiSalas.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Salas");
        this.pack();
        this.desactivarBotones();
    }


    @Override
    public void setController(ControladorSala controller) {
        this.controller=controller;
        guiSalas.getBtnEliminar().addActionListener(controller);
        guiSalas.getBtnGuardar().addActionListener(controller);
        guiSalas.getBtnLimpiar().addActionListener(controller);
        guiSalas.getBtnNuevo().addActionListener(controller);
        guiSalas.getBtnActualizarTabla().addActionListener(controller);
        guiSalas.getTblSalas().addMouseListener(controller);
        guiSalas.getBtnActulizarDatos().addActionListener(controller);
    }

    @Override
    public void iniciar() {
        controller.listarSala();
        //this.setVisible(true);

    }

    public void desactivarBotones(){
        int tipoperfil = VentanaLogin.tipoPerfil;
        if (tipoperfil==0){
            guiSalas.dasactivarCampoTxt();
            guiSalas.getBtnNuevo().setVisible(false);
            guiSalas.getBtnEliminar().setVisible(false);
            guiSalas.getBtnGuardar().setVisible(false);
            guiSalas.getBtnLimpiar().setVisible(false);
            guiSalas.getBtnActulizarDatos().setVisible(false);
            guiSalas.getBtnActualizarTabla().setVisible(false);
        }
    }
}
