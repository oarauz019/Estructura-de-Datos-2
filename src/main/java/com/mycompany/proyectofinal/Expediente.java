/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa el expediente único de un paciente, heredando de Usuario.
 * Contiene información demográfica y listas internas para el historial de citas y medicamentos.
 * @author Sandi Aguero Mario Andres
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ListaSimpleCircularCitas getHistoricoCitas() {
        return historicoCitas;
    }

    public void setHistoricoCitas(ListaSimpleCircularCitas historicoCitas) {
        this.historicoCitas = historicoCitas;
    }

    public ListaSimpleCircularMedicamentos getHistoricoMedicamentos() {
        return historicoMedicamentos;
    }

    public void setHistoricoMedicamentos(ListaSimpleCircularMedicamentos historicoMedicamentos) {
        this.historicoMedicamentos = historicoMedicamentos;
    }

    @Override
    public String toString() {
        return "Cedula: " + cedula + " | Nombre: " + nombre + " | Edad: " + edad + " | Genero: " + genero;
    }
}
