package vistas.Ventanas;

import Interfaces.InterfaceCliente;
import controladores.ControladorCliente;
import controladores.ControladorLogin;
import dao.DAOlogin;
import vistas.Paneles.VistaClientes;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaCliente extends JFrame implements InterfaceCliente.InterfaceVistaCliente {


    private ControladorCliente controller;
    public VistaClientes guiClientes;



    public VentanaCliente(){
        guiClientes=new VistaClientes();
        guiClientes.asignaCommandBotones();
        guiClientes.dasactivarCampoTxt();
        guiClientes.desactivarBotonGuardar();
        guiClientes.desactivarBotonEliminar();
        guiClientes.desactivarBotonActualizar();
        guiClientes.insertarImagenes();
        this.setContentPane(guiClientes.getPanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clientes");
        this.pack();
        desactivarBotones();

    }
    public void filtro() {
        TableRowSorter trsfiltro = new TableRowSorter(guiClientes.getTablaClientes().getModel());
        guiClientes.getTablaClientes().setRowSorter(trsfiltro);

        String filtro = guiClientes.getTxtBuscadorDNI().getText();
        trsfiltro.setRowFilter(RowFilter.regexFilter(guiClientes.getTxtBuscadorDNI().getText(),0));
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
        guiClientes.getTxtBuscadorDNI().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (guiClientes.getTxtBuscadorDNI().getText());
                guiClientes.getTxtBuscadorDNI().setText(cadena);
                repaint();
                filtro();
            }
        });
    }

    @Override
    public void iniciar() {
        controller.listarClietes();
        //this.setVisible(true);
    }
    public int tipoPerfil(){
        return VentanaLogin.tipoPerfil;
    }
    public void desactivarBotones(){
        int tipoperfil = VentanaLogin.tipoPerfil;
        if (tipoperfil==0){
            guiClientes.dasactivarCampoTxt();
            guiClientes.getBtnNuevo().setVisible(false);
            guiClientes.getBtnEliminar().setVisible(false);
            guiClientes.getBtnGuardar().setVisible(false);
            guiClientes.getBtnLimpiar().setVisible(false);
            guiClientes.getBtnActulizarDatos().setVisible(false);

        }
    }
}
