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
    private Date f_h;
    private String nombre;
    private String cedula;
    private String ficha;

    public Paciente(Date f_h, String nombre, String cedula, String ficha) {
        this.f_h = f_h;
        this.nombre = nombre;
        this.cedula = cedula;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula() {
        this.cedula = cedula;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha() {
        this.ficha = ficha;
    }

/**
     * Representacion de texto de objeto paciente
     * Los parametros de la clase paciente son incluidos en el texto
     * @Autor: Nahum Ramirez
*/     
    
    @Override
    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Dia y hora de llegada: " + simpleDateFormat.format(f_h) + "Nombre: " + nombre + "Cedula: " + cedula + "Numero de ficha: " + ficha; 
    }
    
}
