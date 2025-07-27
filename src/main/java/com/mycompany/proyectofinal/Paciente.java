/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Representa un paciente en el sistema, heredando propiedades de Usuario.
 * Contiene información específica de un paciente como fecha/hora de llegada y número de ficha.
 * @author Arauz Cerdas Oscar Arturo
 */
public class Paciente extends Usuario {
    // Fecha y hora de llegada del paciente.
    private Date f_h;
    // Número de ficha asignado al paciente (ej. "P1", "R5").
    private String ficha;

    /**
     * Constructor de la clase Paciente.
     * @param f_h Fecha y hora de llegada del paciente.
     * @param ficha Número de ficha asignado al paciente.
     * @param nombre Nombre completo del paciente.
     * @param cedula Número de cédula del paciente.
     */
    public Paciente(Date f_h, String ficha, String nombre, String cedula) {
        super(nombre, cedula); // Llama al constructor de la clase padre Usuario.
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
     * Proporciona una representación en cadena del objeto Paciente.
     * Incluye el número de ficha, nombre, cédula y fecha/hora de llegada formateada.
     * @return Una cadena que representa al paciente.
     * @author Arauz Cerdas Oscar Arturo
     */
    @Override
    public String toString() {
        // Formateador para la fecha y hora.
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Ficha: " + ficha + " | Nombre: " + nombre + " | Cedula: " + cedula + " | Llegada: " + simpleDateFormat.format(f_h);
    }
}