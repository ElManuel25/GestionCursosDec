import modelos.entidades.*;
import modelos.menus.MenuPrincipal;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Curso> cursos = new LinkedList<>();
        LinkedList<Asignatura> asignaturas = new LinkedList<>();
        LinkedList<Docente> docentes = new LinkedList<>();
        LinkedList<Salon> salones = new LinkedList<>();
        MenuPrincipal menuPrincipal = new MenuPrincipal(cursos, asignaturas, docentes, salones);
    }
}