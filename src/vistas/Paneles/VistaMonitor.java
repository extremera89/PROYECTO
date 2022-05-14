package vistas.Paneles;

import javax.swing.*;

public class VistaMonitor extends JFrame{
    private JPanel PanelPrincipal;
    private JPanel PanelSuperior;
    private JLabel lblTitulo;
    private JPanel PanelIzquierdo;
    private JTable tablaMonitores;
    private JButton btnActualizarTabla;
    private JButton btnEliminar;
    private JPanel PanelDerecho;
    private JLabel lblDNI;
    private JTextField txtDNI;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido1;
    private JTextField txtApellido1;
    private JLabel lblApellido2;
    private JTextField txtApellido2;
    private JLabel lblTelefono;
    private JTextField txtTelefono;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblTitulacion;
    private JTextField txtTitulacion;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnActulizarDatos;

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JTable getTablaMonitores() {
        return tablaMonitores;
    }

    public JButton getBtnActualizarTabla() {
        return btnActualizarTabla;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
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

    public JTextField getTxtTitulacion() {
        return txtTitulacion;
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

    public void asignaCommandBotones(){
        btnNuevo.setActionCommand("NUEVO");
        btnGuardar.setActionCommand("GUARDAR");
        btnEliminar.setActionCommand("ELIMINAR");
        btnLimpiar.setActionCommand("LIMPIAR");
        btnActualizarTabla.setActionCommand("ACTUALIZAR_TABLA");
        btnActulizarDatos.setActionCommand("ACTUALIZAR");
    }

    public void limpiarCampoTxt(){
        txtDNI.setText("");
        txtNombre.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtTitulacion.setText("");
    }

    public void desactivarCampoTxt(){
        txtDNI.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellido1.setEnabled(false);
        txtApellido2.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmail.setEnabled(false);
        txtTitulacion.setEnabled(false);
    }

    public void activaCamposTxt(){
        txtDNI.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellido1.setEnabled(true);
        txtApellido2.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        txtTitulacion.setEnabled(true);
    }

    public void insertarImagenes() {
        btnNuevo.setIcon(new ImageIcon("src\\imagenes\\iconoNuevo.png"));
        btnEliminar.setIcon(new ImageIcon("src\\imagenes\\iconoEliminar.png"));
        btnLimpiar.setIcon(new ImageIcon("src\\imagenes\\inconoLimpiar.png"));
        btnActualizarTabla.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnGuardar.setIcon(new ImageIcon(("src\\imagenes\\iconoGuardar.png")));
        btnActulizarDatos.setIcon(new ImageIcon("src\\imagenes\\iconoActualizarDatos.png"));
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

    public void desactivarTXTNIF(){txtDNI.setEnabled(false);}
    public void activarTXTNIF(){txtDNI.setEnabled(true);}
}
