package modelos.menus;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public  abstract class Menu {
    final public Scanner scanner = new Scanner(System.in);

    public boolean confirmarContinuar() {
        System.out.println("[!] ¿Desea continuar? Presione 1 para continuar o 0 para salir: ");
        int op = obtenerEntradaInt();
        return op > 0;
    }

    public int leerOpcion(int cantidadOpciones) {
        return Stream.generate(this::obtenerEntradaInt).filter(opcion -> opcion > 0 && opcion <= cantidadOpciones).findFirst()
                .orElseThrow(() -> new RuntimeException("Opción ingresada no válida."));
    }

    //DECLARATIVO
    public int obtenerEntradaInt() {
        System.out.print("> ");
        return Stream.generate(scanner::nextLine).filter(this::validarEntradaInt).map(Integer::parseInt).findFirst()
                .orElseThrow(() -> new RuntimeException("No se ha ingresado un número entero válido.")); // Si no se encontró un número entero válido, se lanza una excepción
    }

    private boolean validarEntradaInt(String entrada){
        return entrada.matches("\\d+");
    }

    public String obtenerEntradaTexto(String pregunta){
        System.out.println(pregunta);
        System.out.print("> ");
        return scanner.nextLine();
    }
    // DECLARATIVO +-
    public void verIterable(LinkedList<?> lista){
        if (lista.isEmpty()) {
            System.out.println("***Lista vacía***");
        } else {
            IntStream.range(0, lista.size()).forEach(i -> System.out.printf("[%d] %s%n", i + 1, lista.get(i).toString()));
        }
    }

    // DECLARATIVO
    public void mostrarOpciones(String titulo, String cabecera, String... opciones) {
        System.out.printf("\n%s\n%s\n", titulo, cabecera);
        IntStream.range(0, opciones.length).mapToObj(i -> String.format("[%d] %s", i + 1, opciones[i])).forEach(System.out::println);
    }
}