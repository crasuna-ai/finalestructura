package finalestructura;

import javax.swing.*;
import java.util.ArrayList;

public class ServicioPrestamoDiseno {
    public static ArrayList<EstudianteDiseno> vector_disenadores = new ArrayList<>();
    public static ArrayList<TabletaGrafica> vector_tableta = new ArrayList<>();

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
                "Menú Diseño",
                "Gestión Diseño",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            switch (opcion) {
                case 0: registrarPrestamo(); break;
                case 1: modificarPrestamo(); break;
                case 2: devolucionEquipo(); break;
                case 3: buscarEquipo(); break;
                default: // salir
            }
        } while (opcion != 4 && opcion != JOptionPane.CLOSED_OPTION);
    }

    public static void registrarPrestamo() {
        String cedula = Utilidades.validarCedula("Ingrese cédula:");
        if (Utilidades.buscarEstudianteDiseno(cedula) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un préstamo registrado para esta cédula.");
            return;
        }
        String nombre = Utilidades.validarNombre("Ingrese nombre:");
        String apellido = Utilidades.validarNombre("Ingrese apellido:");
        String telefono = Utilidades.validarTelefono("Ingrese teléfono:");
        String modalidad = JOptionPane.showInputDialog("Ingrese modalidad de estudio (virtual/presencial):");
        int cantAsignaturas = Utilidades.leerEntero("Ingrese cantidad de asignaturas:");

        String serial = Utilidades.validarSerial("Ingrese serial de la tableta:");
        if (Utilidades.buscarTableta(serial) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un préstamo con ese serial.");
            return;
        }
        String marca = Utilidades.validarNombre("Ingrese marca de la tableta:");
        float tamanio = Utilidades.leerFloat("Ingrese tamaño en pulgadas:");
        float precio = Utilidades.leerFloat("Ingrese precio:");
        String almacenamiento = Utilidades.seleccionarAlmacenamiento();
        float peso = Utilidades.leerFloat("Ingrese peso en kg:");

        TabletaGrafica tableta = new TabletaGrafica(serial, marca, tamanio, precio, almacenamiento, peso);
        vector_tableta.add(tableta);

        int serialInt = serial.hashCode();
        EstudianteDiseno estudiante = new EstudianteDiseno(cedula, nombre, apellido, telefono, modalidad, cantAsignaturas, serialInt);
        vector_disenadores.add(estudiante);

        JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
    }

    public static void modificarPrestamo() {
        EstudianteDiseno est = Utilidades.buscarEstudianteDisenoPorMenu();
        if (est == null) {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
            return;
        }
        est.setNombre(Utilidades.validarNombre("Nuevo nombre (" + est.getNombre() + "):"));
        est.setApellido(Utilidades.validarNombre("Nuevo apellido (" + est.getApellido() + "):"));
        est.setTelefono(Utilidades.validarTelefono("Nuevo teléfono (" + est.getTelefono() + "):"));
        est.setModalidad(JOptionPane.showInputDialog("Nueva modalidad (" + est.getModalidad() + "):"));
        est.setCantAsignaturas(Utilidades.leerEntero("Nueva cantidad asignaturas (" + est.getCantAsignaturas() + "):"));

        TabletaGrafica tableta = Utilidades.buscarTabletaPorSerialInt(est.getSerialEquipo());
        if (tableta != null) {
            tableta.setMarca(Utilidades.validarNombre("Nueva marca (" + tableta.getMarca() + "):"));
            tableta.setTamanio(Utilidades.leerFloat("Nuevo tamaño (" + tableta.getTamanio() + "):"));
            tableta.setPrecio(Utilidades.leerFloat("Nuevo precio (" + tableta.getPrecio() + "):"));
            tableta.setAlmacenamiento(Utilidades.seleccionarAlmacenamiento());
            tableta.setPeso(Utilidades.leerFloat("Nuevo peso (" + tableta.getPeso() + "):"));
        }
        JOptionPane.showMessageDialog(null, "Registro modificado.");
    }

    public static void devolucionEquipo() {
        EstudianteDiseno est = Utilidades.buscarEstudianteDisenoPorMenu();
        if (est == null) {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
            return;
        }
        TabletaGrafica tableta = Utilidades.buscarTabletaPorSerialInt(est.getSerialEquipo());
        vector_disenadores.remove(est);
        if (tableta != null) vector_tableta.remove(tableta);
        JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente.");
    }

    public static void buscarEquipo() {
        EstudianteDiseno est = Utilidades.buscarEstudianteDisenoPorMenu();
        if (est != null) {
            TabletaGrafica tableta = Utilidades.buscarTabletaPorSerialInt(est.getSerialEquipo());
            JOptionPane.showMessageDialog(null, est.toString() + (tableta != null ? "\n" + tableta.toString() : ""));
        } else {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
        }
    }
}