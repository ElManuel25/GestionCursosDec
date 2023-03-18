package modelos.menus;

import modelos.entidades.Salon;

import java.util.LinkedList;

public class MenuSalones extends Menu {
    public MenuSalones(LinkedList<Salon> salones) {
        Boolean continuar = true;
        while (continuar) {
            mostrarOpciones("[GESTIÓN DE SALONES]",
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
                    break;
                case 4:
                    verSalones(salones);
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
        System.out.print("[!] Salón añadido correctamente.\n");
    }
}
