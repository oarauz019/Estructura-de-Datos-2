/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una lista simple para objetos BitacoraCitaDia.
 * @author Ramirez Fuentes Nahum Esteban
 */
public class NodoBitacora {
    private BitacoraCitaDia dato;
    private NodoBitacora siguiente;


    public NodoBitacora(BitacoraCitaDia dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public BitacoraCitaDia getDato() {
        return dato;
    }


    public void setDato(BitacoraCitaDia dato) {
        this.dato = dato;
    }


    public NodoBitacora getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(NodoBitacora siguiente) {
        this.siguiente = siguiente;
    }
}