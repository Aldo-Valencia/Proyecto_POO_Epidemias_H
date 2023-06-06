package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Epidemia {
    private int ID;
    private int fecha;
    private String nombre;
    private int muertes;
    private String patogeno;
    private String paisInicial;
    private String url;


    public Epidemia() {
    }


    public Epidemia(int ID, String nombre, int fecha, String patogeno, int muertes, String paisInicial, String url ) {
        this.ID = ID;
        this.nombre = nombre;
        this.fecha = fecha;
        this.patogeno = patogeno;
        this.muertes = muertes;
        this.paisInicial = paisInicial;
        this.url = url;

    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public String getPatogeno() {
        return patogeno;
    }

    public void setPatogeno(String patogeno) {
        this.patogeno = patogeno;
    }

    public String getPaisInicial() {
        return paisInicial;
    }

    public void setPaisInicial(String paisInicial) {
        this.paisInicial = paisInicial;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Epidemia{" +
                "ID=" + ID +
                ", fecha=" + fecha +
                ", nombre='" + nombre + '\'' +
                ", muertes=" + muertes +
                ", patogeno='" + patogeno + '\'' +
                ", paisInicial='" + paisInicial + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImagen = new URL(this.url);
        return new ImageIcon(urlImagen);
    }
}
