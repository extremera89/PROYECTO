package vistas.Ventanas;

import Interfaces.InterfaceReserva;
import controladores.ControladorReserva;
import vistas.Paneles.VistaReserva;


import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        guiReservas.insertarImagenes();
        this.setContentPane(guiReservas.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Reservas");
        this.pack();
        this.desactivarBotones();
    }

    public void filtro() {
        TableRowSorter trsfiltro = new TableRowSorter(guiReservas.getTableReserva().getModel());
        guiReservas.getTableReserva().setRowSorter(trsfiltro);

        String filtro = guiReservas.getTxtBuscador().getText();
        trsfiltro.setRowFilter(RowFilter.regexFilter(guiReservas.getTxtBuscador().getText(), 1));
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
        guiReservas.getTxtBuscador().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (guiReservas.getTxtBuscador().getText());
                guiReservas.getTxtBuscador().setText(cadena);
                repaint();
                filtro();
            }
        });
    }



    @Override
    public void iniciar() {
        controller.listarReserva();
        //this.setVisible(true);
    }

    public void desactivarBotones(){
        int tipoperfil = VentanaLogin.tipoPerfil;
        if (tipoperfil==0){
            guiReservas.dasactivarCampoTxt();
            guiReservas.getBtnNuevo().setVisible(false);
            guiReservas.getBtnEliminar().setVisible(false);
            guiReservas.getBtnGuardar().setVisible(false);
            guiReservas.getBtnLimpiar().setVisible(false);
            guiReservas.getBtnActulizarDatos().setVisible(false);
            guiReservas.getBtnActualizarTabla().setVisible(false);
        }
    }
}
