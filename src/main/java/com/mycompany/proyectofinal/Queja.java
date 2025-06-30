/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;
import java.util.Date;

/**
 *
 * @author LopezAlex
 */
public class Queja extends Usuario{
    private Date fecha;
    private String comentario;

    public Queja(Date fecha, String comentario, String nombre, String cedula) {
        super(nombre, cedula);
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    @Override
    public String toString(){
        return "Que presentada: " + " Nombre: " + nombre + " Cedula: " + cedula + " Fecha: " + fecha + " Descripcion: " + comentario;
    }
}