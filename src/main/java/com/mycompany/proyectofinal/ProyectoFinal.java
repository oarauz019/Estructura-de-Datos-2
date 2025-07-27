/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal;

/**
 * Clase principal que inicia la aplicación de gestión de pacientes.
 * Este es el punto de entrada del programa.
 * @author Lopez Lopez Alex Josue
 */
public class ProyectoFinal {

    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     * Crea una instancia de MenuLogica y llama a su método menu para iniciar la interfaz de usuario.
     * @param args Argumentos de la línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        // Crea una instancia de la lógica del menú principal.
        MenuLogica menuPrincipal = new MenuLogica();
        // Inicia el menú principal de la aplicación.
        menuPrincipal.menu();
    }
}

