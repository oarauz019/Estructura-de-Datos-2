/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa un medicamento prescrito a un paciente en una fecha específica.
 * @author Gemini
 */
public class MedicamentoPrescrito {
    private Date fechaPrescripcion;
    private String medicamento;

    /**
     * Constructor de la clase MedicamentoPrescrito.
     * @param fechaPrescripcion La fecha en que se prescribió el medicamento.
     * @param medicamento El nombre del medicamento prescrito.
     */
    public MedicamentoPrescrito(Date fechaPrescripcion, String medicamento) {
        this.fechaPrescripcion = fechaPrescripcion;
        this.medicamento = medicamento;
    }

    /**
     * Obtiene la fecha de prescripción del medicamento.
     * @return La fecha de prescripción.
     */
    public Date getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    /**
     * Establece la fecha de prescripción del medicamento.
     * @param fechaPrescripcion La nueva fecha de prescripción.
     */
    public void setFechaPrescripcion(Date fechaPrescripcion) {
        this.fechaPrescripcion = fechaPrescripcion;
    }

    /**
     * Obtiene el nombre del medicamento prescrito.
     * @return El nombre del medicamento.
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     * Establece el nombre del medicamento prescrito.
     * @param medicamento El nuevo nombre del medicamento.
     */
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    /**
     * Proporciona una representación en cadena del objeto MedicamentoPrescrito.
     * @return Una cadena que representa el medicamento prescrito.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Fecha: " + sdf.format(fechaPrescripcion) + " | Medicamento: " + medicamento;
    }
}
