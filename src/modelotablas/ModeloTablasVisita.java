package modelotablas;

import dao.DAOvisitaguiada;
import modelo.VisitaGuiada;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ModeloTablasVisita extends AbstractTableModel {


    private ArrayList<VisitaGuiada> visitas;
    private String[] nombreColumnas;
    private Class[] tipoColumnas;
    private DAOvisitaguiada dao;

    public ModeloTablasVisita (DAOvisitaguiada dao){
        visitas = new ArrayList<>();
        this.dao = dao;
        tipoColumnas = new Class[] {Integer.class, Integer.class, Date.class};
        this.nombreColumnas = new String[] {"Número de visita", "Número de personas", "Fecha"};
    }


    public void crearVisita(VisitaGuiada visita){
        visitas.add(visita);
        fireTableDataChanged();
    }

    public void actualizarVisita(int fila, Object expAct){
        visitas.get(fila).setNumvisita(((VisitaGuiada)expAct).getNumvisita());
        visitas.get(fila).setNumpersonas(((VisitaGuiada)expAct).getNumpersonas());
        visitas.get(fila).setFecha(((VisitaGuiada)expAct).getFecha());
    }

    public void eliminarVisita(int pos){
        visitas.remove(pos);
        fireTableDataChanged();
    }

    public void setVisitas(ArrayList<VisitaGuiada> visita){
        this.visitas = visita;
    }


    @Override
    public int getRowCount() {
        return visitas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            java.sql.Date fecha = new java.sql.Date(visitas.get(fila).getFecha().getTime());

            switch (columna) {
                case 0:
                    return visitas.get(fila).getNumvisita();
                case 1:
                    return visitas.get(fila).getNumpersonas();
                case 2:
                    return format.format(fecha);

                default:
                    return null;

            }
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tabla vacía");
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int fila, int columna) {
        switch (columna) {
            case 0:
                visitas.get(fila).setNumvisita(((VisitaGuiada)aValue).getNumvisita());

            case 1:
                visitas.get(fila).setNumpersonas(((VisitaGuiada)aValue).getNumpersonas());

            case 2:
                visitas.get(fila).setFecha(((VisitaGuiada)aValue).getFecha());

            default:

        }


        this.fireTableCellUpdated(fila,columna);
        this.fireTableRowsUpdated(fila,columna);

    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
