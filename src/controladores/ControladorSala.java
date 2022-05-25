package controladores;

import Interfaces.InterfaceSalas;
import dao.DAOsala;
import modelo.Sala;
import modelotablas.ModeloTablaSala;
import vistas.Ventanas.VentanaSalas;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;


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
        ventanaSala.guiSalas.desactivarBotonActualizar();
    }

    @Override
    public void crearSala() {

        try {


        int numSala= Integer.parseInt(ventanaSala.guiSalas.getTxtNumSala().getText());
        int tamanio= Integer.parseInt(ventanaSala.guiSalas.getTxtTamanio().getText());
        int aforo= Integer.parseInt(ventanaSala.guiSalas.getTxtAforo().getText());
        int numPlanta= Integer.parseInt(ventanaSala.guiSalas.getTxtNumPlanta().getText());
        String numSalaStr= (ventanaSala.guiSalas.getTxtNumSala().getText());
        String dadaAltaStr=(ventanaSala.guiSalas.getTxtDadaAlta().getText());
        String tamanioStr= (ventanaSala.guiSalas.getTxtTamanio().getText());
        String aforoStr=(ventanaSala.guiSalas.getTxtAforo().getText());
        String numPlantatr= (ventanaSala.guiSalas.getTxtNumPlanta().getText());
        String dadaAltaregx="si|sí|SI|SÍ|no|NO";

        if (!numSalaStr.equals("")&&!dadaAltaStr.equals("")&&!tamanioStr.equals("")&&!aforoStr.equals("")&&!numPlantatr.equals("")) {
            if (Pattern.matches(dadaAltaregx, dadaAltaStr)) {
                int dadaAltai = 3;
                if (dadaAltaStr.equals("SI") || dadaAltaStr.equals("si")  || dadaAltaStr.equals("SÍ")  || dadaAltaStr.equals("sí")) {
                    dadaAltai = 1;
                } else
                    dadaAltai = 0;

                if (dao.buscarSala(numSala) == null) {
                    Sala nuevaSala = new Sala(numSala, dadaAltai, tamanio, aforo, numPlanta);
                    dao.insertarSala(nuevaSala);
                    if (dao.buscarSala(nuevaSala.getNumSala()) != null) {
                        modeloTabla.crearSalas(numSala, dadaAltai, tamanio, aforo, numPlanta);
                    }
                    ventanaSala.guiSalas.desactivarBotonGuardar();
                    ventanaSala.guiSalas.limpiarCampoTxt();
                    ventanaSala.guiSalas.activaCamposTxt();
                    ventanaSala.guiSalas.desactivarBotonActualizar();
                    ventanaSala.guiSalas.dasactivarCampoTxt();
                } else JOptionPane.showMessageDialog(null, "Ya existe una Sala con ese numero");
            } else {JOptionPane.showMessageDialog(null,"No insertastes si o no");}
        }else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }catch (Exception e){
            System.out.println("Error en crear Sala del controlador");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarSala() {
        if (JOptionPane.showConfirmDialog(null,"¿Estas seguro que desea eliminar esta sala?")==0){
            if (JOptionPane.showConfirmDialog(null,"Todas las exposiciones y reservas que contenga la sala seran eliminadas,¿Esta seguro?")==0) {
                dao.eliminarSala(Integer.parseInt(ventanaSala.guiSalas.getTblSalas().getValueAt(filaPulsada, 0).toString()));
                modeloTabla.eliminarSala(filaPulsada);
                ventanaSala.guiSalas.desactivarBotonEliminar();
                ventanaSala.guiSalas.limpiarCampoTxt();
                ventanaSala.guiSalas.desactivarBotonActualizar();
                ventanaSala.guiSalas.dasactivarCampoTxt();
                filaPulsada = -1;
            }
        }
    }

    @Override
    public void actualizarSala() {
        int numSala = Integer.parseInt(ventanaSala.guiSalas.getTxtNumSala().getText());
        int tamanio = Integer.parseInt(ventanaSala.guiSalas.getTxtTamanio().getText());
        int aforo= Integer.parseInt(ventanaSala.guiSalas.getTxtAforo().getText());
        int numPlanta= Integer.parseInt(ventanaSala.guiSalas.getTxtNumPlanta().getText());
        String numSalaStr = (ventanaSala.guiSalas.getTxtNumSala().getText());
        String tamanioStr = (ventanaSala.guiSalas.getTxtTamanio().getText());
        String aforoStr = (ventanaSala.guiSalas.getTxtAforo().getText());
        String numPlantaStr = (ventanaSala.guiSalas.getTxtNumPlanta().getText());
        String dadaAltastr = (ventanaSala.guiSalas.getTxtDadaAlta().getText());
        String dadaAltaregx="si|sí|SI|SÍ|no|NO";

        if (!numSalaStr.equals("")&&!tamanioStr.equals("")&&!dadaAltastr.equals("")&&!aforoStr.equals("")&&!numPlantaStr.equals("")) {
            if (Pattern.matches(dadaAltaregx, dadaAltastr)) {
                int dadaAltai = 3;
                if (dadaAltastr.equals("SI") || dadaAltastr.equals("si") || dadaAltastr.equals("SÍ") || dadaAltastr.equals("sí")) {
                    dadaAltai = 1;
                } else
                    dadaAltai = 0;

                Sala sala = new Sala(numSala, dadaAltai, tamanio, aforo, numPlanta);
                dao.modificarSala(sala);

                if (!dao.error) {
                    modeloTabla.actualizarSala(filaPulsada, sala);
                }
                this.dao.error = false;
            }else {JOptionPane.showMessageDialog(null,"No insertastes si o no");}
        }else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
    }

    @Override
    public void listarSala() {
        modeloTabla.setSalas(dao.listarSala());
    }

    public void actualizarTabla(){
        listarSala();
        modeloTabla.fireTableDataChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NUEVO"))
            añadirSala();
        else if (e.getActionCommand().equals("ELIMINAR"))
            eliminarSala();
        else if (e.getActionCommand().equals("GUARDAR"))
            crearSala();
        else if (e.getActionCommand().equals("ACTUALIZAR")) {
            actualizarSala();
        }else if(e.getActionCommand().equals("ACTUALIZAR_TABLA")){
            actualizarTabla();
        }
        else if(e.getActionCommand().equals("LIMPIAR")){
            ventanaSala.guiSalas.limpiarCampoTxt();
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        int row = ventanaSala.guiSalas.getTblSalas().rowAtPoint(e.getPoint());
        ventanaSala.guiSalas.getTxtNumSala().setText(ventanaSala.guiSalas.getTblSalas().getValueAt(row,0).toString());
        ventanaSala.guiSalas.getTxtDadaAlta().setText(ventanaSala.guiSalas.getTblSalas().getValueAt(row,1).toString());
        ventanaSala.guiSalas.getTxtTamanio().setText(ventanaSala.guiSalas.getTblSalas().getValueAt(row,2).toString());
        ventanaSala.guiSalas.getTxtAforo().setText(ventanaSala.guiSalas.getTblSalas().getValueAt(row,3).toString());
        ventanaSala.guiSalas.getTxtNumPlanta().setText(ventanaSala.guiSalas.getTblSalas().getValueAt(row,4).toString());

        if(ventanaSala.tipoPerfil()==0){
            ventanaSala.desactivarBotones();
        }else {
        ventanaSala.guiSalas.activarBotonActualizar();
        ventanaSala.guiSalas.activaCamposTxt();
        ventanaSala.guiSalas.desactivarTXTNumSala();
        ventanaSala.guiSalas.activarBotonEliminar();
        ventanaSala.guiSalas.desactivarBotonGuardar();
        ventanaSala.guiSalas.desactivarBotonLimpiar();
        filaPulsada = row;}
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

