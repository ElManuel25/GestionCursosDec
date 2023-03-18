package modelos.menus;

import modelos.entidades.Asignatura;

import java.util.LinkedList;

public class MenuAsignaturas extends Menu{
    public MenuAsignaturas(LinkedList<Asignatura> asignaturas){
        boolean continuar = true;
        while(continuar) {
            mostrarOpciones(" ===== MENÚ DE OPCIONES =====","[ GESTIÓN DE ASIGNATURAS ]"," Ver asignaturas","Crear asignatura","Editar asignatura","Eliminar asignatura");
            int opcion = leerOpcion(4);
            switch (opcion){
                case 1:
                    verAsignaturas(asignaturas);
                    break;
                case 2:
                    crearAsignatura(asignaturas);
                    break;
                case 3:
                    editarAsignatura(asignaturas);
                    break;
                case 4:
                    eliminarAsignatura(asignaturas);
                    break;
            }
            continuar = confirmarContinuar();
        }
    }
    private void verAsignaturas(LinkedList<Asignatura> asignaturas){
        for (int i = 0;i < asignaturas.size();i++){
            System.out.printf("[%d] %s%n", i+1,asignaturas.get(i).toString());
        }
    }

    private void crearAsignatura(LinkedList<Asignatura> asignaturas){
        String codigo =  obtenerEntradaTexto("Ingrese codigo de la asignatura");
        while (!verificarCodigoUnico(codigo,asignaturas)){
            System.out.println("El codigo de la asignatura debe ser unico, por favor ingrese un codigo diferente;");
            codigo = obtenerEntradaTexto("Ingrese codigo de la asignatura");
        }
        String nombre = obtenerEntradaTexto("Ingrese nombre de la  asignatura");
        Asignatura nuevaAsignatura = new Asignatura(codigo,nombre);
        asignaturas.add(nuevaAsignatura);
        System.out.println("Asignatura agregada correctamente");
    }
    private boolean verificarCodigoUnico(String codigo,LinkedList<Asignatura> asignaturas){
        for(Asignatura asignatura:asignaturas){
            if(asignatura.getCodigo().equals(codigo)){
                return false;
            }
        }
        return  true;
    }

    private int posicionAsignaturaSelecionada(LinkedList<Asignatura> asignaturas){
        verAsignaturas(asignaturas);
        System.out.println("Ingrese posicion de la asignatura que desea selecionar");
        return leerOpcion(asignaturas.size())-1;
    }
    private void editarAsignatura(LinkedList<Asignatura> asignaturas){
       int posicion = posicionAsignaturaSelecionada(asignaturas);
        Asignatura asignaturaSelecionada = asignaturas.get(posicion);
        while (true){
            System.out.println("> asignatura selecionada: "+asignaturaSelecionada.toString());
            mostrarOpciones("[ GESTIÓN DE ASIGNATURAS ]","[ EDITAR ASIGNATURA ]","Editar Codigo","Editar nombre","Salir");
            int opcion = leerOpcion(3);
            switch (opcion) {
                case 1 -> {
                    String codigo = obtenerEntradaTexto("Ingrese el nuevo codigo de la asignatura");
                    while (!verificarCodigoUnico(codigo, asignaturas)) {
                        System.out.println("El codigo de la asignatura debe ser unico, por favor ingrese un codigo diferente;");
                        codigo = obtenerEntradaTexto("Ingrese el nuevo codigo de la asignatura");
                    }
                    asignaturaSelecionada.setCodigo(codigo);
                }
                case 2 -> {
                    String nombre = obtenerEntradaTexto("Ingrese el nuevo nombre de la asignatura");
                    asignaturaSelecionada.setNombre(nombre);
                }
                case 3 -> {
                    return;
                }
            }

        }
    }
    private void eliminarAsignatura(LinkedList<Asignatura> asignaturas){
        int posicion = posicionAsignaturaSelecionada(asignaturas);
        asignaturas.remove(posicion);
    }
}