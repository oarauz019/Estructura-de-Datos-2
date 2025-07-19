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
 * @author Gemini
 */
public class BitacoraCitaDia {
    private String numeroFicha;
    private Date fechaLlegada;
    private Date fechaAtencion;
    private String cedulaPaciente;
    private String nombrePaciente;
    private long tiempoEsperaSegundos; // Tiempo en segundos

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

    /**
     * Obtiene el número de ficha del paciente.
     * @return El número de ficha.
     */
    public String getNumeroFicha() {
        return numeroFicha;
    }

    /**
     * Establece el número de ficha del paciente.
     * @param numeroFicha El nuevo número de ficha.
     */
    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    /**
     * Obtiene la fecha de llegada del paciente.
     * @return La fecha de llegada.
     */
    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * Establece la fecha de llegada del paciente.
     * @param fechaLlegada La nueva fecha de llegada.
     */
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * Obtiene la fecha de atención del paciente.
     * @return La fecha de atención.
     */
    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    /**
     * Establece la fecha de atención del paciente.
     * @param fechaAtencion La nueva fecha de atención.
     */
    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    /**
     * Obtiene la cédula del paciente.
     * @return La cédula del paciente.
     */
    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    /**
     * Establece la cédula del paciente.
     * @param cedulaPaciente La nueva cédula del paciente.
     */
    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    /**
     * Obtiene el nombre del paciente.
     * @return El nombre del paciente.
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * Establece el nombre del paciente.
     * @param nombrePaciente El nuevo nombre del paciente.
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     * Obtiene el tiempo de espera del paciente en segundos.
     * @return El tiempo de espera en segundos.
     */
    public long getTiempoEsperaSegundos() {
        return tiempoEsperaSegundos;
    }

    /**
     * Establece el tiempo de espera del paciente en segundos.
     * @param tiempoEsperaSegundos El nuevo tiempo de espera en segundos.
     */
    public void setTiempoEsperaSegundos(long tiempoEsperaSegundos) {
        this.tiempoEsperaSegundos = tiempoEsperaSegundos;
    }

    /**
     * Proporciona una representación en cadena del objeto BitacoraCitaDia.
     * @return Una cadena que representa la entrada de la bitácora.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Ficha: " + numeroFicha + " | Paciente: " + nombrePaciente + " (Cedula: " + cedulaPaciente + ")" +
               " | Llegada: " + sdf.format(fechaLlegada) + " | Atencion: " + sdf.format(fechaAtencion) +
               " | Espera: " + tiempoEsperaSegundos + " segundos.";
    }
}