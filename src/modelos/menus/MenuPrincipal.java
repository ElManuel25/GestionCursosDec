package modelos.menus;

import modelos.menus.Menu;

public class MenuPrincipal extends Menu {
    public MenuPrincipal() {
        Boolean continuar = true;
        while(continuar) {
            mostrarOpciones("===== MENÚ DE OPCIONES =====","[GESTIONES]","GESTIÓN DE CURSOS","GESTIÓN DE ASIGNATURAS","GESTIÓN DE DOCENTES ","GESTIÓN DE SALONES");
            int opcion = leerOpcion(4);
            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
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
