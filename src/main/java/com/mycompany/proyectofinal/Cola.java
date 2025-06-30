/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author LopezAlex
 */
public class Cola {
    private Nodo frente;
    private Nodo ultimo;
    private int tamaño;

    public Cola() {
        frente = null;
        ultimo = null;
        tamaño = 0;
    }
    
    public int getTamaño() {
        return tamaño;
    }

    public Nodo getFrente() {
        return frente;
    }
    
    public Nodo getUltimo() {
        return ultimo;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }


    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public boolean estaVacia() {
        return frente == null;
    }
    public void encolar(Paciente paciente) {
        Nodo aux = new Nodo(paciente);

        if (estaVacia()) {
            frente = aux;
        } else {
            ultimo.setSiguiente(aux);
        }
        ultimo = aux;
        tamaño++;
    }

    public Paciente desencolar() {
        if (estaVacia()) {
            return null;
        }
        Nodo aux = frente;
        frente = frente.getSiguiente();

        if (frente == null) {
            ultimo = null;
        }
        tamaño--;
        aux.setSiguiente(null);
        return aux.getDato();
    }

    public void imprimirCola() {
        Nodo aux = frente;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public int tamañoCola() {
        return tamaño;
    }
}    
