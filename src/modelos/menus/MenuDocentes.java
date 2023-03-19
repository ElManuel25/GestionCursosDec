package modelos.menus;
import modelos.entidades.Curso;
import modelos.entidades.Docente;
import java.util.LinkedList;

public class MenuDocentes extends Menu{
    public MenuDocentes(LinkedList<Docente> docentes, LinkedList<Curso> cursos) {
        boolean continuar = true;
        while(continuar) {
            String[] opciones = new String[]{
                    "Ver docentes","Agregar docente","Editar docente","Eliminar docente", "Volver"
            };
            mostrarOpciones("[GESTIÓN DE DOCENTES]","Opciones:", opciones);
            int opcion = leerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> verDocentes(docentes);
                case 2 -> agregarDocente(docentes);
                case 3 -> editarDocente(docentes);
                case 4 -> eliminarDocente(docentes, cursos);
                case 5 -> continuar = false;
            }
        }
    }

    private void verDocentes(LinkedList<Docente> docentes){
        System.out.println("- LISTA DE DOCENTES -");
        verIterable(docentes);
    }

    private void agregarDocente(LinkedList<Docente> docentes){
        docentes.add(new Docente(obtenerDatoDocumento(docentes), obtenerDatoNombre()));
        System.out.println("[!] Docente agregado correctamente");
    }

    private String obtenerDatoDocumento(LinkedList<Docente> docentes) {
        String documento = "";
        boolean documentoIncorrecto = true;
        while (documentoIncorrecto) {
            documento = obtenerEntradaTexto("Ingresa el documento del documente:");
            if (!verificarDocumentoUnico(documento, docentes)) {
                System.out.println("El documento del docente debe ser único, por favor ingrese un documento diferente.");
            } else {
                documentoIncorrecto = false;
            }
        }
        return documento;
    }

    private boolean verificarDocumentoUnico(String documento, LinkedList<Docente> docentes){
        for(Docente Docente:docentes){
            if(Docente.getDocumento().equals(documento)){ return false; }
        }
        return  true;
    }

    private String obtenerDatoNombre() { return obtenerEntradaTexto("Ingrese el nombre:"); }

    private void editarDocente(LinkedList<Docente> docentes){
        if (hayDocentesRegistrados(docentes)) {
            int indice = obtenerIndiceDocente(docentes);
            Docente docente = docentes.get(indice);
            boolean continuar = true;
            while (continuar) {
                String[] opciones = new String[]{"Cambiar documento", "Cambiar nombre", "Volver"};
                mostrarOpciones(
                        "[GESTIÓN DE DOCENTE]",
                        "- EDITAR DOCENTE #" + (indice + 1) + " -",
                        opciones
                );
                int opcion = leerOpcion(opciones.length);
                switch (opcion) {
                    case 1 -> {
                        docente.setDocumento(obtenerDatoDocumento(docentes));
                        System.out.println("[!] Documento editado correctamente.");
                    }
                    case 2 -> {
                        docente.setNombre(obtenerDatoNombre());
                        System.out.println("[!] Nombre editado correctamente.");
                    }
                    case 3 -> continuar = false;
                }
            }
        }
    }

    private void eliminarDocente(LinkedList<Docente> docentes, LinkedList<Curso> cursos){
        if (hayDocentesRegistrados(docentes)) {
            int indice = obtenerIndiceDocente(docentes);
            if (verificarEliminarDocente(docentes.get(indice), cursos)) {
                docentes.remove(indice);
                System.out.println("[!] Docente eliminado correctamente.");
            } else {
                System.out.println("[!] No se puede eliminar el docente porque hay cursos registrados con él.");
            }
        }
    }

    private int obtenerIndiceDocente(LinkedList<Docente> docentes) {
        verDocentes(docentes);
        System.out.println("Ingresa el índice del docente:");
        return leerOpcion(docentes.size()) - 1;
    }

    private boolean hayDocentesRegistrados(LinkedList<Docente> docentes) {
        if (docentes.size() == 0) {
            System.out.println("[!] No hay docentes registrados.");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean verificarEliminarDocente(Docente asignatura, LinkedList<Curso> cursos) {
        for (Curso curso : cursos) {
            if (curso.getDocente() == asignatura) { return false; }
        }
        return true;
    }
}