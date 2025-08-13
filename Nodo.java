/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una estructura de lista enlazada, específicamente para la Cola de Pacientes.
 * Cada nodo contiene un objeto Paciente y una referencia al siguiente nodo.
 * @author nahum
 */
public class Nodo {
    // El dato (Paciente) que almacena este nodo.
    private Paciente dato;
    // Referencia al siguiente nodo en la lista.
    private Nodo siguiente;

    /**
     * Constructor por defecto de la clase Nodo.
     * Inicializa el dato y el siguiente a null.
     */
    public Nodo() {
        this.dato = null;
        this.siguiente = null;
    }

    /**
     * Constructor de la clase Nodo que recibe un objeto Paciente.
     * Inicializa el nodo con el paciente dado y el siguiente a null.
     * @param dato El objeto Paciente a almacenar en el nodo.
     */
    public Nodo(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Obtiene el objeto Paciente almacenado en este nodo.
     * @return El objeto Paciente.
     */
    public Paciente getDato() {
        return dato;
    }

    /**
     * Establece el objeto Paciente para este nodo.
     * @param dato El nuevo objeto Paciente.
     */
    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     * @return La referencia al siguiente Nodo.
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista.
     * @param siguiente La nueva referencia al siguiente Nodo.
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}