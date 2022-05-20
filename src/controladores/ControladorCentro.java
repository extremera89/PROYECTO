package controladores;

import Interfaces.InterfaceCentro;
import dao.DAOcentro;
import dao.DAOcliente;
import dao.DAOmonitor;
import modelo.Centro;
import modelo.Cliente;
import modelo.Monitor;
import modelotablas.ModeloTablaCentro;
import vistas.Ventanas.VentanaCentro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ControladorCentro implements InterfaceCentro.InterfaceControladorCentro, ActionListener, MouseListener {

    private DAOcentro dao;
    private DAOcentro daOcentro=new DAOcentro();
    private VentanaCentro ventanaCentro;
    private ModeloTablaCentro modeloTabla;
    private int filaPulsada=-1;

    public ControladorCentro(DAOcentro dao, VentanaCentro guiCentro){
        this.dao=dao;
        this.ventanaCentro=guiCentro;
        modeloTabla=new ModeloTablaCentro(dao);
        ventanaCentro.guiCentro.getTablaCentros().setModel(modeloTabla);
    }

    public void añadirCentro(){
        ventanaCentro.guiCentro.limpiarCampoTxt();
        ventanaCentro.guiCentro.activaCamposTxt();
        ventanaCentro.guiCentro.activarBotonGuardar();
    }

    @Override
    public void crearCentro() {

        String codCentro=ventanaCentro.guiCentro.getTxtCodCentro().getText();
        String nombre=ventanaCentro.guiCentro.getTxtNombre().getText();
        String numVisita=ventanaCentro.guiCentro.getTxtNumVisita().getText();
        String dniCliente= (String) ventanaCentro.guiCentro.getCmboxCliente().getSelectedItem();;
        String dniMonitor=(String) ventanaCentro.guiCentro.getComBoxMonitor().getSelectedItem();

        if (!codCentro.equals("")&&!nombre.equals("")&&!numVisita.equals("")&&!dniCliente.equals("")&&!dniMonitor.equals("")){
                if(dao.buscarCentro(codCentro)==null){
                    int numVisit=Integer.parseInt(numVisita);
                        modeloTabla.crearMonitor(codCentro, nombre, numVisit, dniCliente, dniMonitor);
                        dao.insertarCentro(new Centro(codCentro, nombre, numVisit, dniCliente, dniMonitor));
                        ventanaCentro.guiCentro.desactivarBotonGuardar();
                        ventanaCentro.guiCentro.limpiarCampoTxt();
                        ventanaCentro.guiCentro.activaCamposTxt();
                }else JOptionPane.showMessageDialog(null, "No se puede registrar este monitor");
        }else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");

    }

    @Override
    public void eliminarCentro() {
        dao.eliminarCentro(ventanaCentro.guiCentro.getTablaCentros().getValueAt(filaPulsada,0).toString());
        modeloTabla.eliminarMonitor(filaPulsada);
        ventanaCentro.guiCentro.desactivarBotonEliminar();
        ventanaCentro.guiCentro.limpiarCampoTxt();
        filaPulsada=-1;
    }

    @Override
    public void actualizarCentro() {

    }


    public void listarCentros() {
        modeloTabla.setCentros(dao.listarCentros());
    }

    public void cargarDNIClientes(){
        DAOcliente daOcliente=new DAOcliente();
        ArrayList<Cliente> dniCliente=daOcliente.listarClientes();
        for(int i=0;i<dniCliente.size();i++){
            Cliente cliente= dniCliente.get(i);
            ventanaCentro.guiCentro.getCmboxCliente().addItem(cliente.getDNI());
        }
    }
    public void cargarDNIMonitores(){
        DAOmonitor daOmonitor=new DAOmonitor();
        ArrayList<Monitor> dniCliente=daOmonitor.listarMonitores();
        for(int i=0;i<dniCliente.size();i++){
            Monitor monitor= dniCliente.get(i);
            ventanaCentro.guiCentro.getComBoxMonitor().addItem(monitor.getDNI());
        }
    }

    public void actualizarTabla(){
        modeloTabla.fireTableDataChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NUEVO"))
            añadirCentro();
        else if (e.getActionCommand().equals("ELIMINAR"))
            eliminarCentro();
        else if (e.getActionCommand().equals("GUARDAR"))
            crearCentro();
        else if(e.getActionCommand().equals("LIMPIAR")){
            ventanaCentro.guiCentro.limpiarCampoTxt();
        }
        else if(e.getActionCommand().equals("ACTUALIZAR_TABLA")){
            actualizarTabla();
        }
        else if (e.getActionCommand().equals("ACTUALIZAR")){
            actualizarCentro();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = ventanaCentro.guiCentro.getTablaCentros().rowAtPoint(e.getPoint());
        ventanaCentro.guiCentro.getTxtCodCentro().setText(ventanaCentro.guiCentro.getTablaCentros().getValueAt(row, 0).toString());
        ventanaCentro.guiCentro.getTxtNombre().setText(ventanaCentro.guiCentro.getTablaCentros().getValueAt(row,1).toString());
        ventanaCentro.guiCentro.getTxtNumVisita().setText(ventanaCentro.guiCentro.getTablaCentros().getValueAt(row, 2).toString());
        ventanaCentro.guiCentro.getCmboxCliente().setSelectedIndex(modeloTabla.saberCmboxCliente(row,3));
        ventanaCentro.guiCentro.getComBoxMonitor().setSelectedIndex(modeloTabla.saberCmboxMonitor(row,4));
        ventanaCentro.guiCentro.desactivarBotonLimpiar();
        ventanaCentro.guiCentro.activaCamposTxt();
        ventanaCentro.guiCentro.activarBotonEliminar();
        ventanaCentro.guiCentro.activarBotonActualizar();
        ventanaCentro.guiCentro.desactivarBotonGuardar();
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
