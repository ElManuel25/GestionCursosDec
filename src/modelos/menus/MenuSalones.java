package modelos.menus;
import modelos.entidades.Salon;

import java.util.LinkedList;

public class MenuSalones extends Menu {
    public MenuSalones(LinkedList<Salon> salones) {
        mostrarOpciones("[GESTIÓN DE SALONES]","",
                "Ver salones","Agregar salón","Editar salón","Eliminar salón");
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
