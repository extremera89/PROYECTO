package vistas.Paneles;

import controladores.ControladorExposicion;
import vistas.Ventanas.VentanaExposicion;

import javax.swing.*;

public class VistaModalExposicion extends JDialog {

    private JPanel panelPrincipal;
    private JPanel panelIzq;
    private JPanel panelSup;
    private JPanel panelDer;
    private JPanel panelInf;
    private JPanel panelCentro;
    private JPanel panelSupIzq;
    private JPanel panelSupDer;
    private JLabel lblNombre;
    private JLabel lblTematica;
    private JLabel lblDescripcion;
    private JTextField txtNombre;
    private JTextField txtTematica;
    private JTextField txtDescripcion;
    private JTextField txtFechaFin;
    private JTextField txtNumSala;
    private JTextField txtFechaInicio;
    private JLabel lblFechaInicio;
    private JLabel lblFechaFin;
    private JLabel lblNumSala;
    private JButton btnAceptar;
    private JButton btnVolver;

    public VistaModalExposicion(JFrame padre, boolean modal){
        super(padre, modal);

        panelPrincipal.setLayout(null);

    }


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelIzq() {
        return panelIzq;
    }

    public void setPanelIzq(JPanel panelIzq) {
        this.panelIzq = panelIzq;
    }

    public JPanel getPanelSup() {
        return panelSup;
    }

    public void setPanelSup(JPanel panelSup) {
        this.panelSup = panelSup;
    }

    public JPanel getPanelDer() {
        return panelDer;
    }

    public void setPanelDer(JPanel panelDer) {
        this.panelDer = panelDer;
    }

    public JPanel getPanelInf() {
        return panelInf;
    }

    public void setPanelInf(JPanel panelInf) {
        this.panelInf = panelInf;
    }

    public JPanel getPanelCentro() {
        return panelCentro;
    }

    public void setPanelCentro(JPanel panelCentro) {
        this.panelCentro = panelCentro;
    }

    public JPanel getPanelSupIzq() {
        return panelSupIzq;
    }

    public void setPanelSupIzq(JPanel panelSupIzq) {
        this.panelSupIzq = panelSupIzq;
    }

    public JPanel getPanelSupDer() {
        return panelSupDer;
    }

    public void setPanelSupDer(JPanel panelSupDer) {
        this.panelSupDer = panelSupDer;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblTematica() {
        return lblTematica;
    }

    public void setLblTematica(JLabel lblTematica) {
        this.lblTematica = lblTematica;
    }

    public JLabel getLblDescripcion() {
        return lblDescripcion;
    }

    public void setLblDescripcion(JLabel lblDescripcion) {
        this.lblDescripcion = lblDescripcion;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTematica() {
        return txtTematica;
    }

    public void setTxtTematica(JTextField txtTematica) {
        this.txtTematica = txtTematica;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public JTextField getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(JTextField txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public JTextField getTxtNumSala() {
        return txtNumSala;
    }

    public void setTxtNumSala(JTextField txtNumSala) {
        this.txtNumSala = txtNumSala;
    }

    public JTextField getTxtFechaInicio() {
        return txtFechaInicio;
    }

    public void setTxtFechaInicio(JTextField txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public JLabel getLblFechaInicio() {
        return lblFechaInicio;
    }

    public void setLblFechaInicio(JLabel lblFechaInicio) {
        this.lblFechaInicio = lblFechaInicio;
    }

    public JLabel getLblFechaFin() {
        return lblFechaFin;
    }

    public void setLblFechaFin(JLabel lblFechaFin) {
        this.lblFechaFin = lblFechaFin;
    }

    public JLabel getLblNumSala() {
        return lblNumSala;
    }

    public void setLblNumSala(JLabel lblNumSala) {
        this.lblNumSala = lblNumSala;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }


    public void setControler(ControladorExposicion c){

    }

}
