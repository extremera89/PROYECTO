package vistas.Paneles;

import javax.swing.*;

public class VistaVisita {
    private JPanel PanelPrincipal;
    private JPanel PanelSuperior;
    private JPanel PanelIzquierdo;
    private JPanel PanelDerecho;
    private JTable table1;
    private JTextField txtNumVisita;
    private JTextField txtNumPersonas;
    private JTextField txtFecha;
    private JTextField txtCentro;
    private JTextField TxtDnimonitor;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JLabel lblNumVisita;
    private JLabel lblNumPersonas;
    private JLabel lblFecha;
    private JLabel lblCentro;
    private JLabel lblDnimonitor;
    public JButton btnActualizarDatos;
    private JButton btnActualizarTabla;
    private JButton btnEliminar;
    private JLabel lblTitulo;


    public JTable getTable1() {
        return table1;
    }

    public void setTxtNumVisita(JTextField txtNumVisita) {
        this.txtNumVisita = txtNumVisita;
    }

    public void setTxtNumPersonas(JTextField txtNumPersonas) {
        this.txtNumPersonas = txtNumPersonas;
    }

    public void setTxtFecha(JTextField txtFecha) {
        this.txtFecha = txtFecha;
    }

    public void setTxtCentro(JTextField txtCentro) {
        this.txtCentro = txtCentro;
    }

    public void setTxtDnimonitor(JTextField txtDnimonitor) {
        this.TxtDnimonitor = txtDnimonitor;
    }


    public JButton getBtnActualizarDatos(){
        return this.btnActualizarDatos;
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JTextField getTxtNumVisita() {
        return txtNumVisita;
    }

    public JTextField getTxtNumPersonas() {
        return txtNumPersonas;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JTextField getTxtCentro() {
        return txtCentro;
    }

    public JTextField getTxtDnimonitor() {
        return TxtDnimonitor;
    }


    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnActualizarTabla() {
        return btnActualizarTabla;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void asignaCommandBotones(){
        btnNuevo.setActionCommand("NUEVO");
        btnGuardar.setActionCommand("GUARDAR");
        btnEliminar.setActionCommand("ELIMINAR");
        btnLimpiar.setActionCommand("LIMPIAR");
        btnActualizarTabla.setActionCommand("ACTUALIZAR TABLA");
        btnActualizarTabla.setActionCommand("ACTUALIZAR DATOS");
    }

    public void limpiarCampoTxt(){
            txtNumVisita.setText("");
            txtNumPersonas.setText("");
            txtFecha.setText("");
            txtCentro.setText("");
            TxtDnimonitor.setText("");
    }

    public void dasactivarCampoTxt(){
        txtNumVisita.setEnabled(false);
        txtNumPersonas.setEnabled(false);
        txtFecha.setEnabled(false);
        txtCentro.setEnabled(false);
        TxtDnimonitor.setEnabled(false);
    }

    public void activaCamposTxt(){
        txtNumVisita.setEnabled(true);
        txtNumPersonas.setEnabled(true);
        txtFecha.setEnabled(true);
        txtCentro.setEnabled(true);
        TxtDnimonitor.setEnabled(true);
    }

    public void desactivarBotonEliminar(){
        btnEliminar.setEnabled(false);
    }

    public void activarBotonEliminar(){
        btnEliminar.setEnabled(true);
    }
    public void desactivarBotonNuevo(){
        btnNuevo.setEnabled(false);
    }
    public void activarBotonNuevo(){
        btnNuevo.setEnabled(true);
    }
    public void desactivarBotonGuardar(){btnGuardar.setEnabled(false);}
    public void activarBotonGuardar(){btnGuardar.setEnabled(true);}

    public void desactivarBotonActualizar(){
        btnActualizarDatos.setEnabled(false);}

    public void activarBotonActualizar(){
        btnActualizarDatos.setEnabled(true);}

}
