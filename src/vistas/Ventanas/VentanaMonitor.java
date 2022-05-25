package vistas.Ventanas;

import Interfaces.InterfaceCliente;
import Interfaces.InterfaceMonitor;
import controladores.ControladorCliente;
import controladores.ControladorMonitor;
import vistas.Paneles.VistaClientes;
import vistas.Paneles.VistaMonitor;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        guiMonitor.cargarCombobox();
        guiMonitor.insertarImagenes();
        guiMonitor.getTxtTitulacion().setEnabled(false);
        this.setContentPane(guiMonitor.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clientes");
        this.pack();
        this.desactivarBotones();
    }

    public void filtro() {
        TableRowSorter trsfiltro = new TableRowSorter(guiMonitor.getTablaMonitores().getModel());
        guiMonitor.getTablaMonitores().setRowSorter(trsfiltro);

        String filtro = guiMonitor.getTxtBuscadorMonitor().getText();
        trsfiltro.setRowFilter(RowFilter.regexFilter(guiMonitor.getTxtBuscadorMonitor().getText(),0));
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
        guiMonitor.getTxtBuscadorMonitor().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (guiMonitor.getTxtBuscadorMonitor().getText());
                guiMonitor.getTxtBuscadorMonitor().setText(cadena);
                repaint();
                filtro();
            }
        });

    }

    @Override
    public void iniciar() {
        controller.listarMonitores();
        //this.setVisible(true);
    }
    public int tipoPerfil(){
        return VentanaLogin.tipoPerfil;
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

            guiMonitor.getCmbox().setVisible(false);
        }
    }
}
