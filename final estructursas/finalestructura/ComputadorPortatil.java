package finalestructura;

public class ComputadorPortatil extends EquipoElectronico {
    private String sistemaOperativo;
    private String procesador;

    public ComputadorPortatil(String serial, String marca, float tamanio, float precio,
                              String sistemaOperativo, String procesador) {
        super(serial, marca, tamanio, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public String getSistemaOperativo() { return sistemaOperativo; }
    public void setSistemaOperativo(String so) { this.sistemaOperativo = so; }
    public String getProcesador() { return procesador; }
    public void setProcesador(String procesador) { this.procesador = procesador; }

    @Override
    public String toString() {
        return "Portátil [Serial: " + serial + ", Marca: " + marca + ", Tamaño: " + tamanio +
               "\", Precio: $" + precio + ", SO: " + sistemaOperativo + ", CPU: " + procesador + "]";
    }
}