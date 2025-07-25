/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una estructura de lista enlazada, específicamente para la Pila de Quejas.
 * Cada nodo contiene un objeto Queja y una referencia al siguiente nodo.
 * @author nahum
 */
public class NodoP {
    // El dato (Queja) que almacena este nodo.
    private Queja dato;
    // Referencia al siguiente nodo en la pila.
    private NodoP siguiente;

    /**
     * Constructor de la clase NodoP.
     * @param dato El objeto Queja a almacenar en el nodo.
     * @param siguiente La referencia al siguiente NodoP en la pila.
     */
    public NodoP(Queja dato, NodoP siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * Obtiene el objeto Queja almacenado en este nodo.
     * @return El objeto Queja.
     */
    public Queja getDato() {
        return dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la pila.
     * @return La referencia al siguiente NodoP.
     */
    public NodoP getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo en la pila.
     * @param siguiente La nueva referencia al siguiente NodoP.
     */
    public void setSiguiente(NodoP siguiente) {
        this.siguiente = siguiente;
    }
}
