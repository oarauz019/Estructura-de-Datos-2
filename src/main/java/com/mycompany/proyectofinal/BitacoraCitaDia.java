/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa una entrada en la bitácora de citas del día.
 * Contiene información relevante de la cita y el tiempo de espera.
 * @author Ramirez Fuentes Nahum Esteban
 */
public class BitacoraCitaDia {
    private String numeroFicha;
    private Date fechaLlegada;
    private Date fechaAtencion;
    private String cedulaPaciente;
    private String nombrePaciente;
    private long tiempoEsperaSegundos; 

    /**
     * Constructor de la clase BitacoraCitaDia.
     * @param numeroFicha El número de ficha del paciente.
     * @param fechaLlegada La fecha y hora de llegada del paciente.
     * @param fechaAtencion La fecha y hora en que el paciente fue atendido.
     * @param cedulaPaciente La cédula del paciente.
     * @param nombrePaciente El nombre del paciente.
     * @param tiempoEsperaSegundos El tiempo de espera del paciente en segundos.
     */
    public BitacoraCitaDia(String numeroFicha, Date fechaLlegada, Date fechaAtencion, String cedulaPaciente, String nombrePaciente, long tiempoEsperaSegundos) {
        this.numeroFicha = numeroFicha;
        this.fechaLlegada = fechaLlegada;
        this.fechaAtencion = fechaAtencion;
        this.cedulaPaciente = cedulaPaciente;
        this.nombrePaciente = nombrePaciente;
        this.tiempoEsperaSegundos = tiempoEsperaSegundos;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public long getTiempoEsperaSegundos() {
        return tiempoEsperaSegundos;
    }

    public void setTiempoEsperaSegundos(long tiempoEsperaSegundos) {
        this.tiempoEsperaSegundos = tiempoEsperaSegundos;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Ficha: " + numeroFicha + " | Paciente: " + nombrePaciente + " (Cedula: " + cedulaPaciente + ")" +
               " | Llegada: " + sdf.format(fechaLlegada) + " | Atencion: " + sdf.format(fechaAtencion) +
               " | Espera: " + tiempoEsperaSegundos + " segundos.";
    }
}