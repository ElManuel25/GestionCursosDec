public class Docente {
    private final String documento;
    private String nombre;

    public String getDocumento() {
        return documento;
    }

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
}
