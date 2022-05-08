package Interfaces;

import modelo.Cliente;
import modelo.Exposicion;

import java.util.ArrayList;

public interface InterfaceCliente {

    public interface InterfaceDAOCliente{
        public void insertarCliente(Cliente cliente);
        public void eliminarCliente(String DNI);
        public Cliente buscarCliente(String DNI);
        public Cliente modificarCliente(Cliente cliente);
        public ArrayList<Cliente> listarClientes();
    }

}
