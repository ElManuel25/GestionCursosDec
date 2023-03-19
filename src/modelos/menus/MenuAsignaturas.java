package modelos.menus;
import modelos.entidades.Asignatura;
import modelos.entidades.Curso;
import java.util.LinkedList;

public class MenuAsignaturas extends Menu {
    public MenuAsignaturas(LinkedList<Asignatura> asignaturas, LinkedList<Curso> cursos) {
        boolean continuar = true;
        while (continuar) {
            String[] opciones = new String[]{
                    "Ver asignaturas", "Agregar asignatura", "Editar asignatura", "Eliminar asignatura", "Volver"
            };
            mostrarOpciones("[GESTIÓN DE ASIGNATURAS]", "Opciones:", opciones);
            int opcion = leerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> verAsignaturas(asignaturas);
                case 2 -> agregarAsignatura(asignaturas);
                case 3 -> editarAsignatura(asignaturas);
                case 4 -> eliminarAsignatura(asignaturas, cursos);
                case 5 -> continuar = false;
            }
        }
    }

    private void verAsignaturas(LinkedList<Asignatura> asignaturas) {
        System.out.println("- LISTA DE ASIGNATURAS -");
        verIterable(asignaturas);
    }

    private void agregarAsignatura(LinkedList<Asignatura> asignaturas) {
        asignaturas.add(new Asignatura(obtenerDatoCodigo(asignaturas), obtenerDatoNombre()));
        System.out.println("[!] Asignatura agregada correctamente");
    }

    private String obtenerDatoCodigo(LinkedList<Asignatura> asignaturas) {
        String codigo = "";
        boolean codigoIncorrecto = true;
        while (codigoIncorrecto) {
            codigo = obtenerEntradaTexto("Ingresa el código de la asignatura:");
            if (!verificarCodigoUnico(codigo, asignaturas)) {
                System.out.println("El código de la asignatura debe ser único, por favor ingrese un código diferente.");
            } else {
                codigoIncorrecto = false;
            }
        }
        return codigo;
    }

    private boolean verificarCodigoUnico(String codigo, LinkedList<Asignatura> asignaturas) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(codigo)) { return false; }
        }
        return true;
    }

    private String obtenerDatoNombre() { return obtenerEntradaTexto("Ingrese el nombre:"); }

    private void editarAsignatura(LinkedList<Asignatura> asignaturas) {
        if (hayAsignaturasRegistradas(asignaturas)) {
            int indice = obtenerIndiceAsignatura(asignaturas);
            Asignatura asignatura = asignaturas.get(indice);
            boolean continuar = true;
            while (continuar) {
                String[] opciones = new String[]{"Cambiar código", "Cambiar nombre", "Volver"};
                mostrarOpciones(
                        "[GESTIÓN DE ASIGNATURAS]",
                        "- EDITAR ASIGNATURA #" + (indice + 1) + " -",
                        opciones
                );
                int opcion = leerOpcion(opciones.length);
                switch (opcion) {
                    case 1 -> {
                        asignatura.setCodigo(obtenerDatoCodigo(asignaturas));
                        System.out.println("[!] Código editado correctamente.");
                    }
                    case 2 -> {
                        asignatura.setNombre(obtenerDatoNombre());
                        System.out.println("[!] Nombre editado correctamente.");
                    }
                    case 3 -> continuar = false;
                }
            }
        }
    }

    private void eliminarAsignatura(LinkedList<Asignatura> asignaturas, LinkedList<Curso> cursos) {
        if (hayAsignaturasRegistradas(asignaturas)) {
            int indice = obtenerIndiceAsignatura(asignaturas);
            if (verificarEliminarAsignatura(asignaturas.get(indice), cursos)) {
                asignaturas.remove(indice);
                System.out.println("[!] Asignatura eliminada correctamente.");
            } else {
                System.out.println("[!] No se puede eliminar la asignatura porque hay cursos registrados para ella.");
            }
        }
    }

    private int obtenerIndiceAsignatura(LinkedList<Asignatura> asignaturas) {
        verAsignaturas(asignaturas);
        System.out.println("Ingresa el índice de la asignatura:");
        return leerOpcion(asignaturas.size()) - 1;
    }

    private boolean hayAsignaturasRegistradas(LinkedList<Asignatura> asignaturas) {
        if (asignaturas.size() == 0) {
            System.out.println("[!] No hay asignaturas registradas.");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean verificarEliminarAsignatura(Asignatura asignatura, LinkedList<Curso> cursos) {
        for (Curso curso : cursos) {
            if (curso.getAsignatura() == asignatura) { return false; }
        }
        return true;
    }
}