/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Clase base que representa un usuario genérico en el sistema.
 * Contiene propiedades comunes como nombre y cédula.
 * @author Ramirez Fuentes Nahum Esteban
 */
public class Usuario {
    // Nombre completo del usuario.
    protected String nombre;
    // Número de cédula del usuario.
    protected String cedula;

    /**
     * Constructor de la clase Usuario.
     * @param nombre El nombre completo del usuario.
     * @param cedula El número de cédula del usuario.
     */
    public Usuario(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCedula() {
        return cedula;
    }


    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}