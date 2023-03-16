import java.util.Scanner;

public  abstract class Menu {
    final public Scanner scanner = new Scanner(System.in);
    public int confirmarContinuar() {
        System.out.print("[!] ¿Desea continuar? Presione 1 para continuar o 0 para salir: ");
        int op = scanner.nextInt();
        return op;
    }
    public int leerOpcion(int cantidadOpciones) {
        int opcion = obtenerEntradaInt();
        while (opcion > cantidadOpciones){
            System.out.println("Valor ingresado sobrepasa a las opciones dadas ingrese nuevamente un valor correcto.");
            opcion = obtenerEntradaInt();
        }
        return opcion;
    }
    private int obtenerEntradaInt(){
        System.out.print(":");
        String entradaUsuario = scanner.next();
        while (!validarEntradaInt(entradaUsuario)){
            System.out.println("Opcion ingresada no valida, ingrese nuevamente un valor correcto");
            System.out.print(":");
            entradaUsuario = scanner.next();
        }
        return Integer.parseInt(entradaUsuario);
    }
    private boolean validarEntradaInt(String entrada){
        return entrada.matches("\\d+");
    }
    public String obtenerEntradaTexto(String pregunta){
        System.out.println(pregunta);
        return  scanner.nextLine();
    }
    public void mostrarOpciones(String titulo,String cabecera, String ...opciones){
        StringBuilder sb = new StringBuilder();
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

