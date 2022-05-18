package modelotablas;


import dao.DAOsala;
import modelo.Sala;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaSala extends AbstractTableModel {

    private ArrayList<Sala> listaSalas;
    private Class[] tipoColumnas;
    private String[] nombreColumnas;
    private DAOsala dao;

    public ModeloTablaSala(DAOsala dao){
        listaSalas = new ArrayList();
        tipoColumnas = new Class [] {Integer.class, Integer.class, Integer.class,Integer.class,Integer.class};
        nombreColumnas = new String [] {"Numero de Sala", "Dada de Alta", "Tamaño","Aforo","Numero de planta"};
        this.dao = dao;

    }

    public void setSalas(ArrayList<Sala>salas){
        listaSalas =salas;
    }

    public void eliminarSala(int pos){
        listaSalas.remove(pos);
        fireTableDataChanged();
    }

    public void crearSalas(int numSala, int dadaAlta, int tamanio,int Aforo,int NumPlanta){
        listaSalas.add(new Sala(numSala,dadaAlta,tamanio,Aforo,NumPlanta));
        fireTableDataChanged();
    }

    public void actualizarTabla(){
        fireTableDataChanged();
    }

    public void actualizarSala(int fila, Object expAct) {
        listaSalas.get(fila).setNumSala(((Sala)expAct).getNumSala());
        listaSalas.get(fila).setDadaAlta(((Sala)expAct).getDadaAlta());
        listaSalas.get(fila).setTamanio(((Sala)expAct).getTamanio());
        listaSalas.get(fila).setAforo(((Sala)expAct).getAforo());
        listaSalas.get(fila).setNumPlanta(((Sala)expAct).getNumPlanta());
    }

    @Override
    public int getRowCount() {
        return listaSalas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaSalas.get(rowIndex).getNumSala();

            case 1:
                return listaSalas.get(rowIndex).getDadaAlta();

            case 2:
                return listaSalas.get(rowIndex).getTamanio();
            case 3:
                return listaSalas.get(rowIndex).getAforo();
            case 4:
                return listaSalas.get(rowIndex).getNumPlanta();
            default:
                return null;

        }
    }

    @Override
    public void setValueAt(Object aValue, int fila, int columna) {
        // TODO Auto-generated method stub

        switch(columna) {

            case 0:
                listaSalas.get(fila).setNumSala(Integer.parseInt(aValue.toString()));
                break;

            case 1:
                listaSalas.get(fila).setDadaAlta(Integer.parseInt(aValue.toString()));
                break;

            case 2:
                listaSalas.get(fila).setTamanio(Integer.parseInt(aValue.toString()));
                break;
            case 3:
                listaSalas.get(fila).setAforo(Integer.parseInt(aValue.toString()));
                break;
            case 4:
                listaSalas.get(fila).setNumPlanta(Integer.parseInt(aValue.toString()));
                break;

            default: ;
        }

        this.fireTableCellUpdated(fila, columna);
        this.fireTableRowsUpdated(fila, columna);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }



    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }


}
