/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Representa un nodo en una estructura de lista enlazada, específicamente para la Cola de Pacientes.
 * Cada nodo contiene un objeto Paciente y una referencia al siguiente nodo.
 * @author Sandi Aguero Mario Andres
 */
public class Nodo {
    // El dato (Paciente) que almacena este nodo.
    private Paciente dato;
    // Referencia al siguiente nodo en la lista.
    private Nodo siguiente;


    public Nodo() {
        this.dato = null;
        this.siguiente = null;
    }


    public Nodo(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Paciente getDato() {
        return dato;
    }

    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}