package modelos.menus;

import java.util.LinkedList;
import java.util.Scanner;

public  abstract class Menu {
    final public Scanner scanner = new Scanner(System.in);

    public boolean confirmarContinuar() {
        System.out.println("[!] ¿Desea continuar? Presione 1 para continuar o 0 para salir: ");
        int op = obtenerEntradaInt();
        return op > 0;
    }

    public int leerOpcion(int cantidadOpciones) {
        int opcion = 0;
        boolean valorIncorrecto = true;
        while (valorIncorrecto) {
            opcion = obtenerEntradaInt();

            if (opcion <= 0 || opcion > cantidadOpciones) {
                System.out.println("Opción ingresada no válida, ingrese nuevamente una opción correcta.");
            }
            else {
                valorIncorrecto = false;
            }
        }
        return opcion;
    }

    public int obtenerEntradaInt(){
        String entradaUsuario = "";
        boolean valorIncorrecto = true;
        while (valorIncorrecto){
            System.out.print("> ");
            entradaUsuario = scanner.nextLine();
            if (!validarEntradaInt(entradaUsuario)) {
                System.out.println("Valor ingresado debe ser un número entero, ingrese nuevamente un valor correcto.");
            }
            else  {
                valorIncorrecto = false;
            }
        }
        return Integer.parseInt(entradaUsuario);
    }

    private boolean validarEntradaInt(String entrada){
        return entrada.matches("\\d+");
    }

    public String obtenerEntradaTexto(String pregunta){
        System.out.println(pregunta);
        System.out.print("> ");
        return scanner.nextLine();
    }

    public void verIterable(LinkedList<?> lista){
        if(lista.size() < 1) {
            System.out.println("***Lista vacía***");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.printf("[%d] %s%n", i + 1, lista.get(i).toString());
            }
        }
    }

    public void mostrarOpciones(String titulo,String cabecera, String ...opciones){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(titulo);
        sb.append("\n");
        sb.append(cabecera);
        sb.append("\n");
        int numeroOpcion= 1;
        for(String opcion:opciones){
            sb.append("[%d] %s  \n".formatted(numeroOpcion,opcion));
            numeroOpcion++;
        }
        System.out.println(sb);
    }
}