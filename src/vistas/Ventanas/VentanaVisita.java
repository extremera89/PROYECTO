package vistas.Ventanas;

import Interfaces.InterfaceVisitaGuiada;
import controladores.ControladorVisita;
import vistas.Paneles.VistaVisita;

import javax.swing.*;

public class VentanaVisita extends JFrame implements InterfaceVisitaGuiada.InterfaceVistaVisita {

    private ControladorVisita controlador;
    private VistaVisita vista;


    public VentanaVisita(){
        vista = new VistaVisita();
        this.vista.asignaCommandBotones();
        this.vista.dasactivarCampoTxt();
        this.vista.desactivarBotonEliminar();
        this.vista.desactivarBotonGuardar();
        this.vista.desactivarBotonActualizar();
        this.setContentPane(vista.getPanelPrincipal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Visitas.");
        this.pack();
    }

    @Override
    public void setControler(ControladorVisita controlador) {
        this.controlador = controlador;
        this.vista.getBtnActualizarDatos().addActionListener(controlador);
        this.vista.getBtnActualizarTabla().addActionListener(controlador);
        this.vista.getBtnGuardar().addActionListener(controlador);
        this.vista.getBtnLimpiar().addActionListener(controlador);
        this.vista.getBtnNuevo().addActionListener(controlador);
        this.vista.getBtnEliminar().addActionListener(controlador);
        this.vista.getTable1().addMouseListener(controlador);
    }

    @Override
    public void iniciar() {
        //controlador.listarExposiciones();
        this.setVisible(true);
    }
}
