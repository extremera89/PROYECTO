package controladores;

import Interfaces.InterfaceMonitor;
import dao.DAOmonitor;
import modelotablas.ModeloTablaMonitor;
import vistas.Ventanas.VentanaMonitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorMonitor implements InterfaceMonitor.InterfaceControladorMonitor, ActionListener, MouseListener {

    private DAOmonitor dao;
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
