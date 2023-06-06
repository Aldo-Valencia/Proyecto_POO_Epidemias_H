package org.example.modelo;

import org.example.database.EpidemiaDAO;
import org.example.vista.Ventana;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaEpidemia implements TableModel {
    private ArrayList <Epidemia> datos;
    private EpidemiaDAO edao;
    public static final int COLS = 7;

    public ModeloTablaEpidemia() {
        datos = new ArrayList<>();
        edao = new EpidemiaDAO();
    }

    public ModeloTablaEpidemia(ArrayList<Epidemia> datos) {
        this.datos = datos;
        edao = new EpidemiaDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombreCol = "";
        switch (columnIndex){
            case 0:
                nombreCol = "ID";
                break;
            case 1:
                nombreCol = "Nombre";
                break;
            case 2:
                nombreCol = "Fecha";
                break;
            case 3:
                nombreCol = "Patogeno";
                break;
            case 4:
                nombreCol = "Muertes";
                break;
            case 5:
                nombreCol = "Pais Inicial";
                break;
            case 6:
                nombreCol = "Url";
                break;
            default:
                nombreCol = "";

        }

        return nombreCol;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
               return int.class;
            case 1:
                return String.class;
            case 2:
                return int.class;
            case 3:
                return String.class;
            case 4:
                return int.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            default:
                return String.class;

        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Epidemia tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getID();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getFecha();
            case 3:
                return tmp.getPatogeno();
            case 4:
                return tmp.getMuertes();
            case 5:
                return tmp.getPaisInicial();
            case 6:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                datos.get(rowIndex).setID((Integer) aValue);
            case 1:
                datos.get(rowIndex).setFecha((Integer) aValue);
                break;
            case 2:
                datos.get(rowIndex).setMuertes((Integer) aValue);
                break;
            case 3:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setPatogeno((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setPaisInicial((String) aValue);
            case 6:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            default:
                System.out.println("No se modifica nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public boolean agregarEpidemia(Epidemia epidemia){
        boolean resultado = false;
        try {
            if (edao.insertar(epidemia)){
                datos.add(epidemia);
                resultado = true;
            }
            else
            {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

        return resultado;
    }


    public boolean actualizarEpidemia(Epidemia epidemia) {
        boolean resultado = false;
        try {
            if (edao.update (epidemia)) {
                datos.add(epidemia);
                resultado = true;
            } else {
                resultado = false;

            }
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }
        return resultado;
    }


    public Epidemia getEpiAtIndex (int idx) {
         return datos.get(idx);
    }

    public void cargarDatos (){
        try {
            datos = edao.obtenerTodo();
        }catch (SQLException sqle ){
            System.out.println(sqle.getMessage());
        }

    }

    public boolean eliminarEpidemia(String id){
        boolean resultado = false;
        try {
            if (edao.delete(id)) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }
        return resultado;
    }

}
