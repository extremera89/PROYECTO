package vistas.Ventanas;

import Interfaces.InterfaceCentro;
import controladores.ControladorCentro;
import controladores.ControladorCliente;
import principal.GuiCentro;
import vistas.Paneles.VistaCentro;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaCentro extends JFrame implements InterfaceCentro.InterfaceVistaCentro {

    private ControladorCentro controller;
    public VistaCentro guiCentro;

    public VentanaCentro(){
        guiCentro=new VistaCentro();
        guiCentro.asignaCommandBotones();
        guiCentro.dasactivarCampoTxt();
        guiCentro.desactivarBotonGuardar();
        guiCentro.desactivarBotonEliminar();
        guiCentro.desactivarBotonActualizar();
        guiCentro.insertarImagenes();
        this.desactivarBotones();
        this.setContentPane(guiCentro.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Centros");
        this.pack();
        guiCentro.getTxtDNICliente().setVisible(false);
        guiCentro.getTxtDNIMonitor().setVisible(false);
    }

    public void filtro() {
        TableRowSorter trsfiltro = new TableRowSorter(guiCentro.getTablaCentros().getModel());
        guiCentro.getTablaCentros().setRowSorter(trsfiltro);

        String filtro = guiCentro.getTxtBuscador().getText();
        trsfiltro.setRowFilter(RowFilter.regexFilter(guiCentro.getTxtBuscador().getText(),0));
    }



    @Override
    public void setController(ControladorCentro controller) {
        this.controller=controller;
        controller.cargarDNIClientes();
        controller.cargarDNIMonitores();
        guiCentro.getBtnEliminar().addActionListener(controller);
        guiCentro.getBtnGuardar().addActionListener(controller);
        guiCentro.getBtnLimpiar().addActionListener(controller);
        guiCentro.getBtnNuevo().addActionListener(controller);
        guiCentro.getBtnActualizarTabla().addActionListener(controller);
        guiCentro.getTablaCentros().addMouseListener(controller);
        guiCentro.getBtnActulizarDatos().addActionListener(controller);
        guiCentro.getBtnComMonitor().addActionListener(controller);
        guiCentro.getBtnComCliente().addActionListener(controller);
        guiCentro.getTxtBuscador().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (guiCentro.getTxtBuscador().getText());
                guiCentro.getTxtBuscador().setText(cadena);
                repaint();
                filtro();
            }
        });
    }

    @Override
    public void iniciar() {
        controller.listarCentros();
        //this.setVisible(true);
    }
    public int tipoPerfil(){
        return VentanaLogin.tipoPerfil;
    }

    public void desactivarBotones(){
        int tipoperfil = VentanaLogin.tipoPerfil;
        if (tipoperfil==0){
            guiCentro.dasactivarCampoTxt();
            guiCentro.getBtnNuevo().setVisible(false);
            guiCentro.getBtnEliminar().setVisible(false);
            guiCentro.getBtnGuardar().setVisible(false);
            guiCentro.getBtnLimpiar().setVisible(false);
            guiCentro.getBtnActulizarDatos().setVisible(false);
            guiCentro.getCmboxCliente().setEnabled(false);
            guiCentro.getComBoxMonitor().setEnabled(false);

            guiCentro.getBtnComCliente().setVisible(false);
            guiCentro.getBtnComMonitor().setVisible(false);
        }
    }
}
