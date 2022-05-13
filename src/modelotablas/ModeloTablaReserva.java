package modelotablas;

import dao.DAOreserva;
import modelo.Reserva;

import javax.swing.table.AbstractTableModel;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ModeloTablaReserva extends AbstractTableModel {

    private ArrayList<Reserva> listaReserva;
    private Class[] tipoColumnas;
    private String[] nombreColumnas;
    private DAOreserva dao;

    public ModeloTablaReserva(DAOreserva dao){
        listaReserva = new ArrayList();
        tipoColumnas = new Class [] {String.class, String.class, Integer.class, Date.class,Date.class,Integer.class,String.class};
        nombreColumnas = new String [] {"Codigo Reserva", "DNI", "Numero Sala","Fecha Reserva","Fecha Fin","Confirmado","Motivo"};
        this.dao = dao;

    }

    public void setReserva(ArrayList<Reserva>Reserva){
        listaReserva =Reserva;
    }


    public void actualizarReserva(int fila, Object expAct) {
        listaReserva.get(fila).setCodigoReserva(((Reserva)expAct).getCodigoReserva());
        listaReserva.get(fila).setDNI(((Reserva)expAct).getDNI());
        listaReserva.get(fila).setNumSala(((Reserva)expAct).getNumSala());
        listaReserva.get(fila).setFechaReserva(((Reserva)expAct).getFechaReserva());
        listaReserva.get(fila).setFechaFin(((Reserva)expAct).getFechaFin());
        listaReserva.get(fila).setConfirmado(((Reserva)expAct).getConfirmado());
        listaReserva.get(fila).setMotivoReserva(((Reserva)expAct).getMotivoReserva());

    }

    public void eliminarReserva(int pos){
        listaReserva.remove(pos);
        fireTableDataChanged();
    }

    public void crearReserva(String codigoReserva, String DNI, int numSala, Date fechaReserva, Date fechaFin, int confirmado, String motivoReserva){
        listaReserva.add(new Reserva(codigoReserva,DNI,numSala,fechaReserva,fechaFin,confirmado,motivoReserva));
        fireTableDataChanged();
    }

    public void actualizarTabla(){
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaReserva.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        java.sql.Date fechaReserva = new java.sql.Date(listaReserva.get(rowIndex).getFechaReserva().getTime());
        java.sql.Date fechaFin = new java.sql.Date(listaReserva.get(rowIndex).getFechaFin().getTime());

        switch (columnIndex) {
            case 0:
                return listaReserva.get(rowIndex).getCodigoReserva();
            case 1:
                return listaReserva.get(rowIndex).getDNI();
            case 2:
                return listaReserva.get(rowIndex).getNumSala();
            case 3:
                return formatoFecha.format(fechaReserva);
            case 4:
                return formatoFecha.format(fechaFin);
            case 5:
                return listaReserva.get(rowIndex).getConfirmado();
            case 6:
                return listaReserva.get(rowIndex).getMotivoReserva();

            default:
                return null;

        }
    }

    @Override
    public void setValueAt(Object aValue, int fila, int columna) {
        // TODO Auto-generated method stub

        switch(columna) {

            case 0:
                listaReserva.get(fila).setCodigoReserva(aValue.toString());
                break;

            case 1:
                listaReserva.get(fila).setDNI(aValue.toString());
                break;

            case 2:
                listaReserva.get(fila).setNumSala(Integer.parseInt(aValue.toString()));
                break;
            case 3:
                listaReserva.get(fila).setFechaReserva(Date.valueOf(aValue.toString()));
                break;

            case 4:
                listaReserva.get(fila).setFechaFin(Date.valueOf(aValue.toString()));
                break;
            case 5:
                listaReserva.get(fila).setConfirmado(Integer.parseInt(aValue.toString()));
                break;

            case 6:
                listaReserva.get(fila).setMotivoReserva(aValue.toString());
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
