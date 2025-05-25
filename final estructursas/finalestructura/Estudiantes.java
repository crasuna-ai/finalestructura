package finalestructura;

public abstract class Estudiantes {
    protected final String cedula;
    protected String nombre;
    protected String apellido;
    protected String telefono;

    public Estudiantes(String cedula, String nombre, String apellido, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public abstract String toString();
}