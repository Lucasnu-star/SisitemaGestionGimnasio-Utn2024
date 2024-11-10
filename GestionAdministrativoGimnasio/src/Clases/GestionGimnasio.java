package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestionGimnasio, esta clase...
 *
 */
public class GestionGimnasio<T>  {
    //Atributo
    List<T> gestionUsuario;

    //Contructor
    public GestionGimnasio() {
        this.gestionUsuario = new ArrayList<>();
    }

    //Getter
    public List<T> getGestionUsuario() {
        return gestionUsuario;
    }

    //Setter
    public void setGestionUsuario(List<T> gestionUsuario) {
        this.gestionUsuario = gestionUsuario;
    }

    //ToString
    @Override
    public String toString() {
        return "GestionGimnasio " +
                "gestionUsuario=" + gestionUsuario;
    }
    public void agregar(T obj) {
        gestionUsuario.add(obj);
        System.out.println("Elemento agregado: " + obj);
    }

    // Metdo para eliminar un elemento
    public void eliminar(T obj) {
        if (gestionUsuario.remove(obj)) {
            System.out.println("Elemento eliminado: " + obj);
        } else {
            System.out.println("El elemento no se encontró en la lista.");
        }
    }

    // Metodo para consultar los elementos de un tipo especifico
    public List<T> consultar(Class<T> clase) {
        List<T> result = new ArrayList<>();
        for (T obj : gestionUsuario) {
            if (clase.isInstance(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    // Metodo para mostrar elementos de la lista
    public void mostrarTodos() {
        System.out.println("Lista de elementos en GestionGym:");
        for (T obj : gestionUsuario) {
            System.out.println(obj);
        }
    }
}
