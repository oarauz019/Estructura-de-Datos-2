/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.Scanner;

/**
 * 
 * @author MarioSandi
 */
public class GestionPacientes {
    MenuLogica MenuPrincipal = new MenuLogica();
/**
 * Esta clase permite la llegada de pacientes al centro de salud
 * con diferentes opciones a elegir
 * @author MarioSandi
 */    
    protected void SubMenuGestionPacientes(){
        
        
         Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Submenú de Atención de Pacientes ---");
            System.out.println("1. Seleccionar Ficha");
            System.out.println("2. Atender Paciente");
            System.out.println("3. Abandonar Cola de Pacientes");
            System.out.println("4. Mostrar Fichas Pendientes");
            System.out.println("5. Mostrar Quejas Recibidas");
            System.out.println("6. Regresar");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // descarta entrada no numérica
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID de la ficha a seleccionar: ");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del paciente a atender: ");
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del paciente que desea abandonar la cola: ");
                    break;

                case 4:
                    System.out.println("Mostrando fichas pendientes...");
                    break;

                case 5:
                    System.out.println("Mostrando quejas recibidas...");
                    break;

                case 6:
                    MenuPrincipal.menu();
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 6);

        scanner.close();
    
    }
    
}
