
package com.mycompany.proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa una cita médica específica de un paciente.
 * Contiene la fecha de la cita, el nombre del doctor y el diagnóstico.
 * @author Gemini
 */
public class Cita {
    private Date fecha;
    private String nombreDoctor;
    private String diagnostico;

    /**
     * Constructor de la clase Cita.
     * @param fecha La fecha y hora en que se realizó la cita.
     * @param nombreDoctor El nombre del doctor que atendió la cita.
     * @param diagnostico El diagnóstico proporcionado durante la cita.
     */
    public Cita(Date fecha, String nombreDoctor, String diagnostico) {
        this.fecha = fecha;
        this.nombreDoctor = nombreDoctor;
        this.diagnostico = diagnostico;
    }

    /**
     * Obtiene la fecha de la cita.
     * @return La fecha de la cita.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la cita.
     * @param fecha La nueva fecha de la cita.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el nombre del doctor.
     * @return El nombre del doctor.
     */
    public String getNombreDoctor() {
        return nombreDoctor;
    }

    /**
     * Establece el nombre del doctor.
     * @param nombreDoctor El nuevo nombre del doctor.
     */
    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    /**
     * Obtiene el diagnóstico de la cita.
     * @return El diagnóstico.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Establece el diagnóstico de la cita.
     * @param diagnostico El nuevo diagnóstico.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Proporciona una representación en cadena del objeto Cita.
     * @return Una cadena que representa la cita.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Fecha: " + sdf.format(fecha) + " | Doctor: " + nombreDoctor + " | Diagnóstico: " + diagnostico;
    }
}
