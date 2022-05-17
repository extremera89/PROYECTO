package modelotablas;

import dao.DAOcentro;
import dao.DAOmonitor;
import modelo.Centro;
import modelo.Monitor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaCentro extends AbstractTableModel {

    private ArrayList<Centro> listaCentros;
    private Class[] tipoColumnas;
    private String[] nombreColumnas;
    private DAOcentro dao;

    public ModeloTablaCentro (DAOcentro dao){
        listaCentros = new ArrayList();
        tipoColumnas = new Class [] {String.class, String.class, String.class,String.class,String.class,String.class,String.class};
        nombreColumnas = new String [] {"CodigoCentro", "Nombre", "NumeroVisita", "DNI_Cliente", "DNI_Monitor"};
        this.dao = dao;
    }

    public void setCentros(ArrayList<Centro>centros){
        listaCentros=centros;
    }

    public void crearMonitor(String codCentro, String nombre, int numVisita, String dni_Cliente, String dni_Monitor){
        listaCentros.add(new Centro(codCentro,nombre,numVisita,dni_Cliente,dni_Monitor));
        fireTableDataChanged();
    }

    public void eliminarMonitor(int pos){
        listaCentros.remove(pos);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int fila, int columna) {

        switch (columna){
            case 0:
                return listaCentros.get(fila).getCodCentro();
            case 1:
                return listaCentros.get(fila).getNombre();
            case 2:
                return listaCentros.get(fila).getNumVisita();
            case 3:
                return listaCentros.get(fila).getDniCliente();
            case 4:
                return listaCentros.get(fila).getDniMonitor();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int fila, int columna) {

        switch (columna){
            case 0:
                listaCentros.get(fila).setCodCentro(aValue.toString());
            case 1:
                listaCentros.get(fila).setNombre(aValue.toString());
            case 2:
                listaCentros.get(fila).setNumVisita(Integer.parseInt(aValue.toString()));
            case 3:
                listaCentros.get(fila).setDniCliente(aValue.toString());
            case 4:
                listaCentros.get(fila).setDniMonitor(aValue.toString());

            default:
                ;
        }

        this.fireTableCellUpdated(fila, columna);
        this.fireTableRowsUpdated(fila, columna);

    }

    @Override
    public int getRowCount() {
        return listaCentros.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }





    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


}
