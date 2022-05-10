package modelotablas;

import dao.DAOexposicion;
import modelo.Exposicion;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ModeloTablasExposicion extends AbstractTableModel {



    private ArrayList<Exposicion> exposiciones;
    private Class[] tipoColumnas;
    private String[] nombreColumnas;
    private DAOexposicion dao; //?

    public ModeloTablasExposicion (DAOexposicion dao){
        exposiciones = new ArrayList<>();
        tipoColumnas = new Class[] {String.class, String.class, Date.class, Date.class, String.class, Integer.class};
        this.dao = dao;
        this.nombreColumnas = new String[] {"Nombre", "Temática", "Fecha de inicio", "Fecha de fin", "Descripción", "Número de sala"};
    }


    public void actualizarExposicion(int fila, Object expAct){
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

        try {
            exposiciones.get(fila).setNombre(expAct.toString());
            exposiciones.get(fila).setNombre(expAct.toString());
            exposiciones.get(fila).setTematica(expAct.toString());
            //exposiciones.get(fila).setFechainicio(expAct.toString());
            exposiciones.get(fila).setFechafin(formatter1.parse(expAct.toString()));
            exposiciones.get(fila).setDescripcion(expAct.toString());
            exposiciones.get(fila).setNumsala(Integer.parseInt(expAct.toString()));
            fireTableDataChanged();
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }
    }

    public void eliminarExposicion(int pos){
        exposiciones.remove(pos);
        fireTableDataChanged();
    }


    public void crearExposicion(String nombre, String tematica, Date fechain, Date fechafin, String desc, int numSala){
        exposiciones.add(new Exposicion(nombre, tematica, fechain, fechafin, desc, numSala));
        fireTableDataChanged();
    }

    public void setExposiciones(ArrayList<Exposicion> exposiciones){
        this.exposiciones = exposiciones;
    }




    @Override
    public int getRowCount() {
        return exposiciones.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        switch (columna){
            case 0:
                return exposiciones.get(fila).getNombre();
            case 1:
                return exposiciones.get(fila).getTematica();
            case 2:
                return formatter1.format(exposiciones.get(fila).getFechainicio());
            case 3:
                return formatter1.format(exposiciones.get(fila).getFechafin());
            case 4:
                return exposiciones.get(fila).getDescripcion();
            case 5:
                return exposiciones.get(fila).getNumsala();

            default:
                return null;

        }

    }

    @Override
    public void setValueAt(Object aValue, int fila, int columna) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

        try {
            switch (columna) {
                case 0:
                    exposiciones.get(fila).setNombre(aValue.toString());
                case 1:
                    exposiciones.get(fila).setTematica(aValue.toString());
                case 2:
                    exposiciones.get(fila).setFechainicio(formatter1.parse(aValue.toString()));
                case 3:
                    exposiciones.get(fila).setFechafin(formatter1.parse(aValue.toString()));
                case 4:
                    exposiciones.get(fila).setDescripcion(aValue.toString());
                case 5:
                    exposiciones.get(fila).setNumsala(Integer.parseInt(aValue.toString()));


                default:

            }
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }

        this.fireTableCellUpdated(fila,columna);
        this.fireTableRowsUpdated(fila,columna);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }


}
