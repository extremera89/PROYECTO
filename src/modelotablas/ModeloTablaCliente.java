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
        tipoColumnas = new Class [] {String.class, String.class, Integer.class};
        nombreColumnas = new String [] {"DNI", "Nombre", "Apellido", "Apellido2, Telefono, Email, Expositor"};
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
