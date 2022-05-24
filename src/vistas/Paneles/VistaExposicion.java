package vistas.Paneles;

import javax.swing.*;

public class VistaExposicion {
    private JPanel panelPrincipal;
    private JPanel PanelSuperior;
    private JLabel lblTitulo;
    private JPanel PanelIzquierdo;
    private JTable table1;
    private JButton btnActualizarTabla;
    private JButton btnEliminar;
    private JPanel PanelDerecho;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblTematica;
    private JTextField txtTematica;
    private JLabel lblFechainicio;
    private JTextField txtFechainicio;
    private JLabel lblFechafin;
    private JTextField txtFechafin;
    private JLabel lblDescripcion;
    private JTextField txtDescripcion;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnActualizarDatos;
    private JTextField txtNumExp;
    private JLabel lblNumExp;
    private JLabel lblNumSala;
    private JComboBox comboSala;
    private JButton btnSala;
    private JPanel panelTitulo;
    private JPanel panelTabla;
    private JPanel panelFormulario;


    public void asignaCommandBotones(){
        this.btnActualizarDatos.setActionCommand("ACTUALIZAR");
        this.btnActualizarTabla.setActionCommand("ACTUALIZAR TABLA");
        this.btnGuardar.setActionCommand("GUARDAR");
        this.btnLimpiar.setActionCommand("LIMPIAR");
        this.btnNuevo.setActionCommand("NUEVO");
        this.btnEliminar.setActionCommand("ELIMINAR");
        this.btnSala.setActionCommand("SALA");
    }

    public void desactivaCamposTexto(){
        txtNombre.setEnabled(false);
        txtTematica.setEnabled(false);
        txtFechainicio.setEnabled(false);
        txtFechafin.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtNumExp.setEnabled(false);

    }

    public void activaCamposTxt(){
        txtNombre.setEnabled(true);
        txtTematica.setEnabled(true);
        txtFechainicio.setEnabled(true);
        txtFechafin.setEnabled(true);
        txtDescripcion.setEnabled(true);

    }

    public void limpiarCampoTxt(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtFechafin.setText("");
        txtTematica.setText("");
        txtFechainicio.setText("");
        txtNumExp.setText("");
        comboSala.removeAllItems();

    }

    public void insertarImagenes() {
        btnNuevo.setIcon(new ImageIcon("src\\imagenes\\iconoNuevo.png"));
        btnEliminar.setIcon(new ImageIcon("src\\imagenes\\iconoEliminar.png"));
        btnLimpiar.setIcon(new ImageIcon("src\\imagenes\\inconoLimpiar.png"));
        btnActualizarTabla.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnGuardar.setIcon(new ImageIcon(("src\\imagenes\\iconoGuardar.png")));
        btnActualizarDatos.setIcon(new ImageIcon("src\\imagenes\\iconoActualizarDatos.png"));
    }


    public JComboBox getComboSala() {
        return comboSala;
    }

    public void setComboSala(JComboBox comboSala) {
        this.comboSala = comboSala;
    }

    public void desactivarNumExp(){
        txtNumExp.setEnabled(false);
    }

    public JButton getBtnSala() {
        return btnSala;
    }

    public void setBtnSala(JButton btnSala) {
        this.btnSala = btnSala;
    }

    public void desactivarBotonSala(){
        btnSala.setEnabled(false);
    }

    public void activarBotonSala(){
        btnSala.setEnabled(true);
    }

    public void desactivarBotonEliminar(){
        btnEliminar.setEnabled(false);
    }

    public void activarBotonEliminar(){
        this.btnEliminar.setEnabled(true);
    }

    public void desactivarBotonNuevo(){
        this.btnNuevo.setEnabled(false);
    }

    public void activarBotonNuevo(){
        this.btnNuevo.setEnabled(true);
    }

    public void desactivarBotonGuardar(){
        btnGuardar.setEnabled(false);
    }

    public void activarBotonGuardar(){btnGuardar.setEnabled(true);
    }

    public void desactivarBotonActualizar(){
        btnActualizarDatos.setEnabled(false);
    }

    public void activarBotonActualizar(){
        btnActualizarDatos.setEnabled(true);
    }

    public void desactivarBotonLimpiar(){
        btnLimpiar.setEnabled(false);
    }

    public void activarBotonLimpiar(){
        btnLimpiar.setEnabled(true);
    }


    public JTextField getTxtNumExp() {
        return txtNumExp;
    }

    public void setTxtNumExp(JTextField txtNumExp) {
        this.txtNumExp = txtNumExp;
    }

    public JLabel getLblNumExp() {
        return lblNumExp;
    }

    public void setLblNumExp(JLabel lblNumExp) {
        this.lblNumExp = lblNumExp;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelSuperior() {
        return PanelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        PanelSuperior = panelSuperior;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JPanel getPanelIzquierdo() {
        return PanelIzquierdo;
    }

    public void setPanelIzquierdo(JPanel panelIzquierdo) {
        PanelIzquierdo = panelIzquierdo;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getBtnActualizarTabla() {
        return btnActualizarTabla;
    }

    public void setBtnActualizarTabla(JButton btnActualizarTabla) {
        this.btnActualizarTabla = btnActualizarTabla;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JPanel getPanelDerecho() {
        return PanelDerecho;
    }

    public void setPanelDerecho(JPanel panelDerecho) {
        PanelDerecho = panelDerecho;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JLabel getLblTematica() {
        return lblTematica;
    }

    public void setLblTematica(JLabel lblTematica) {
        this.lblTematica = lblTematica;
    }

    public JTextField getTxtTematica() {
        return txtTematica;
    }

    public void setTxtTematica(JTextField txtTematica) {
        this.txtTematica = txtTematica;
    }

    public JLabel getLblFechainicio() {
        return lblFechainicio;
    }

    public void setLblFechainicio(JLabel lblFechainicio) {
        this.lblFechainicio = lblFechainicio;
    }

    public JTextField getTxtFechainicio() {
        return txtFechainicio;
    }

    public void setTxtFechainicio(JTextField txtFechainicio) {
        this.txtFechainicio = txtFechainicio;
    }

    public JLabel getLblFechafin() {
        return lblFechafin;
    }

    public void setLblFechafin(JLabel lblFechafin) {
        this.lblFechafin = lblFechafin;
    }

    public JTextField getTxtFechafin() {
        return txtFechafin;
    }

    public void setTxtFechafin(JTextField txtFechafin) {
        this.txtFechafin = txtFechafin;
    }

    public JLabel getLblDescripcion() {
        return lblDescripcion;
    }

    public void setLblDescripcion(JLabel lblDescripcion) {
        this.lblDescripcion = lblDescripcion;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }



    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public JButton getBtnActualizarDatos() {
        return btnActualizarDatos;
    }



}
