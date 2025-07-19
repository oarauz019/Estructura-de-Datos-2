/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una lista simple para objetos BitacoraCitaDia.
 * @author Gemini
 */
public class NodoBitacora {
    private BitacoraCitaDia dato;
    private NodoBitacora siguiente;

    /**
     * Constructor de la clase NodoBitacora.
     * @param dato El objeto BitacoraCitaDia a almacenar en el nodo.
     */
    public NodoBitacora(BitacoraCitaDia dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Obtiene el objeto BitacoraCitaDia almacenado en este nodo.
     * @return El objeto BitacoraCitaDia.
     */
    public BitacoraCitaDia getDato() {
        return dato;
    }

    /**
     * Establece el objeto BitacoraCitaDia para este nodo.
     * @param dato El nuevo objeto BitacoraCitaDia.
     */
    public void setDato(BitacoraCitaDia dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     * @return La referencia al siguiente NodoBitacora.
     */
    public NodoBitacora getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista.
     * @param siguiente La nueva referencia al siguiente NodoBitacora.
     */
    public void setSiguiente(NodoBitacora siguiente) {
        this.siguiente = siguiente;
    }
}