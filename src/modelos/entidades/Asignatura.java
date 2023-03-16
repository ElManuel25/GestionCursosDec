package modelos.entidades;

public class Asignatura {
    private final String codigo;
    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura (String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
