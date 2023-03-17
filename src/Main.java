import modelos.entidades.*;
import modelos.menus.MenuPrincipal;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Asignatura> asignaturas = new LinkedList<>();
        LinkedList<Docente> docentes = new LinkedList<>();
        LinkedList<Salon> salones = new LinkedList<>();
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        /* PRUEBA PRINT HORARIO DE UN SALÓN
        Salon salon = new Salon("12-302", "Bloque 12 Aula 302");
        Asignatura aPenAlg = new Asignatura("304", "Pensamiento Algorítmico");
        Docente d1 = new Docente("100", "Gildardon't");
        Curso cPenAlg1 = new Curso("1", aPenAlg, d1, 20, salon);
        salon.agregarClaseAlHorario(cPenAlg1, Dia.LUNES, Hora.De10A12);
        salon.agregarClaseAlHorario(cPenAlg1, Dia.MIERCOLES, Hora.De10A12);
        salon.mostrarHorario();
         */
    }
}