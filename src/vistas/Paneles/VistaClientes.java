package vistas.Paneles;

import javax.swing.*;

public class VistaClientes{
    private JPanel PanelPrincipal;
    private JPanel PanelSuperior;
    private JPanel PanelIzquierdo;
    private JPanel PanelDerecho;
    private JTable table1;
    private JTextField txtDNI;
    private JTextField txtNombre;
    private JTextField txtApellido1;
    private JTextField txtApellido2;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtExpositor;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JLabel lblDNI;
    private JLabel lblNombre;
    private JLabel lblApellido1;
    private JLabel lblApellido2;
    private JLabel lblTelefono;
    private JLabel lblEmail;
    private JLabel lblExpositor;
    public JButton btnActulizarDatos;
    private JButton btnActualizarTabla;
    private JButton btnEliminar;
    private JLabel lblTitulo;

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JTextField getTxtDNI() {
        return txtDNI;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtApellido1() {
        return txtApellido1;
    }

    public JTextField getTxtApellido2() {
        return txtApellido2;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtExpositor() {
        return txtExpositor;
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
        btnActualizarTabla.setActionCommand("ACTUALIZAR_DATOS");
    }

    public void limpiarCampoTxt(){
            txtDNI.setText("");
            txtNombre.setText("");
            txtApellido1.setText("");
            txtApellido2.setText("");
            txtTelefono.setText("");
            txtEmail.setText("");
            txtExpositor.setText("");
    }

    public void dasactivarCampoTxt(){
        txtDNI.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellido1.setEnabled(false);
        txtApellido2.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmail.setEnabled(false);
        txtExpositor.setEnabled(false);
    }

    public void activaCamposTxt(){
        txtDNI.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellido1.setEnabled(true);
        txtApellido2.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        txtExpositor.setEnabled(true);
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

}
