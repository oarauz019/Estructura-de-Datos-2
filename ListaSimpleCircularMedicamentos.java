/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Implementación de una lista simple circular para almacenar objetos MedicamentoPrescrito.
 * @author Gemini
 */
public class ListaSimpleCircularMedicamentos {
    private NodoMedicamento cabeza;
    private int tamaño;

    /**
     * Constructor por defecto de la clase ListaSimpleCircularMedicamentos.
     * Inicializa la lista vacía.
     */
    public ListaSimpleCircularMedicamentos() {
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
     * Inserta un nuevo medicamento al final de la lista circular.
     * @param medicamento El objeto MedicamentoPrescrito a insertar.
     */
    public void insertar(MedicamentoPrescrito medicamento) {
        NodoMedicamento nuevoNodo = new NodoMedicamento(medicamento);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza); // Se apunta a sí mismo para ser circular
        } else {
            NodoMedicamento temp = cabeza;
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
            System.out.println("Lista de medicamentos vacía.");
            return;
        }
        NodoMedicamento actual = cabeza;
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

