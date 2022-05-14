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
        this.setContentPane(guiSalas.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Salas");
        this.pack();
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
        this.setVisible(true);
    }
}
