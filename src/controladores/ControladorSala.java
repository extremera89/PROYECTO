package controladores;

import Interfaces.InterfaceSalas;
import dao.DAOsala;
import modelo.Sala;
import modelotablas.ModeloTablaSala;
import vistas.Ventanas.VentanaSalas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorSala implements InterfaceSalas.InterfaceControladorSala, ActionListener , MouseListener {

    private DAOsala dao;
    private VentanaSalas ventanaSala;
    private ModeloTablaSala modeloTabla;
    private int filaPulsada=-1;

    public ControladorSala(DAOsala dao, VentanaSalas guiCliente){
        this.dao=dao;
        this.ventanaSala =guiCliente;
        modeloTabla=new ModeloTablaSala(dao);
        ventanaSala.guiSalas.getTblSalas().setModel(modeloTabla);
    }

    public void añadirSala(){
        ventanaSala.guiSalas.limpiarCampoTxt();
        ventanaSala.guiSalas.activaCamposTxt();
        ventanaSala.guiSalas.activarBotonGuardar();
        ventanaSala.guiSalas.desactivarBotonEliminar();
        ventanaSala.guiSalas.activarBotonLimpiar();
    }

    @Override
    public void crearSala() {

        try {


        int numSala= Integer.parseInt(ventanaSala.guiSalas.getTxtNumSala().getText());
        int dadaAlta= Integer.parseInt(ventanaSala.guiSalas.getTxtDadaAlta().getText());
        int tamanio= Integer.parseInt(ventanaSala.guiSalas.getTxtTamanio().getText());
        String numSalaStr= (ventanaSala.guiSalas.getTxtNumSala().getText());
        String dadaAltaStr=(ventanaSala.guiSalas.getTxtDadaAlta().getText());
        String tamanioStr= (ventanaSala.guiSalas.getTxtTamanio().getText());


        if (!numSalaStr.equals("")&&!dadaAltaStr.equals("")&&!tamanioStr.equals("")){
            if (dao.buscarSala(numSala)==null){
                modeloTabla.crearSalas(numSala,dadaAlta,tamanio);
                dao.insertarSala(new Sala(numSala,dadaAlta,tamanio));
                ventanaSala.guiSalas.desactivarBotonGuardar();
                ventanaSala.guiSalas.limpiarCampoTxt();
                ventanaSala.guiSalas.activaCamposTxt();
            }
            else JOptionPane.showMessageDialog(null, "Ya existe una Sala con ese numero");
        }
        else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");

        }catch (Exception e){
            System.out.println("Error en crear Sala del controlador");
        }
    }

    @Override
    public void eliminarSala() {
        dao.eliminarSala(Integer.parseInt(ventanaSala.guiSalas.getTblSalas().getValueAt(filaPulsada, 0).toString()));
        modeloTabla.eliminarSala(filaPulsada);
        ventanaSala.guiSalas.desactivarBotonEliminar();
        ventanaSala.guiSalas.limpiarCampoTxt();
        filaPulsada = -1;
    }

    @Override
    public void actualizarSala() {

    }

    @Override
    public void listarSala() {
        modeloTabla.setSalas(dao.listarSala());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NUEVO"))
            añadirSala();
        else if (e.getActionCommand().equals("ELIMINAR"))
            eliminarSala();
        else if (e.getActionCommand().equals("GUARDAR"))
            crearSala();
        else if(e.getActionCommand().equals("LIMPIAR")){
            ventanaSala.guiSalas.limpiarCampoTxt();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = ventanaSala.guiSalas.getTblSalas().rowAtPoint(e.getPoint());
        ventanaSala.guiSalas.getTxtNumSala().setText(ventanaSala.guiSalas.getTblSalas().getValueAt(row,0).toString());//Numsala
        ventanaSala.guiSalas.getTxtDadaAlta().setText(ventanaSala.guiSalas.getTblSalas().getValueAt(row,1).toString());//DadaAlta
        ventanaSala.guiSalas.getTxtTamanio().setText(ventanaSala.guiSalas.getTblSalas().getValueAt(row,2).toString());//Tamanio

        ventanaSala.guiSalas.dasactivarCampoTxt();
        ventanaSala.guiSalas.activarBotonEliminar();
        ventanaSala.guiSalas.desactivarBotonGuardar();
        ventanaSala.guiSalas.desactivarBotonLimpiar();
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

