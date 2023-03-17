package modelos.menus;
import modelos.entidades.Curso;

import java.util.LinkedList;

public class MenuCursos extends Menu {
    public MenuCursos(LinkedList<Curso> cursos) {
        mostrarOpciones("[GESTIÓN DE CURSOS]","",
                "Ver cursos","Agregar curso","Editar curso","Eliminar curso");
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
    }
}
