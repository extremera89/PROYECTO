package vistas.Paneles;

import javax.swing.*;

public class VistaExposicion {
    private JPanel panelPrincipal;
    private JPanel panelIzq;
    private JPanel panelSup;
    private JPanel panelDer;
    private JPanel panelInf;
    private JPanel panelCentro;
    private JTable table1;
    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton Volver;


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }
}
