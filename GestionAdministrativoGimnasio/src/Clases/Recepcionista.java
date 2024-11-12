package Clases;

import Excepciones.ExcepcionMembresiaExpirada;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *Clase Recepcionista, esta clase...
 */
public final class Recepcionista extends Empleado {



    //Constructor

    public Recepcionista(String nombre, String apellido, String documento, LocalDate fechaNacimiento, int salario, String horario) {
        super(nombre, apellido, documento, fechaNacimiento, salario, horario);
    }




    //ToString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        return sb.toString();
    }

    // Verificando membresia del miembro.
    public String verificarMembresia(Miembro miembro) throws ExcepcionMembresiaExpirada {
        if (miembro == null) {
            throw new IllegalArgumentException("El miembro no puede ser nulo.");
        }

        if (!miembro.isEstadoMembresia()) {
            throw new ExcepcionMembresiaExpirada("La membresía del miembro " + miembro.getNombre() + " ha expirado.");
        }

        return  "La membresía del miembro " + miembro.getNombre() + " está activa.";
    }

    //Metodos
    public <T> void agregarDeLista(GestionGenericaGimnasio<T> lista, String clave, T obj){
        lista.agregar(clave, obj);

    }

    public <T> void eliminarDeLista(GestionGenericaGimnasio<T> lista, String clave){
       lista.eliminar(clave);
    }

    public <T> String consultar(GestionGenericaGimnasio<T> lista, String id){
        if (lista.getGestionUsuario().containsKey(id)){
            return "Encontrado: "+lista.getGestionUsuario().get(id);
        }

        return "No se ha encontrado el elemento a buscar ";

    }
}
