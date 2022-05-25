package modelotablas;

import dao.DAOcentro;
import dao.DAOcliente;
import dao.DAOmonitor;
import modelo.Centro;
import modelo.Cliente;
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
        tipoColumnas = new Class [] {String.class, String.class, String.class,String.class,String.class,String.class};
        nombreColumnas = new String [] {"CodigoCentro", "Nombre", "DNI_Cliente", "DNI_Monitor"};
        this.dao = dao;
    }

    public void setCentros(ArrayList<Centro>centros){
        listaCentros=centros;
    }

    public void crearMonitor(String codCentro, String nombre, Cliente dni_Cliente, Monitor dni_Monitor){
        listaCentros.add(new Centro(codCentro,nombre,dni_Cliente,dni_Monitor));
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
                return listaCentros.get(fila).getDniCliente().getDNI();
            case 3:
                return listaCentros.get(fila).getDniMonitor().getDNI();
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
                listaCentros.get(fila).getDniCliente().setDNI(((Centro)aValue).getDniCliente().getDNI());
            case 3:
                listaCentros.get(fila).getDniMonitor().setDNI(((Centro)aValue).getDniMonitor().getDNI());

            default:
                ;
        }

        this.fireTableCellUpdated(fila, columna);
        this.fireTableRowsUpdated(fila, columna);

    }

    public int saberCmboxCliente(int fila, int columna){
        int numCmbox=0;
        DAOcliente daOcliente=new DAOcliente();
        ArrayList<Cliente> dniCliente=daOcliente.listarClientes();
        for(int i=0;i<dniCliente.size();i++){
            Cliente cliente= dniCliente.get(i);
            if (listaCentros.get(fila).getDniCliente().getDNI().equals(cliente.getDNI())){
                return numCmbox;
            }
            numCmbox++;
        }
        return numCmbox;
    }

    public int saberCmboxMonitor(int fila, int columna){
        int numCmbox=0;
        DAOmonitor daoMonitor=new DAOmonitor();
        ArrayList<Monitor> dniMonitor=daoMonitor.listarMonitores();
        for(int i=0;i<dniMonitor.size();i++){
            Monitor monitor= dniMonitor.get(i);
            if (listaCentros.get(fila).getDniMonitor().getDNI().equals(monitor.getDNI())){
                return numCmbox;
            }
            numCmbox++;
        }
        return numCmbox;
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
