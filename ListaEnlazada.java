/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Lista enlazada simple para almacenar las preguntas de un nodo hoja del árbol.
 */
class ListaEnlazada {
    NodoLista cabeza;
    private int contador = 1;

    /**
     * Agrega una nueva pregunta al final de la lista.
     * @param nombre El nombre de la pregunta.
     * @param respuesta La respuesta a la pregunta.
     */
    public void agregar(String nombre, String respuesta) {
        Pregunta nuevaPregunta = new Pregunta(String.valueOf(contador++), nombre, respuesta);
        NodoLista nuevoNodo = new NodoLista(nuevaPregunta);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLista temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
        System.out.println("Pregunta agregada con éxito.");
    }

    /**
     * Busca una pregunta por su código.
     * @param codigo El código de la pregunta a buscar.
     * @return El objeto Pregunta si se encuentra, de lo contrario null.
     */
    public Pregunta buscar(int codigo) {
        NodoLista temp = cabeza;
        while (temp != null) {
            if (Integer.parseInt(temp.pregunta.codigoPregunta) == codigo) {
                return temp.pregunta;
            }
            temp = temp.siguiente;
        }
        return null;
    }

    /**
     * Modifica una pregunta existente por su código.
     * @param codigo El código de la pregunta a modificar.
     * @param nuevoNombre El nuevo nombre de la pregunta.
     * @param nuevaRespuesta La nueva respuesta de la pregunta.
     */
    public void modificar(int codigo, String nuevoNombre, String nuevaRespuesta) {
        Pregunta p = buscar(codigo);
        if (p != null) {
            p.nombrePregunta = nuevoNombre;
            p.respuesta = nuevaRespuesta;
            System.out.println("Pregunta modificada con éxito.");
        } else {
            System.out.println("Error: Pregunta con código " + codigo + " no encontrada.");
        }
    }

    /**
     * Elimina una pregunta de la lista por su código.
     * @param codigo El código de la pregunta a eliminar.
     */
    public void eliminar(int codigo) {
        if (cabeza == null) {
            System.out.println("Error: La lista de preguntas está vacía.");
            return;
        }

        if (Integer.parseInt(cabeza.pregunta.codigoPregunta) == codigo) {
            cabeza = cabeza.siguiente;
            System.out.println("Pregunta eliminada con éxito.");
            return;
        }

        NodoLista actual = cabeza;
        while (actual.siguiente != null && Integer.parseInt(actual.siguiente.pregunta.codigoPregunta) != codigo) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            System.out.println("Pregunta eliminada con éxito.");
        } else {
            System.out.println("Error: Pregunta con código " + codigo + " no encontrada.");
        }
    }

    /**
     * Imprime todas las preguntas de la lista.
     */
    public void imprimir() {
        NodoLista temp = cabeza;
        while (temp != null) {
            System.out.println(temp.pregunta.codigoPregunta + ". " + temp.pregunta.nombrePregunta);
            temp = temp.siguiente;
        }
    }
}