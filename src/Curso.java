public class Curso {
    private final String codigo;
    private Asignatura asignatura;
    private Docente docente;
    private int numeroEstudiantes;
    public String getCodigo() {
        return codigo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getNumeroEstudiantes() {
        return numeroEstudiantes;
    }

    public void setNumeroEstudiantes(int numeroEstudiantes) {
        this.numeroEstudiantes = numeroEstudiantes;
    }

    public Curso(String codigo, Asignatura asignatura, Docente docente, int numeroEstudiantes) {
        this.codigo = codigo;
        this.asignatura = asignatura;
        this.docente = docente;
        this.numeroEstudiantes = numeroEstudiantes;
    }
}
