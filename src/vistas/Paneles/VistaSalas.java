package vistas.Paneles;

import javax.swing.*;

public class VistaSalas {
    private JPanel PanelPrincipal;
    private JPanel PanelSuperior;
    private JPanel PanelIzquierdo;
    private JPanel PanelDerecho;
    private JTable tblSalas;
    private JTextField txtNumSala;
    private JTextField txtDadaAlta;
    private JTextField txtTamanio;
    private JTextField txtApellido2;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtExpositor;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JLabel lblNumSala;
    private JLabel lblDadaAlta;
    private JLabel lblTamanio;
    public JButton btnActulizarDatos;
    private JButton btnActualizarTabla;
    private JButton btnEliminar;
    private JLabel lblTitulo;

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JTextField getTxtNumSala() {
        return txtNumSala;
    }

    public JTextField getTxtDadaAlta() {
        return txtDadaAlta;
    }

    public JTextField getTxtTamanio() {
        return txtTamanio;
    }

    public JTable getTblSalas() {
        return tblSalas;
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
        btnActualizarTabla.setActionCommand("ACTUALIZAR_TABLA");
        btnActulizarDatos.setActionCommand("ACTUALIZAR");
    }

    public void limpiarCampoTxt(){
            txtNumSala.setText("");
            txtDadaAlta.setText("");
            txtTamanio.setText("");
    }

    public void dasactivarCampoTxt(){
        txtNumSala.setEnabled(false);
        txtDadaAlta.setEnabled(false);
        txtTamanio.setEnabled(false);
    }

    public void activaCamposTxt(){
        txtNumSala.setEnabled(true);
        txtDadaAlta.setEnabled(true);
        txtTamanio.setEnabled(true);
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

    public void desactivarBotonActualizar(){btnActulizarDatos.setEnabled(false);}
    public void activarBotonActualizar(){btnActulizarDatos.setEnabled(true);}

    public void activarBotonLimpiar(){btnLimpiar.setEnabled(true);}
    public void desactivarBotonLimpiar(){btnLimpiar.setEnabled(false);}
    public void desactivarTXTNumSala(){txtNumSala.setEnabled(false);}
    public JButton getBtnActulizarDatos() {
        return btnActulizarDatos;
    }

    public void setBtnActulizarDatos(JButton btnActulizarDatos) {
        this.btnActulizarDatos = btnActulizarDatos;
    }
}