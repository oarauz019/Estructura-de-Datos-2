/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Implementación de una lista simple para almacenar objetos BitacoraCitaDia.
 * Los elementos se insertan de forma ordenada por la cédula del paciente.
 * @author Gemini
 */
public class ListaSimpleBitacoraCitas {
    private NodoBitacora cabeza;
    private int tamaño;

    /**
     * Constructor por defecto de la clase ListaSimpleBitacoraCitas.
     * Inicializa la lista vacía.
     */
    public ListaSimpleBitacoraCitas() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    /**
     * Obtiene el primer nodo de la lista.
     * @return El nodo cabeza de la lista.
     */
    public NodoBitacora getCabeza() {
        return cabeza;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Inserta una nueva entrada de bitácora en la lista de forma ordenada por la cédula del paciente.
     * @param bitacora El objeto BitacoraCitaDia a insertar.
     */
    public void insertarOrdenado(BitacoraCitaDia bitacora) {
        NodoBitacora nuevoNodo = new NodoBitacora(bitacora);
        if (estaVacia() || bitacora.getCedulaPaciente().compareTo(cabeza.getDato().getCedulaPaciente()) < 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        } else {
            NodoBitacora actual = cabeza;
            while (actual.getSiguiente() != null && bitacora.getCedulaPaciente().compareTo(actual.getSiguiente().getDato().getCedulaPaciente()) > 0) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    /**
     * Imprime todos los elementos de la lista.
     */
    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("La bitacora de citas del dia esta vacia.");
            return;
        }
        NodoBitacora actual = cabeza;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.getDato());
            actual = actual.getSiguiente();
            i++;
        }
    }

    /**
     * Obtiene el tamaño actual de la lista.
     * @return El número de elementos en la lista.
     */
    public int getTamaño() {
        return tamaño;
    }
}
