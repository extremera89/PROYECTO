package controladores;

import Interfaces.InterfaceCliente;
import dao.DAOcliente;
import modelo.Cliente;
import modelotablas.ModeloTablaCliente;
import vistas.Ventanas.VentanaCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorCliente implements InterfaceCliente.InterfaceControladorCliente, ActionListener, MouseListener {

    private DAOcliente dao;
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


        if (!dni.equals("")&&!nombre.equals("")&&!apellido1.equals("")&&!apellido2.equals("")&&!telefono.equals("")&&!email.equals("")&&!expositor.equals("")){
            if (dao.buscarCliente(dni)==null){
                int expositorI =Integer.parseInt(expositor);
                modeloTabla.crearCliente(dni,nombre,apellido1,apellido2,telefono,email,expositorI);
                dao.insertarCliente(new Cliente(dni,nombre,apellido1,apellido2,telefono,email,expositorI));
                ventanaCliente.guiClientes.desactivarBotonGuardar();
                ventanaCliente.guiClientes.limpiarCampoTxt();
                ventanaCliente.guiClientes.activaCamposTxt();
            }
            else JOptionPane.showMessageDialog(null, "Ya se cuenta con un cliente con dichos datos");
        }
        else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
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
        if (e.getActionCommand().equals("NUEVO"))
            añadirCliente();
        else if (e.getActionCommand().equals("ELIMINAR"))
            eliminarCliente();
        else if (e.getActionCommand().equals("GUARDAR"))
            crearCliente();
        else if(e.getActionCommand().equals("LIMPIAR")){
            ventanaCliente.guiClientes.limpiarCampoTxt();
        }
        else if(e.getActionCommand().equals("ACTUALIZAR_TABLA")){
            actualizarTabla();
        }
        else if (e.getActionCommand().equals("ACTUALIZAR_DATOS")){
            actualizarCliente();
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
        ventanaCliente.guiClientes.dasactivarCampoTxt();
        ventanaCliente.guiClientes.activarBotonEliminar();
        ventanaCliente.guiClientes.desactivarBotonGuardar();
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
