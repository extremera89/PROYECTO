package controladores;

import Interfaces.InterfaceCliente;
import dao.DAOcliente;
import modelo.Cliente;
import modelotablas.ModeloTablaCliente;
import vistas.Ventanas.VentanaCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCliente implements InterfaceCliente.InterfaceControladorCliente, ActionListener {

    private DAOcliente dao;
    private VentanaCliente ventanaCliente;
    private ModeloTablaCliente modeloTabla;
    private int filaPulsada=-1;

    public ControladorCliente(DAOcliente dao, VentanaCliente guiCliente){
        this.dao=dao;
        this.ventanaCliente=guiCliente;
        modeloTabla=new ModeloTablaCliente(dao);

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

    }

    @Override
    public void actualizarCliente() {

    }

    @Override
    public void listarClietes() {

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
    }
}
