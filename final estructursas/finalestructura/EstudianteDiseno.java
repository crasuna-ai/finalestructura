package finalestructura;

public class EstudianteDiseno extends Estudiantes {
    private String modalidad;
    private int cantAsignaturas;
    private final int serialEquipo;

    public EstudianteDiseno(String cedula, String nombre, String apellido, String telefono,
                            String modalidad, int cantAsignaturas, int serialEquipo) {
        super(cedula, nombre, apellido, telefono);
        this.modalidad = modalidad;
        this.cantAsignaturas = cantAsignaturas;
        this.serialEquipo = serialEquipo;
    }

    public String getModalidad() { return modalidad; }
    public int getCantAsignaturas() { return cantAsignaturas; }
    public int getSerialEquipo() { return serialEquipo; }

    public void setModalidad(String modalidad) { this.modalidad = modalidad; }
    public void setCantAsignaturas(int cantAsignaturas) { this.cantAsignaturas = cantAsignaturas; }

    @Override
    public String toString() {
        return "Diseño: " + nombre + " " + apellido + " [Cédula: " + cedula + ", Tel: " + telefono +
               ", Modalidad: " + modalidad + ", Asignaturas: " + cantAsignaturas + ", Serial: " + serialEquipo + "]";
    }
}