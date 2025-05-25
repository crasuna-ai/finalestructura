package finalestructura;

import javax.swing.*;

public class MenuPrincipal {
    public static void mostrarMenu() {
        String[] opciones = {
            "Estudiantes de Ingeniería", 
            "Estudiantes de Diseño", 
            "Imprimir Inventario Total", 
            "Salir"
        };
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(
                null,
                "GESTIÓN PRÉSTAMO EQUIPOS ELECTRÓNICOS SAN JUAN DE DIOS",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            switch (opcion) {
                case 0:
                    ServicioPrestamoIngenieria.menu();
                    break;
                case 1:
                    ServicioPrestamoDiseno.menu();
                    break;
                case 2:
                    Inventario.imprimirInventario();
                    break;
                default:
                    // salir o cerrar ventana
            }
        } while (opcion != 3 && opcion != JOptionPane.CLOSED_OPTION);
    }
}