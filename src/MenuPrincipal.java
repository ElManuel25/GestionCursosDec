import java.util.Scanner;

public class MenuPrincipal extends Menu {
    public MenuPrincipal() {
        Boolean continuar = true;
        while(continuar) {
            mostrarOpciones("===== MENÚ DE OPCIONES =====","[ GESTIÓN DE CURSOS ]","Ver cursos","Crear curso","Editar curso","Eliminar curso");
            int opcion = leerOpcion(5);
            continuar = confirmarContinuar() == 1;
        }
    }

    /*public void mostrarOpciones() {
        System.out.println(
            "===== MENÚ DE OPCIONES =====\n" +
            "[ GESTIÓN DE CURSOS ]\n" +
            "    [1] Ver cursos\n" +
            "    [2] Crear curso\n" +
            "    [3] Editar curso\n" +
            "    [4] Eliminar curso\n" +
            "[ GESTIÓN DE ASIGNATURAS ]\n" +
            "    [5] Ver asignaturas\n" +
            "    [6] Crear asignatura\n" +
            "    [7] Editar asignatura\n" +
            "    [8] Eliminar asignatura\n" +
            "[ GESTIÓN DE DOCENTES ]\n" +
            "    [9] Ver docentes\n" +
            "    [10] Crear docente\n" +
            "    [11] Editar docente\n" +
            "    [12] Eliminar docente\n" +
            "[ GESTIÓN DE SALONES ]\n" +
            "    [13] Ver salones\n" +
            "    [14] Crear salón\n" +
            "    [15] Editar salón\n" +
            "    [16] Eliminar salón\n"
        );
    }*/
}
