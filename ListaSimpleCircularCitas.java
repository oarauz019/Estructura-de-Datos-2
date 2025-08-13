/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Implementación de una lista simple circular para almacenar objetos Cita.
 * @author Gemini
 */
public class ListaSimpleCircularCitas {
    private NodoCita cabeza;
    private int tamaño;

    /**
     * Constructor por defecto de la clase ListaSimpleCircularCitas.
     * Inicializa la lista vacía.
     */
    public ListaSimpleCircularCitas() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Inserta una nueva cita al final de la lista circular.
     * @param cita El objeto Cita a insertar.
     */
    public void insertar(Cita cita) {
        NodoCita nuevoNodo = new NodoCita(cita);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza); // Se apunta a sí mismo para ser circular
        } else {
            NodoCita temp = cabeza;
            while (temp.getSiguiente() != cabeza) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(cabeza);
        }
        tamaño++;
    }

    /**
     * Imprime todos los elementos de la lista circular.
     */
    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("Lista de citas vacía.");
            return;
        }
        NodoCita actual = cabeza;
        int i = 1;
        do {
            System.out.println(i + ". " + actual.getDato());
            actual = actual.getSiguiente();
            i++;
        } while (actual != cabeza);
    }

    /**
     * Obtiene el tamaño actual de la lista.
     * @return El número de elementos en la lista.
     */
    public int getTamaño() {
        return tamaño;
    }
}