/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa un medicamento prescrito a un paciente en una fecha específica.
 * @author Arauz Cerdas Oscar Arturo
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

    public Date getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    public void setFechaPrescripcion(Date fechaPrescripcion) {
        this.fechaPrescripcion = fechaPrescripcion;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Fecha: " + sdf.format(fechaPrescripcion) + " | Medicamento: " + medicamento;
    }
}
