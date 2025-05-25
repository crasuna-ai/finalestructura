package finalestructura;

import javax.swing.*;
import java.util.ArrayList;

public class ServicioPrestamoIngenieria {
    public static ArrayList<EstudianteIngenieria> vector_ingenieros = new ArrayList<>();
    public static ArrayList<ComputadorPortatil> vector_portatil = new ArrayList<>();

    public static void menu() {
        String[] opciones = {
            "Registrar préstamo de equipo",
            "Modificar préstamo de equipo",
            "Devolución de equipo",
            "Buscar equipo",
            "Volver al menú principal"
        };
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(
                null,
                "Menú Ingeniería",
                "Gestión Ingeniería", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]
            );
            switch (opcion) {
                case 0: 
                registrarPrestamo(); 
                break;
                case 1: 
                modificarPrestamo(); 
                break;
                case 2: 
                devolucionEquipo();
                 break;
                case 3: 
                buscarEquipo();
                break;
                default: // salir
            }
        } while (opcion != 4 && opcion != JOptionPane.CLOSED_OPTION);
    }

    public static void registrarPrestamo() {
        String cedula = Utilidades.validarCedula("Ingrese cédula:");
        if (Utilidades.buscarEstudianteIngenieria(cedula) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un préstamo registrado para esta cédula.");
            return;
        }
        String nombre = Utilidades.validarNombre("Ingrese nombre:");
        String apellido = Utilidades.validarNombre("Ingrese apellido:");
        String telefono = Utilidades.validarTelefono("Ingrese teléfono:");
        int semestre = Utilidades.leerEntero("Ingrese semestre actual:");
        float promedio = Utilidades.leerFloat("Ingrese promedio acumulado:");

        String serial = Utilidades.validarSerial("Ingrese serial del portátil:");
        if (Utilidades.buscarPortatil(serial) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un préstamo con ese serial.");
            return;
        }
        String marca = Utilidades.validarNombre("Ingrese marca del portátil:");
        float tamanio = Utilidades.leerFloat("Ingrese tamaño en pulgadas:");
        float precio = Utilidades.leerFloat("Ingrese precio:");
        String sistemaOperativo = Utilidades.seleccionarSO();
        String procesador = Utilidades.seleccionarProcesador();

        ComputadorPortatil portatil = new ComputadorPortatil(serial, marca, tamanio, precio, sistemaOperativo, procesador);
        vector_portatil.add(portatil);

        EstudianteIngenieria estudiante = new EstudianteIngenieria(cedula, nombre, apellido, telefono, semestre, promedio, serial);
        vector_ingenieros.add(estudiante);

        JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
    }

    public static void modificarPrestamo() {
        EstudianteIngenieria est = Utilidades.buscarEstudianteIngenieriaPorMenu();
        if (est == null) {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
            return;
        }
        est.setNombre(Utilidades.validarNombre("Nuevo nombre (" + est.getNombre() + "):"));
        est.setApellido(Utilidades.validarNombre("Nuevo apellido (" + est.getApellido() + "):"));
        est.setTelefono(Utilidades.validarTelefono("Nuevo teléfono (" + est.getTelefono() + "):"));
        est.setSemestre(Utilidades.leerEntero("Nuevo semestre (" + est.getSemestre() + "):"));
        est.setPromedio(Utilidades.leerFloat("Nuevo promedio (" + est.getPromedio() + "):"));

        ComputadorPortatil portatil = Utilidades.buscarPortatil(est.getSerialEquipo());
        if (portatil != null) {
            portatil.setMarca(Utilidades.validarNombre("Nueva marca (" + portatil.getMarca() + "):"));
            portatil.setTamanio(Utilidades.leerFloat("Nuevo tamaño (" + portatil.getTamanio() + "):"));
            portatil.setPrecio(Utilidades.leerFloat("Nuevo precio (" + portatil.getPrecio() + "):"));
            portatil.setSistemaOperativo(Utilidades.seleccionarSO());
            portatil.setProcesador(Utilidades.seleccionarProcesador());
        }
        JOptionPane.showMessageDialog(null, "Registro modificado.");
    }

    public static void devolucionEquipo() {
        EstudianteIngenieria est = Utilidades.buscarEstudianteIngenieriaPorMenu();
        if (est == null) {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
            return;
        }
        ComputadorPortatil portatil = Utilidades.buscarPortatil(est.getSerialEquipo());
        vector_ingenieros.remove(est);
        if (portatil != null) vector_portatil.remove(portatil);
        JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente.");
    }

    public static void buscarEquipo() {
        EstudianteIngenieria est = Utilidades.buscarEstudianteIngenieriaPorMenu();
        if (est != null) {
            ComputadorPortatil portatil = Utilidades.buscarPortatil(est.getSerialEquipo());
            JOptionPane.showMessageDialog(null, est.toString() + (portatil != null ? "\n" + portatil.toString() : ""));
        } else {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
        }
    }
}