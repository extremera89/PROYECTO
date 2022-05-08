package vistas.Paneles;

import javax.swing.*;
import java.awt.event.*;

public class VistaModalExp extends JDialog {
    private JPanel contentPane;
    private JPanel panelIzq;
    private JPanel panelSup;
    private JPanel panelSupIzq;
    private JLabel lblFechaInicio;
    private JLabel lblFechaFin;
    private JLabel lblNumSala;
    private JTextField txtFechaFin;
    private JTextField txtNumSala;
    private JTextField txtFechaInicio;
    private JPanel panelSupDer;
    private JLabel lblNombre;
    private JLabel lblTematica;
    private JLabel lblDescripcion;
    private JTextField txtNombre;
    private JTextField txtTematica;
    private JTextField txtDescripcion;
    private JPanel panelDer;
    private JPanel panelInf;
    private JPanel panelCentro;
    private JButton btnAceptar;
    private JButton btnVolver;
    private JButton buttonOK;
    private JButton buttonCancel;

    public VistaModalExp(JFrame ventana, boolean modal ) {
        super(ventana, modal);
        setContentPane(contentPane);
        setModal(true);
        this.setBounds(100, 100, 600, 600);
    }




}
