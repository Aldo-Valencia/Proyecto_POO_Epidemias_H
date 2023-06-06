package org.example.controlador;


import org.example.modelo.Epidemia;
import org.example.modelo.ModeloTablaEpidemia;
import org.example.vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorEpidemia extends MouseAdapter {
    private Ventana view;
    private ModeloTablaEpidemia modelo;


    public ControladorEpidemia(Ventana view) {
        this.view = view;
        modelo = new ModeloTablaEpidemia();
        this.view.getTblEpidemia().setModel(modelo);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblEpidemia().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == this.view.getBtnAgregar()) {
            System.out.println("Eventos sobre boton add");
            Epidemia epidemia = new Epidemia();
            ImageIcon iconoEliminado = new ImageIcon("IconoEliminar.png");
            ImageIcon iconoDeAcuerdo= new ImageIcon("IconoDeAcuerdo.png");
            epidemia.setNombre(this.view.getTxtNombre().getText());
            epidemia.setFecha(Integer.parseInt(this.view.getTxtAnio().getText()));
            epidemia.setPatogeno(this.view.getTxtTipo().getText());
            epidemia.setMuertes(Integer.parseInt(this.view.getTxtMuertes().getText()));
            epidemia.setPaisInicial(this.view.getTxtPaisInicial().getText());
            epidemia.setUrl(this.view.getTxtUrl().getText());
            if (modelo.agregarEpidemia(epidemia)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE,iconoDeAcuerdo);
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos, revise su conexion", "Error al agregar", JOptionPane.ERROR_MESSAGE,iconoEliminado);
            }
            this.view.getTblEpidemia().updateUI();
            this.view.limpiar();
        }

        if (e.getSource() == this.view.getBtnCargar()) {
            System.out.println("Evento sobre boton cargar");
            modelo = new ModeloTablaEpidemia();
            modelo.cargarDatos();
            this.view.getTblEpidemia().setModel(modelo);
            this.view.getTblEpidemia().updateUI();
        }

        if (e.getSource() == this.view.getTblEpidemia()) {
            System.out.println("Eventos sobre tabla add");
            int index = this.view.getTblEpidemia().getSelectedRow();
            Epidemia tmp = modelo.getEpiAtIndex(index);
            try {
                this.view.getImagenEpidemia().setIcon(tmp.getImagen());
                this.view.getImagenEpidemia().setText("");
            } catch (MalformedURLException mfue) {
                System.out.println(e.toString());
            }


        }

        if (e.getSource() == this.view.getBtnActualizar()) {

            System.out.println("Eventos sobre btn actualizar");
            int index = this.view.getTblEpidemia().getSelectedRow();
            Epidemia tmp = modelo.getEpiAtIndex(index);
            ImageIcon iconoIdea= new ImageIcon("IconoIdea.png");
            tmp.setNombre(this.view.getAtxtNombre().getText());
            tmp.setFecha((Integer.parseInt(this.view.getAtxtAnio().getText())));
            tmp.setPatogeno(this.view.getAtxtTipo().getText());
            tmp.setMuertes((Integer.parseInt(this.view.getAtxtMuertes().getText())));
            tmp.setPaisInicial(this.view.getAtxtPaisInicial().getText());
            tmp.setUrl(this.view.getAtxtUrl().getText());
            if (modelo.actualizarEpidemia(tmp)) {
                JOptionPane.showMessageDialog(view, "Datos actualizados", "Actualizacion", JOptionPane.INFORMATION_MESSAGE,iconoIdea);

            }
            this.view.getTblEpidemia().updateUI();
            this.view.limpiar2();
        }

        if (e.getSource() == this.view.getBtnBorrar()) {
            System.out.println("Eventos sobre btn Borrar");
            int index = this.view.getTblEpidemia().getSelectedRow();
            Epidemia tmp =  modelo.getEpiAtIndex(index);
            String id = String.valueOf(tmp.getID());
            ImageIcon iconoBasura= new ImageIcon("IconoBasura.png");
            ImageIcon iconoEliminado = new ImageIcon("IconoEliminar.png");
            ImageIcon iconoDeAcuerdo= new ImageIcon("IconoDeAcuerdo.png");
            int resultado = JOptionPane.showConfirmDialog(view,"Seguro que quieres eliminar?", "Eliminar", JOptionPane.WARNING_MESSAGE, 1, iconoBasura);
            if (resultado == JOptionPane.YES_NO_OPTION){
                if (modelo.eliminarEpidemia(id)){
                    JOptionPane.showMessageDialog(view,"Se ha eliminado el elemento seleccionado", "Eliminar",JOptionPane.INFORMATION_MESSAGE,iconoDeAcuerdo);
                }
            }else {
                JOptionPane.showMessageDialog(view, "No se ha eliminado", "Eliminacion cancelada", JOptionPane.INFORMATION_MESSAGE, iconoEliminado);
            }
            this.view.getTblEpidemia().updateUI();
            this.view.limpiar2();
        }
    }

        }



