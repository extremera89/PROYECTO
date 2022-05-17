package controladores;

import dao.DAOcentro;
import modelotablas.ModeloTablaCentro;
import modelotablas.ModeloTablaCliente;
import vistas.Ventanas.VentanaCentro;

public class ControladorCentro {

    private DAOcentro dao;
    private DAOcentro daOcentro=new DAOcentro();
    private VentanaCentro ventanaCentro;
    private ModeloTablaCentro modeloTabla;
    private int filaPulsada=-1;

    public ControladorCentro(DAOcentro dao, VentanaCentro guiCentro){
        this.dao=dao;
        this.ventanaCentro=guiCentro;
        //modeloTabla=new ModeloTablaCentro(dao);
        ventanaCentro.guiCentro.getTablaCentros().setModel(modeloTabla);
    }

}
