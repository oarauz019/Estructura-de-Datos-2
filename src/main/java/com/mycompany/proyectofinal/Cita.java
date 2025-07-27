
package com.mycompany.proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa una cita médica específica de un paciente.
 * Contiene la fecha de la cita, el nombre del doctor y el diagnóstico.
 * @author Lopez Lopez Alex Josue
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Fecha: " + sdf.format(fecha) + " | Doctor: " + nombreDoctor + " | Diagnostico: " + diagnostico;
    }
}
