package org.example;


import org.example.controlador.ControladorEpidemia;
import org.example.database.EpidemiaDAO;
import org.example.modelo.Epidemia;
import org.example.vista.Ventana;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        Ventana view = new Ventana("EPIDEMIAS HISTORICAS");
        ControladorEpidemia controller = new ControladorEpidemia(view);


    }
}