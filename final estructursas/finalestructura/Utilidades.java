
package finalestructura;

import javax.swing.*;

public class Utilidades {
    public static int leerEntero(String mensaje) {
        String valor = JOptionPane.showInputDialog(mensaje);
        if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número entero.");
            return leerEntero(mensaje);
        }
        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número entero.");
            return leerEntero(mensaje);
        }
    }

    public static float leerFloat(String mensaje) {
        String valor = JOptionPane.showInputDialog(mensaje);
        if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            return leerFloat(mensaje);
        }
        try {
            return Float.parseFloat(valor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número válido.");
            return leerFloat(mensaje);
        }
    }

    public static String validarCedula(String mensaje) {
        String cedula = JOptionPane.showInputDialog(mensaje);
        if (cedula == null || cedula.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cédula.");
            return validarCedula(mensaje);
        }
        if (!cedula.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Solo números permitidos para la cédula. Intente de nuevo.");
            return validarCedula(mensaje);
        }
        return cedula;
    }

    public static String validarNombre(String mensaje) {
        String nombre = JOptionPane.showInputDialog(mensaje);
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre.");
            return validarNombre(mensaje);
        }
        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$")) {
            JOptionPane.showMessageDialog(null, "Solo letras permitidas. Intente de nuevo.");
            return validarNombre(mensaje);
        }
        return nombre;
    }

    public static String validarTelefono(String mensaje) {
        String tel = JOptionPane.showInputDialog(mensaje);
        if (tel == null || tel.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un teléfono.");
            return validarTelefono(mensaje);
        }
        if (!tel.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Solo números permitidos para el teléfono. Intente de nuevo.");
            return validarTelefono(mensaje);
        }
        return tel;
    }

    public static String validarSerial(String mensaje) {
        String serial = JOptionPane.showInputDialog(mensaje);
        if (serial == null || serial.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un serial.");
            return validarSerial(mensaje);
        }
        if (!serial.matches("^[a-zA-Z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Serial inválido. Intente de nuevo.");
            return validarSerial(mensaje);
        }
        return serial;
    }

    public static float leerPromedio(String mensaje) {
        String valor = JOptionPane.showInputDialog(mensaje);
        if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un promedio.");
            return leerPromedio(mensaje);
        }
        try {
            float promedio = Float.parseFloat(valor);
            if (promedio <= 0 || promedio > 5) {
                JOptionPane.showMessageDialog(null, "El promedio debe ser mayor que 0 y máximo 5.0.");
                return leerPromedio(mensaje);
            }
            return promedio;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número válido.");
            return leerPromedio(mensaje);
        }
    }

    public static int leerSemestre(String mensaje) {
        String valor = JOptionPane.showInputDialog(mensaje);
        if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el semestre.");
            return leerSemestre(mensaje);
        }
        try {
            int semestre = Integer.parseInt(valor);
            if (semestre < 1) {
                JOptionPane.showMessageDialog(null, "El semestre debe ser mínimo 1.");
                return leerSemestre(mensaje);
            }
            return semestre;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número entero.");
            return leerSemestre(mensaje);
        }
    }

    public static String seleccionarSO() {
        Object[] opciones = {"Windows 7", "Windows 10", "Windows 11"};
        int op = JOptionPane.showOptionDialog(null, "Seleccione Sistema Operativo:", "Sistema Operativo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op < 0) return seleccionarSO();
        return opciones[op].toString();
    }

    public static String seleccionarProcesador() {
        Object[] opciones = {"AMD Ryzen", "Intel® Core™ i5"};
        int op = JOptionPane.showOptionDialog(null, "Seleccione Procesador:", "Procesador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op < 0) return seleccionarProcesador();
        return opciones[op].toString();
    }

    public static String seleccionarAlmacenamiento() {
        Object[] opciones = {"256 GB", "512 GB", "1 TB"};
        int op = JOptionPane.showOptionDialog(null, "Seleccione Almacenamiento:", "Almacenamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op < 0) return seleccionarAlmacenamiento();
        return opciones[op].toString();
    }

    // Búsquedas y utilidades para Ingeniería
    public static EstudianteIngenieria buscarEstudianteIngenieria(String cedula) {
        for (EstudianteIngenieria est : ServicioPrestamoIngenieria.vector_ingenieros)
            if (est.getCedula().equalsIgnoreCase(cedula)) return est;
        return null;
    }

    public static ComputadorPortatil buscarPortatil(String serial) {
        for (ComputadorPortatil portatil : ServicioPrestamoIngenieria.vector_portatil)
            if (portatil.getSerial().equalsIgnoreCase(serial)) return portatil;
        return null;
    }

    public static EstudianteIngenieria buscarEstudianteIngenieriaPorMenu() {
        Object[] opciones = {"Cédula", "Serial"};
        int op = JOptionPane.showOptionDialog(null, "Buscar por:", "Buscar Ingeniería", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op == 0) {
            String cedula = validarCedula("Ingrese cédula:");
            return buscarEstudianteIngenieria(cedula);
        } else if (op == 1) {
            String serial = validarSerial("Ingrese serial:");
            for (EstudianteIngenieria est : ServicioPrestamoIngenieria.vector_ingenieros)
                if (est.getSerialEquipo().equalsIgnoreCase(serial)) return est;
        }
        return null;
    }

    // Búsquedas y utilidades para Diseño
    public static EstudianteDiseno buscarEstudianteDiseno(String cedula) {
        for (EstudianteDiseno est : ServicioPrestamoDiseno.vector_disenadores)
            if (est.getCedula().equalsIgnoreCase(cedula)) return est;
        return null;
    }

    public static TabletaGrafica buscarTableta(String serial) {
        for (TabletaGrafica tab : ServicioPrestamoDiseno.vector_tableta)
            if (tab.getSerial().equalsIgnoreCase(serial)) return tab;
        return null;
    }

    public static TabletaGrafica buscarTabletaPorSerialInt(int serialInt) {
        for (TabletaGrafica tab : ServicioPrestamoDiseno.vector_tableta)
            if (tab.getSerial().hashCode() == serialInt)
                return tab;
        return null;
    }

    public static EstudianteDiseno buscarEstudianteDisenoPorMenu() {
        Object[] opciones = {"Cédula", "Serial"};
        int op = JOptionPane.showOptionDialog(null, "Buscar por:", "Buscar Diseño", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op == 0) {
            String cedula = validarCedula("Ingrese cédula:");
            return buscarEstudianteDiseno(cedula);
        } else if (op == 1) {
            String serial = validarSerial("Ingrese serial:");
            int serialInt = serial.hashCode();
            for (EstudianteDiseno est : ServicioPrestamoDiseno.vector_disenadores)
                if (est.getSerialEquipo() == serialInt) return est;
        }
        return null;
    }
}