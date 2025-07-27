/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una lista doblemente enlazada circular para objetos Expediente.
 * @author Arauz Cerdas Oscar Arturo
 */
public class NodoExpediente {
    private Expediente dato;
    private NodoExpediente siguiente;
    private NodoExpediente anterior;


    public NodoExpediente(Expediente dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }


    public Expediente getDato() {
        return dato;
    }


    public void setDato(Expediente dato) {
        this.dato = dato;
    }


    public NodoExpediente getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(NodoExpediente siguiente) {
        this.siguiente = siguiente;
    }


    public NodoExpediente getAnterior() {
        return anterior;
    }


    public void setAnterior(NodoExpediente anterior) {
        this.anterior = anterior;
    }
}
