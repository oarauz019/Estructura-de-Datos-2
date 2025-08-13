/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Implementación de una estructura de datos de Cola (Queue) utilizando nodos.
 * Esta cola sigue el principio FIFO (First-In, First-Out).
 * @author LopezAlex
 */
public class Cola {
    // Nodo que representa el frente de la cola.
    private Nodo frente;
    // Nodo que representa el último elemento de la cola.
    private Nodo ultimo;
    // Tamaño actual de la cola.
    private int tamaño;

    /**
     * Constructor por defecto de la clase Cola.
     * Inicializa la cola vacía.
     */
    public Cola() {
        this.frente = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    /**
     * Obtiene el tamaño actual de la cola.
     * @return El número de elementos en la cola.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Obtiene el nodo que está en el frente de la cola.
     * @return El nodo en el frente de la cola.
     */
    public Nodo getFrente() {
        return frente;
    }

    /**
     * Obtiene el nodo que está en el último de la cola.
     * @return El nodo en el último de la cola.
     */
    public Nodo getUltimo() {
        return ultimo;
    }

    /**
     * Establece el tamaño de la cola.
     * @param tamaño El nuevo tamaño de la cola.
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * Establece el nodo del frente de la cola.
     * @param frente El nuevo nodo del frente.
     */
    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    /**
     * Establece el nodo del último de la cola.
     * @param ultimo El nuevo nodo del último.
     */
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola no contiene elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Agrega un paciente al final de la cola (encolar).
     * @param paciente El objeto Paciente a agregar.
     */
    public void encolar(Paciente paciente) {
        Nodo nuevoNodo = new Nodo(paciente); // Crea un nuevo nodo con el paciente.

        if (estaVacia()) { // Si la cola está vacía, el nuevo nodo es el frente.
            frente = nuevoNodo;
        } else { // Si no está vacía, el siguiente del último nodo apunta al nuevo nodo.
            ultimo.setSiguiente(nuevoNodo);
        }
        ultimo = nuevoNodo; // El nuevo nodo se convierte en el último.
        tamaño++; // Incrementa el tamaño de la cola.
    }

    /**
     * Elimina y devuelve el paciente del frente de la cola (desencolar).
     * @return El objeto Paciente que estaba en el frente de la cola, o null si la cola está vacía.
     */
    public Paciente desencolar() {
        if (estaVacia()) { // Si la cola está vacía, no hay nada que desencolar.
            return null;
        }
        Nodo nodoDesencolado = frente; // Guarda el nodo del frente.
        frente = frente.getSiguiente(); // El frente se mueve al siguiente nodo.

        if (frente == null) { // Si el frente se vuelve null, la cola está vacía, por lo tanto, el último también es null.
            ultimo = null;
        }
        tamaño--; // Decrementa el tamaño de la cola.
        nodoDesencolado.setSiguiente(null); // Desvincula el nodo desencolado.
        return nodoDesencolado.getDato(); // Devuelve el paciente del nodo desencolado.
    }

    /**
     * Imprime todos los pacientes actualmente en la cola, desde el frente hasta el último.
     */
    public void imprimirCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Nodo auxiliar = frente; // Nodo auxiliar para recorrer la cola.
        int i = 1;
        while (auxiliar != null) {
            System.out.println(i + ". " + auxiliar.getDato()); // Imprime la información del paciente.
            auxiliar = auxiliar.getSiguiente(); // Avanza al siguiente nodo.
            i++;
        }
    }
}