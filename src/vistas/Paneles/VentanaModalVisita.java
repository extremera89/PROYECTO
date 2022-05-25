package vistas.Paneles;

import controladores.ControladorVisita;
import vistas.Ventanas.VentanaVisita;

import javax.swing.*;

public class VentanaModalVisita extends JDialog {
    private JPanel contentPane;
    private JTextField txtNumpersonas;
    private JTextField txtFecha;
    private JTextField txtCentro;
    private JTextField txtDnimonitor;
    private JTextField txtDnicliente;
    private JTextField txtNumexp;
    private JLabel lblnumPersonas;
    private JLabel lblfecha;
    private JLabel lblCentro;
    private JLabel lblDnimonitor;
    private JLabel lblDnicliente;
    private JLabel lblNumexp;
    private JTextField txtNumvisita;
    private JLabel lblNumvisita;
    private JTextField txtNumSala;
    private ControladorVisita controlador;

    public VentanaModalVisita(VentanaVisita padre, boolean modal) {
        super(padre, modal);
        this.setSize(900,400);
        setContentPane(contentPane);
        setModal(true);

    }

    public void setControler(ControladorVisita controler){
        this.controlador = controler;
    }

    public JTextField getTxtNumvisita() {
        return txtNumvisita;
    }

    public void setTxtNumvisita(JTextField txtNumvisita) {
        this.txtNumvisita = txtNumvisita;
    }

    public JTextField getTxtNumpersonas() {
        return txtNumpersonas;
    }

    public void setTxtNumpersonas(JTextField txtNumpersonas) {
        this.txtNumpersonas = txtNumpersonas;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(JTextField txtFecha) {
        this.txtFecha = txtFecha;
    }

    public JTextField getTxtCentro() {
        return txtCentro;
    }

    public void setTxtCentro(JTextField txtCentro) {
        this.txtCentro = txtCentro;
    }

    public JTextField getTxtDnimonitor() {
        return txtDnimonitor;
    }

    public void setTxtDnimonitor(JTextField txtDnimonitor) {
        this.txtDnimonitor = txtDnimonitor;
    }

    public JTextField getTxtDnicliente() {
        return txtDnicliente;
    }

    public JTextField getTextField1() {
        return txtNumSala;
    }

    public JTextField getTxtNumSala() {
        return txtNumSala;
    }

    public void setTxtNumSala(JTextField txtNumSala) {
        this.txtNumSala = txtNumSala;
    }

    public JTextField getTxtNumexp() {
        return txtNumexp;
    }

    public void setTxtNumexp(JTextField txtNumexp) {
        this.txtNumexp = txtNumexp;
    }
}
