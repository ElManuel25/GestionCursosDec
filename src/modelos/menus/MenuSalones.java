package modelos.menus;
import modelos.entidades.Salon;
import modelos.entidades.Curso;
import java.util.LinkedList;

public class MenuSalones extends Menu {
    public MenuSalones(LinkedList<Salon> salones, LinkedList<Curso> cursos) {
        boolean continuar = true;
        while (continuar) {
            String[] opciones = new String[]{
                    "Ver salones", "Ver horario", "Agregar salón", "Editar salón", "Eliminar salón", "Volver"
            };
            mostrarOpciones("[GESTIÓN DE SALONES]", "Opciones:", opciones);
            int opcion = leerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> verSalones(salones);
                case 2 -> verHorario(salones);
                case 3 -> agregarSalon(salones);
                case 4 -> editarSalon(salones);
                case 5 -> eliminarSalon(salones, cursos);
                case 6 -> continuar = false;
            }
        }
    }

    private void verSalones(LinkedList<Salon> salones) {
        System.out.println("- LISTA DE SALONES -");
        verIterable(salones);
    }

    private void verHorario(LinkedList<Salon> salones) {
        if (haySalonesRegistrados(salones)) {
            salones.get(obtenerIndiceSalon(salones)).mostrarHorario();
        }
    }

    private void agregarSalon(LinkedList<Salon> salones) {
        salones.add(new Salon(obtenerDatoCodigo(salones)));
        System.out.println("[!] Salón agregado correctamente.");
    }

    private String obtenerDatoCodigo(LinkedList<Salon> salones) {
        String codigo = "";
        boolean codigoIncorrecto = true;
        while (codigoIncorrecto) {
            codigo = obtenerEntradaTexto("Ingresa el código del salón:");
            if (!verificarCodigoUnico(codigo, salones)) {
                System.out.println("El código del salón debe ser único, por favor ingrese un código diferente.");
            } else {
                codigoIncorrecto = false;
            }
        }
        return codigo;
    }

    private boolean verificarCodigoUnico(String codigo, LinkedList<Salon> salones) {
        for (Salon salon : salones) {
            if (salon.getCodigo().equals(codigo)) { return false; }
        }
        return true;
    }

    private void editarSalon(LinkedList<Salon> salones) {
        if (haySalonesRegistrados(salones)) {
            int indice = obtenerIndiceSalon(salones);
            Salon salon = salones.get(indice);
            boolean continuar = true;
            while (continuar) {
                String[] opciones = new String[]{"Cambiar código", "Volver"};
                mostrarOpciones(
                        "[GESTIÓN DE SALONES]",
                        "- EDITAR SALÓN #" + (indice + 1) + " -",
                        opciones
                );
                int opcion = leerOpcion(opciones.length);
                switch (opcion) {
                    case 1 -> {
                        salon.setCodigo(obtenerDatoCodigo(salones));
                        System.out.println("[!] Código editado correctamente.");
                    }
                    case 2 -> continuar = false;
                }
            }
        }
    }

    private void eliminarSalon(LinkedList<Salon> salones, LinkedList<Curso> cursos) {
        if (haySalonesRegistrados(salones)) {
            int indice = obtenerIndiceSalon(salones);
            if (verificarEliminarSalon(salones.get(indice), cursos)) {
                salones.remove(indice);
                System.out.println("[!] Salón eliminado correctamente.");
            } else {
                System.out.println("[!] No se puede eliminar el salón porque hay cursos registrados allí.");
            }
        }
    }

    private int obtenerIndiceSalon(LinkedList<Salon> salones) {
        verSalones(salones);
        System.out.println("Ingresa el índice del salón:");
        return leerOpcion(salones.size()) - 1;
    }

    private boolean haySalonesRegistrados(LinkedList<Salon> salones) {
        if (salones.size() == 0) {
            System.out.println("[!] No hay salones registrados.");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean verificarEliminarSalon(Salon salon, LinkedList<Curso> cursos) {
        for (Curso curso : cursos) {
            if (curso.getSalon() == salon) { return false; }
        }
        return true;
    }
}