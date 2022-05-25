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
        this.nombreColumnas = new String[] {"Número de exposición", "Nombre", "Temática", "Fecha de inicio", "Fecha de fin", "Descripción", "Número de sala"};
    }


    public void actualizarExposicion(int fila, Object expAct){
        exposiciones.get(fila).setNumExp(((Exposicion)expAct).getNumExp());
        exposiciones.get(fila).setNombre(((Exposicion)expAct).getNombre());
        exposiciones.get(fila).setTematica(((Exposicion)expAct).getTematica());
        exposiciones.get(fila).setFechainicio(((Exposicion)expAct).getFechainicio());
        exposiciones.get(fila).setFechafin(((Exposicion)expAct).getFechafin());
        exposiciones.get(fila).setDescripcion(((Exposicion)expAct).getDescripcion());
        exposiciones.get(fila).setNumsala(((Exposicion)expAct).getNumsala());


    }

    public void eliminarExposicion(int pos){
        exposiciones.remove(pos);
        fireTableDataChanged();
    }


    public void crearExposicion(Exposicion exposicion){
        exposiciones.add(exposicion);
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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        java.sql.Date fechainicio = new java.sql.Date(exposiciones.get(fila).getFechainicio().getTime());
        java.sql.Date fechafin = new java.sql.Date(exposiciones.get(fila).getFechafin().getTime());

        switch (columna){
            case 0:
                return exposiciones.get(fila).getNumExp();
            case 1:
                return exposiciones.get(fila).getNombre();
            case 2:
                return exposiciones.get(fila).getTematica();
            case 3:
                return format.format(fechainicio);

            case 4:
                return format.format(fechafin);

            case 5:
                return exposiciones.get(fila).getDescripcion();

            case 6:
                return exposiciones.get(fila).getNumsala().getNumSala();

            default:
                return null;

        }

    }

    @Override
    public void setValueAt(Object aValue, int fila, int columna) {
            switch (columna) {
                case 0:
                    exposiciones.get(fila).setNumExp(((Exposicion)aValue).getNumExp());

                case 1:
                    exposiciones.get(fila).setNombre(((Exposicion)aValue).getNombre());

                case 2:
                    exposiciones.get(fila).setTematica(((Exposicion)aValue).getTematica());

                case 3:
                    exposiciones.get(fila).setFechainicio(((Exposicion)aValue).getFechainicio());

                case 4:
                    exposiciones.get(fila).setFechafin(((Exposicion)aValue).getFechafin());

                case 5:
                    exposiciones.get(fila).setDescripcion(((Exposicion)aValue).getDescripcion());

                case 6:
                    exposiciones.get(fila).getNumsala().setNumSala( ((Exposicion)aValue).getNumsala().getNumSala() );

                default:

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
