package modelos.entidades;

public class Docente {
    private String documento;
    private String nombre;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) { this.documento = documento; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente(String documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
