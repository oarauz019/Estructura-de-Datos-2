/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una lista simple circular para objetos MedicamentoPrescrito.
 * @author Sandi Aguero Mario Andres
 */
public class NodoMedicamento {
    private MedicamentoPrescrito dato;
    private NodoMedicamento siguiente;


    public NodoMedicamento(MedicamentoPrescrito dato) {
        this.dato = dato;
        this.siguiente = null;
    }


    public MedicamentoPrescrito getDato() {
        return dato;
    }


    public void setDato(MedicamentoPrescrito dato) {
        this.dato = dato;
    }


    public NodoMedicamento getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(NodoMedicamento siguiente) {
        this.siguiente = siguiente;
    }
}

