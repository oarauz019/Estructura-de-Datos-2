/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author nahum
 */
public class NodoP {
    private Queja dato;
    private NodoP siguiente;

    public NodoP(Queja dato, NodoP siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Queja getDato() {
        return dato;
    }

    public NodoP getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoP siguiente) {
        this.siguiente = siguiente;
    } 
}
