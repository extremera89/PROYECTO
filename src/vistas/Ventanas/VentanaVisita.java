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
        this.vista.getTxtNumVisita().setEnabled(false);
        this.setContentPane(vista.getPanelPrincipal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(tipoPerfil()==0){
            validarUsuario();
        }
        this.setTitle("Visitas.");
        this.pack();
    }
    public int tipoPerfil(){
        return VentanaLogin.tipoPerfil;
    }

    public void validarUsuario(){
        if(VentanaLogin.tipoPerfil==0){
            this.vista.dasactivarCampoTxt();
            this.vista.getBtnExp().setEnabled(false);
            this.vista.getBtnMon().setEnabled(false);
            this.vista.getBtnCli().setEnabled(false);
            this.vista.getBtnNuevo().setVisible(false);
            this.vista.getBtnLimpiar().setVisible(false);
            this.vista.getBtnEliminar().setVisible(false);
            this.vista.getBtnGuardar().setVisible(false);
            this.vista.getBtnActualizarDatos().setVisible(false);
        }
    }

    @Override
    public void setControler(ControladorVisita controlador) {
        this.controlador = controlador;
        controlador.cargarDNIClientes();
        controlador.cargarDNIMonitores();
        controlador.cargarExposiciones();
        this.vista.getBtnActualizarDatos().addActionListener(controlador);
        this.vista.getBtnActualizarTabla().addActionListener(controlador);
        this.vista.getBtnGuardar().addActionListener(controlador);
        this.vista.getBtnLimpiar().addActionListener(controlador);
        this.vista.getBtnNuevo().addActionListener(controlador);
        this.vista.getBtnEliminar().addActionListener(controlador);
        this.vista.getTable1().addMouseListener(controlador);
        this.vista.getBtnExp().addActionListener(controlador);
        this.vista.getBtnCli().addActionListener(controlador);
        this.vista.getBtnMon().addActionListener(controlador);

    }

    @Override
    public void iniciar() {
        controlador.listarVisitas();
    }

    public VistaVisita getVista() {
        return vista;
    }

    public void setVista(VistaVisita vista) {
        this.vista = vista;
    }
}
