package vistas.Ventanas;

import Interfaces.InterfaceExposicion;
import controladores.ControladorExposicion;
import modelo.Exposicion;
import vistas.Paneles.VistaExposicion;

import javax.swing.*;

public class VentanaExposicion extends JFrame implements InterfaceExposicion.InterfaceVistaExposicion {
    private ControladorExposicion controlador;
    private VistaExposicion vista;



    public VentanaExposicion() {
        vista = new VistaExposicion();
        this.vista.asignaCommandBotones();
        this.vista.desactivaCamposTexto();
        this.vista.desactivarBotonEliminar();
        this.vista.desactivarBotonGuardar();
        this.vista.desactivarBotonActualizar();
        this.vista.desactivarBotonSala();
        this.vista.insertarImagenes();
        this.setContentPane(vista.getPanelPrincipal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(tipoPerfil()==0){
            validarUsuario();
        }

        this.setTitle("Exposiciones.");
        this.pack();
    }

    public int tipoPerfil(){
        return VentanaLogin.tipoPerfil;
    }

    public void validarUsuario(){
        if(VentanaLogin.tipoPerfil==0){
            this.vista.desactivaCamposTexto();
            this.vista.getBtnNuevo().setVisible(false);
            this.vista.getBtnLimpiar().setVisible(false);
            this.vista.getBtnEliminar().setVisible(false);
            this.vista.getBtnSala().setVisible(false);
            this.vista.getBtnGuardar().setVisible(false);
            this.vista.getBtnActualizarDatos().setVisible(false);

        }
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
        this.vista.getBtnSala().addActionListener(controlador);
    }

    @Override
    public void iniciar() {
        controlador.listarExposiciones();
    }

}
