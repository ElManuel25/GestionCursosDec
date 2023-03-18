package modelos.menus;

import modelos.entidades.Curso;
import modelos.entidades.Asignatura;
import modelos.entidades.Docente;
import modelos.entidades.Salon;
import java.util.LinkedList;

public class MenuPrincipal extends Menu {
    public MenuPrincipal(
            LinkedList<Curso> cursos,
            LinkedList<Asignatura> asignaturas,
            LinkedList<Docente> docentes,
            LinkedList<Salon> salones
    ) {
        boolean continuar = true;
        while(continuar) {
            mostrarOpciones("===== MENÚ DE OPCIONES =====","[GESTIONES]",
                    "GESTIÓN DE CURSOS","GESTIÓN DE ASIGNATURAS","GESTIÓN DE DOCENTES","GESTIÓN DE SALONES");
            int opcion = leerOpcion(4);
            switch (opcion){
                case 1:
                    MenuCursos menuCursos = new MenuCursos(cursos);
                    break;
                case 2:
                    MenuAsignaturas menuAsignaturas = new MenuAsignaturas(asignaturas);
                    break;
                case 3:
                    MenuDocentes menuDocentes = new MenuDocentes(docentes);
                    break;
                case 4:
                    MenuSalones menuSalones = new MenuSalones(salones);
                    break;
            }
            continuar = confirmarContinuar();
        }
    }
}
