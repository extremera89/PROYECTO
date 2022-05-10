package vistas.Paneles;

import javax.swing.*;

public class VistaPrincipal {
    public JPanel PanelPrincipal;
    private JPanel Pestania;
    private JTabbedPane ptPestanias;
    private JPanel ptPestania1;
    private JPanel ptPestania3;
    private JPanel ptPestania2;
    private JPanel ptPestania4;

    public void addPestania(JPanel vista, String titulo) {
        ptPestanias.addTab(titulo, vista);
    }
}
