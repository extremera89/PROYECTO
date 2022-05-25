package controladores;

import Interfaces.InterfaceVisitaGuiada;
import dao.DAOcliente;
import dao.DAOexposicion;
import dao.DAOmonitor;
import dao.DAOvisitaguiada;
import modelo.*;
import modelotablas.ModeloTablasVisita;
import vistas.Paneles.VentanaModalVisita;
import vistas.Ventanas.VentanaVisita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControladorVisita implements ActionListener, MouseListener, InterfaceVisitaGuiada.InterfaceControladorVisita {
    private DAOvisitaguiada dao;
    private VentanaVisita ventana;
    private ModeloTablasVisita tabla;
    private int filapul = -1;
    private VentanaModalVisita modal;


    public ControladorVisita(DAOvisitaguiada dao, VentanaVisita vista){
        this.dao = dao;
        this.ventana = vista;
        this.tabla = new ModeloTablasVisita(dao);
        this.modal = new VentanaModalVisita(this.ventana, true);
        this.modal.setControler(this);
        this.ventana.getVista().getTable1().setModel(this.tabla);


    }
    @Override
    public void cargarDNIClientes(){
        DAOcliente daOcliente=new DAOcliente();
        ArrayList<Cliente> dniCliente=daOcliente.listarClientes();
        for(int i=0;i<dniCliente.size();i++){
            Cliente cliente= dniCliente.get(i);
            ventana.getVista().getComboBoxCliente().addItem(cliente.getDNI());
        }
    }
    @Override
    public void cargarDNIMonitores(){
        DAOmonitor daOmonitor=new DAOmonitor();
        ArrayList<Monitor> dniCliente=daOmonitor.listarMonitores();
        for(int i=0;i<dniCliente.size();i++){
            Monitor monitor= dniCliente.get(i);
            ventana.getVista().getComboBoxMonitor().addItem(monitor.getDNI());
        }
    }
    @Override
    public void cargarExposiciones(){
        DAOexposicion daoexp = new DAOexposicion();
        ArrayList<Exposicion> exposiciones = daoexp.listarExposiciones();
        for(int i = 0; i<exposiciones.size(); i++){
            Exposicion exp = exposiciones.get(i);
            ventana.getVista().getComboBoxExp().addItem(exp.getNumExp());
        }
    }
    @Override
    public void crearVisita() {

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            String numpersonas = this.ventana.getVista().getTxtNumPersonas().getText();
            Date fech = format.parse(this.ventana.getVista().getTxtFecha().getText());
            java.sql.Date fecha = new java.sql.Date(fech.getTime());
            Centro centro = new Centro();
            Cliente cliente = new Cliente();
            Monitor monitor = new Monitor();
            Exposicion exp = new Exposicion();
            String codcentro = this.ventana.getVista().getTxtCentro().getText();
            String dnicliente = (String) this.ventana.getVista().getComboBoxCliente().getSelectedItem();
            String dnimonitor = (String) this.ventana.getVista().getComboBoxMonitor().getSelectedItem();
            String numexp = this.ventana.getVista().getComboBoxExp().getSelectedItem().toString();
            centro.setCodCentro(codcentro);
            cliente.setDNI(dnicliente);
            monitor.setDNI(dnimonitor);
            if (!numpersonas.equals("") && !fecha.equals("") && !codcentro.equals("") && !dnicliente.equals("") && !dnimonitor.equals("") && !numexp.equals("")) {
                int numExp = Integer.parseInt(numexp);
                exp.setNumExp(numExp);
                if (dao.buscarvisita(numExp) == null) {
                    int numPersonas = Integer.parseInt(numpersonas);
                    VisitaGuiada prueba = new VisitaGuiada(numPersonas, fecha, centro, monitor, cliente, exp);
                    dao.insertarvisita(prueba);
                    ventana.getVista().limpiarCampoTxt();

                    if(dao.buscarvisita(prueba.getNumExp().getNumExp())!=null) {
                        prueba.setNumvisita(dao.getNumVisita(prueba));
                        tabla.crearVisita(prueba);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe esa visita");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "No has rellenado el campo numérico con un número");
        }catch (ParseException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Has introducido la fecha de manera incorrecta");
        }


    }
    @Override
    public void modificarVisita(){

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            int numvisita = Integer.parseInt(ventana.getVista().getTxtNumVisita().getText());
            String numpersonas = this.ventana.getVista().getTxtNumPersonas().getText();
            Date fech = format.parse(this.ventana.getVista().getTxtFecha().getText());
            java.sql.Date fecha = new java.sql.Date(fech.getTime());
            Centro centro = new Centro();
            Cliente cliente = new Cliente();
            Monitor monitor = new Monitor();
            Exposicion exp = new Exposicion();
            String codcentro = this.ventana.getVista().getTxtCentro().getText();
            String dnicliente = (String) this.ventana.getVista().getComboBoxCliente().getSelectedItem();
            String dnimonitor = (String) this.ventana.getVista().getComboBoxMonitor().getSelectedItem();
            String numexp = this.ventana.getVista().getComboBoxExp().getSelectedItem().toString();

            centro.setCodCentro(codcentro);
            cliente.setDNI(dnicliente);
            monitor.setDNI(dnimonitor);
            exp.setNumExp(Integer.parseInt(numexp));
            VisitaGuiada prueba = new VisitaGuiada(numvisita, Integer.parseInt(numpersonas), fecha, centro, monitor, cliente, exp);


            dao.modificarVisita(prueba);
            tabla.actualizarVisita(filapul, prueba);
        }catch (ParseException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Has introducido la fecha de manera incorrecta");
        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Has introducido un carácter que no es un número");
        }


    }

    @Override
    public void listarVisitas(){
        tabla.setVisitas(dao.listarVisitas());
    }

    @Override
    public void eliminarVisita() {
        VisitaGuiada visita = new VisitaGuiada();
        visita.setNumvisita(Integer.parseInt(ventana.getVista().getTable1().getValueAt(filapul, 0).toString()));
        dao.eliminarVisita(visita);
        tabla.eliminarVisita(filapul);
        ventana.getVista().desactivarBotonEliminar();
        ventana.getVista().limpiarCampoTxt();
        ventana.getVista().activaCamposTxt();
        filapul = -1;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NUEVO")){
            ventana.getVista().activaCamposTxt();
            ventana.getVista().activarBotonGuardar();
            ventana.getVista().limpiarCampoTxt();
            ventana.getVista().getComboBoxCliente().removeAllItems();
            ventana.getVista().getComboBoxMonitor().removeAllItems();
            ventana.getVista().getComboBoxExp().removeAllItems();

            cargarDNIClientes();
            cargarDNIMonitores();
            cargarExposiciones();
        }
        else if (e.getActionCommand().equals("GUARDAR")){
            crearVisita();
        }

        else if (e.getActionCommand().equals("LIMPIAR")){
            ventana.getVista().limpiarCampoTxt();
        }

        else if (e.getActionCommand().equals("ELIMINAR")){
            eliminarVisita();
        }
        else if (e.getActionCommand().equals("EXPOSICIONES")) {
            this.ventana.getVista().getComboBoxExp().removeAllItems();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date fech = null;
            try {
                fech = format.parse(this.ventana.getVista().getTxtFecha().getText());
                java.sql.Date fecha = new java.sql.Date(fech.getTime());

                ArrayList<Integer> exp = new ArrayList<>();
                exp = dao.expNoDisponibles(fecha);

                for (int i : exp) {
                    ventana.getVista().getComboBoxExp().addItem(i);
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }


        else if(e.getActionCommand().equals("CLIENTES")){
            this.ventana.getVista().getComboBoxCliente().removeAllItems();
            cargarDNIClientes();
        }
        else if(e.getActionCommand().equals("MONITORES")){
            this.ventana.getVista().getComboBoxMonitor().removeAllItems();
            cargarDNIMonitores();
        }
        else if(e.getActionCommand().equals("ACTUALIZAR DATOS")){
            modificarVisita();
        }

        else if(e.getActionCommand().equals("ACTUALIZAR TABLA")){
                actualizarTabla();
        }


    }
    @Override
    public void ponerDatosModal(){
        modal.getTxtNumvisita().setText((ventana.getVista().getTxtNumVisita().getText()));
        modal.getTxtNumpersonas().setText((ventana.getVista().getTxtNumPersonas().getText()));
        modal.getTxtCentro().setText((ventana.getVista().getTxtCentro().getText()));
        modal.getTxtFecha().setText((ventana.getVista().getTxtFecha().getText()));
        modal.getTxtDnimonitor().setText((String) ventana.getVista().getComboBoxMonitor().getSelectedItem());
        modal.getTxtDnicliente().setText((String) ventana.getVista().getComboBoxCliente().getSelectedItem());
        modal.getTxtNumexp().setText( ventana.getVista().getComboBoxExp().getSelectedItem().toString());
        Exposicion exp = new Exposicion(Integer.parseInt(ventana.getVista().getComboBoxExp().getSelectedItem().toString()));
        int numsala = dao.buscarSala(exp);
        modal.getTxtNumSala().setText(String.valueOf(numsala));
        modal.getTxtNumvisita().setEnabled(false);
        modal.getTxtNumpersonas().setEnabled(false);
        modal.getTxtCentro().setEnabled(false);
        modal.getTxtFecha().setEnabled(false);
        modal.getTxtDnimonitor().setEnabled(false);
        modal.getTxtDnicliente().setEnabled(false);
        modal.getTxtNumexp().setEnabled(false);
        modal.getTxtNumSala().setEnabled(false);



    }

    @Override
    public void actualizarTabla(){
        tabla.fireTableDataChanged();
        listarVisitas();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        VisitaGuiada visita;

        int row = ventana.getVista().getTable1().rowAtPoint(e.getPoint());
        Date fechain = null;

        try {
            fechain = format.parse(ventana.getVista().getTable1().getValueAt(row, 2).toString());
            java.sql.Date fecha = new java.sql.Date(fechain.getTime() );
            ventana.getVista().activaCamposTxt();

            ventana.getVista().getTxtNumVisita().setText(ventana.getVista().getTable1().getValueAt(row,0).toString());
            ventana.getVista().getTxtNumPersonas().setText(ventana.getVista().getTable1().getValueAt(row, 1).toString());
            ventana.getVista().getTxtFecha().setText(ventana.getVista().getTable1().getValueAt(row, 2).toString());
            visita = dao.saberDatos(Integer.parseInt(ventana.getVista().getTable1().getValueAt(row,0).toString()), Integer.parseInt(ventana.getVista().getTable1().getValueAt(row, 1).toString()));


            ventana.getVista().getTxtCentro().setText(visita.getCentro().getCodCentro());
            if(e.getClickCount() == 1){
                ventana.getVista().getComboBoxCliente().removeAllItems();
                ventana.getVista().getComboBoxCliente().addItem(visita.getDnicliente().getDNI());
                ventana.getVista().getComboBoxMonitor().removeAllItems();
                ventana.getVista().getComboBoxMonitor().addItem(visita.getDnimonitor().getDNI());
                ventana.getVista().getComboBoxExp().removeAllItems();
                ventana.getVista().getComboBoxExp().addItem(visita.getNumExp().getNumExp());

            }

            if(ventana.tipoPerfil()==0){
                ventana.validarUsuario();
            }else {
                ventana.getVista().desactivarBotonGuardar();
                ventana.getVista().activarBotonActualizar();
                ventana.getVista().activarBotonEliminar();
            }
            if(e.getClickCount()==2){
                ponerDatosModal();
                modal.setVisible(true);
            }

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        filapul = row;

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
