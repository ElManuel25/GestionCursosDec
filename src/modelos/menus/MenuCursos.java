package modelos.menus;
import modelos.entidades.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class MenuCursos extends Menu {
    public MenuCursos(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {
        boolean continuar = true;
        while (continuar) {
            String[] opciones = new String[]{
                    "Ver cursos", "Ver horario", "Agregar curso", "Editar curso",
                    "Gestionar horario", "Eliminar curso", "Volver"
            };
            mostrarOpciones("[GESTIÓN DE CURSOS]", "Opciones:", opciones);
            int opcion = leerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> verCursos(cursos);
                case 2 -> verHorario(cursos);
                case 3 -> agregarCurso(cursos, asignaturas, docentes, salones);
                case 4 -> editarCurso(cursos, asignaturas, docentes, salones);
                case 5 -> gestionarHorario(cursos);
                case 6 -> eliminarCurso(cursos, salones);
                case 7 -> continuar = false;
            }
        }
    }

    private void verCursos(LinkedList<Curso> cursos) {
        System.out.println("- LISTA DE CURSOS -");
        verIterable(cursos);
    }

    private void verAsignaturas(LinkedList<Asignatura> asignaturas) {
        System.out.println("- LISTA DE ASIGNATURAS -");
        verIterable(asignaturas);
    }

    private void verDocentes(LinkedList<Docente> docentes) {
        System.out.println("- LISTA DE DOCENTES -");
        verIterable(docentes);
    }

    private void verSalones(LinkedList<Salon> salones) {
        System.out.println("- LISTA DE SALONES -");
        verIterable(salones);
    }

    private void verHorario(LinkedList<Curso> cursos) {
        if (hayCursosRegistrados(cursos)) {
            cursos.get(obtenerIndiceCurso(cursos)).mostrarHorario();
        }
    }

    private void agregarCurso(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {
        String codigo = obtenerDatoCodigo(cursos);
        Asignatura asignatura = obtenerDatoAsignatura(asignaturas);
        Docente docente = obtenerDatoDocente(docentes);
        int numeroEstudiantes = obtenerDatosNumeroEstudiantes();
        Salon salon = obtenerDatoSalon(salones);
        if (asignatura != null && docente != null && salon != null) {
            cursos.add(new Curso(codigo, asignatura, docente, numeroEstudiantes, salon));
            System.out.println("[!] Curso agregado correctamente.");
        }
        else {
            System.out.println("[!] No se pudo añadir el curso.");
        }
    }

    //DECLARATIVO
    private String obtenerDatoCodigo(LinkedList<Curso> cursos) {
        return Stream.generate(() -> obtenerEntradaTexto("Ingresa el código del curso:"))
                .filter(codigo -> verificarCodigoUnico(codigo, cursos))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se ha ingresado un código válido."));
    }


    private boolean verificarCodigoUnico(String codigo, LinkedList<Curso> cursos) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) { return false; }
        }
        return true;
    }

    private Asignatura obtenerDatoAsignatura(LinkedList<Asignatura> asignaturas) {
        verAsignaturas(asignaturas);
        if (asignaturas.size() == 0) {
            System.out.println("[!] Es necesario que hayan asignaturas registradas.");
            return null;
        }
        System.out.println("Ingresa el índice de la asignatura:");
        return asignaturas.get(leerOpcion(asignaturas.size()) - 1);
    }

    private Docente obtenerDatoDocente(LinkedList<Docente> docentes) {
        verDocentes(docentes);
        if (docentes.size() == 0) {
            System.out.println("[!] Es necesario que hayan docentes registrados.");
            return null;
        }
        System.out.println("Ingresa el índice del docente:");
        return docentes.get(leerOpcion(docentes.size()) - 1);
    }

    private int obtenerDatosNumeroEstudiantes() {
        System.out.println("Ingresa el número de estudiantes:");
        return obtenerEntradaInt();
    }

    private Salon obtenerDatoSalon(LinkedList<Salon> salones) {
        verSalones(salones);
        if (salones.size() == 0) {
            System.out.println("[!] Es necesario que hayan salones registrados.");
            return null;
        }
        System.out.println("Ingresa el índice del salón:");
        return salones.get(leerOpcion(salones.size()) - 1);
    }

    private void editarCurso(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {
        if (hayCursosRegistrados(cursos)) {
            int indice = obtenerIndiceCurso(cursos);
            Curso curso = cursos.get(indice);
            boolean continuar = true;
            while (continuar) {
                String[] opciones = new String[]{
                        "Cambiar código", "Cambiar asignatura", "Cambiar docente",
                        "Cambiar número de estudiantes", "Cambiar salón", "Volver"
                };
                mostrarOpciones("[GESTIÓN DE CURSOS]", "- EDITAR CURSO #" + indice + " -", opciones);
                int opcion = leerOpcion(opciones.length);
                switch (opcion) {
                    case 1 -> {
                        curso.setCodigo(obtenerDatoCodigo(cursos));
                        System.out.println("[!] Código editado correctamente.");
                    }
                    case 2 -> {
                        Asignatura asignatura = obtenerDatoAsignatura(asignaturas);
                        if (asignatura != null) {
                            curso.setAsignatura(asignatura);
                            System.out.println("[!] Asignatura del curso editada correctamente.");
                        } else {
                            System.out.println("[!] No se pudo modificar la asignatura del curso.");
                        }
                    }
                    case 3 -> {
                        Docente docente = obtenerDatoDocente(docentes);
                        if (docente != null) {
                            curso.setDocente(docente);
                            System.out.println("[!] Docente del curso editado correctamente.");
                        } else {
                            System.out.println("[!] No se pudo modificar el docente del curso.");
                        }
                    }
                    case 4 -> {
                        curso.setNumeroEstudiantes(obtenerDatosNumeroEstudiantes());
                        System.out.println("[!] Código editado correctamente.");
                    }
                    case 5 -> {
                        Salon actualSalon = curso.getSalon();
                        Salon nuevoSalon = obtenerDatoSalon(salones);
                        if (nuevoSalon != null) {
                            boolean sePuedeTrasladar = true;
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
                                curso.setSalon(nuevoSalon);
                                System.out.println("[!] Salón del curso editado correctamente. " +
                                        "No se encontraron incompatibilidades.");
                            }
                        } else {
                            System.out.println("[!] No se pudo modificar el salón del curso.");
                        }
                    }
                    case 6 -> continuar = false;
                }
            }
        }
    }

    private void gestionarHorario(LinkedList<Curso> cursos) {
        if (cursos.size() < 1) {
            System.out.println("[!] No hay cursos registrados.");
        } else {
            int indice = obtenerIndiceCurso(cursos);
            Curso curso = cursos.get(indice);
            boolean continuar = true;
            while (continuar) {
                verClases(curso);
                String[] opciones = new String[]{"Añadir clase", "Eliminar clase", "Volver"};
                mostrarOpciones("[GESTIÓN DE CURSOS]", "- GESTIONAR HORARIO CURSO #" + (indice + 1) + " -",
                        opciones);
                int opcion = leerOpcion(opciones.length);
                switch (opcion) {
                    case 1 -> {
                        System.out.println("- Elige el día de la clase -");
                        verIterable(new LinkedList<>(List.of(Dia.values())));
                        System.out.println("Ingresa el índice del día:");
                        Dia dia = Dia.values()[leerOpcion(Dia.values().length) - 1];
                        System.out.println("- Elige la hora de la clase -");
                        verIterable(new LinkedList<>(List.of(Hora.values())));
                        System.out.println("Ingresa el índice de la hora:");
                        Hora hora = Hora.values()[leerOpcion(Hora.values().length) - 1];
                        if (curso.getSalon().agregarClaseAlHorario(curso, dia, hora)) {
                            System.out.println("[!] Clase añadida correctamente.");
                        } else {
                            System.out.println("[!] No se pudo añadir la clase por incompatibilidad con otro curso en" +
                                    " el salón [" + curso.getSalon().getCodigo() + "].");
                        }
                    }
                    case 2 -> {
                        LinkedList<LinkedList<?>> clases = curso.getSalon().obtenerClasesDeUnCurso(curso);
                        if (clases.size() == 0) {
                            System.out.println("[!] No hay clases registradas para este curso.");
                        } else {
                            verClases(curso);
                            System.out.println("Ingresa el índice de la clase a eliminar:");
                            int indiceClase = leerOpcion(clases.size()) - 1;
                            Dia diaClase = (Dia) clases.get(indiceClase).get(0);
                            Hora horaClase = (Hora) clases.get(indiceClase).get(1);
                            curso.getSalon().eliminarClaseDelHorario(diaClase, horaClase);
                            System.out.println("[!] Clase eliminada correctamente.");
                        }
                    }
                    case 3 -> continuar = false;
                }
            }
        }
    }

    private void verClases(Curso curso) {
        System.out.println("- LISTA DE CLASES A LA SEMANA DEL CURSO [SALÓN " +
                curso.getSalon().getCodigo() + "] -");
        verIterable(curso.getSalon().obtenerClasesDeUnCurso(curso));
    }

    private void eliminarCurso(LinkedList<Curso> cursos, LinkedList<Salon> salones) {
        if (hayCursosRegistrados(cursos)) {
            int indice = obtenerIndiceCurso(cursos);
            Curso curso = cursos.get(indice);
            for (List<?> clases : curso.getSalon().obtenerClasesDeUnCurso(curso)) {
                Dia dia = (Dia) clases.get(0);
                Hora hora = (Hora) clases.get(1);
                curso.getSalon().eliminarClaseDelHorario(dia, hora);
            }
            salones.remove(indice);
            System.out.println("[!] Curso eliminado correctamente.");
        }
    }

    private int obtenerIndiceCurso(LinkedList<Curso> cursos) {
        verCursos(cursos);
        System.out.println("Ingresa el índice del curso:");
        return leerOpcion(cursos.size()) - 1;
    }
    //RECORTADO
    private boolean hayCursosRegistrados(LinkedList<Curso> cursos) {
        boolean hayCursos = cursos.size() > 0;
        if (!hayCursos) {
            System.out.println("[!] No hay cursos registrados.");
        }
        return hayCursos;
    }
}
