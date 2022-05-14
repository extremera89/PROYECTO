package vistas.Paneles;

import javax.swing.*;

public class VistaPrincipal {
    public JPanel PanelPrincipal;
    private JPanel Pestania;
    private JTabbedPane ptPestanias;

    public void addPestania(JPanel vista, String titulo) {
        ptPestanias.addTab(titulo, vista);
    }
}
