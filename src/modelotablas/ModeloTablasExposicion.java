package modelotablas;

import dao.DAOexposicion;
import modelo.Exposicion;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablasExposicion extends AbstractTableModel {



    private ArrayList<Exposicion> exposiciones;
    private String[] nombreColumnas;
    private DAOexposicion dao; //?

    public ModeloTablasExposicion (DAOexposicion dao){
        exposiciones = new ArrayList<>();
        this.dao = dao;
        this.nombreColumnas = new String[] {"Nombre", "Temática", "Fecha de inicio", "Fecha de fin", "Descripción", "Número de sala"};
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
