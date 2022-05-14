package vistas.Paneles;

import Interfaces.InterfaceLogin;
import controladores.ControladorLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaLogin{

    public JPanel PanelPrincipal;
    public JPanel PanelSuperior;
    public JPanel panelDerecho;
    public JLabel lblTitutlo;
    public JTextField txtUsuario;
    public JPasswordField txtContrasenia;
    public JLabel lblUsuario;
    public JLabel lblContrasenia;
    public JLabel lblLogin;
    public JButton btnIniciarSesion;
    public JButton btnLimpiar;
    public JLabel lblImagen;
    private JLabel lblImagen2;
    private JLabel lblImagenLogo;

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        PanelPrincipal = panelPrincipal;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JPasswordField getTxtContrasenia() {
        return txtContrasenia;
    }

    public void setTxtContrasenia(JPasswordField txtContrasenia) {
        this.txtContrasenia = txtContrasenia;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public void setBtnIniciarSesion(JButton btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }


    public void asignaCommandBotones(){
        btnIniciarSesion.setActionCommand("LOGUEAR");
        btnLimpiar.setActionCommand("LIMPIAR");
    }

    public void desactivaLogin(){
        btnIniciarSesion.setEnabled(false);
    }
    public void activaLogin(){
        btnIniciarSesion.setEnabled(true);
    }
    public void limpiarCampos(){
        txtContrasenia.setText("");
        txtUsuario.setText("");
    }
    public void insertarImagenes() {
        lblImagenLogo.setIcon(new ImageIcon("src\\imagenes\\logoInstituto.png"));
        lblImagen2.setIcon(new ImageIcon("src\\imagenes\\fondoAzul.jpg"));
        lblImagen.setIcon(new ImageIcon("src\\imagenes\\ImagenMuseo.png"));
        btnIniciarSesion.setIcon(new ImageIcon("src\\imagenes\\iconoTick.png"));
        btnLimpiar.setIcon(new ImageIcon("src\\imagenes\\inconoLimpiar.png"));
    }
}
