package controladores;

import Interfaces.InterfaceReserva;
import dao.DAOcliente;
import dao.DAOreserva;
import dao.DAOsala;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Sala;
import modelotablas.ModeloTablaReserva;
import vistas.Ventanas.VentanaReserva;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import static otros.AlphaNumericStringGenerator.getRandomString;

public class ControladorReserva implements InterfaceReserva.InterfaceControladorReserva, ActionListener, MouseListener {

    private DAOreserva dao;
    private VentanaReserva ventanaReserva;
    private ModeloTablaReserva modeloTabla;
    private int filaPulsada=-1;

    public ControladorReserva(DAOreserva dao, VentanaReserva guiReserva){
        this.dao=dao;
        this.ventanaReserva =guiReserva;
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
        ventanaReserva.guiReservas.desactivarTXTCodigoReserva();
    }

    @Override
    public void crearReserva() {

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String CodigoReserva = getRandomString(5);

            String DNI = (String) ventanaReserva.guiReservas.getCombDNI().getSelectedItem();
            int NumSala = (int) ventanaReserva.guiReservas.getCombSala().getSelectedItem();

            java.util.Date FechaReserva =  formatoFecha.parse((ventanaReserva.guiReservas.getTxtFechaReserva().getText()));
            Date FechaFin =  formatoFecha.parse((ventanaReserva.guiReservas.getTxtFechaFin().getText()));

            java.sql.Date fechainicio = new java.sql.Date(FechaReserva.getTime());
            java.sql.Date fechafin = new java.sql.Date(FechaFin.getTime());


            //String MotivoReserva = ventanaReserva.guiReservas.getTxtMotivo().getText();
            String MotivoReserva = ventanaReserva.guiReservas.getTextArea().getText();

            String NumSalaStr = ventanaReserva.guiReservas.getTxtNumeroSala().getText();
            String ConfirmadoStr = ventanaReserva.guiReservas.getTxtConfirmado().getText();

            String confirmadorgx="si|sí|SI|SÍ|no|NO";

            if (!FechaReserva.equals("")&&!FechaFin.equals("")&&!MotivoReserva.equals("")&&!ConfirmadoStr.equals("")) {
                if (Pattern.matches(confirmadorgx, ConfirmadoStr)) {
                    int confirmado = 3;
                    if (ConfirmadoStr.equals("SI") || ConfirmadoStr.equals("si") || ConfirmadoStr.equals("SÍ") || ConfirmadoStr.equals("sí")) {
                        confirmado = 1;
                    } else
                        confirmado = 0;


                    if (dao.buscarReserva(CodigoReserva) == null) {
                        Sala sala = new Sala();
                        sala.setNumSala(NumSala);
                        Cliente cliente = new Cliente();
                        cliente.setDNI(DNI);
                        Reserva nuevaReserva = new Reserva(CodigoReserva, cliente, sala, fechainicio, fechafin, confirmado, MotivoReserva);
                        dao.insertarReserva(nuevaReserva);
                        if (dao.buscarReserva(nuevaReserva.getCodigoReserva()) != null) {
                            modeloTabla.crearReserva(CodigoReserva, cliente, sala, fechainicio, fechafin, confirmado, MotivoReserva);
                        }
                        ventanaReserva.guiReservas.desactivarBotonGuardar();
                        ventanaReserva.guiReservas.limpiarCampoTxt();
                        ventanaReserva.guiReservas.activaCamposTxt();
                        ventanaReserva.guiReservas.desactivarBotonActualizar();
                        ventanaReserva.guiReservas.dasactivarCampoTxt();

                    } else JOptionPane.showMessageDialog(null, "Ya existe una Reserva con ese codigo");
                } else {JOptionPane.showMessageDialog(null,"No insertastes si o no");}
            } else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }catch (ParseException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Fecha mal introducida");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Algun campo numerico no fue rellenado con un numero");
        }
    }

    @Override
    public void eliminarReserva() {
        dao.eliminarReserva(ventanaReserva.guiReservas.getTableReserva().getValueAt(filaPulsada, 0).toString());
        modeloTabla.eliminarReserva(filaPulsada);
        ventanaReserva.guiReservas.desactivarBotonEliminar();
        ventanaReserva.guiReservas.limpiarCampoTxt();
        ventanaReserva.guiReservas.desactivarBotonActualizar();
        ventanaReserva.guiReservas.dasactivarCampoTxt();
        filaPulsada = -1;
    }

    @Override
    public void actualizarReserva() throws ParseException {

      try {

        String codigoReserva = ventanaReserva.guiReservas.getTxtCodigoReserva().getText();
        String DNI = (String) ventanaReserva.guiReservas.getCombDNI().getSelectedItem();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        int NumSala = (int) ventanaReserva.guiReservas.getCombSala().getSelectedItem();
        Date fechaReserva = formatoFecha.parse(this.ventanaReserva.guiReservas.getTxtFechaReserva().getText());
        Date fechaFin = formatoFecha.parse(this.ventanaReserva.guiReservas.getTxtFechaFin().getText());
        java.sql.Date fechareserva = new java.sql.Date(fechaReserva.getTime());
        java.sql.Date fechafin = new java.sql.Date(fechaFin.getTime());
        //int Confirmado = Integer.parseInt(ventanaReserva.guiReservas.getTxtConfirmado().getText());
          String Motivo = ventanaReserva.guiReservas.getTextArea().getText();
        //String Motivo = ventanaReserva.guiReservas.getTxtMotivo().getText();
        String ConfirmadoStr = (ventanaReserva.guiReservas.getTxtConfirmado().getText());
        String confirmadorgx="si|sí|SI|SÍ|no|NO";

          if (!DNI.equals("")&&!codigoReserva.equals("")&&!fechaReserva.equals("")&&!fechaFin.equals("")&&!Motivo.equals("")&&!ConfirmadoStr.equals("")) {
              if (Pattern.matches(confirmadorgx, ConfirmadoStr)) {
                  int confirmado = 3;
                  if (ConfirmadoStr.equals("SI") || ConfirmadoStr.equals("si") || ConfirmadoStr.equals("SÍ") || ConfirmadoStr.equals("sí")) {
                      confirmado = 1;
                  } else
                      confirmado = 0;
                  Sala sala = new Sala();
                  sala.setNumSala(NumSala);
                  Cliente cliente = new Cliente();
                  cliente.setDNI(DNI);
                  Reserva reserva = new Reserva(codigoReserva,cliente, sala, fechareserva, fechafin, confirmado, Motivo);

                  dao.modificarReserva(reserva);

                  if (!dao.error) {
                      modeloTabla.actualizarReserva(filaPulsada, reserva);
                  }
                  this.dao.error = false;
              } else {JOptionPane.showMessageDialog(null,"No insertastes si o no");}
          } else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
      }catch (NumberFormatException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,"Has introducido un carácter que no es un número");
    }catch (ParseException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,"Has introducido la fecha de manera incorrecta");
    }
    }

    @Override
    public void listarReserva() {
        modeloTabla.setReserva(dao.listarReserva());
    }



    public void cargarDNIClientes(){
        ventanaReserva.guiReservas.getCombDNI().removeAllItems();
        DAOcliente daoCliente=new DAOcliente();
        ArrayList<Cliente> dniCliente=daoCliente.listarClientes();
        for(int i=0;i<dniCliente.size();i++){
            Cliente cliente= dniCliente.get(i);
            ventanaReserva.guiReservas.getCombDNI().addItem(cliente.getDNI());
        }
    }
    public void cargarNumSala(){
        ventanaReserva.guiReservas.getCombSala().removeAllItems();
        DAOsala daoSala=new DAOsala();
        ArrayList<Sala> numSalas= daoSala.listarSala();
        for(int i=0;i<numSalas.size();i++){
            Sala sala= numSalas.get(i);
            //if (sala.getDadaAlta() == 1)
            ventanaReserva.guiReservas.getCombSala().addItem(sala.getNumSala());
        }
    }

    public void actualizarTabla(){
        listarReserva();
        modeloTabla.fireTableDataChanged();
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
            actualizarTabla();
        }else if(e.getActionCommand().equals("ACTDNI")){
            cargarDNIClientes();
        }
        else if (e.getActionCommand().equals("ACTNUMSALA")){
            cargarNumSala();
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

        ventanaReserva.guiReservas.getTextArea().setText(ventanaReserva.guiReservas.getTableReserva().getValueAt(row,6).toString());

        ventanaReserva.guiReservas.getCombSala().setSelectedIndex(modeloTabla.saberCmboxSala(row,3));
        ventanaReserva.guiReservas.getCombDNI().setSelectedIndex(modeloTabla.saberCmboxCliente(row,2));

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
