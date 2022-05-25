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
    private JTextField TxtDnimonitor;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JLabel lblNumVisita;
    private JLabel lblNumPersonas;
    private JLabel lblFecha;
    private JLabel lblCentro;
    public JButton btnActualizarDatos;
    private JButton btnActualizarTabla;
    private JButton btnEliminar;
    private JLabel lblTitulo;
    private JTextField txtDnicliente;
    private JTextField txtNumExp;
    private JLabel lblNumExp;
    private JLabel lblDnimonitor;
    private JLabel lblDnicliente;
    private JComboBox comboBoxCliente;
    private JComboBox comboBoxMonitor;
    private JComboBox comboBoxExp;
    private JButton btnExp;
    private JButton btnMon;
    private JButton btnCli;
    private JTextField txtFiltro;
    private JComboBox comboBoxCentro;
    private JButton btnCentro;


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

    public JButton getBtnExp() {
        return btnExp;
    }

    public void setBtnExp(JButton btnExp) {
        this.btnExp = btnExp;
    }

    public JTextField getTxtFiltro() {
        return txtFiltro;
    }

    public JButton getBtnCentro() {
        return btnCentro;
    }

    public void setBtnCentro(JButton btnCentro) {
        this.btnCentro = btnCentro;
    }

    public void setTxtFiltro(JTextField txtFiltro) {
        this.txtFiltro = txtFiltro;
    }

    public JComboBox getComboBoxCentro() {
        return comboBoxCentro;
    }

    public void setComboBoxCentro(JComboBox comboBoxCentro) {
        this.comboBoxCentro = comboBoxCentro;
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
    public void desactivarBotonLimpiar(){
        btnLimpiar.setEnabled(false);
    }

    public void desactivarBotonActualizar(){
        btnActualizarDatos.setEnabled(false);}

    public void activarBotonActualizar(){
        btnActualizarDatos.setEnabled(true);}

    public void setPanelPrincipal(JPanel panelPrincipal) {
        PanelPrincipal = panelPrincipal;
    }

    public JTextField getTxtDnicliente() {
        return txtDnicliente;
    }

    public void setTxtDnicliente(JTextField txtDnicliente) {
        this.txtDnicliente = txtDnicliente;
    }

    public JButton getBtnMon() {
        return btnMon;
    }

    public JButton getBtnCli() {
        return btnCli;
    }

    public JPanel getPanelSuperior() {
        return PanelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        PanelSuperior = panelSuperior;
    }

    public JComboBox getComboBoxCliente() {
        return comboBoxCliente;
    }

    public void setComboBoxCliente(JComboBox comboBoxCliente) {
        this.comboBoxCliente = comboBoxCliente;
    }

    public JComboBox getComboBoxMonitor() {
        return comboBoxMonitor;
    }

    public void setComboBoxMonitor(JComboBox comboBoxMonitor) {
        this.comboBoxMonitor = comboBoxMonitor;
    }

    public JComboBox getComboBoxExp() {
        return comboBoxExp;
    }

    public void asignaCommandBotones(){
        btnNuevo.setActionCommand("NUEVO");
        btnGuardar.setActionCommand("GUARDAR");
        btnEliminar.setActionCommand("ELIMINAR");
        btnLimpiar.setActionCommand("LIMPIAR");
        btnActualizarTabla.setActionCommand("ACTUALIZAR TABLA");
        btnActualizarDatos.setActionCommand("ACTUALIZAR DATOS");
        btnExp.setActionCommand("EXPOSICIONES");
        btnCli.setActionCommand("CLIENTES");
        btnMon.setActionCommand("MONITORES");
        btnCentro.setActionCommand("CENTROS");
    }

    public void insertarImagenes() {
        btnNuevo.setIcon(new ImageIcon("src\\imagenes\\iconoNuevo.png"));
        btnEliminar.setIcon(new ImageIcon("src\\imagenes\\iconoEliminar.png"));
        btnLimpiar.setIcon(new ImageIcon("src\\imagenes\\inconoLimpiar.png"));
        btnActualizarTabla.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnGuardar.setIcon(new ImageIcon(("src\\imagenes\\iconoGuardar.png")));
        btnActualizarDatos.setIcon(new ImageIcon("src\\imagenes\\iconoActualizarDatos.png"));
        btnCli.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnExp.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnMon.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnCentro.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));

    }



    public void limpiarCampoTxt(){
        txtNumVisita.setText("");
        txtNumPersonas.setText("");
        txtFecha.setText("");
    }

    public void dasactivarCampoTxt(){
        txtNumVisita.setEnabled(false);
        txtNumPersonas.setEnabled(false);
        txtFecha.setEnabled(false);
    }

    public void activaCamposTxt(){
        txtNumPersonas.setEnabled(true);
        txtFecha.setEnabled(true);
    }

}
