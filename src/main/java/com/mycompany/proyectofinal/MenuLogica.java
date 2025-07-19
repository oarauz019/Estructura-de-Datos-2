/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.Scanner;

/**
 * Esta clase gestiona la lógica del menú principal de la aplicación.
 * Permite al usuario navegar entre las diferentes opciones del sistema.
 * @author Nahum Ramirez
 */
public class MenuLogica {
    /**
     * Muestra el menú principal de la aplicación y gestiona la selección del usuario.
     * Este método contiene el bucle principal del programa.
     * @author Nahum Ramirez
     */
    public void menu() {
        GestionPacientes gestionPacientes = new GestionPacientes(); // Instancia para gestionar pacientes.
        Scanner scanner = new Scanner(System.in); // Scanner para leer la entrada del usuario.

        int opcion;
        System.out.println("Bienvenido al Hospital Metropolitano!");
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gestion de Pacientes");
            System.out.println("2. Consulta de Bitacora de Citas del Dia");
            System.out.println("3. Consulta de Expediente unico de Pacientes");
            System.out.println("4. Ayuda e Informacion");
            System.out.println("5. Salir del Programa");
            System.out.print("Seleccione una opcion: ");

            // Valida que la entrada sea un número entero.
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada invalida. Por favor, ingrese un numero.");
                scanner.next(); // Descarta la entrada no numérica.
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer después de leer el entero.

            switch (opcion) {
                case 1:
                    System.out.println("Accediendo a la Gestion de Pacientes...");
                    gestionPacientes.SubMenuGestionPacientes(); // Llama al submenú de gestión de pacientes.
                    break;
                case 2:
                    System.out.println("Accediendo a la Bitacora de Citas del Dia...");
                    gestionPacientes.consultarBitacoraCitasDia();
                    break;
                case 3:
                    System.out.println("Accediendo a la Consulta de Expedientes de Pacientes...");
                    gestionPacientes.consultarExpedienteUnicoPacientes(scanner);
                    break;
                case 4:
                    System.out.println("\n--- Ayuda e Informacion ---");
                    System.out.println("*** Version del Sistema: 2.0.0 (Avance 2) ***"); // Versión actualizada
                    System.out.println("Desarrollado por:");
                    System.out.println("-> Ramirez Fuentes Nahum Esteban");
                    System.out.println("-> Lopez Lopez Alex Josue");
                    System.out.println("-> Arauz Cerdas Oscar Arturo");
                    System.out.println("-> Sandi Aguero Mario Andres");
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Gracias por su visita!");
                    break; // Sale del bucle do-while.
                default:
                    System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                    break;
            }
        } while (opcion != 5); // Cambiado a 5 para salir.

        scanner.close(); // Cierra el scanner al finalizar el programa.
    }
}
