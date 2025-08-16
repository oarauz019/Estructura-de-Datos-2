/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Nodo del árbol binario que representa una pregunta padre.
 * @author Arauz Cerdas Oscar Arturo
 */
class NodoArbol {
    String codigo;
    String nombre;
    ListaEnlazada listaPreguntas;
    NodoArbol izquierda, derecha, padre;

    /**
     * Constructor para un nodo del árbol.
     * @param codigo El código único del nodo.
     * @param nombre El nombre del nodo.
     */
    public NodoArbol(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaPreguntas = null;
        this.izquierda = this.derecha = this.padre = null;
    }
}

