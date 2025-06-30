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
    private QuejasPila pilaQuejas = new QuejasPila();
    private Cola c_Regular = new Cola(); // Cola pacientes regulares
    private int conta_Regular = 1; // Contador de pacientes regulares
    private Cola c_Prefe = new Cola(); // Cola pacientes preferenciles
    private int conta_Prefe = 1; // Contador pacientes preferenciales
    private int pref_Contador = 0;
 
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
                    escogerFichaPaciente(scanner);
                    break;

                case 2:
                    atencionDePacientes();
                    break;

                case 3:
                    abandonarCola(scanner);
                    break;

                case 4:
                    mostrarFichasPendientes();
                    break;

                case 5:
                    quejasRecibidas();
                    break;

                case 6:
                    System.out.println("Volviendo al menu principal del programa...");
                    return;

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
        System.out.print("Ingrese nombre completo del paciente: ");
        String nombre = scanner.nextLine();

        Date fecha = new Date();
        String ficha;

        if (categoria == 1){
            ficha = "P" + conta_Prefe++;
            Paciente paciente = new Paciente(fecha, ficha, nombre, cedula);
            c_Prefe.encolar(paciente);
        } else if (categoria == 2) {
            ficha = "R" + conta_Regular++;
            Paciente paciente = new Paciente(fecha, ficha, nombre, cedula);
            c_Regular.encolar(paciente);
        } else {
            System.out.println("Categoria de ficha no válida.");
            return;
        }

        System.out.println("Su número de ficha es la: " + ficha);
    }
/**
     * En este metodo se va a utilizar para poder atender los pacientes en cola atendiendo 2 pref mas 1 regular
     * El systema ficha mas cedula para saber quien sera atendido y al final si existen usuarios en cola
     * @Autor: Nahum Ramirez
*/    
    private void atencionDePacientes(){
        Paciente atendido = null;
                
        if (!c_Prefe.estaVacia() && pref_Contador < 2){
            atendido = c_Prefe.desencolar();
            pref_Contador++;
        }else if (!c_Regular.estaVacia()){
            atendido = c_Regular.desencolar();
            pref_Contador = 0;
        }
        
        if (atendido != null){
            System.out.println("Numero de ficha: " + atendido.getFicha() + " Numero de cedula: " + atendido.getCedula());
        }else{
            System.out.println("Todos los pacientes fueron atendidos, no hay pacientes por atender");
        }
    }
    
    
/**
     * Metodo que nos permite mostrar la ficha de los pacientes
     * Nos muestra las fichas sin atender
     * @Autor: Nahum Ramirez
*/    
    private void mostrarFichasPendientes() {
        System.out.println("[Paciente Regular] Fichas sin atender en la categoria regular: ");
        c_Regular.imprimirCola();
        
        System.out.println("Paciente Preferencial] Fichas sin atender en la categoria preferencial: ");
        c_Prefe.imprimirCola();
    }
/**
     * Metodo que va a permitir abandonar la cola con el ingreso del numero de ficha.
     * Da un mensaje indicando numero de ficha con la cedula correspondiente
     * @Autor: Nahum Ramirez
*/
    private void abandonarCola(Scanner scanner) {
        System.out.print("Indique el número de ficha: ");
        String ficha = scanner.nextLine();

        Paciente abandonandoCola = eliminarDeCola(c_Prefe, ficha);
        if (abandonandoCola == null) {
            abandonandoCola = eliminarDeCola(c_Regular, ficha);
        }

        if (abandonandoCola != null) {
            System.out.println("Ficha #" + abandonandoCola.getFicha() + " con cédula " + abandonandoCola.getCedula() + " abandona la cola sin ser atendid@.");

            Queja queja = new Queja(new Date(), "Saliendo de la cola", abandonandoCola.getNombre(), abandonandoCola.getCedula());
            pilaQuejas.apilar(queja);
        } else {
            System.out.println("Ficha no localizada.");
        }
    }
/**
     * Meotodo donde en la cola de Pacientes se buscara y eliminara el paciente de la cola al igual que la ficha
     * Este trabaja en conjunto con "abandonarCola"
     * @Autor: Nahum Ramirez
*/
    
    private Paciente eliminarDeCola(Cola cola, String numeroDeFicha) {
        Cola temp = new Cola();
        Paciente localizado = null;

        while (!cola.estaVacia()) {
            Paciente p = cola.desencolar();
            if (p.getFicha().equalsIgnoreCase(numeroDeFicha)) {
                localizado = p;
            } else {
                temp.encolar(p);
            }
        }
        while (!temp.estaVacia()) {
            cola.encolar(temp.desencolar());
        }
        return localizado;
    }
    
    private void quejasRecibidas(){
        System.out.println("Quejas en el sistema");
        if (pilaQuejas.estaVacia()){
            System.out.println("No hay quejas");
        }else{
            pilaQuejas.mostrarPila();
        }
    }  
}

