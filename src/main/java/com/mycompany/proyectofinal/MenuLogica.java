/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.Scanner;

/**
 * Esta clase gestiona la lógica del menú principal de la aplicación.
 * Permite al usuario navegar entre las diferentes opciones del sistema.
 * @author Ramirez Fuentes Nahum Esteban
 */
public class MenuLogica {
    /**
     * Muestra el menú principal de la aplicación y gestiona la selección del usuario.
     * Este método contiene el bucle principal del programa.
     * @author Ramirez Fuentes Nahum Esteban
     */
    public void menu() {
        // Instancia para gestionar pacientes y el nuevo chatbot.
        GestionPacientes gestionPacientes = new GestionPacientes();
        ChatbotLogica chatbot = new ChatbotLogica();
        Scanner scanner = new Scanner(System.in); // Scanner para leer la entrada del usuario.

        int opcion;
        System.out.println("Bienvenido al Hospital Metropolitano!");
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gestion de Pacientes");
            System.out.println("2. Consulta de Bitacora de Citas del Dia");
            System.out.println("3. Consulta de Expediente unico de Pacientes");
            System.out.println("4. Chat Bot de atencion de consultas"); // Nueva opción del chatbot
            System.out.println("5. Ayuda e Informacion");
            System.out.println("6. Salir del Programa");
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
                    System.out.println("Accediendo al Chatbot...");
                    chatbot.mostrarMenuChatbot(); // Llama al menú del chatbot.
                    break;
                case 5:
                    System.out.println("\n--- Ayuda e Informacion ---");
                    System.out.println("*** Versión del Sistema: 3.0.0 (Presentación Final) ***"); // Versión actualizada
                    System.out.println("Desarrollado por:");
                    System.out.println("-> Ramirez Fuentes Nahum Esteban");
                    System.out.println("-> Lopez Lopez Alex Josue");
                    System.out.println("-> Arauz Cerdas Oscar Arturo");
                    System.out.println("-> Sandi Aguero Mario Andres");
                    break;
                case 6:
                    System.out.println("Saliendo del programa. Gracias por su visita!");
                    break; // Sale del bucle do-while.
                default:
                    System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                    break;
            }
        } while (opcion != 6); // Cambiado a 6 para salir.

        scanner.close(); // Cierra el scanner al finalizar el programa.
    }
}
