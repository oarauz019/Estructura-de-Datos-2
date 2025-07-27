/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una lista simple circular para objetos Cita.
 * @author Lopez Lopez Alex Josue
 */
public class NodoCita {
    private Cita dato;
    private NodoCita siguiente;


    public NodoCita(Cita dato) {
        this.dato = dato;
        this.siguiente = null;
    }


    public Cita getDato() {
        return dato;
    }


    public void setDato(Cita dato) {
        this.dato = dato;
    }


    public NodoCita getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(NodoCita siguiente) {
        this.siguiente = siguiente;
    }
}
