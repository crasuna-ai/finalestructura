package finalestructura;

public class EstudianteIngenieria extends Estudiantes {
    private int semestre;
    private float promedio;
    private final String serialEquipo;

    public EstudianteIngenieria(String cedula, String nombre, String apellido, String telefono,
                               int semestre, float promedio, String serialEquipo) {
        super(cedula, nombre, apellido, telefono);
        this.semestre = semestre;
        this.promedio = promedio;
        this.serialEquipo = serialEquipo;
    }

    public int getSemestre() { return semestre; }
    public float getPromedio() { return promedio; }
    public String getSerialEquipo() { return serialEquipo; }

    public void setSemestre(int semestre) { this.semestre = semestre; }
    public void setPromedio(float promedio) { this.promedio = promedio; }

    @Override
    public String toString() {
        return "Ingeniería: " + nombre + " " + apellido + " [Cédula: " + cedula + ", Tel: " + telefono +
               ", Semestre: " + semestre + ", Promedio: " + promedio + ", Serial: " + serialEquipo + "]";
    }
}