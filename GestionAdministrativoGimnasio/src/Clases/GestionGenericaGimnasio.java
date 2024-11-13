package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    public void mostrarTodos() {
        System.out.println("Lista de elementos en GestionGym:");
        for (Map.Entry<String, T> entrada : gestionUsuario.entrySet()){

        }
    }
    // consultar por clave
    public T consultar (String clave){
        return gestionUsuario.get(clave);
    }
}
