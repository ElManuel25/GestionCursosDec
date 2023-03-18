import modelos.entidades.*;
import modelos.menus.MenuPrincipal;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Curso> cursos = new LinkedList<>();
        LinkedList<Asignatura> asignaturas = new LinkedList<>();
        LinkedList<Docente> docentes = new LinkedList<>();
        LinkedList<Salon> salones = new LinkedList<>();

        //Añadir objetos iniciales
        salones.add(new Salon("14-204"));
        salones.add(new Salon("12-310"));
        salones.add(new Salon("3-105"));
        salones.add(new Salon("5-301"));
        docentes.add(new Docente("100", "Juangui"));
        docentes.add(new Docente("200", "Gildardon't"));
        docentes.add(new Docente("300", "Elkin Alias JIJIJI"));
        asignaturas.add(new Asignatura("1", "Pensamiento Algorítmico"));
        asignaturas.add(new Asignatura("2", "Electrónica Digital"));
        asignaturas.add(new Asignatura("3", "Ecuaciones Diferenciales"));
        cursos.add(new Curso("401", asignaturas.get(0), docentes.get(0), 20, salones.get(0)));
        cursos.add(new Curso("402", asignaturas.get(0), docentes.get(1), 18, salones.get(1)));
        cursos.add(new Curso("1", asignaturas.get(2), docentes.get(2), 15, salones.get(3)));
        salones.get(0).agregarClaseAlHorario(cursos.get(0), Dia.LUNES, Hora.De08A10);
        salones.get(0).agregarClaseAlHorario(cursos.get(0), Dia.MIERCOLES, Hora.De08A10);
        salones.get(1).agregarClaseAlHorario(cursos.get(1), Dia.MARTES, Hora.De12A14);
        salones.get(1).agregarClaseAlHorario(cursos.get(1), Dia.JUEVES, Hora.De12A14);
        salones.get(3).agregarClaseAlHorario(cursos.get(2), Dia.MIERCOLES, Hora.De08A10);
        salones.get(3).agregarClaseAlHorario(cursos.get(2), Dia.VIERNES, Hora.De08A10);

        MenuPrincipal menuPrincipal = new MenuPrincipal(cursos, asignaturas, docentes, salones);
    }
}