package modelos.menus;

import modelos.entidades.Salon;

import java.util.LinkedList;

public class MenuSalones extends Menu {
    public MenuSalones(LinkedList<Salon> salones) {
        Boolean continuar = true;
        while (continuar) {
            mostrarOpciones("[GESTIÓN DE SALONES]", "Opciones:",
                    "Ver salones", "Agregar salón", "Editar salón", "Eliminar salón", "Volver");
            int opcion = leerOpcion(5);
            switch (opcion) {
                case 1:
                    verSalones(salones);
                    break;
                case 2:
                    agregarSalon(salones);
                    break;
                case 3:
                    verSalones(salones);
                    editarSalon(salones);
                    break;
                case 4:
                    verSalones(salones);
                    eliminarSalon(salones);
                    break;
                case 5:
                    continuar = false;
                    break;
            }
        }
    }

    private void verSalones(LinkedList<Salon> salones) {
        System.out.println("- LISTA DE SALONES -");
        verIterable(salones);
    }

    private void agregarSalon(LinkedList<Salon> salones) {
        String codigo = obtenerEntradaTexto("Ingresa el código del salón:");
        salones.add(new Salon(codigo));
        System.out.println("[!] Salón agregado correctamente.");
    }

    private void editarSalon(LinkedList<Salon> salones) {
        if (salones.size() < 1) {
            System.out.println("[!] No hay salones registrados.");
        } else {
            System.out.println("Ingresa el índice del salón a editar: ");
            int indice = leerOpcion(salones.size());

            Boolean continuar = true;
            while (continuar) {
                mostrarOpciones("[GESTIÓN DE SALONES]", "- EDITAR SALÓN #" + indice + " -",
                        "Cambiar código", "Volver");
                int opcion = leerOpcion(5);
                switch (opcion) {
                    case 1:
                        String codigo = obtenerEntradaTexto("Ingresa el nuevo código del salón:");
                        salones.get(indice - 1).setCodigo(codigo);
                        System.out.println("[!] Código editado correctamente.");
                        break;
                    case 2:
                        continuar = false;
                        break;
                }
            }
        }
    }

    private void eliminarSalon(LinkedList<Salon> salones) {
        if (salones.size() < 1) {
            System.out.println("[!] No hay salones registrados.");
        } else {
            System.out.println("Ingresa el índice del salón a eliminar: ");
            int indice = leerOpcion(salones.size());
            salones.remove(indice - 1);
            System.out.println("[!] Salón eliminado correctamente.");
        }
    }
}
