/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una lista simple circular para objetos Cita.
 * @author Gemini
 */
public class NodoCita {
    private Cita dato;
    private NodoCita siguiente;

    /**
     * Constructor de la clase NodoCita.
     * @param dato El objeto Cita a almacenar en el nodo.
     */
    public NodoCita(Cita dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Obtiene el objeto Cita almacenado en este nodo.
     * @return El objeto Cita.
     */
    public Cita getDato() {
        return dato;
    }

    /**
     * Establece el objeto Cita para este nodo.
     * @param dato El nuevo objeto Cita.
     */
    public void setDato(Cita dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     * @return La referencia al siguiente NodoCita.
     */
    public NodoCita getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista.
     * @param siguiente La nueva referencia al siguiente NodoCita.
     */
    public void setSiguiente(NodoCita siguiente) {
        this.siguiente = siguiente;
    }
}
