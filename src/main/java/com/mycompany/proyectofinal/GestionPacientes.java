/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.Scanner;
import java.util.Date;

/**
 * 
 * @author MarioSandi
 */
public class GestionPacientes {
    private MenuLogica MenuPrincipal = new MenuLogica();
    private Cola c_Regular = new Cola(); // Cola pacientes regulares
    private int conta_Regular = 1; // Contador de pacientes regulares
    private Cola c_Prefe = new Cola(); // Cola pacientes preferenciles
    private int conta_Prefe = 1; // Contador pacientes preferenciales
 
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
                    mostrarFichasPendientes();
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
    }
/**
     * En este metodo se le va a solicar al usuario los datos del paciente y para de esta manera poder delegar una ficha según la categoria del mismo
     * Finalmente el sistema segun lo indicado se va a colocar al paciente en la cola correspondiente.
     * @Autor: Nahum Ramirez
*/
    private void escogerFichaPaciente(Scanner scanner) {
        System.out.println("Escoge la categoria apropiada de ficha: ");
        System.out.println("1. Paciente Preferencial");
        System.out.println("2. Paciente Regular");
        System.out.print("Categoria: ");

        int categoria = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese número de cédula: ");
        String cedula = scanner.nextLine();
        scanner.nextLine();
        
        System.out.print("Ingrese nombre completo del paciente: ");
        String nombre = scanner.nextLine();

        Date fecha = new Date();
        String ficha;

        if (categoria == 1){
            ficha = "P" + conta_Prefe++;
            Paciente paciente = new Paciente(fecha, nombre, categoria, ficha);
            c_Prefe.encolar(paciente);
        } else if (categoria == 2) {
            ficha = "R" + conta_Regular++;
            Paciente paciente = new Paciente(fecha, nombre, categoria, ficha);
            c_Regular.encolar(paciente);
        } else {
            System.out.println("Categoria de ficha no válida.");
            return;
        }

        System.out.println("Su número de ficha es la: " + ficha);
    }
/**
     * Metodo que nos permite mostrar la ficha de los pacientes
     * Nos muestra las fichas sin atender
     * @Autor: Nahum Ramirez
*/    
     private void mostrarFichasPendientes() {
        System.out.println("Fichas sin atender en la categoria regular: ");
        c_Regular.imprimirCola();
        
        System.out.println("Fichas sin atender en la categoria preferencial: ");
        c_Prefe.imprimirCola();
    }   
}
