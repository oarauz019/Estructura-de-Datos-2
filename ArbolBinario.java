/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 * Implementación del árbol binario para la estructura del chatbot.
 */
class ArbolBinario {
    NodoArbol raiz;
    private static final int MAX_HIJOS = 2; // Solo se permite 2 hijos por nodo

    /**
     * Constructor del árbol binario.
     */
    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Inserta un nuevo nodo en el árbol.
     * @param codigoPadre El código del nodo padre.
     * @param nombreNodo El nombre del nuevo nodo.
     */
    public void insertar(String codigoPadre, String nombreNodo) {
        if (raiz == null) {
            if (codigoPadre.equals("1")) {
                raiz = new NodoArbol("1", nombreNodo);
                System.out.println("Nodo raíz '1' creado con éxito.");
            } else {
                System.out.println("Error: La raíz debe ser '1'.");
            }
            return;
        }

        NodoArbol padre = buscarNodo(raiz, codigoPadre);
        if (padre == null) {
            System.out.println("Error: No se encontró el nodo padre con código " + codigoPadre);
            return;
        }

        if (padre.listaPreguntas != null) {
            System.out.println("Error: No se pueden agregar sub-nodos a un nodo que ya tiene preguntas.");
            return;
        }

        if (padre.izquierda != null && padre.derecha != null) {
            System.out.println("Error: El nodo padre ya tiene dos hijos.");
            return;
        }
        
        String nuevoCodigo;
        if (padre.izquierda == null) {
            nuevoCodigo = codigoPadre + "1";
            padre.izquierda = new NodoArbol(nuevoCodigo, nombreNodo);
            padre.izquierda.padre = padre;
            System.out.println("Nuevo nodo " + nuevoCodigo + " insertado con éxito.");
        } else {
            nuevoCodigo = codigoPadre + "2";
            padre.derecha = new NodoArbol(nuevoCodigo, nombreNodo);
            padre.derecha.padre = padre;
            System.out.println("Nuevo nodo " + nuevoCodigo + " insertado con éxito.");
        }
    }

    /**
     * Busca un nodo en el árbol por su código.
     * @param nodo El nodo actual desde donde buscar.
     * @param codigo El código del nodo a buscar.
     * @return El nodo encontrado, o null si no existe.
     */
    public NodoArbol buscarNodo(NodoArbol nodo, String codigo) {
        if (nodo == null || nodo.codigo.equals(codigo)) {
            return nodo;
        }

        if (codigo.startsWith(nodo.codigo)) {
            // Decidir si buscar en el hijo izquierdo o derecho
            if (nodo.izquierda != null && codigo.equals(nodo.izquierda.codigo)) {
                return nodo.izquierda;
            }
            if (nodo.derecha != null && codigo.equals(nodo.derecha.codigo)) {
                return nodo.derecha;
            }
            
            NodoArbol resultadoIzquierda = buscarNodo(nodo.izquierda, codigo);
            if (resultadoIzquierda != null) {
                return resultadoIzquierda;
            }
            
            NodoArbol resultadoDerecha = buscarNodo(nodo.derecha, codigo);
            return resultadoDerecha;
        }
        return null;
    }
    
     /**
     * Modifica el nombre de un nodo existente en el árbol.
     * @param codigo El código del nodo a modificar.
     * @param nuevoNombre El nuevo nombre para el nodo.
     */
    public void modificarNodo(String codigo, String nuevoNombre) {
        NodoArbol nodo = buscarNodo(raiz, codigo);
        if (nodo != null) {
            nodo.nombre = nuevoNombre;
            System.out.println("Nodo con código " + codigo + " modificado con éxito.");
        } else {
            System.out.println("Error: Nodo con código " + codigo + " no encontrado.");
        }
    }

    /**
     * Elimina un nodo del árbol.
     * @param codigo El código del nodo a eliminar.
     */
    public void eliminarNodo(String codigo) {
        if (raiz == null) {
            System.out.println("Error: El árbol está vacío.");
            return;
        }
        if (raiz.codigo.equals(codigo)) {
            System.out.println("Error: No se puede eliminar la raíz.");
            return;
        }

        NodoArbol nodo = buscarNodo(raiz, codigo);
        if (nodo == null) {
            System.out.println("Error: Nodo con código " + codigo + " no encontrado.");
            return;
        }
        if (nodo.izquierda != null || nodo.derecha != null) {
            System.out.println("Error: No se puede eliminar un nodo que tiene hijos.");
            return;
        }

        NodoArbol padre = nodo.padre;
        if (padre != null) {
            if (padre.izquierda != null && padre.izquierda.codigo.equals(codigo)) {
                padre.izquierda = null;
            } else if (padre.derecha != null && padre.derecha.codigo.equals(codigo)) {
                padre.derecha = null;
            }
            System.out.println("Nodo con código " + codigo + " eliminado con éxito.");
        }
    }

    /**
     * Método para pre-cargar el árbol con los datos iniciales.
     */
    public void preCargarArbol() {
        // Nivel 1
        raiz = new NodoArbol("1", "Preguntas Frecuentes (FAQ)");

        // Nivel 2
        NodoArbol nodo11 = new NodoArbol("11", "Emergencias");
        NodoArbol nodo12 = new NodoArbol("12", "Consulta Externa");
        raiz.izquierda = nodo11;
        raiz.derecha = nodo12;
        nodo11.padre = raiz;
        nodo12.padre = raiz;

        // Nivel 3
        NodoArbol nodo111 = new NodoArbol("111", "Emergencias Menores");
        NodoArbol nodo112 = new NodoArbol("112", "Emergencias Mayores");
        nodo11.izquierda = nodo111;
        nodo11.derecha = nodo112;
        nodo111.padre = nodo11;
        nodo112.padre = nodo11;

        NodoArbol nodo121 = new NodoArbol("121", "Servicios");
        nodo12.izquierda = nodo121;
        nodo121.padre = nodo12;

        // Nivel 4
        NodoArbol nodo1111 = new NodoArbol("1111", "Mayores 18 años");
        NodoArbol nodo1112 = new NodoArbol("1112", "Menores de edad");
        nodo111.izquierda = nodo1111;
        nodo111.derecha = nodo1112;
        nodo1111.padre = nodo111;
        nodo1112.padre = nodo111;

        NodoArbol nodo1211 = new NodoArbol("1211", "Laboratorio");
        NodoArbol nodo1212 = new NodoArbol("1212", "Farmacia");
        nodo121.izquierda = nodo1211;
        nodo121.derecha = nodo1212;
        nodo1211.padre = nodo121;
        nodo1212.padre = nodo121;

        // Cargar preguntas en los nodos hoja
        // Nodo 1111
        nodo1111.listaPreguntas = new ListaEnlazada();
        nodo1111.listaPreguntas.agregar("¿Cuál es el costo de consulta para adultos?", "El costo de atención en emergencias para un adulto es de 20,000 colones.");
        nodo1111.listaPreguntas.agregar("¿Cuál es el tiempo promedio de espera?", "Por tratarse de un servicio de emergencia no podemos garantizar un tiempo mínimo para atenciones menores. Sin embargo, en promedio demoramos 30 minutos.");

        // Nodo 1112
        nodo1112.listaPreguntas = new ListaEnlazada();
        nodo1112.listaPreguntas.agregar("¿Qué especialidad atiende a los niños?", "Contamos con pediatra las 24 horas del día.");
        nodo1112.listaPreguntas.agregar("¿Se puede aplicar el seguro estudiantil?", "Sí, recibimos todos los seguros médicos del mercado.");

        // Nodo 112 (Preguntas del nivel anterior, pero la especificación dice en una hoja, así que las pondré en este nodo)
        // La especificación dice "No tiene. Las preguntas estarán en el nivel anterior", pero luego lista preguntas.
        // Asumiendo que es un error en la especificación, las preguntas se asocian al nodo hoja 112.
        nodo112.listaPreguntas = new ListaEnlazada();
        nodo112.listaPreguntas.agregar("Horario", "Atendemos 24 horas del día.");
        nodo112.listaPreguntas.agregar("Sucursales", "Tenemos sucursales en todo el país, ingrese a www.susalud.com/sucursales para mayor información.");
        nodo112.listaPreguntas.agregar("Aplicar a una plaza", "Ingrese a www.susalud.com/plazas para ver las vacantes disponibles.");

        // Nodo 1211 (Laboratorio)
        nodo1211.listaPreguntas = new ListaEnlazada();
        nodo1211.listaPreguntas.agregar("¿Qué tipo de exámenes de laboratorio realizan?", "Realizamos exámenes de sangre, orina, heces y otros estudios especializados.");
        nodo1211.listaPreguntas.agregar("¿Necesito una cita previa para exámenes de laboratorio?", "Para la mayoría de los exámenes no es necesario. Para estudios especializados, por favor, consulte la página web o llame a nuestra central telefónica.");

        // Nodo 1212 (Farmacia)
        nodo1212.listaPreguntas = new ListaEnlazada();
        nodo1212.listaPreguntas.agregar("¿Tienen servicio a domicilio?", "Sí, contamos con servicio de entrega a domicilio con un costo adicional.");
        nodo1212.listaPreguntas.agregar("¿Cuál es el horario de la farmacia?", "Nuestra farmacia está abierta las 24 horas del día, los 7 días de la semana.");
    }
}
