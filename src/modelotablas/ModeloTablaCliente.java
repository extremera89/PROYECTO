package modelotablas;

import dao.DAOcliente;
import modelo.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaCliente extends AbstractTableModel {

    private ArrayList<Cliente>listaClientes;
    private Class[] tipoColumnas;
    private String[] nombreColumnas;
    private DAOcliente dao;
    public ModeloTablaCliente (DAOcliente dao){
        listaClientes = new ArrayList(); //creamos los alumnos
        tipoColumnas = new Class [] {String.class, String.class, String.class,String.class,String.class,String.class,Integer.class};
        nombreColumnas = new String [] {"DNI", "Nombre", "Apellido", "Apellido2", "Telefono", "Email", "Expositor"};
        this.dao = dao;

    }

    public void setClientes(ArrayList<Cliente>clientes){
        listaClientes=clientes;
    }

    public void crearCliente(String dni, String nombre, String apellido1, String apellido2, String telefono, String email, int expositor){
        listaClientes.add(new Cliente(dni,nombre,apellido1,apellido2,telefono,email,expositor));
        fireTableDataChanged();
    }

    public void eliminarCliente(int pos){
        listaClientes.remove(pos);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
     public Object getValueAt(int fila, int columna) {

        switch (columna){
            case 0:
                return listaClientes.get(fila).getDNI();
            case 1:
                return listaClientes.get(fila).getNombre();
            case 2:
                return listaClientes.get(fila).getApellido1();
            case 3:
                return listaClientes.get(fila).getApellido2();
            case 4:
                return listaClientes.get(fila).getTelefono();
            case 5:
                return listaClientes.get(fila).getEmail();
            case 6:
                return listaClientes.get(fila).getEs_Expositor();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int fila, int columna) {

        switch (columna){
            case 0:
                listaClientes.get(fila).setDNI(aValue.toString());
            case 1:
                listaClientes.get(fila).setNombre(aValue.toString());
            case 2:
                 listaClientes.get(fila).setApellido1(aValue.toString());
            case 3:
                 listaClientes.get(fila).setApellido2(aValue.toString());
            case 4:
                 listaClientes.get(fila).setTelefono(aValue.toString());
            case 5:
                 listaClientes.get(fila).setEmail(aValue.toString());
            case 6:
                 listaClientes.get(fila).setEs_Expositor(Integer.parseInt(aValue.toString()));
            default:
                 ;
        }

        this.fireTableCellUpdated(fila, columna);
        this.fireTableRowsUpdated(fila, columna);

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
