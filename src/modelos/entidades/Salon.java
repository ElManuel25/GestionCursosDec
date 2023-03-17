package modelos.entidades;

import java.util.Arrays;

public class Salon {
    private final String codigo;
    private String descripcion;
    private Curso[][] horario;

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Curso[][] getHorario() {
        return horario;
    }

    public void setHorario(Curso[][] horario) {
        this.horario = horario;
    }

    public Salon(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.horario = new Curso[5][8];
    }

    public void mostrarHorario() {
        System.out.printf("=".repeat(64) + " HORARIO DEL SALÓN %-6s " + "=".repeat(64) + "%n", codigo);
        System.out.printf("| HORA  | %-26s | %-26s | %-26s | %-26s | %-26s |%n", (Object[]) Dia.values());
        System.out.printf("| ----- |" + " -------------------------- |".repeat(5) + "%n");
        for (int i = 0; i < 8; i++) {
            String[] clasesHora = new String[5];
            for (int j = 0; j < 5; j++) {
                if (horario[j][i] == null) {
                    clasesHora[j] = "";
                } else {
                    clasesHora[j] = horario[j][i].getAsignatura().getNombre().substring(0, 20) +
                            " (" +
                            horario[j][i].getCodigo() +
                            ")";
                }
            }
            System.out.printf("| " +
                    horaAString(Hora.values()[i]) +
                    " | %-26s | %-26s | %-26s | %-26s | %-26s |%n", clasesHora);
        }
        System.out.printf("=".repeat(154) + "%n");
    }

    public Boolean agregarClaseAlHorario(Curso curso, Dia dia, Hora hora) {
        if (this.horario[dia.ordinal()][hora.ordinal()] == null) {
            this.horario[dia.ordinal()][hora.ordinal()] = curso;
            return true;
        } else {
            return false;
        }
    }

    private String horaAString(Hora hora) {
        return hora.toString().replaceAll("De", "").replaceAll("A", "-");
    }

    @Override
    public String toString() {
        return "Salon{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
