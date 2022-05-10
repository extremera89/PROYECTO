package vistas.Ventanas;

import Interfaces.InterfaceExposicion;
import controladores.ControladorExposicion;
import dao.DAOexposicion;
import modelo.Exposicion;
import vistas.Paneles.VistaExposicion;

import javax.swing.*;
import java.util.Date;

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
        this.setVisible(true);
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
        this.vista.getBtnActualizarDatos().addActionListener(controlador);
        this.vista.getBtnActualizarTabla().addActionListener(controlador);
        this.vista.getBtnGuardar().addActionListener(controlador);
        this.vista.getBtnLimpiar().addActionListener(controlador);
        this.vista.getBtnNuevo().addActionListener(controlador);
        this.vista.getBtnEliminar().addActionListener(controlador);
    }





    public static void main(String[] args) {
        DAOexposicion dao = new DAOexposicion();
        //VentanaExposicion menu = new VentanaExposicion();
        //ControladorExposicion controlador = new ControladorExposicion(dao, menu);
        //menu.setControler(controlador);
        //Date fechainicio = new Date(24/7/1994);
        //dao.insertarExposicion(new Exposicion("Ars Noveau","Arte",fechainicio,new Date(22/8/1995),"Una exposicion de cuadros de artistas franceses",10));

        for(Exposicion prueba: dao.listarExposiciones()){
            System.out.println(prueba.toString());
        }

        //new VentanaExposicion();


    }

}
