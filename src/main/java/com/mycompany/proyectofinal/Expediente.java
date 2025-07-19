/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa el expediente único de un paciente, heredando de Usuario.
 * Contiene información demográfica y listas internas para el historial de citas y medicamentos.
 * @author Gemini
 */
public class Expediente extends Usuario {
    private int edad;
    private String genero;
    private ListaSimpleCircularCitas historicoCitas;
    private ListaSimpleCircularMedicamentos historicoMedicamentos;

    /**
     * Constructor de la clase Expediente.
     * @param nombre El nombre del paciente.
     * @param cedula La cédula del paciente.
     * @param edad La edad del paciente.
     * @param genero El género del paciente.
     */
    public Expediente(String nombre, String cedula, int edad, String genero) {
        super(nombre, cedula);
        this.edad = edad;
        this.genero = genero;
        this.historicoCitas = new ListaSimpleCircularCitas();
        this.historicoMedicamentos = new ListaSimpleCircularMedicamentos();
    }

    /**
     * Obtiene la edad del paciente.
     * @return La edad del paciente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del paciente.
     * @param edad La nueva edad del paciente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el género del paciente.
     * @return El género del paciente.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del paciente.
     * @param genero El nuevo género del paciente.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la lista del historial de citas del paciente.
     * @return La lista de citas históricas.
     */
    public ListaSimpleCircularCitas getHistoricoCitas() {
        return historicoCitas;
    }

    /**
     * Establece la lista del historial de citas del paciente.
     * @param historicoCitas La nueva lista de citas históricas.
     */
    public void setHistoricoCitas(ListaSimpleCircularCitas historicoCitas) {
        this.historicoCitas = historicoCitas;
    }

    /**
     * Obtiene la lista del historial de medicamentos prescritos del paciente.
     * @return La lista de medicamentos históricos.
     */
    public ListaSimpleCircularMedicamentos getHistoricoMedicamentos() {
        return historicoMedicamentos;
    }

    /**
     * Establece la lista del historial de medicamentos prescritos del paciente.
     * @param historicoMedicamentos La nueva lista de medicamentos históricos.
     */
    public void setHistoricoMedicamentos(ListaSimpleCircularMedicamentos historicoMedicamentos) {
        this.historicoMedicamentos = historicoMedicamentos;
    }

    /**
     * Proporciona una representación en cadena del objeto Expediente.
     * @return Una cadena que representa el expediente del paciente.
     */
    @Override
    public String toString() {
        return "Cedula: " + cedula + " | Nombre: " + nombre + " | Edad: " + edad + " | Genero: " + genero;
    }
}
