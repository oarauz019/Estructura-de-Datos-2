/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Implementación de una estructura de datos de Pila (Stack) utilizando nodos.
 * Esta pila sigue el principio LIFO (Last-In, First-Out).
 * @author Arauz Arturo
 */
public class QuejasPila {
    // Nodo que representa la cima de la pila.
    private NodoP cima;

    /**
     * Constructor por defecto de la clase QuejasPila.
     * Inicializa la pila vacía.
     */
    public QuejasPila() {
        this.cima = null;
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila no contiene elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return cima == null;
    }

    /**
     * Agrega una queja a la cima de la pila (apilar).
     * @param queja El objeto Queja a agregar.
     */
    public void apilar(Queja queja) {
        NodoP nuevoNodo = new NodoP(queja, null); // Crea un nuevo nodo con la queja.

        if (estaVacia()) { // Si la pila está vacía, el nuevo nodo es la cima.
            cima = nuevoNodo;
        } else { // Si no está vacía, el nuevo nodo apunta a la cima actual y se convierte en la nueva cima.
            nuevoNodo.setSiguiente(cima);
            cima = nuevoNodo;
        }
    }

    /**
     * Elimina y devuelve la queja de la cima de la pila (desapilar).
     * @return El objeto Queja que estaba en la cima de la pila, o null si la pila está vacía.
     */
    public Queja desapilar() {
        if (estaVacia()) { // Si la pila está vacía, no hay nada que desapilar.
            System.out.println("La pila de quejas esta vacia.");
            return null;
        } else {
            Queja tempQueja = cima.getDato(); // Guarda la queja de la cima.
            cima = cima.getSiguiente(); // La cima se mueve al siguiente nodo.
            return tempQueja; // Devuelve la queja desapilada.
        }
    }

    /**
     * Muestra la queja que está en la cima de la pila sin eliminarla.
     * @return El objeto Queja en la cima de la pila, o null si la pila está vacía.
     */
    public Queja mostrarCima() {
        if (estaVacia()) {
            System.out.println("La pila de quejas esta vacia.");
            return null;
        } else {
            return cima.getDato(); // Devuelve la queja de la cima.
        }
    }

    /**
     * Imprime todas las quejas actualmente en la pila, desde la cima hasta la base.
     */
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("No hay quejas para mostrar.");
            return;
        }
        NodoP auxiliar = cima; // Nodo auxiliar para recorrer la pila.
        int i = 1;
        while (auxiliar != null) {
            System.out.println(i + ". " + auxiliar.getDato()); // Imprime la información de la queja.
            auxiliar = auxiliar.getSiguiente(); // Avanza al siguiente nodo.
            i++;
        }
    }
}