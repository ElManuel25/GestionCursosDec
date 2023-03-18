package modelos.menus;

import modelos.entidades.*;

import java.util.LinkedList;
import java.util.List;

public class MenuCursos extends Menu {
    public MenuCursos(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {
        Boolean continuar = true;
        while (continuar) {
            mostrarOpciones("[GESTIÓN DE CURSOS]", "Opciones:",
                    "Ver cursos", "Ver horario", "Agregar curso", "Editar curso", "Gestionar horario",
                    "Eliminar curso", "Volver");
            int opcion = leerOpcion(7);
            switch (opcion) {
                case 1:
                    verCursos(cursos);
                    break;
                case 2:
                    verCursos(cursos);
                    verHorario(cursos);
                    break;
                case 3:
                    agregarCurso(cursos, asignaturas, docentes, salones);
                    break;
                case 4:
                    verCursos(cursos);
                    editarCurso(cursos, asignaturas, docentes, salones);
                    break;
                case 5:
                    verCursos(cursos);
                    gestionarHorario(cursos);
                    break;
                case 6:
                    verCursos(cursos);
                    eliminarCurso(cursos, asignaturas, docentes, salones);
                    break;
                case 7:
                    continuar = false;
                    break;
            }
        }
    }

    private void verCursos(LinkedList<Curso> cursos) {
        System.out.println("- LISTA DE CURSOS -");
        verIterable(cursos);
    }

    private void verHorario(LinkedList<Curso> cursos) {
        if (cursos.size() < 1) {
            System.out.println("[!] No hay cursos registrados.");
        } else {
            System.out.println("Ingresa el índice del curso para ver su horario:");
            int indice = leerOpcion(cursos.size());
            Curso curso = cursos.get(indice - 1);
            curso.getSalon().mostrarHorarioCurso(curso);
        }
    }

    private void agregarCurso(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {
        String codigo = obtenerEntradaTexto("Ingresa el código del curso:");
        System.out.println("- LISTA DE ASIGNATURAS -");
        verIterable(asignaturas);
        if (asignaturas.size() < 1) {
            System.out.println("[!] Es necesario que hayan asignaturas registradas para registrar el curso.");
            return;
        }
        System.out.println("Ingresa el índice de la asignatura:");
        Asignatura asignatura = asignaturas.get(leerOpcion(asignaturas.size()) - 1);
        System.out.println("- LISTA DE DOCENTES -");
        verIterable(docentes);
        if (docentes.size() < 1) {
            System.out.println("[!] Es necesario que hayan docentes registrados para registrar el curso.");
            return;
        }
        System.out.println("Ingresa el índice del docente:");
        Docente docente = docentes.get(leerOpcion(docentes.size()) - 1);
        System.out.println("Ingresa el número de estudiantes:");
        int numeroEstudiantes = obtenerEntradaInt();
        System.out.println("- LISTA DE SALONES -");
        verIterable(salones);
        if (salones.size() < 1) {
            System.out.println("[!] Es necesario que hayan salones registrados para registrar el curso.");
            return;
        }
        System.out.println("Ingresa el índice del salón:");
        Salon salon = salones.get(leerOpcion(salones.size()) - 1);
        cursos.add(new Curso(codigo, asignatura, docente, numeroEstudiantes, salon));
        System.out.println("[!] Curso agregado correctamente.");
    }

    private void editarCurso(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {
        if (cursos.size() < 1) {
            System.out.println("[!] No hay cursos registrados.");
        } else {
            System.out.println("Ingresa el índice del curso a editar:");
            int indice = leerOpcion(cursos.size());
            Curso curso = cursos.get(indice - 1);

            Boolean continuar = true;
            while (continuar) {
                mostrarOpciones("[GESTIÓN DE CURSOS]", "- EDITAR CURSO #" + indice + " -",
                        "Cambiar código", "Cambiar asignatura", "Cambiar docente",
                        "Cambiar número de estudiantes", "Cambiar salón", "Volver");
                int opcion = leerOpcion(6);
                switch (opcion) {
                    case 1:
                        String codigo = obtenerEntradaTexto("Ingresa el nuevo código del curso:");
                        curso.setCodigo(codigo);
                        System.out.println("[!] Código editado correctamente.");
                        break;
                    case 2:
                        System.out.println("- LISTA DE ASIGNATURAS -");
                        verIterable(asignaturas);
                        if (asignaturas.size() < 1) {
                            System.out.println("[!] Es necesario que hayan asignaturas registradas para editar el curso.");
                            return;
                        }
                        System.out.println("Ingresa el índice de la nueva asignatura del curso:");
                        Asignatura asignatura = asignaturas.get(leerOpcion(asignaturas.size()) - 1);
                        curso.setAsignatura(asignatura);
                        System.out.println("[!] Asignatura del curso editada correctamente.");
                        break;
                    case 3:
                        System.out.println("- LISTA DE DOCENTES -");
                        verIterable(docentes);
                        if (docentes.size() < 1) {
                            System.out.println("[!] Es necesario que hayan docentes registrados para editar el curso.");
                            return;
                        }
                        System.out.println("Ingresa el índice del nuevo docente del curso:");
                        Docente docente = docentes.get(leerOpcion(docentes.size()) - 1);
                        curso.setDocente(docente);
                        System.out.println("[!] Docente del curso editado correctamente.");
                        break;
                    case 4:
                        System.out.println("Ingresa el nuevo número de estudiantes:");
                        int numeroEstudiantes = obtenerEntradaInt();
                        curso.setNumeroEstudiantes(numeroEstudiantes);
                        System.out.println("[!] Código editado correctamente.");
                        break;
                    case 5:
                        System.out.println("- LISTA DE SALONES -");
                        verIterable(salones);
                        if (salones.size() < 1) {
                            System.out.println("[!] Es necesario que hayan salones registrados para editar el curso.");
                            return;
                        }
                        System.out.println("Ingresa el índice del nuevo salón del curso:");
                        Salon actualSalon = curso.getSalon();
                        Salon nuevoSalon = salones.get(leerOpcion(salones.size()) - 1);
                        curso.setSalon(nuevoSalon);
                        Boolean sePuedeTrasladar = true;
                        for (List<?> clases : actualSalon.obtenerClasesDeUnCurso(curso)) {
                            Dia dia = (Dia) clases.get(0);
                            Hora hora = (Hora) clases.get(1);
                            if (nuevoSalon.existeClaseEnHorario(dia, hora)) {
                                System.out.println("- No se puede trasladar la clase [" + dia + " " + hora +
                                        "] al nuevo salón por incompatibilidad con otro curso.");
                                sePuedeTrasladar = false;
                            }
                        }
                        if (!sePuedeTrasladar) {
                            System.out.println("[!] No se pudo editar el salón del curso por incompatibilidades.");
                        } else {
                            for (List<?> clases : actualSalon.obtenerClasesDeUnCurso(curso)) {
                                Dia dia = (Dia) clases.get(0);
                                Hora hora = (Hora) clases.get(1);
                                actualSalon.eliminarClaseDelHorario(dia, hora);
                                nuevoSalon.agregarClaseAlHorario(curso, dia, hora);
                            }
                            System.out.println("[!] Salón del curso editado correctamente. " +
                                    "No se encontraron incompatibilidades.");
                        }
                        break;
                    case 6:
                        continuar = false;
                        break;
                }
            }
        }
    }

    private void gestionarHorario(LinkedList<Curso> curso) {

    }

    private void eliminarCurso(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {

    }
}
