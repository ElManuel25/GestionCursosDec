package modelos.entidades;

import java.util.LinkedList;

public class Curso {
    private String codigo;
    private Asignatura asignatura;
    private Docente docente;
    private int numeroEstudiantes;
    private Salon salon;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) { this.codigo = codigo; }

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

    public Salon getSalon() { return salon; }

    public void setSalon(Salon salon) { this.salon = salon; }

    public Curso(String codigo, Asignatura asignatura, Docente docente, int numeroEstudiantes, Salon salon) {
        this.codigo = codigo;
        this.asignatura = asignatura;
        this.docente = docente;
        this.numeroEstudiantes = numeroEstudiantes;
        this.salon = salon;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", asignatura=" + asignatura +
                ", docente=" + docente +
                ", numeroEstudiantes=" + numeroEstudiantes +
                ", salon=" + salon +
                '}';
    }
}
