/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.Date;

/**
 * Representa una queja en el sistema, heredando propiedades de Usuario.
 * Contiene información específica de una queja como la fecha y el comentario.
 * @author LopezAlex
 */
public class Queja extends Usuario {
    // Fecha en que se registró la queja.
    private Date fecha;
    // Comentario o descripción de la queja.
    private String comentario;

    /**
     * Constructor de la clase Queja.
     * @param fecha La fecha en que se registró la queja.
     * @param comentario El comentario o descripción de la queja.
     * @param nombre El nombre del usuario que presenta la queja.
     * @param cedula La cédula del usuario que presenta la queja.
     */
    public Queja(Date fecha, String comentario, String nombre, String cedula) {
        super(nombre, cedula); // Llama al constructor de la clase padre Usuario.
        this.fecha = fecha;
        this.comentario = comentario;
    }

    /**
     * Obtiene la fecha de la queja.
     * @return La fecha de la queja.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la queja.
     * @param fecha La nueva fecha de la queja.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el comentario de la queja.
     * @return El comentario de la queja.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario de la queja.
     * @param comentario El nuevo comentario de la queja.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Proporciona una representación en cadena del objeto Queja.
     * Incluye el nombre, cédula, fecha y descripción de la queja.
     * @return Una cadena que representa la queja.
     */
    @Override
    public String toString() {
        return "Queja de: " + nombre + " | Cedula: " + cedula + " | Fecha: " + fecha + " | Descripcion: " + comentario;
    }
}