/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtrokonoha.model;

/**
 *
 * @author Uniminuto Tibu
 */
public class Mision {
    private int id;
    private String descripcion;
    private String Rnago;
    private double recompensa;
    
    public Mision (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRnago() {
        return Rnago;
    }

    public void setRnago(String Rnago) {
        this.Rnago = Rnago;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }
       
}
