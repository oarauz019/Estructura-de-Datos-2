/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oarau
 */
public class Prueba {


public class FacturaSistema {

    // Clase Factura para modelar los datos
    static class Factura {
        String fechaHora;
        String alumno;
        String instructor;
        String sede;
        boolean anulada;

        // Constructor
        public Factura(String fechaHora, String alumno, String instructor, String sede) {
            this.fechaHora = fechaHora;
            this.alumno = alumno;
            this.instructor = instructor;
            this.sede = sede;
            this.anulada = false; // Por defecto, una factura no está anulada
        }

        //Obtener los datos de la factura como texto
        public String mostrarFactura() {
            return "Fecha y Hora: " + fechaHora +
                    "\nAlumno: " + alumno +
                    "\nInstructor: " + instructor +
                    "\nSede: " + sede +
                    "\nEstado: " + (anulada ? "Anulada" : "Activa");
        }
    }

    // Arreglo para almacenar un máximo de 10 facturas
    static Factura[] facturas = new Factura[10];
    static int contadorFacturas = 0;

    // Método para crear una nueva factura
    public static void crearFactura() {
        if (contadorFacturas >= facturas.length) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más facturas. Arreglo lleno.");
            return;
        }

        String fechaHora = JOptionPane.showInputDialog("Ingrese la fecha y hora (dd/MM/yyyy HH:mm):");
        String alumno = JOptionPane.showInputDialog("Ingrese el nombre del alumno:");
        String instructor = JOptionPane.showInputDialog("Ingrese el nombre del instructor:");
        String sede = JOptionPane.showInputDialog("Ingrese la sede:");

        facturas[contadorFacturas] = new Factura(fechaHora, alumno, instructor, sede);
        contadorFacturas++;

        JOptionPane.showMessageDialog(null, "Factura creada exitosamente.");
    }
   
}
