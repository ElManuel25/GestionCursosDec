package modelos.menus;

import modelos.entidades.Curso;
import modelos.entidades.Asignatura;
import modelos.entidades.Docente;
import modelos.entidades.Salon;

import java.util.LinkedList;

public class MenuPrincipal extends Menu {
    public MenuPrincipal(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {
        boolean continuar = true;
        while (continuar) {
            String[] opciones = new String[]{
                    "GESTIÓN DE CURSOS", "GESTIÓN DE ASIGNATURAS", "GESTIÓN DE DOCENTES", "GESTIÓN DE SALONES", "SALIR"
            };
            mostrarOpciones("===== MENÚ PRINCIPAL =====", "Opciones:", opciones);
            int opcion = leerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> {
                    MenuCursos menuCursos = new MenuCursos(cursos, asignaturas, docentes, salones);
                }
                case 2 -> {
                    MenuAsignaturas menuAsignaturas = new MenuAsignaturas(asignaturas, cursos);
                }
                case 3 -> {
                    MenuDocentes menuDocentes = new MenuDocentes(docentes, cursos);
                }
                case 4 -> {
                    MenuSalones menuSalones = new MenuSalones(salones, cursos);
                }
                case 5 -> {
                    System.out.println("[!] Saliendo del programa...");
                    continuar = false;
                }
            }
        }
    }
}