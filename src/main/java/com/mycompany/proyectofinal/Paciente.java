/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ArauzArturo
 */
public class Paciente extends Usuario{
    private Date f_h;
    private String ficha;

    public Paciente(Date f_h, String ficha, String nombre, String cedula) {
        super(nombre, cedula);
        this.f_h = f_h;
        this.ficha = ficha;
    }

    public Date getF_h() {
        return f_h;
    }

    public void setF_h(Date f_h) {
        this.f_h = f_h;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }  
/**
     * Representacion de texto de objeto paciente
     * Los parametros de la clase paciente son incluidos en el texto
     * @Autor: Arauz Arturo
*/     
    
    @Override
    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Numero de ficha: " + ficha + " Nombre: " + nombre + " Cedula: " + cedula + " Dia y hora de llegada: " + simpleDateFormat.format(f_h); 
    }  
}