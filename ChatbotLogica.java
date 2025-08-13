/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Clase que gestiona la lógica del chatbot de preguntas frecuentes del Hospital.
 * Contiene los menús y la interacción con el usuario y el administrador.
 */
public class ChatbotLogica {

    // Instancia del árbol binario que contendrá el chatbot
    private static ArbolBinario arbolChatbot;
    // Escáner para la entrada de datos del usuario
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Constructor que inicializa el árbol del chatbot y precarga los datos.
     */
    public ChatbotLogica() {
        arbolChatbot = new ArbolBinario();
        arbolChatbot.preCargarArbol(); // Cargamos los datos iniciales del árbol
    }

    /**
     * Muestra el submenú del chatbot y maneja las opciones.
     */
    public void mostrarMenuChatbot() {
        int opcion;
        do {
            System.out.println("\n--- Menú del Chatbot ---");
            System.out.println("1. Ver Chatbot (Usuarios pacientes)");
            System.out.println("2. Mantenimiento del Chatbot (Personal administrativo)");
            System.out.println("3. Regresar al Menú Principal");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        verChatbot();
                        break;
                    case 2:
                        mantenimientoChatbot();
                        break;
                    case 3:
                        System.out.println("Regresando al menú principal.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);
    }

    /**
     * Permite a los usuarios navegar por el chatbot.
     */
    private void verChatbot() {
        System.out.println("\n--- Ver Chatbot ---");
        System.out.println("¡Hola! Soy tu asistente virtual del Hospital 'Su Salud'. ¿En qué puedo ayudarte hoy?");

        NodoArbol nodoActual = arbolChatbot.raiz;
        String opcion;

        while (true) {
            System.out.println("\nEstás en: " + nodoActual.nombre);
            System.out.println("Opciones disponibles:");

            // Si el nodo actual no es una hoja, muestra sus hijos
            if (nodoActual.listaPreguntas == null) {
                if (nodoActual.izquierda != null) {
                    System.out.println(nodoActual.izquierda.codigo + ". " + nodoActual.izquierda.nombre);
                }
                if (nodoActual.derecha != null) {
                    System.out.println(nodoActual.derecha.codigo + ". " + nodoActual.derecha.nombre);
                }
                System.out.println("Regresar. (Regresar al nivel anterior)");
                System.out.println("Salir. (Salir del chatbot)");
            } else { // Si el nodo es una hoja, muestra las preguntas
                System.out.println("Seleccione una pregunta para ver la respuesta:");
                nodoActual.listaPreguntas.imprimir();
                System.out.println("Regresar. (Regresar al nivel anterior)");
                System.out.println("Salir. (Salir del chatbot)");
            }

            System.out.print("Tu selección: ");
            opcion = scanner.nextLine().trim();

            if (opcion.equalsIgnoreCase("salir")) {
                System.out.println("¡Ha sido un placer ayudarte! ¡Hasta pronto!");
                return;
            }

            if (opcion.equalsIgnoreCase("regresar")) {
                if (nodoActual.padre != null) {
                    nodoActual = nodoActual.padre;
                } else {
                    System.out.println("Ya estás en el menú principal del chatbot. No puedes regresar más.");
                }
                continue;
            }

            if (nodoActual.listaPreguntas == null) { // Navegación por el árbol
                NodoArbol siguienteNodo = null;
                if (nodoActual.izquierda != null && nodoActual.izquierda.codigo.equals(opcion)) {
                    siguienteNodo = nodoActual.izquierda;
                } else if (nodoActual.derecha != null && nodoActual.derecha.codigo.equals(opcion)) {
                    siguienteNodo = nodoActual.derecha;
                }

                if (siguienteNodo != null) {
                    nodoActual = siguienteNodo;
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione un código de opción válido.");
                }
            } else { // Navegación por las preguntas de una hoja
                try {
                    int numPregunta = Integer.parseInt(opcion);
                    Pregunta p = nodoActual.listaPreguntas.buscar(numPregunta);
                    if (p != null) {
                        System.out.println("\n--- Respuesta ---");
                        System.out.println(p.nombrePregunta + "\n");
                        System.out.println(p.respuesta);
                        System.out.println("--- Fin de la respuesta ---");
                    } else {
                        System.out.println("Número de pregunta no válido.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número de pregunta o una opción de navegación.");
                }
            }
        }
    }

    /**
     * Módulo de mantenimiento del chatbot para administradores.
     */
    private void mantenimientoChatbot() {
        int opcion;
        do {
            System.out.println("\n--- Mantenimiento del Chatbot ---");
            System.out.println("1. Insertar/Modificar/Eliminar Nodos del Árbol (Preguntas Padre)");
            System.out.println("2. Insertar/Modificar/Eliminar Preguntas Hija (en hojas)");
            System.out.println("3. Imprimir preguntas de un nodo padre");
            System.out.println("4. Regresar al Menú del Chatbot");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        mantenimientoNodos();
                        break;
                    case 2:
                        mantenimientoPreguntas();
                        break;
                    case 3:
                        imprimirPreguntasDeNodo();
                        break;
                    case 4:
                        System.out.println("Regresando...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 4);
    }

    /**
     * Submenú para insertar, modificar y eliminar nodos del árbol.
     */
    private void mantenimientoNodos() {
        int opcion;
        do {
            System.out.println("\n--- Mantenimiento de Nodos (Preguntas Padre) ---");
            System.out.println("1. Insertar nuevo nodo");
            System.out.println("2. Modificar nodo existente");
            System.out.println("3. Eliminar nodo existente");
            System.out.println("4. Regresar");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.print("Código del nodo padre: ");
                        String codigoPadre = scanner.nextLine();
                        System.out.print("Nombre del nuevo nodo: ");
                        String nombreNodo = scanner.nextLine();
                        arbolChatbot.insertar(codigoPadre, nombreNodo);
                        break;
                    case 2:
                        System.out.print("Código del nodo a modificar: ");
                        String codigoModificar = scanner.nextLine();
                        System.out.print("Nuevo nombre para el nodo: ");
                        String nuevoNombre = scanner.nextLine();
                        arbolChatbot.modificarNodo(codigoModificar, nuevoNombre);
                        break;
                    case 3:
                        System.out.print("Código del nodo a eliminar: ");
                        String codigoEliminar = scanner.nextLine();
                        arbolChatbot.eliminarNodo(codigoEliminar);
                        break;
                    case 4:
                        System.out.println("Regresando...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 4);
    }

    /**
     * Submenú para insertar, modificar y eliminar preguntas en nodos hoja.
     */
    private void mantenimientoPreguntas() {
        int opcion;
        do {
            System.out.println("\n--- Mantenimiento de Preguntas Hija ---");
            System.out.println("1. Insertar nueva pregunta");
            System.out.println("2. Modificar pregunta existente");
            System.out.println("3. Eliminar pregunta existente");
            System.out.println("4. Regresar");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.print("Código del nodo padre (hoja) para la nueva pregunta: ");
                        String codigoHoja = scanner.nextLine();
                        NodoArbol nodoHoja = arbolChatbot.buscarNodo(arbolChatbot.raiz, codigoHoja);
                        if (nodoHoja != null && nodoHoja.listaPreguntas != null) {
                            System.out.print("Nombre de la pregunta: ");
                            String nombrePregunta = scanner.nextLine();
                            System.out.print("Respuesta: ");
                            String respuesta = scanner.nextLine();
                            nodoHoja.listaPreguntas.agregar(nombrePregunta, respuesta);
                        } else {
                            System.out.println("Error: El nodo no existe o no es una hoja.");
                        }
                        break;
                    case 2:
                        System.out.print("Código del nodo padre (hoja) de la pregunta a modificar: ");
                        String codigoHojaMod = scanner.nextLine();
                        NodoArbol nodoHojaMod = arbolChatbot.buscarNodo(arbolChatbot.raiz, codigoHojaMod);
                        if (nodoHojaMod != null && nodoHojaMod.listaPreguntas != null) {
                            System.out.print("Número de pregunta a modificar: ");
                            int numPregunta = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Nuevo nombre de la pregunta: ");
                            String nuevoNombre = scanner.nextLine();
                            System.out.print("Nueva respuesta: ");
                            String nuevaRespuesta = scanner.nextLine();
                            nodoHojaMod.listaPreguntas.modificar(numPregunta, nuevoNombre, nuevaRespuesta);
                        } else {
                            System.out.println("Error: El nodo no existe o no es una hoja.");
                        }
                        break;
                    case 3:
                        System.out.print("Código del nodo padre (hoja) de la pregunta a eliminar: ");
                        String codigoHojaDel = scanner.nextLine();
                        NodoArbol nodoHojaDel = arbolChatbot.buscarNodo(arbolChatbot.raiz, codigoHojaDel);
                        if (nodoHojaDel != null && nodoHojaDel.listaPreguntas != null) {
                            System.out.print("Número de pregunta a eliminar: ");
                            int numPregunta = scanner.nextInt();
                            scanner.nextLine();
                            nodoHojaDel.listaPreguntas.eliminar(numPregunta);
                        } else {
                            System.out.println("Error: El nodo no existe o no es una hoja.");
                        }
                        break;
                    case 4:
                        System.out.println("Regresando...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 4);
    }

    /**
     * Imprime todas las preguntas asociadas a un nodo hoja.
     */
    private void imprimirPreguntasDeNodo() {
        System.out.println("\n--- Imprimir Preguntas de un Nodo ---");
        System.out.print("Ingrese el código del nodo padre (hoja): ");
        String codigo = scanner.nextLine();
        NodoArbol nodo = arbolChatbot.buscarNodo(arbolChatbot.raiz, codigo);
        if (nodo != null) {
            if (nodo.listaPreguntas != null) {
                System.out.println("\nPreguntas en el nodo '" + nodo.nombre + "':");
                nodo.listaPreguntas.imprimir();
            } else {
                System.out.println("Error: El nodo con código '" + codigo + "' no es una hoja y no contiene preguntas.");
            }
        } else {
            System.out.println("Error: No se encontró un nodo con el código '" + codigo + "'.");
        }
    }
}
