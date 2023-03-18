package modelos.menus;

import java.util.LinkedList;
import java.util.Scanner;

public  abstract class Menu {
    final public Scanner scanner = new Scanner(System.in);
    public boolean confirmarContinuar() {
        System.out.print("[!] ¿Desea continuar? Presione 1 para continuar o 0 para salir: ");
        int op = obtenerEntradaInt();
        return op > 0;
    }
    public int leerOpcion(int cantidadOpciones) {
        int opcion = obtenerEntradaInt();
        while (opcion > cantidadOpciones || opcion <=0){
            System.out.println("Opción ingresada no válida, ingrese nuevamente un valor correcto.");
            opcion = obtenerEntradaInt();
        }
        return opcion;
    }
    public int obtenerEntradaInt(){
        System.out.print("> ");
        String entradaUsuario = scanner.next();
        while (!validarEntradaInt(entradaUsuario)){
            System.out.println("Opción ingresada no válida, ingrese nuevamente un valor correcto.");
            System.out.print("> ");
            entradaUsuario = scanner.next();
        }
        return Integer.parseInt(entradaUsuario);
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
    private boolean validarEntradaInt(String entrada){
        return entrada.matches("\\d+");
    }
    public String obtenerEntradaTexto(String pregunta){
        System.out.println(pregunta);
        System.out.print("> ");
        return scanner.next();
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
        System.out.println(sb.toString());
    }
}

