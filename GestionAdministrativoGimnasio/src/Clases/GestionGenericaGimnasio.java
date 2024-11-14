package Clases;

import java.time.LocalDate;
import java.util.*;
import Enums.eEspecialidad;

/**
 * Clase GestionGimnasio, esta clase...
 *
 */
public class GestionGenericaGimnasio<T>  {
    //Atributo
    TreeMap<String, T> gestionUsuario;

    //Contructor
    public GestionGenericaGimnasio() {
        this.gestionUsuario = new TreeMap<>();
    }

    //Getter
    public TreeMap<String, T> getGestionUsuario() {
        return gestionUsuario;
    }

    //Setter


    //ToString
    @Override
    public String toString() {
        return "GestionGimnasio " +
                "gestionUsuario=" + gestionUsuario;
    }
    public void agregar(String clave, T obj) {
        gestionUsuario.put(clave, obj);
        System.out.println("Elemento agregado: " + obj);
    }

    // Metdo para eliminar un elemento
    public void eliminar(String clave) {
        if (gestionUsuario.remove(clave) != null) {
            System.out.println("Elemento eliminado: " + clave);
        } else {
            System.out.println("El elemento no se encontró en la lista.");
        }
    }

    // Metodo para consultar los elementos de un tipo especifico
    public List<T> consultarPorClase(Class<T> clase) {
        List<T> result = new ArrayList<>();
        for (T obj : gestionUsuario.values()) {
            if (clase.isInstance(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    // Metodo para mostrar elementos de la lista

    // consultar por clave
    public T consultar (String clave){
        return gestionUsuario.get(clave);
    }

    // crea entrenador
    public Entrenador crearEntrenador(){
        Entrenador entrenador = new Entrenador();
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese el nombre del entrenador");
        entrenador.setNombre(entrada.nextLine());
        System.out.println("ingrese apellido del entrenador");
        entrenador.setApellido(entrada.nextLine());
        System.out.println("ingrese documento del entrenador");
        entrenador.setDocumento(entrada.nextLine());
        System.out.println("ingrese fecha de nacimiento");
        entrenador.setFechaNacimiento(LocalDate.parse(entrada.nextLine()));
        // Mostrar las especialidades disponibles
        System.out.println("Seleccione la especialidad:");
        eEspecialidad[] especialidades = eEspecialidad.values();
        for (int i = 0; i < especialidades.length; i++) {
            System.out.println((i + 1) + ". " + especialidades[i].name());
        }

        int opcionEspecialidad = entrada.nextInt();
        while (opcionEspecialidad < 1 || opcionEspecialidad > especialidades.length) {
            System.out.println("Opción no válida. Por favor seleccione una especialidad válida.");
            opcionEspecialidad = entrada.nextInt();
        }
        entrenador.setEspecialidad(especialidades[opcionEspecialidad - 1]);

        return entrenador;
    }

    /*
    //modificar entrenador
    public Entrenador modificarEntrenador(){
        Entrenador entrenador = new Entrenador();
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese el nuevo documento");
        entrenador.setDocumento(entrada.nextLine());
    }

     */
}
