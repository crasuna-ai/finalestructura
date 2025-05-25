package finalestructura;

public class TabletaGrafica extends EquipoElectronico {
    private String almacenamiento;
    private float peso;

    public TabletaGrafica(String serial, String marca, float tamanio, float precio,
                          String almacenamiento, float peso) {
        super(serial, marca, tamanio, precio);
        this.almacenamiento = almacenamiento;
        this.peso = peso;
    }

    public String getAlmacenamiento() { return almacenamiento; }
    public void setAlmacenamiento(String almacenamiento) { this.almacenamiento = almacenamiento; }
    public float getPeso() { return peso; }
    public void setPeso(float peso) { this.peso = peso; }

    @Override
    public String toString() {
        return "Tableta [Serial: " + serial + ", Marca: " + marca + ", Tamaño: " + tamanio +
               "\", Precio: $" + precio + ", Almacenamiento: " + almacenamiento + ", Peso: " + peso + "kg]";
    }
}