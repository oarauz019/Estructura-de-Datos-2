/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author nahum
 */
public class Paciente {
    Date f_h;
    private String nombre;
    private int cedula;
    private int ficha;

    public Paciente(Date f_h, int cedula, String nombre, int fecha) {
        this.f_h = f_h;
        this.cedula = cedula;
        this.nombre = nombre;
        this.ficha = ficha;
    }

    public Date getF_h() {
        return f_h;
    }

    public void setF_h() {
        this.f_h = f_h;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula() {
        this.cedula = cedula;
    }

    public int getFicha() {
        return ficha;
    }

    public void setFicha() {
        this.ficha = ficha;
    }
      
    @Override
    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Month/Day/Year Hour:Minutes:Seconds");
        return "Dia y hora de llegada: " + simpleDateFormat.format(f_h) + "Nombre: " + nombre + "Cedula: " + cedula + "Numero de ficha: " + ficha; 
    }
    
}
