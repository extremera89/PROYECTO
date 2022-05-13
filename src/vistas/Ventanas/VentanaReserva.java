package vistas.Ventanas;

import Interfaces.InterfaceReserva;
import controladores.ControladorReserva;
import vistas.Paneles.VistaReserva;


import javax.swing.*;

public class VentanaReserva extends JFrame implements InterfaceReserva.InterfaceVistaReserva {


    private ControladorReserva controller;
    public VistaReserva guiReservas;

    public VentanaReserva(){
        guiReservas =new VistaReserva();
        guiReservas.asignaCommandBotones();
        guiReservas.dasactivarCampoTxt();
        guiReservas.desactivarBotonGuardar();
        guiReservas.desactivarBotonEliminar();
        guiReservas.desactivarBotonActualizar();
        this.setContentPane(guiReservas.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Reservas");
        this.pack();
    }


    @Override
    public void setController(ControladorReserva controller) {
        this.controller=controller;
        guiReservas.getBtnEliminar().addActionListener(controller);
        guiReservas.getBtnGuardar().addActionListener(controller);
        guiReservas.getBtnLimpiar().addActionListener(controller);
        guiReservas.getBtnNuevo().addActionListener(controller);
        guiReservas.getBtnActualizarTabla().addActionListener(controller);
        guiReservas.getTableReserva().addMouseListener(controller);
        guiReservas.getBtnActulizarDatos().addActionListener(controller);
    }



    @Override
    public void iniciar() {
        controller.listarReserva();
        this.setVisible(true);
    }
}
