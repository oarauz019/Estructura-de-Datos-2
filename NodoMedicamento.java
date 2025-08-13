/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una lista simple circular para objetos MedicamentoPrescrito.
 * @author Gemini
 */
public class NodoMedicamento {
    private MedicamentoPrescrito dato;
    private NodoMedicamento siguiente;

    /**
     * Constructor de la clase NodoMedicamento.
     * @param dato El objeto MedicamentoPrescrito a almacenar en el nodo.
     */
    public NodoMedicamento(MedicamentoPrescrito dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Obtiene el objeto MedicamentoPrescrito almacenado en este nodo.
     * @return El objeto MedicamentoPrescrito.
     */
    public MedicamentoPrescrito getDato() {
        return dato;
    }

    /**
     * Establece el objeto MedicamentoPrescrito para este nodo.
     * @param dato El nuevo objeto MedicamentoPrescrito.
     */
    public void setDato(MedicamentoPrescrito dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     * @return La referencia al siguiente NodoMedicamento.
     */
    public NodoMedicamento getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista.
     * @param siguiente La nueva referencia al siguiente NodoMedicamento.
     */
    public void setSiguiente(NodoMedicamento siguiente) {
        this.siguiente = siguiente;
    }
}

