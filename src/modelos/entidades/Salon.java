package modelos.entidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Salon {
    private String codigo;
    private Curso[][] horario;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Salon(String codigo) {
        this.codigo = codigo;
        this.horario = new Curso[5][8];
    }

    public void mostrarHorario() {
        System.out.println("=".repeat(64) + " HORARIO DEL SALÓN " + codigo + " ".repeat(6) + "=".repeat(64));
        System.out.printf("| HORA  | %-26s | %-26s | %-26s | %-26s | %-26s |\n", Dia.LUNES, Dia.MARTES, Dia.MIERCOLES, Dia.JUEVES, Dia.VIERNES);
        System.out.println("|-------|" + "--------------------------|".repeat(5));
        for (int i = 0; i < Hora.values().length; i++) {
            String[] clasesHora = new String[5];
            for (int j = 0; j < Dia.values().length; j++) {
                if (horario[j][i] == null) {
                    clasesHora[j] = "";
                } else {
                    String nombreAsignatura = horario[j][i].getAsignatura().getNombre();
                    if (nombreAsignatura.length() > 21) {
                        nombreAsignatura = nombreAsignatura.substring(0, 20);
                    }
                    clasesHora[j] = nombreAsignatura + " (" + horario[j][i].getCodigo() + ")";
                }
            }
            System.out.printf("| " + horaAString(Hora.values()[i]) + " | %-26s | %-26s | %-26s | %-26s | %-26s |%n", clasesHora);
        }
        System.out.println("=".repeat(154));
    }


    public void mostrarHorarioCurso(Curso curso) {
        System.out.printf("=".repeat(50) + " HORARIO DEL CURSO %-28S (%-3s) " + "=".repeat(50) + "%n",
                curso.getAsignatura().getNombre(), curso.getCodigo());
        System.out.printf("| HORA  | %-26s | %-26s | %-26s | %-26s | %-26s |%n", (Object[]) Dia.values());
        System.out.printf("| ----- |" + " -------------------------- |".repeat(5) + "%n");
        for (int i = 0; i < 8; i++) {
            String[] clasesHora = new String[5];
            for (int j = 0; j < 5; j++) {
                if (horario[j][i] == curso) {
                    clasesHora[j] = "Salón " + codigo;
                }
                else {
                    clasesHora[j] = "";
                }
            }
            System.out.printf("| " +
                    horaAString(Hora.values()[i]) +
                    " | %-26s | %-26s | %-26s | %-26s | %-26s |%n", clasesHora);
        }
        System.out.printf("=".repeat(154) + "%n");
    }

    public boolean existeClaseEnHorario(Dia dia, Hora hora) { return horario[dia.ordinal()][hora.ordinal()] != null; }

    public boolean agregarClaseAlHorario(Curso curso, Dia dia, Hora hora) {
        if (existeClaseEnHorario(dia, hora)) {
            return false;
        }
        else {
            horario[dia.ordinal()][hora.ordinal()] = curso;
            return true;
        }
    }

    public boolean eliminarClaseDelHorario(Dia dia, Hora hora) {
        horario[dia.ordinal()][hora.ordinal()] = null;
        return true;
    }

    public LinkedList<LinkedList<?>> obtenerClasesDeUnCurso(Curso curso) {
        LinkedList<LinkedList<?>> clasesDelCurso = new LinkedList<>();
        IntStream.range(0, 5).boxed().flatMap(i -> IntStream.range(0, 8).filter(j -> horario[i][j] == curso).mapToObj(j -> new LinkedList<>(List.of(Dia.values()[i], Hora.values()[j]))))
                .forEach(clasesDelCurso::add);
        return clasesDelCurso;
    }


    private String horaAString(Hora hora) {
        return hora.toString().replaceAll("De", "").replaceAll("A", "-");
    }

    @Override
    public String toString() {
        return "Salon{" + "codigo='" + codigo + '\'' + '}';
    }
}
