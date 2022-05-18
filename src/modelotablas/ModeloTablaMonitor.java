package modelotablas;

import dao.DAOmonitor;
import modelo.Monitor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaMonitor extends AbstractTableModel {

    private ArrayList<Monitor> listaMonitores;
    private Class[] tipoColumnas;
    private String[] nombreColumnas;
    private DAOmonitor dao;

    public ModeloTablaMonitor (DAOmonitor dao){
        listaMonitores = new ArrayList();
        tipoColumnas = new Class [] {String.class, String.class, String.class,String.class,String.class,String.class,String.class};
        nombreColumnas = new String [] {"DNI", "Nombre", "Apellido", "Apellido2", "Telefono", "Email", "Titulación"};
        this.dao = dao;
    }

    public void setMonitores(ArrayList<Monitor>monitores){
        listaMonitores=monitores;
    }

    public void crearMonitor(String dni, String nombre, String apellido1, String apellido2, String telefono, String email, String titulacion){
        listaMonitores.add(new Monitor(dni,nombre,apellido1,apellido2,telefono,email,titulacion));
        fireTableDataChanged();
    }

    public void eliminarMonitor(int pos){
        listaMonitores.remove(pos);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaMonitores.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {

        switch (columna){
            case 0:
                return listaMonitores.get(fila).getDNI();
            case 1:
                return listaMonitores.get(fila).getNombre();
            case 2:
                return listaMonitores.get(fila).getApellido1();
            case 3:
                return listaMonitores.get(fila).getApellido2();
            case 4:
                return listaMonitores.get(fila).getTelefono();
            case 5:
                return listaMonitores.get(fila).getEmail();
            case 6:
                return listaMonitores.get(fila).getTitulacion();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int fila, int columna) {

        switch (columna){
            case 0:
                listaMonitores.get(fila).setDNI(aValue.toString());
            case 1:
                listaMonitores.get(fila).setNombre(aValue.toString());
            case 2:
                listaMonitores.get(fila).setApellido1(aValue.toString());
            case 3:
                listaMonitores.get(fila).setApellido2(aValue.toString());
            case 4:
                listaMonitores.get(fila).setTelefono(aValue.toString());
            case 5:
                listaMonitores.get(fila).setEmail(aValue.toString());
            case 6:
                listaMonitores.get(fila).setTitulacion(aValue.toString());
            default:
                ;
        }

        this.fireTableCellUpdated(fila, columna);
        this.fireTableRowsUpdated(fila, columna);

    }

    public int saberTitulacion(int fila, int columna){
        int numCmbox=0;
        ArrayList<Monitor> dniMonitor=dao.listarMonitores();
        for(int i=0;i<dniMonitor.size();i++){
            Monitor monitor= dniMonitor.get(i);
            if (listaMonitores.get(fila).getTitulacion().equals(monitor.getTitulacion())){
                return numCmbox;
            }
            numCmbox++;
        }
        return numCmbox;
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
