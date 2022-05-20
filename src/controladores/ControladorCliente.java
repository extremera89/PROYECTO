package controladores;

import Interfaces.InterfaceCliente;
import dao.DAOcliente;
import dao.DAOmonitor;
import modelo.Cliente;
import modelotablas.ModeloTablaCliente;
import vistas.Ventanas.VentanaCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

public class ControladorCliente implements InterfaceCliente.InterfaceControladorCliente, ActionListener, MouseListener {

    private DAOcliente dao;
    private DAOmonitor daoMonitor=new DAOmonitor();
    private VentanaCliente ventanaCliente;
    private ModeloTablaCliente modeloTabla;
    private int filaPulsada=-1;

    public ControladorCliente(DAOcliente dao, VentanaCliente guiCliente){
        this.dao=dao;
        this.ventanaCliente=guiCliente;
        modeloTabla=new ModeloTablaCliente(dao);
        ventanaCliente.guiClientes.getTablaClientes().setModel(modeloTabla);
    }

    public void añadirCliente(){
        ventanaCliente.guiClientes.limpiarCampoTxt();
        ventanaCliente.guiClientes.activaCamposTxt();
        ventanaCliente.guiClientes.activarBotonGuardar();
        ventanaCliente.guiClientes.activarBotonLimpiar();
    }

    @Override
    public void crearCliente() {
        String dni=ventanaCliente.guiClientes.getTxtDNI().getText();
        String nombre=ventanaCliente.guiClientes.getTxtNombre().getText();
        String apellido1=ventanaCliente.guiClientes.getTxtApellido1().getText();
        String apellido2=ventanaCliente.guiClientes.getTxtApellido2().getText();;
        String telefono=ventanaCliente.guiClientes.getTxtTelefono().getText();
        String email=ventanaCliente.guiClientes.getTxtEmail().getText();
        String expositor=ventanaCliente.guiClientes.getTxtExpositor().getText();

        //COMPROBACION CON EXPRESIONES REGULARES
        String rDNI="[0-9]{8}[A-Z]";
        String rTexto="^[a-zA-Z]+$";
        String rTelefono="^[6|7|9][0-9]{8}$";
        String rCorreo="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String rExpositor="[si|sí|SI|SÍ|no|NO]";


        if (!dni.equals("")&&!nombre.equals("")&&!apellido1.equals("")&&!apellido2.equals("")&&!telefono.equals("")&&!email.equals("")&&!expositor.equals("")) {
            if ((Pattern.matches(rDNI, dni) == true) && (Pattern.matches(rTexto, nombre) == true) && (Pattern.matches(rTexto, apellido1) == true) && (Pattern.matches(rTexto, apellido2) == true)
                    && (Pattern.matches(rTelefono, telefono) == true) && (Pattern.matches(rCorreo, email) == true))  {
                int numExpo = -1;
                if (expositor.equals("SI") == true || expositor.equals("si") == true || expositor.equals("SÍ") == true || expositor.equals("sí") == true) {
                    numExpo = 1;
                } else
                    numExpo = 0;
                if (daoMonitor.buscarMonitor(dni) == null) {
                    if (dao.buscarCliente(dni) == null) {
                        modeloTabla.crearCliente(dni, nombre, apellido1, apellido2, telefono, email, numExpo);
                        dao.insertarCliente(new Cliente(dni, nombre, apellido1, apellido2, telefono, email, numExpo));
                        ventanaCliente.guiClientes.desactivarBotonGuardar();
                        ventanaCliente.guiClientes.limpiarCampoTxt();
                        ventanaCliente.guiClientes.activaCamposTxt();
                    } else JOptionPane.showMessageDialog(null, "Ya se cuenta con un cliente con dichos datos");
                } else JOptionPane.showMessageDialog(null, "No se puede registrar este cliente");
            } else JOptionPane.showMessageDialog(null, "Algún dato no esta bien introducido");
        }else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");

    }

    @Override
    public void eliminarCliente() {
        dao.eliminarCliente(ventanaCliente.guiClientes.getTablaClientes().getValueAt(filaPulsada,0).toString());
        modeloTabla.eliminarCliente(filaPulsada);
        ventanaCliente.guiClientes.desactivarBotonEliminar();
        ventanaCliente.guiClientes.limpiarCampoTxt();
        filaPulsada=-1;
    }

    @Override
    public void actualizarCliente() {
        String dni=ventanaCliente.guiClientes.getTxtDNI().getText();
        String nombre=ventanaCliente.guiClientes.getTxtNombre().getText();
        String apellido1=ventanaCliente.guiClientes.getTxtApellido1().getText();
        String apellido2=ventanaCliente.guiClientes.getTxtApellido2().getText();
        String telefono=ventanaCliente.guiClientes.getTxtTelefono().getText();
        String email=ventanaCliente.guiClientes.getTxtEmail().getText();
        String exposi=ventanaCliente.guiClientes.getTxtExpositor().getText();
        int numExpo = -1;
        if (exposi.equals("SI") == true || exposi.equals("si") == true || exposi.equals("SÍ") == true || exposi.equals("sí") == true) {
            numExpo = 1;
        } else
            numExpo = 0;
        dao.modificarCliente(dni,nombre,apellido1,apellido2,telefono,email,numExpo);
        modeloTabla.fireTableDataChanged();
        ventanaCliente.guiClientes.activarBotonLimpiar();
    }

    @Override
    public void listarClietes() {
        modeloTabla.setClientes(dao.listarClientes());
    }


    public void actualizarTabla(){
        modeloTabla.fireTableDataChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NUEVO")) {
            añadirCliente();
        }
        else if (e.getActionCommand().equals("ELIMINAR")){
            eliminarCliente();
        }else if (e.getActionCommand().equals("GUARDAR")) {
            crearCliente();
        }else if(e.getActionCommand().equals("LIMPIAR")){
            ventanaCliente.guiClientes.limpiarCampoTxt();
        }
        else if(e.getActionCommand().equals("ACTUALIZAR")){
            actualizarCliente();
        }
        else if(e.getActionCommand().equals("ACTUALIZAR_TABLA")){
            actualizarTabla();
        }

    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        int row = ventanaCliente.guiClientes.getTablaClientes().rowAtPoint(evt.getPoint());
        ventanaCliente.guiClientes.getTxtDNI().setText(ventanaCliente.guiClientes.getTablaClientes().getValueAt(row, 0).toString());
        ventanaCliente.guiClientes.getTxtNombre().setText(ventanaCliente.guiClientes.getTablaClientes().getValueAt(row,1).toString());
        ventanaCliente.guiClientes.getTxtApellido1().setText(ventanaCliente.guiClientes.getTablaClientes().getValueAt(row, 2).toString());
        ventanaCliente.guiClientes.getTxtApellido2().setText(ventanaCliente.guiClientes.getTablaClientes().getValueAt(row, 3).toString());
        ventanaCliente.guiClientes.getTxtTelefono().setText(ventanaCliente.guiClientes.getTablaClientes().getValueAt(row,4).toString());
        ventanaCliente.guiClientes.getTxtEmail().setText(ventanaCliente.guiClientes.getTablaClientes().getValueAt(row,5).toString());
        ventanaCliente.guiClientes.getTxtExpositor().setText(ventanaCliente.guiClientes.getTablaClientes().getValueAt(row,6).toString());
        ventanaCliente.guiClientes.desactivarBotonLimpiar();
        ventanaCliente.guiClientes.activaCamposTxt();
        ventanaCliente.guiClientes.desactivarTXTNIF();
        ventanaCliente.guiClientes.activarBotonEliminar();
        ventanaCliente.guiClientes.activarBotonActualizar();
        ventanaCliente.guiClientes.desactivarBotonGuardar();
        modeloTabla.fireTableDataChanged();
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
