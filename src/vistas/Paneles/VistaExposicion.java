package vistas.Paneles;

import javax.swing.*;

public class VistaExposicion {
    private JPanel panelPrincipal;
    private JPanel panelIzq;
    private JPanel panelSup;
    private JPanel panelDer;
    private JPanel panelInf;
    private JPanel panelCentro;
    private JTable tblExposicion;
    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton Volver;


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

    public JTable getTblExposicion() {
        return tblExposicion;
    }

    public void setTblExposicion(JTable table1) {
        this.tblExposicion = table1;
    }

    public JButton getBtnInsertar() {
        return btnInsertar;
    }

    public void setBtnInsertar(JButton btnInsertar) {
        this.btnInsertar = btnInsertar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getVolver() {
        return Volver;
    }

    public void setVolver(JButton volver) {
        Volver = volver;
    }
}
