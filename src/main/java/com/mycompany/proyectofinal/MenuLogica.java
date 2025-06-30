/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.Scanner;

/**
 *
 * @author nahum
 */
public class MenuLogica {
/**
 * Esta clase permite gestionar la logica del menu y su navegacion para poder utilzar las opciones solicitadas
 * para que el usuario pueda selecionar las opciones apropiadas para moverse por el sistema y ser atendido
 * @author Nahum Ramirez
 */
    public void menu() {
        GestionPacientes SubMenuGestionPacientes = new GestionPacientes();
        Scanner scanner = new Scanner(System.in);
        
        int opciones;
        System.out.println("¡Bienvenido al Hopital Metropolitano!");
        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Gestionar Llegada de Pacientes");
            System.out.println("2. Ayuda");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opciones = scanner.nextInt();
            switch (opciones) {
                case 1:
                    System.out.println("Opcion: Llegada de pacientes.");
                    SubMenuGestionPacientes.SubMenuGestionPacientes();
                    break;
                case 2:
                    System.out.println("Opcion: Ayuda.");
                    System.err.println("***Avance 1 V 1.0.2***");
                    System.err.println("Desarrollado por: ");
                    System.err.println("-> Ramirez Fuentes Nahum Esteban");
                    System.err.println("-> Lopez Lopez Alex Josue");
                    System.err.println("-> Arauz Cerdas Oscar Arturo");
                    System.err.println("-> Sandi Aguero Mario Andres");
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Gracias por su visita!");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opciones != 3);

        scanner.close();
    }
}



    
