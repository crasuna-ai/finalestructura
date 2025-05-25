package finalestructura;

public abstract class EquipoElectronico {
    protected final String serial;
    protected String marca;
    protected float tamanio;
    protected float precio;

    public EquipoElectronico(String serial, String marca, float tamanio, float precio) {
        this.serial = serial;
        this.marca = marca;
        this.tamanio = tamanio;
        this.precio = precio;
    }

    public String getSerial() { return serial; }
    public String getMarca() { return marca; }
    public float getTamanio() { return tamanio; }
    public float getPrecio() { return precio; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setTamanio(float tamanio) { this.tamanio = tamanio; }
    public void setPrecio(float precio) { this.precio = precio; }

    public abstract String toString();
}