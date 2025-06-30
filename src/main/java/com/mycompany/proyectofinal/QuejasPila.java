/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author MarioSandi
 */
public class QuejasPila {
    private NodoP cima;
    
    public QuejasPila(){
        cima = null;
    } 
    
    public boolean estaVacia(){
        return cima == null;
    }
    
    public void apilar(Queja queja){
        NodoP nodoNuevo = new NodoP(queja, null);
        
        if (estaVacia()){
            cima = nodoNuevo;
        }else{
            nodoNuevo.setSiguiente(cima);
            cima = nodoNuevo;
        }
    }
    
    public Queja desapilar(){
        if (estaVacia()){
            return null;
        }else{
            Queja temp = cima.getDato();
            cima = cima.getSiguiente();
            return temp;
        }
    }
    
    public Queja mostrarCima(){
        if (estaVacia()){
            return null;
        }else{
            return  cima.getDato();
        }
    }
    
    public void mostrarPila(){
        NodoP aux = cima;
        while (aux != null){
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }
}
