/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una lista doblemente enlazada circular para objetos Expediente.
 * @author Gemini
 */
public class NodoExpediente {
    private Expediente dato;
    private NodoExpediente siguiente;
    private NodoExpediente anterior;

    /**
     * Constructor de la clase NodoExpediente.
     * @param dato El objeto Expediente a almacenar en el nodo.
     */
    public NodoExpediente(Expediente dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    /**
     * Obtiene el objeto Expediente almacenado en este nodo.
     * @return El objeto Expediente.
     */
    public Expediente getDato() {
        return dato;
    }

    /**
     * Establece el objeto Expediente para este nodo.
     * @param dato El nuevo objeto Expediente.
     */
    public void setDato(Expediente dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     * @return La referencia al siguiente NodoExpediente.
     */
    public NodoExpediente getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista.
     * @param siguiente La nueva referencia al siguiente NodoExpediente.
     */
    public void setSiguiente(NodoExpediente siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Obtiene la referencia al nodo anterior en la lista.
     * @return La referencia al nodo anterior.
     */
    public NodoExpediente getAnterior() {
        return anterior;
    }

    /**
     * Establece la referencia al nodo anterior en la lista.
     * @param anterior La nueva referencia al nodo anterior.
     */
    public void setAnterior(NodoExpediente anterior) {
        this.anterior = anterior;
    }
}
