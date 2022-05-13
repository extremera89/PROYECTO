package controladores;

import Interfaces.InterfaceReserva;
import dao.DAOreserva;
import modelo.Exposicion;
import modelo.Reserva;
import modelotablas.ModeloTablaReserva;
import vistas.Ventanas.VentanaReserva;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControladorReserva implements InterfaceReserva.InterfaceControladorReserva, ActionListener, MouseListener {

    private DAOreserva dao;
    private VentanaReserva ventanaReserva;
    private ModeloTablaReserva modeloTabla;
    private int filaPulsada=-1;

    public ControladorReserva(DAOreserva dao, VentanaReserva guiCliente){
        this.dao=dao;
        this.ventanaReserva =guiCliente;
        modeloTabla=new ModeloTablaReserva(dao);
        ventanaReserva.guiReservas.getTableReserva().setModel(modeloTabla);
    }

    public void añadirReserva(){
        ventanaReserva.guiReservas.limpiarCampoTxt();
        ventanaReserva.guiReservas.activaCamposTxt();
        ventanaReserva.guiReservas.activarBotonGuardar();
        ventanaReserva.guiReservas.desactivarBotonEliminar();
        ventanaReserva.guiReservas.activarBotonLimpiar();
        ventanaReserva.guiReservas.desactivarBotonActualizar();
    }

    @Override
    public void crearReserva() {

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

            String CodigoReserva = (ventanaReserva.guiReservas.getTxtCodigoReserva().getText());
            String DNI = (ventanaReserva.guiReservas.getTxtDNI().getText());
            int NumSala = Integer.parseInt(ventanaReserva.guiReservas.getTxtNumeroSala().getText());

            java.util.Date FechaReserva =  formatoFecha.parse((ventanaReserva.guiReservas.getTxtFechaReserva().getText()));
            Date FechaFin =  formatoFecha.parse((ventanaReserva.guiReservas.getTxtFechaFin().getText()));

            java.sql.Date fechainicio = new java.sql.Date(FechaReserva.getTime());
            java.sql.Date fechafin = new java.sql.Date(FechaFin.getTime());

            int Confirmado = Integer.parseInt((ventanaReserva.guiReservas.getTxtConfirmado().getText()));
            String MotivoReserva = ventanaReserva.guiReservas.getTxtMotivo().getText();

            String NumSalaStr = ventanaReserva.guiReservas.getTxtNumeroSala().getText();
            String ConfirmadoStr = ventanaReserva.guiReservas.getTxtConfirmado().getText();

            if (!CodigoReserva.equals("")&&!DNI.equals("")&&!NumSalaStr.equals("")&&!FechaReserva.equals("")&&!FechaFin.equals("")&&!MotivoReserva.equals("")&&!ConfirmadoStr.equals("")){
                if (dao.buscarReserva(CodigoReserva)==null){
                    modeloTabla.crearReserva(CodigoReserva,DNI,NumSala,fechainicio,fechafin,Confirmado,MotivoReserva);
                    dao.insertarReserva(new Reserva(CodigoReserva,DNI,NumSala,fechainicio,fechafin,Confirmado,MotivoReserva));
                    ventanaReserva.guiReservas.desactivarBotonGuardar();
                    ventanaReserva.guiReservas.limpiarCampoTxt();
                    ventanaReserva.guiReservas.activaCamposTxt();
                    ventanaReserva.guiReservas.desactivarBotonActualizar();
                }
                else JOptionPane.showMessageDialog(null, "Ya existe una Reserva con ese numero");
            }
            else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");

        }catch (Exception e){
            System.out.println("Error en crear Reserva del controlador");
        }
    }

    @Override
    public void eliminarReserva() {
        dao.eliminarReserva(ventanaReserva.guiReservas.getTableReserva().getValueAt(filaPulsada, 0).toString());
        modeloTabla.eliminarReserva(filaPulsada);
        ventanaReserva.guiReservas.desactivarBotonEliminar();
        ventanaReserva.guiReservas.limpiarCampoTxt();
        ventanaReserva.guiReservas.desactivarBotonActualizar();
        filaPulsada = -1;
    }

    @Override
    public void actualizarReserva() throws ParseException {
        String codigoReserva = ventanaReserva.guiReservas.getTxtCodigoReserva().getText();
        String DNI = ventanaReserva.guiReservas.getTxtDNI().getText();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        int NumSala = Integer.parseInt(ventanaReserva.guiReservas.getTxtNumeroSala().getText());
        Date fechaReserva = formatoFecha.parse(this.ventanaReserva.guiReservas.getTxtFechaReserva().getText());
        Date fechaFin = formatoFecha.parse(this.ventanaReserva.guiReservas.getTxtFechaFin().getText());
        java.sql.Date fechareserva = new java.sql.Date(fechaReserva.getTime());
        java.sql.Date fechafin = new java.sql.Date(fechaFin.getTime());
        int Confirmado = Integer.parseInt(ventanaReserva.guiReservas.getTxtConfirmado().getText());
        String Motivo = ventanaReserva.guiReservas.getTxtMotivo().getText();


        Reserva reserva = new Reserva(codigoReserva,DNI,NumSala,fechareserva,fechafin,Confirmado,Motivo);
        dao.modificarReserva(reserva);

        modeloTabla.actualizarReserva(filaPulsada, reserva);
    }

    @Override
    public void listarReserva() {
        modeloTabla.setReserva(dao.listarReserva());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NUEVO"))
            añadirReserva();
        else if (e.getActionCommand().equals("ELIMINAR"))
            eliminarReserva();
        else if (e.getActionCommand().equals("GUARDAR"))
            crearReserva();
        else if (e.getActionCommand().equals("ACTUALIZAR")) {
            try {
                actualizarReserva();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getActionCommand().equals("LIMPIAR")){
            ventanaReserva.guiReservas.limpiarCampoTxt();
        }else if(e.getActionCommand().equals("ACTUALIZAR_TABLA")){
            modeloTabla.actualizarTabla();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = ventanaReserva.guiReservas.getTableReserva().rowAtPoint(e.getPoint());

        ventanaReserva.guiReservas.getTxtCodigoReserva().setText(ventanaReserva.guiReservas.getTableReserva().getValueAt(row,0).toString());
        ventanaReserva.guiReservas.getTxtDNI().setText(ventanaReserva.guiReservas.getTableReserva().getValueAt(row,1).toString());
        ventanaReserva.guiReservas.getTxtNumeroSala().setText(ventanaReserva.guiReservas.getTableReserva().getValueAt(row,2).toString());
        ventanaReserva.guiReservas.getTxtFechaReserva().setText(ventanaReserva.guiReservas.getTableReserva().getValueAt(row,3).toString());
        ventanaReserva.guiReservas.getTxtFechaFin().setText(ventanaReserva.guiReservas.getTableReserva().getValueAt(row,4).toString());
        ventanaReserva.guiReservas.getTxtConfirmado().setText(ventanaReserva.guiReservas.getTableReserva().getValueAt(row,5).toString());
        ventanaReserva.guiReservas.getTxtMotivo().setText(ventanaReserva.guiReservas.getTableReserva().getValueAt(row,6).toString());

        ventanaReserva.guiReservas.activarBotonActualizar();
        ventanaReserva.guiReservas.activaCamposTxt();
        ventanaReserva.guiReservas.desactivarTXTCodigoReserva();
        ventanaReserva.guiReservas.activarBotonEliminar();
        ventanaReserva.guiReservas.desactivarBotonGuardar();
        ventanaReserva.guiReservas.desactivarBotonLimpiar();
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
