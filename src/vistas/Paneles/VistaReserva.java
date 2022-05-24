package vistas.Paneles;

import javax.swing.*;

public class VistaReserva {
    private JPanel PanelPrincipal;
    private JPanel PanelSuperior;
    private JPanel PanelIzquierdo;
    private JPanel PanelDerecho;
    private JTable tableReserva;
    private JTextField txtCodigoReserva;
    private JTextField txtDNI;
    private JTextField txtNumeroSala;
    private JTextField txtFechaReserva;
    private JTextField txtFechaFin;
    private JTextField txtConfirmado;
    private JTextField txtMotivo;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JLabel lblCodigoReserva;
    private JLabel lblDNI;
    private JLabel lblNumSala;
    private JLabel lblFechaReserva;
    private JLabel lblFechaFin;
    private JLabel lblConfirmado;
    private JLabel lblMotivo;
    public JButton btnActulizarDatos;
    private JButton btnActualizarTabla;
    private JButton btnEliminar;
    private JLabel lblTitulo;
    private JTextField txtBuscador;
    private JLabel lblBusca;
    private JComboBox combDNI;
    private JComboBox combSala;
    private JButton actDNI;
    private JButton actNumSala;


    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JTextField getTxtCodigoReserva() {
        return txtCodigoReserva;
    }

    public JTextField getTxtDNI() {
        return txtDNI;
    }

    public JTextField getTxtNumeroSala() {
        return txtNumeroSala;
    }

    public JTextField getTxtFechaReserva() {
        return txtFechaReserva;
    }

    public JTextField getTxtFechaFin() {
        return txtFechaFin;
    }

    public JTextField getTxtConfirmado() {
        return txtConfirmado;
    }

    public JTextField getTxtMotivo() {
        return txtMotivo;
    }

    public JButton getActDNI() {
        return actDNI;
    }

    public JButton getActNumSala() {
        return actNumSala;
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

    public JTable getTableReserva(){return tableReserva;}

    public JTextField getTxtBuscador() {
        return txtBuscador;
    }

    public JComboBox getCombDNI() {
        return combDNI;
    }

    public JComboBox getCombSala() {
        return combSala;
    }

    public void asignaCommandBotones(){
        btnNuevo.setActionCommand("NUEVO");
        btnGuardar.setActionCommand("GUARDAR");
        btnEliminar.setActionCommand("ELIMINAR");
        btnLimpiar.setActionCommand("LIMPIAR");
        btnActualizarTabla.setActionCommand("ACTUALIZAR_TABLA");
        btnActulizarDatos.setActionCommand("ACTUALIZAR");
        actDNI.setActionCommand("ACTDNI");
        actNumSala.setActionCommand("ACTNUMSALA");
    }

    public void limpiarCampoTxt(){
            txtCodigoReserva.setText("");
            txtDNI.setText("");
            txtNumeroSala.setText("");
            txtFechaReserva.setText("");
            txtFechaFin.setText("");
            txtConfirmado.setText("");
            txtMotivo.setText("");
    }

    public void dasactivarCampoTxt(){
        txtCodigoReserva.setEnabled(false);
        txtDNI.setEnabled(false);
        txtNumeroSala.setEnabled(false);
        txtFechaReserva.setEnabled(false);
        txtFechaFin.setEnabled(false);
        txtConfirmado.setEnabled(false);
        txtMotivo.setEnabled(false);
    }

    public void activaCamposTxt(){
        txtCodigoReserva.setEnabled(true);
        txtDNI.setEnabled(true);
        txtNumeroSala.setEnabled(true);
        txtFechaReserva.setEnabled(true);
        txtFechaFin.setEnabled(true);
        txtConfirmado.setEnabled(true);
        txtMotivo.setEnabled(true);
    }

    public void insertarImagenes() {
        btnNuevo.setIcon(new ImageIcon("src\\imagenes\\iconoNuevo.png"));
        btnEliminar.setIcon(new ImageIcon("src\\imagenes\\iconoEliminar.png"));
        btnLimpiar.setIcon(new ImageIcon("src\\imagenes\\inconoLimpiar.png"));
        btnActualizarTabla.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        btnGuardar.setIcon(new ImageIcon(("src\\imagenes\\iconoGuardar.png")));
        btnActulizarDatos.setIcon(new ImageIcon("src\\imagenes\\iconoActualizarDatos.png"));
        actDNI.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
        actNumSala.setIcon(new ImageIcon("src\\imagenes\\iconoActualizar.png"));
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

    public void desactivarTXTCodigoReserva(){txtCodigoReserva.setEnabled(false);}

    public JButton getBtnActulizarDatos() {
        return btnActulizarDatos;
    }

    public void setBtnActulizarDatos(JButton btnActulizarDatos) {
        this.btnActulizarDatos = btnActulizarDatos;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
