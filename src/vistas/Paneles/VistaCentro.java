package vistas.Paneles;

import javax.swing.*;

public class VistaCentro {
    private JPanel PanelPrincipal;
    private JPanel PanelSuperior;
    private JLabel lblTitulo;
    private JPanel PanelIzquierdo;
    private JTable tablaCentros;
    private JButton btnActualizarTabla;
    private JButton btnEliminar;
    private JPanel PanelDerecho;
    private JLabel lblCodCentro;
    private JTextField txtCodCentro;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnActulizarDatos;
    private JTextField txtDNICliente;
    private JTextField txtDNIMonitor;
    private JLabel lblDNICLiente;
    private JLabel lblDNIMonitor;
    private JComboBox comBoxMonitor;
    private JComboBox cmboxCliente;
    private JButton btnComMonitor;
    private JButton btnComCliente;
    private JLabel lblBuscador;
    private JTextField txtBuscador;


    public JButton getBtnActualizarTabla() {
        return btnActualizarTabla;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JTextField getTxtCodCentro() {
        return txtCodCentro;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
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

    public JButton getBtnActulizarDatos() {
        return btnActulizarDatos;
    }

    public JTextField getTxtDNICliente() {
        return txtDNICliente;
    }

    public JTextField getTxtDNIMonitor() {
        return txtDNIMonitor;
    }

    public JTable getTablaCentros() {
        return tablaCentros;
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JComboBox getComBoxMonitor() {
        return comBoxMonitor;
    }

    public JButton getBtnComMonitor() {
        return btnComMonitor;
    }

    public JButton getBtnComCliente() {
        return btnComCliente;
    }

    public void setComBoxMonitor(JComboBox comBoxMonitor) {
        this.comBoxMonitor = comBoxMonitor;
    }

    public JComboBox getCmboxCliente() {
        return cmboxCliente;
    }

    public void setCmboxCliente(JComboBox cmboxCliente) {
        this.cmboxCliente = cmboxCliente;
    }

    public JTextField getTxtBuscador() {
        return txtBuscador;
    }

    public void asignaCommandBotones(){
        btnNuevo.setActionCommand("NUEVO");
        btnGuardar.setActionCommand("GUARDAR");
        btnEliminar.setActionCommand("ELIMINAR");
        btnLimpiar.setActionCommand("LIMPIAR");
        btnActualizarTabla.setActionCommand("ACTUALIZAR_TABLA");
        btnActulizarDatos.setActionCommand("ACTUALIZAR");
        btnComCliente.setActionCommand("ACTCLIENTE");
        btnComMonitor.setActionCommand("ACTUMONI");

    }

    public void limpiarCampoTxt(){
        txtCodCentro.setText("");
        txtNombre.setText("");
        txtDNICliente.setText("");
        txtDNIMonitor.setText("");
    }

    public void dasactivarCampoTxt(){
        txtCodCentro.setEnabled(false);
        txtNombre.setEnabled(false);
        txtDNICliente.setEnabled(false);
        txtDNIMonitor.setEnabled(false);
    }

    public void activaCamposTxt(){
        txtCodCentro.setEnabled(true);
        txtNombre.setEnabled(true);

    }

    public void insertarImagenes() {
        btnNuevo.setIcon(new ImageIcon("src\\imagenes\\iconoNuevo.png"));
        btnEliminar.setIcon(new ImageIcon("src\\imagenes\\iconoEliminar.png"));
        btnLimpiar.setIcon(new ImageIcon("src\\imagenes\\inconoLimpiar.png"));
        btnActualizarTabla.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnGuardar.setIcon(new ImageIcon(("src\\imagenes\\iconoGuardar.png")));
        btnActulizarDatos.setIcon(new ImageIcon("src\\imagenes\\iconoActualizarDatos.png"));
        btnComMonitor.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnComCliente.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
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

    public void desactivarBotonLimpiar(){btnLimpiar.setEnabled(false);}
    public void activarBotonLimpiar(){btnLimpiar.setEnabled(true);}

    public void desactivarbtnCodCentro(){txtCodCentro.setEnabled(false);}
    public void activarbtnCodCentro(){txtCodCentro.setEnabled(true);}
}
