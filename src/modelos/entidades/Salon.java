package modelos.entidades;

import java.util.Arrays;

public class Salon {
    private String codigo;
    private Curso[][] horario;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso[][] getHorario() {
        return horario;
    }

    public Salon(String codigo) {
        this.codigo = codigo;
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
                    String nombreAsignatura = horario[j][i].getAsignatura().getNombre();
                    if (nombreAsignatura.length() > 21) {
                        nombreAsignatura = nombreAsignatura.substring(0, 20);
                    }
                    clasesHora[j] = nombreAsignatura +
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

    public Boolean eliminarClaseDelHorario(Curso curso, Dia dia, Hora hora) {
        if (this.horario[dia.ordinal()][hora.ordinal()] == null) {
            return true;
        } else if (this.horario[dia.ordinal()][hora.ordinal()] == curso) {
            this.horario[dia.ordinal()][hora.ordinal()] = null;
            return true;
        } else {
            return false;
        }
    }

    public Boolean eliminarClaseDelHorario(Dia dia, Hora hora) {
        if (this.horario[dia.ordinal()][hora.ordinal()] != null) {
            this.horario[dia.ordinal()][hora.ordinal()] = null;
        }
        return true;
    }

    public void resetearHorario() {
        this.horario = new Curso[5][8];
    }

    private String horaAString(Hora hora) {
        return hora.toString().replaceAll("De", "").replaceAll("A", "-");
    }

    @Override
    public String toString() {
        return "Salon{" +
                "codigo='" + codigo + '\'' +
                '}';
    }
}
