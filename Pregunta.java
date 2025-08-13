/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Representa una pregunta con su código, nombre y respuesta.
 */
class Pregunta {
    String codigoPregunta;
    String nombrePregunta;
    String respuesta;

    /**
     * Constructor para una pregunta.
     * @param codigoPregunta El código único de la pregunta.
     * @param nombrePregunta El texto de la pregunta.
     * @param respuesta La respuesta a la pregunta.
     */
    public Pregunta(String codigoPregunta, String nombrePregunta, String respuesta) {
        this.codigoPregunta = codigoPregunta;
        this.nombrePregunta = nombrePregunta;
        this.respuesta = respuesta;
    }
}