package modelos.menus;

import modelos.entidades.Docente;

import java.util.LinkedList;

public class MenuDocentes extends Menu{
    public MenuDocentes(LinkedList<Docente> docentes) {
        boolean continuar = true;
        while(continuar) {
            mostrarOpciones(" ===== MENÚ DE OPCIONES =====","[ GESTIÓN DE DOCENTES ]"," Ver docentes","Crear docente","Editar docente","Eliminar docente");
            int opcion = leerOpcion(4);
            switch (opcion){
                case 1:
                    verDocentes(docentes);
                    break;
                case 2:
                    crearDocente(docentes);
                    break;
                case 3:
                    editarDocente(docentes);
                    break;
                case 4:
                    eliminarDocente(docentes);
                    break;
            }
            continuar = confirmarContinuar();
        }
    }
    private void verDocentes(LinkedList<Docente> docentes){
        for (int i = 0;i < docentes.size();i++){
            System.out.printf("[%d] %s%n", i+1,docentes.get(i).toString());
        }
    }

    private void crearDocente(LinkedList<Docente> docentes){
        String documento =  obtenerEntradaTexto("Ingrese documento del Docente");
        while (!verificarDocumentoUnico(documento,docentes)){
            System.out.println("El documento del Docente debe ser unico, por favor ingrese un documento diferente;");
            documento = obtenerEntradaTexto("Ingrese documento del Docente");
        }
        String nombre = obtenerEntradaTexto("Ingrese nombre del  Docente");
        Docente nuevaDocente = new Docente(documento,nombre);
        docentes.add(nuevaDocente);
        System.out.println("Docente agregado correctamente");
    }
    private boolean verificarDocumentoUnico(String documento, LinkedList<Docente> docentes){
        for(Docente Docente:docentes){
            if(Docente.getDocumento().equals(documento)){
                return false;
            }
        }
        return  true;
    }

    private int posicionDocenteSelecionado(LinkedList<Docente> docentes){
        verDocentes(docentes);
        System.out.println("Ingrese posicion de la Docente que desea selecionar");
        return leerOpcion(docentes.size())-1;
    }
    private void editarDocente(LinkedList<Docente> docentes){
        int posicion = posicionDocenteSelecionado(docentes);
        Docente docenteselecionada = docentes.get(posicion);
        while (true){
            System.out.println("> Docente selecionada: "+docenteselecionada.toString());
            mostrarOpciones("[ GESTIÓN DE DOCENTES ]","[ EDITAR DOCENTE ]","Editar documento","Editar nombre","Salir");
            int opcion = leerOpcion(3);
            switch (opcion) {
                case 1 -> {
                    String documento = obtenerEntradaTexto("Ingrese el nuevo documento del docente");
                    while (!verificarDocumentoUnico(documento, docentes)) {
                        System.out.println("El documento del docente debe ser unico, por favor ingrese un documento diferente;");
                        documento = obtenerEntradaTexto("Ingrese el nuevo documento del docente");
                    }
                    docenteselecionada.setDocumento(documento);
                }
                case 2 -> {
                    String nombre = obtenerEntradaTexto("Ingrese el nuevo nombre del docente");
                    docenteselecionada.setNombre(nombre);
                }
                case 3 -> {
                    return;
                }
            }

        }
    }
    private void eliminarDocente(LinkedList<Docente> docentes){
        int posicion = posicionDocenteSelecionado(docentes);
        docentes.remove(posicion);
    }
}