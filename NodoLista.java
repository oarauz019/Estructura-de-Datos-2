/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Nodo de una lista enlazada simple, que contiene una pregunta.
 */
class NodoLista {
    Pregunta pregunta;
    NodoLista siguiente;

    /**
     * Constructor para un nodo de la lista.
     * @param pregunta La pregunta que almacena el nodo.
     */
    public NodoLista(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.siguiente = null;
    }
}