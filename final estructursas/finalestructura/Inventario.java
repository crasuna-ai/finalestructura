package finalestructura;

import javax.swing.*;

public class Inventario {
    public static void imprimirInventario() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Préstamos Ingeniería ---\n");
        for (EstudianteIngenieria est : ServicioPrestamoIngenieria.vector_ingenieros) {
            sb.append(est).append("\n");
        }
        for (ComputadorPortatil comp : ServicioPrestamoIngenieria.vector_portatil) {
            sb.append(comp).append("\n");
        }
        sb.append("\n--- Préstamos Diseño ---\n");
        for (EstudianteDiseno est : ServicioPrestamoDiseno.vector_disenadores) {
            sb.append(est).append("\n");
        }
        for (TabletaGrafica tab : ServicioPrestamoDiseno.vector_tableta) {
            sb.append(tab).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}