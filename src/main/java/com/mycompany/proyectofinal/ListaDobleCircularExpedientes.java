/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Implementación de una lista doblemente enlazada circular para almacenar objetos Expediente.
 * Los expedientes se mantienen ordenados por la cédula del paciente.
 * @author Lopez Lopez Alex Josue
 */
public class ListaDobleCircularExpedientes {
    private NodoExpediente cabeza;
    private int tamaño;


    public ListaDobleCircularExpedientes() {
        this.cabeza = null;
        this.tamaño = 0;
    }


    public NodoExpediente getCabeza() {
        return cabeza;
    }


    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Inserta un nuevo expediente en la lista de forma ordenada por la cédula del paciente.
     * Si un expediente con la misma cédula ya existe, no se inserta.
     * @param expediente El objeto Expediente a insertar.
     */
    public void insertarOrdenado(Expediente expediente) {
        if (buscarPorCedula(expediente.getCedula()) != null) {
            System.out.println("Error: Ya existe un expediente con la cedula " + expediente.getCedula());
            return;
        }

        NodoExpediente nuevoNodo = new NodoExpediente(expediente);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoExpediente actual = cabeza;
            // Encuentra la posición de inserción manteniendo el orden por cédula
            while (actual.getSiguiente() != cabeza && expediente.getCedula().compareTo(actual.getDato().getCedula()) > 0) {
                actual = actual.getSiguiente();
            }

            // Caso 1: Insertar al principio (nuevo nodo es menor que la cabeza actual)
            if (expediente.getCedula().compareTo(actual.getDato().getCedula()) < 0 && actual == cabeza) {
                NodoExpediente ultimo = cabeza.getAnterior();
                nuevoNodo.setSiguiente(cabeza);
                cabeza.setAnterior(nuevoNodo);
                nuevoNodo.setAnterior(ultimo);
                ultimo.setSiguiente(nuevoNodo);
                cabeza = nuevoNodo; // La nueva cabeza es el nodo insertado
            }
            // Caso 2: Insertar en medio o al final
            else {
                nuevoNodo.setSiguiente(actual);
                nuevoNodo.setAnterior(actual.getAnterior());
                actual.getAnterior().setSiguiente(nuevoNodo);
                actual.setAnterior(nuevoNodo);
            }
        }
        tamaño++;
    }

    /**
     * Busca un expediente en la lista por su número de cédula.
     * @param cedula La cédula del paciente a buscar.
     * @return El objeto Expediente si se encuentra, o null si no existe.
     */
    public Expediente buscarPorCedula(String cedula) {
        if (estaVacia()) {
            return null;
        }
        NodoExpediente actual = cabeza;
        do {
            if (actual.getDato().getCedula().equals(cedula)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        return null;
    }

    /**
     * Imprime todos los expedientes en la lista.
     */
    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("La lista de expedientes esta vacia.");
            return;
        }
        NodoExpediente actual = cabeza;
        int i = 1;
        do {
            System.out.println(i + ". " + actual.getDato());
            actual = actual.getSiguiente();
            i++;
        } while (actual != cabeza);
    }

    public int getTamaño() {
        return tamaño;
    }
}

