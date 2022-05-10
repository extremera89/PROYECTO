package controladores;

import Interfaces.InterfaceMonitor;
import dao.DAOcliente;
import dao.DAOmonitor;
import modelo.Cliente;
import modelo.Monitor;
import modelotablas.ModeloTablaMonitor;
import vistas.Ventanas.VentanaMonitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

public class ControladorMonitor implements InterfaceMonitor.InterfaceControladorMonitor, ActionListener, MouseListener {

    private DAOmonitor dao;
    private DAOcliente daoCliente=new DAOcliente();
    private VentanaMonitor ventanaMonitor;
    private ModeloTablaMonitor modeloTabla;
    private int filaPulsada=-1;

    public ControladorMonitor(DAOmonitor dao, VentanaMonitor guiMonitor){
        this.dao=dao;
        this.ventanaMonitor=guiMonitor;
        modeloTabla=new ModeloTablaMonitor(dao);
        ventanaMonitor.guiMonitor.getTablaMonitores().setModel(modeloTabla);
    }

    public void añadirMonitor(){
        ventanaMonitor.guiMonitor.limpiarCampoTxt();
        ventanaMonitor.guiMonitor.activaCamposTxt();
        ventanaMonitor.guiMonitor.activarBotonGuardar();
    }


    @Override
    public void crearMonitor() {
        String dni=ventanaMonitor.guiMonitor.getTxtDNI().getText();
        String nombre=ventanaMonitor.guiMonitor.getTxtNombre().getText();
        String apellido1=ventanaMonitor.guiMonitor.getTxtApellido1().getText();
        String apellido2=ventanaMonitor.guiMonitor.getTxtApellido2().getText();;
        String telefono=ventanaMonitor.guiMonitor.getTxtTelefono().getText();
        String email=ventanaMonitor.guiMonitor.getTxtEmail().getText();
        String titulacion=ventanaMonitor.guiMonitor.getTxtTitulacion().getText();

        //COMPROBACION CON EXPRESIONES REGULARES
        String rDNI="[0-9]{8}[A-Z]";
        String rTexto="^[a-zA-Z]+$";
        String rTelefono="^[6|7|9][0-9]{8}$";
        String rCorreo="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String rExpositor="[0|1]";

        if (!dni.equals("")&&!nombre.equals("")&&!apellido1.equals("")&&!apellido2.equals("")&&!telefono.equals("")&&!email.equals("")&&!titulacion.equals("")){
            if ((Pattern.matches(rDNI, dni) == true) && (Pattern.matches(rTexto, nombre) == true) && (Pattern.matches(rTexto, apellido1) == true) && (Pattern.matches(rTexto, apellido2) == true)
                    && (Pattern.matches(rTelefono, telefono) == true) && (Pattern.matches(rCorreo, email) == true) && (Pattern.matches(rTexto, titulacion) == true)) {
                if(daoCliente.buscarCliente(dni)==null){
                    if (dao.buscarMonitor(dni)==null){
                        modeloTabla.crearMonitor(dni, nombre, apellido1, apellido2, telefono, email, titulacion);
                        dao.insertarMonitor(new Monitor(dni, nombre, apellido1, apellido2, telefono, email, titulacion));
                        ventanaMonitor.guiMonitor.desactivarBotonGuardar();
                        ventanaMonitor.guiMonitor.limpiarCampoTxt();
                        ventanaMonitor.guiMonitor.activaCamposTxt();
                    }else JOptionPane.showMessageDialog(null, "Ya se cuenta con un monitor con dichos datos");
                }else JOptionPane.showMessageDialog(null, "No se puede registrar este monitor");
            } else JOptionPane.showMessageDialog(null, "Algún dato no esta bien introducido");
        }else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");

    }

    @Override
    public void eliminarMonitor() {
        dao.eliminarMonitor(ventanaMonitor.guiMonitor.getTablaMonitores().getValueAt(filaPulsada,0).toString());
        modeloTabla.eliminarMonitor(filaPulsada);
        ventanaMonitor.guiMonitor.desactivarBotonEliminar();
        ventanaMonitor.guiMonitor.limpiarCampoTxt();
        filaPulsada=-1;
    }

    @Override
    public void actualizarMonitor() {

    }

    @Override
    public void listarMonitores() {
        modeloTabla.setMonitores(dao.listarMonitores());
    }

    public void actualizarTabla(){
        modeloTabla.fireTableDataChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NUEVO"))
            añadirMonitor();
        else if (e.getActionCommand().equals("ELIMINAR"))
            eliminarMonitor();
        else if (e.getActionCommand().equals("GUARDAR"))
            crearMonitor();
        else if(e.getActionCommand().equals("LIMPIAR")){
            ventanaMonitor.guiMonitor.limpiarCampoTxt();
        }
        else if(e.getActionCommand().equals("ACTUALIZAR_TABLA")){
            actualizarTabla();
        }
        else if (e.getActionCommand().equals("ACTUALIZAR_DATOS")){
            actualizarMonitor();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = ventanaMonitor.guiMonitor.getTablaMonitores().rowAtPoint(e.getPoint());
        ventanaMonitor.guiMonitor.getTxtDNI().setText(ventanaMonitor.guiMonitor.getTablaMonitores().getValueAt(row, 0).toString());
        ventanaMonitor.guiMonitor.getTxtNombre().setText(ventanaMonitor.guiMonitor.getTablaMonitores().getValueAt(row,1).toString());
        ventanaMonitor.guiMonitor.getTxtApellido1().setText(ventanaMonitor.guiMonitor.getTablaMonitores().getValueAt(row, 2).toString());
        ventanaMonitor.guiMonitor.getTxtApellido2().setText(ventanaMonitor.guiMonitor.getTablaMonitores().getValueAt(row, 3).toString());
        ventanaMonitor.guiMonitor.getTxtTelefono().setText(ventanaMonitor.guiMonitor.getTablaMonitores().getValueAt(row,4).toString());
        ventanaMonitor.guiMonitor.getTxtEmail().setText(ventanaMonitor.guiMonitor.getTablaMonitores().getValueAt(row,5).toString());
        ventanaMonitor.guiMonitor.getTxtTitulacion().setText(ventanaMonitor.guiMonitor.getTablaMonitores().getValueAt(row,6).toString());
        ventanaMonitor.guiMonitor.dasactivarCampoTxt();
        ventanaMonitor.guiMonitor.activarBotonEliminar();
        ventanaMonitor.guiMonitor.desactivarBotonGuardar();
        filaPulsada = row;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
