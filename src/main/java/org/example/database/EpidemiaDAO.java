package org.example.database;

import org.example.modelo.Epidemia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EpidemiaDAO implements InterfazDAO {

    public EpidemiaDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Epidemias (Nombre,Fecha,Patogeno,Muertes,PaisInicial,URL) VALUES(?, ?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("EpidemiasDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Epidemia) obj).getNombre());
        pstm.setInt(2, ((Epidemia) obj).getFecha());
        pstm.setString(3, ((Epidemia) obj).getPatogeno());
        pstm.setInt(4, ((Epidemia) obj).getMuertes());
        pstm.setString(5, ((Epidemia) obj).getPaisInicial());
        pstm.setString(6, ((Epidemia) obj).getUrl());

        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Epidemias SET Nombre = ?, Fecha = ?, Patogeno = ?, Muertes = ?, PaisInicial = ?, URL = ? WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("EpidemiasDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Epidemia) obj).getNombre());
        pstm.setInt(2, ((Epidemia) obj).getFecha());
        pstm.setString(3, ((Epidemia) obj).getPatogeno());
        pstm.setInt(4, ((Epidemia) obj).getMuertes());
        pstm.setString(5, ((Epidemia) obj).getPaisInicial());
        pstm.setString(6, ((Epidemia) obj).getUrl());
        pstm.setInt(7, ((Epidemia)obj).getID());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Epidemias WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("EpidemiasDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Epidemias";
        ArrayList<Epidemia> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("EpidemiasDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(new Epidemia(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getInt(5), rst.getString(6), rst.getString(7)));

        }
        return resultado;
    }
    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Epidemias WHERE id = ? ;";
        Epidemia epidemia  = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("EpidemiasDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){

            epidemia =new Epidemia(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getInt(5), rst.getString(6), rst.getString(7));


            return epidemia;
        }
        return null;
    }


}
