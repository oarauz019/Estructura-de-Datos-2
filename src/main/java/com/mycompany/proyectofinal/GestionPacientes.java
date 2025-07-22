/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Esta clase gestiona la llegada, atención y salida de pacientes del centro de salud.
 * Utiliza colas para pacientes regulares y preferenciales, una pila para las quejas,
 * una lista doble circular para expedientes y una lista simple para la bitácora de citas del día.
 * @author MarioSandi
 */
public class GestionPacientes {
    // Constante para el número de pacientes preferenciales a atender antes de uno regular.
    private static final int max_pref_atendidos = 2;

    // Instancia de la pila para almacenar quejas.
    private QuejasPila pilaQuejas = new QuejasPila();
    // Cola para pacientes regulares.
    private Cola c_Regular = new Cola();
    // Contador para asignar fichas a pacientes regulares.
    private int conta_Regular = 1;
    // Cola para pacientes preferenciales.
    private Cola c_Prefe = new Cola();
    // Contador para asignar fichas a pacientes preferenciales.
    private int conta_Prefe = 1;
    // Contador de pacientes preferenciales atendidos consecutivamente.
    private int pref_Contador = 0;

    // Nueva lista para el expediente único de pacientes (Lista Doble Circular).
    private ListaDobleCircularExpedientes expedientes = new ListaDobleCircularExpedientes();
    // Nueva lista para la bitácora de citas del día (Lista Simple).
    private ListaSimpleBitacoraCitas bitacoraCitasDia = new ListaSimpleBitacoraCitas();


    /**
     * Muestra el submenú de atención de pacientes y gestiona las opciones del usuario.
     * Este método contiene el bucle principal para la interacción con el usuario
     * en la sección de gestión de pacientes.
     * @author MarioSandi
     */
    protected void SubMenuGestionPacientes() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Submenu de Atencion de Pacientes ---");
            System.out.println("1. Seleccionar Ficha");
            System.out.println("2. Atender Paciente");
            System.out.println("3. Abandonar Cola de Pacientes");
            System.out.println("4. Mostrar Fichas Pendientes");
            System.out.println("5. Mostrar Quejas Recibidas");
            System.out.println("6. Regresar al Menu Principal");
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
                    escogerFichaPaciente(scanner);
                    break;
                case 2:
                    atencionDePacientes(scanner); // Se pasa el scanner para la nueva funcionalidad
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
                    break; // Sale del bucle do-while.
                default:
                    System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                    break;
            }
        } while (opcion != 6);
    }

    /**
     * Solicita al usuario los datos del paciente y le asigna una ficha según la categoría.
     * El paciente es encolado en la cola correspondiente (preferencial o regular).
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     * @author Nahum Ramirez
     */
    private void escogerFichaPaciente(Scanner scanner) {
        System.out.println("\n--- Seleccion de Ficha ---");
        System.out.println("Escoja la categoria apropiada de ficha:");
        System.out.println("1. Paciente Preferencial");
        System.out.println("2. Paciente Regular");
        System.out.print("Categoria: ");

        int categoria;
        // Valida que la entrada de categoría sea un número entero.
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Por favor, ingrese 1 o 2.");
            scanner.next(); // Descarta la entrada no numérica.
            System.out.print("Categoria: ");
        }
        categoria = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer.

        System.out.print("Ingrese numero de cedula: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese nombre completo del paciente: ");
        String nombre = scanner.nextLine();

        Date fechaLlegada = new Date(); // Obtiene la fecha y hora actual.
        String fichaAsignada;
        Paciente nuevoPaciente;

        if (categoria == 1){
            fichaAsignada = "P" + conta_Prefe++; // Asigna ficha preferencial.
            nuevoPaciente = new Paciente(fechaLlegada, fichaAsignada, nombre, cedula);
            c_Prefe.encolar(nuevoPaciente);
            System.out.println("Paciente preferencial encolado.");
        } else if (categoria == 2) {
            fichaAsignada = "R" + conta_Regular++; // Asigna ficha regular.
            nuevoPaciente = new Paciente(fechaLlegada, fichaAsignada, nombre, cedula);
            c_Regular.encolar(nuevoPaciente);
            System.out.println("Paciente regular encolado.");
        } else {
            System.out.println("Categoria de ficha no valida. El paciente no fue encolado.");
            return; // Sale del método si la categoría no es válida.
        }

        System.out.println("Su numero de ficha es: " + fichaAsignada);
        System.out.println("Gracias por su paciencia!");
    }

    /**
     * Atiende a los pacientes siguiendo la lógica de 2 preferenciales por 1 regular.
     * Si no hay pacientes en ninguna cola, se informa al usuario.
     * Además, gestiona la creación/actualización del expediente del paciente
     * y la bitácora de citas del día.
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     * @author Lopez Alex
     */
    private void atencionDePacientes(Scanner scanner) {
        Paciente pacienteAtendido = null;
        Date fechaAtencion = new Date(); // Momento en que el paciente es atendido.

        System.out.println("\n--- Atencion de Pacientes ---");

        // Lógica de atención: 2 preferenciales, luego 1 regular.
        if (!c_Prefe.estaVacia() && pref_Contador < max_pref_atendidos) {
            pacienteAtendido = c_Prefe.desencolar();
            pref_Contador++;
            System.out.println("Atendiendo paciente preferencial.");
        } else if (!c_Regular.estaVacia()) {
            pacienteAtendido = c_Regular.desencolar();
            pref_Contador = 0; // Reinicia el contador de preferenciales después de atender un regular.
            System.out.println("Atendiendo paciente regular.");
        } else if (!c_Prefe.estaVacia()) { // Si no hay regulares y aún quedan preferenciales (y ya se atendieron 2)
            pacienteAtendido = c_Prefe.desencolar();
            pref_Contador++;
            System.out.println("Atendiendo paciente preferencial (sin regulares disponibles).");
        }

        if (pacienteAtendido != null) {
            System.out.println("\nDatos del paciente a atender:");
            System.out.println(pacienteAtendido);

            Expediente expedienteActual = expedientes.buscarPorCedula(pacienteAtendido.getCedula());

            // Si el paciente no tiene expediente, es su primera vez.
            if (expedienteActual == null) {
                System.out.println("Paciente " + pacienteAtendido.getNombre() + " asiste a consulta por primera vez.");
                int edad;
                String genero;

                System.out.print("Ingrese la edad del paciente: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada invalida. Por favor, ingrese un numero para la edad.");
                    scanner.next();
                    System.out.print("Ingrese la edad del paciente: ");
                }
                edad = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Ingrese el genero del paciente (Ej. Masculino, Femenino, Otro): ");
                genero = scanner.nextLine();

                expedienteActual = new Expediente(pacienteAtendido.getNombre(), pacienteAtendido.getCedula(), edad, genero);
                expedientes.insertarOrdenado(expedienteActual); // Insertar el nuevo expediente ordenado por cédula.
                System.out.println("Expediente creado para " + pacienteAtendido.getNombre() + ".");
            } else {
                // Si el paciente ya tiene expediente, mostrar sus datos.
                System.out.println("\nDatos del expediente existente:");
                System.out.println(expedienteActual);
            }

            // Solicitar datos de la cita actual
            System.out.print("\nIngrese el nombre del doctor que atiende: ");
            String nombreDoctor = scanner.nextLine();
            System.out.print("Ingrese el diagnostico (texto abierto): ");
            String diagnostico = scanner.nextLine();

            // Crear y añadir la cita al historial del expediente
            Cita nuevaCita = new Cita(fechaAtencion, nombreDoctor, diagnostico);
            expedienteActual.getHistoricoCitas().insertar(nuevaCita);
            System.out.println("Cita registrada en el historial del paciente.");

            // Solicitar y añadir medicamentos prescritos
            System.out.println("Ingrese los medicamentos prescritos (escriba 'Finalizar' para terminar):");
            String medicamentoInput;
            do {
                System.out.print("Medicamento: ");
                medicamentoInput = scanner.nextLine();
                if (!medicamentoInput.equalsIgnoreCase("Finalizar") && !medicamentoInput.trim().isEmpty()) {
                    MedicamentoPrescrito nuevoMedicamento = new MedicamentoPrescrito(fechaAtencion, medicamentoInput);
                    expedienteActual.getHistoricoMedicamentos().insertar(nuevoMedicamento);
                    System.out.println("Medicamento '" + medicamentoInput + "' registrado.");
                }
            } while (!medicamentoInput.equalsIgnoreCase("Finalizar"));

            // Alimentar la bitácora de citas del día
            long tiempoEsperaMillis = fechaAtencion.getTime() - pacienteAtendido.getF_h().getTime();
            long tiempoEsperaSegundos = tiempoEsperaMillis / 1000;

            BitacoraCitaDia bitacoraEntry = new BitacoraCitaDia(
                pacienteAtendido.getFicha(),
                pacienteAtendido.getF_h(),
                fechaAtencion,
                pacienteAtendido.getCedula(),
                pacienteAtendido.getNombre(),
                tiempoEsperaSegundos
            );
            bitacoraCitasDia.insertarOrdenado(bitacoraEntry); // Insertar en la bitácora ordenada por cédula.
            System.out.println("Cita anadida a la bitacora del dia.");

            System.out.println("\nPaciente " + pacienteAtendido.getNombre() + ", su cita ha concluido.");

        } else {
            System.out.println("Todos los pacientes fueron atendidos, no hay pacientes por atender.");
        }
    }

    /**
     * Muestra las fichas pendientes en ambas colas (regular y preferencial).
     * @author Arauz Arturo
     */
    private void mostrarFichasPendientes() {
        System.out.println("\n--- Fichas Pendientes ---");
        System.out.println("Fichas sin atender en la categoria REGULAR:");
        c_Regular.imprimirCola();

        System.out.println("\nFichas sin atender en la categoria PREFERENCIAL:");
        c_Prefe.imprimirCola();
    }

    /**
     * Permite a un paciente abandonar la cola ingresando su número de ficha.
     * Si el paciente es encontrado y eliminado, se registra una queja.
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     * @author Lopez Alex
     */
    private void abandonarCola(Scanner scanner) {
        System.out.println("\n--- Abandonar Cola ---");
        System.out.print("Indique el numero de ficha para abandonar la cola: ");
        String fichaABuscar = scanner.nextLine();

        Paciente pacienteAbandonando = null;

        // Intenta eliminar de la cola preferencial.
        pacienteAbandonando = eliminarDeCola(c_Prefe, fichaABuscar);
        if (pacienteAbandonando == null) {
            // Si no se encuentra en la preferencial, intenta en la regular.
            pacienteAbandonando = eliminarDeCola(c_Regular, fichaABuscar);
        }

        if (pacienteAbandonando != null) {
            System.out.println("Ficha #" + pacienteAbandonando.getFicha() + " con cedula " + pacienteAbandonando.getCedula() + " ha abandonado la cola sin ser atendido/a.");

            // Registra una queja por el abandono de la cola.
            Queja queja = new Queja(new Date(), "Paciente abandono la cola sin ser atendido.", pacienteAbandonando.getNombre(), pacienteAbandonando.getCedula());
            pilaQuejas.apilar(queja);
            System.out.println("Se ha registrado una queja por el abandono.");
        } else {
            System.out.println("Ficha no localizada en ninguna de las colas. Por favor, verifique el numero.");
        }
    }

    /**
     * Busca y elimina un paciente de una cola específica basándose en su número de ficha.
     * Este método se utiliza internamente por 'abandonarCola'.
     * @param cola La cola de la cual se intentará eliminar el paciente.
     * @param numeroDeFicha El número de ficha del paciente a eliminar.
     * @return El objeto Paciente eliminado, o null si no se encontró.
     * @author Lopez Alex
     */
    private Paciente eliminarDeCola(Cola cola, String numeroDeFicha) {
        Cola colaTemporal = new Cola(); // Cola temporal para mover los pacientes no coincidentes.
        Paciente pacienteEncontrado = null;

        // Recorre la cola original.
        while (!cola.estaVacia()) {
            Paciente p = cola.desencolar();
            if (p.getFicha().equalsIgnoreCase(numeroDeFicha)) {
                pacienteEncontrado = p; // Si encuentra el paciente, lo guarda.
            } else {
                colaTemporal.encolar(p); // Si no es el paciente buscado, lo encola en la cola temporal.
            }
        }
        // Devuelve los pacientes de la cola temporal a la cola original.
        while (!colaTemporal.estaVacia()) {
            cola.encolar(colaTemporal.desencolar());
        }
        return pacienteEncontrado; // Devuelve el paciente encontrado (o null si no se encontró).
    }

    /**
     * Muestra todas las quejas que han sido registradas en el sistema.
     * @author Arauz Arturo
     */
    private void quejasRecibidas() {
        System.out.println("\n--- Quejas Recibidas ---");
        if (pilaQuejas.estaVacia()) {
            System.out.println("No hay quejas registradas en el sistema.");
        } else {
            pilaQuejas.mostrarPila();
        }
    }

    /**
     * Muestra la bitácora de citas del día, indicando el tiempo de espera
     * con un distintivo visual (colores).
     * @author Nahum Ramirez
     */
    protected void consultarBitacoraCitasDia() {
        System.out.println("\n--- Bitacora de Citas del Dia ---");
        if (bitacoraCitasDia.estaVacia()) {
            System.out.println("No hay citas registradas en la bitacora del dia.");
            return;
        }

        NodoBitacora actual = bitacoraCitasDia.getCabeza();
        if (actual == null) return; // En caso de que la lista se vacíe inesperadamente.

        do {
            BitacoraCitaDia cita = actual.getDato();
            String color = "";
            if (cita.getTiempoEsperaSegundos() <= 30) {
                color = "\u001B[32m"; // Verde
            } else if (cita.getTiempoEsperaSegundos() > 30 && cita.getTiempoEsperaSegundos() < 60) {
                color = "\u001B[33m"; // Amarillo
            } else {
                color = "\u001B[31m"; // Rojo
            }
            System.out.println(color + cita + "\u001B[0m"); // Restablecer color
            actual = actual.getSiguiente();
        } while (actual != null); // Lista simple, no circular
    }

    /**
     * Permite al usuario consultar los expedientes únicos de pacientes,
     * navegando hacia adelante y hacia atrás.
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     * @author Arauz Cerdas Oscar Arturo
     */
protected void consultarExpedienteUnicoPacientes(Scanner scanner) {
    System.out.println("\n--- Consulta de Expediente unico de Pacientes ---");
    if (expedientes.estaVacia()) {
        System.out.println("No hay expedientes de pacientes registrados.");
        return;
    }

    NodoExpediente actual = expedientes.getCabeza();
    NodoExpediente inicio = actual; // Guardamos el nodo inicial como referencia
    String opcion;
    boolean primeraVez = true;

    do {
        if (!primeraVez) {
            System.out.println("\n--- Expediente Actual ---");
            System.out.println("Cedula: " + actual.getDato().getCedula());
            System.out.println("Nombre: " + actual.getDato().getNombre());
            System.out.println("Edad: " + actual.getDato().getEdad());
            System.out.println("Genero: " + actual.getDato().getGenero());

            System.out.println("\n--- Histórico de Citas ---");
            if (actual.getDato().getHistoricoCitas().estaVacia()) {
                System.out.println("No hay citas registradas para este paciente.");
            } else {
                actual.getDato().getHistoricoCitas().imprimirLista();
            }

            System.out.println("\n--- Histórico de Medicamentos Prescritos ---");
            if (actual.getDato().getHistoricoMedicamentos().estaVacia()) {
                System.out.println("No hay medicamentos prescritos para este paciente.");
            } else {
                actual.getDato().getHistoricoMedicamentos().imprimirLista();
            }
        }
        primeraVez = false;

        System.out.println("\nNavegacion (S: Siguiente, A: Anterior, X: Salir):");
        System.out.print("Ingrese su opcion: ");
        opcion = scanner.nextLine().trim().toUpperCase();

        switch (opcion) {
            case "N":
                actual = actual.getSiguiente();
                if (actual == inicio) {
                    System.out.println("Has llegado al final de la lista. Volviendo al primer expediente.");
                }
                break;
            case "P":
                actual = actual.getAnterior();
                if (actual == inicio.getAnterior()) {
                    System.out.println("Has llegado al inicio de la lista. Mostrando último expediente.");
                }
                break;
            case "S":
                System.out.println("Saliendo de la consulta de expedientes.");
                break;
            default:
                System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                break;
        }
    } while (!opcion.equals("S"));
}
}
