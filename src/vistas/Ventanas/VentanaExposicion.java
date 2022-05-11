package vistas.Ventanas;

import Interfaces.InterfaceExposicion;
import controladores.ControladorExposicion;
import vistas.Paneles.VistaExposicion;

import javax.swing.*;

public class VentanaExposicion extends JFrame implements InterfaceExposicion.InterfaceVistaExposicion {
    private ControladorExposicion controlador;
    private VistaExposicion vista;


    public VentanaExposicion(){
        vista = new VistaExposicion();
        this.vista.asignaCommandBotones();
        this.vista.desactivaCamposTexto();
        this.vista.desactivarBotonEliminar();
        this.vista.desactivarBotonGuardar();
        this.vista.desactivarBotonActualizar();
        this.setContentPane(vista.getPanelPrincipal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Exposiciones.");
        this.pack();
    }


    public ControladorExposicion getControlador() {
        return controlador;
    }

    public void setControlador(ControladorExposicion controlador) {
        this.controlador = controlador;
    }

    public VistaExposicion getVista() {
        return vista;
    }

    public void setVista(VistaExposicion vista) {
        this.vista = vista;
    }

    @Override
    public void setControler(ControladorExposicion controlador) {
        this.controlador = controlador;
        this.vista.getBtnActualizarDatos().addActionListener(controlador);
        this.vista.getBtnActualizarTabla().addActionListener(controlador);
        this.vista.getBtnGuardar().addActionListener(controlador);
        this.vista.getBtnLimpiar().addActionListener(controlador);
        this.vista.getBtnNuevo().addActionListener(controlador);
        this.vista.getBtnEliminar().addActionListener(controlador);
        this.vista.getTable1().addMouseListener(controlador);
    }

    public void iniciar(){
        controlador.listarExposiciones();
        this.setVisible(true);
        System.out.println("prueba iniciar");
    }



    public static void main(String[] args) {



    }

}
