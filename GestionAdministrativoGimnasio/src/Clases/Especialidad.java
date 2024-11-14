package Clases;
import org.json.*;
import java.util.List;
import java.util.Objects;
import Enums.eEspecialidad;

public final class Especialidad {

    // Atributos
    private String descripcion;
    private eEspecialidad especialidad;

    // Constructor
    public Especialidad(String descripcion, eEspecialidad especialidad) {
        this.descripcion = descripcion;
        this.especialidad = especialidad;
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public eEspecialidad getEspecialidad() {
        return especialidad;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEspecialidad(eEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

    // Equals && HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especialidad that = (Especialidad) o;
        return Objects.equals(descripcion, that.descripcion) && especialidad == that.especialidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, especialidad);
    }

    // ToString
    @Override
    public String toString() {
        return "Especialidad { " +
                "descripcion='" + descripcion + '\'' +
                ", especialidad=" + especialidad +
                ", listaEntrenadores="   ;
    }

    // Mostrar entrenadores por especialidad
    public void mostrarEntrenadorPorEspecialidad(Especialidad tipo, GestionGenericaGimnasio gestionGym) {
        System.out.println("Entrenadores de la especialidad: " + tipo);
        List<Entrenador> todosEntrenadores = gestionGym.consultarPorClase(Entrenador.class);

        for (Entrenador entrenador : todosEntrenadores) {
            if (entrenador.getEspecialidad().equals(tipo.getEspecialidad())) {
                System.out.println(entrenador);
            }
        }
    }
    /*
    // Mostrar miembros por especialidad
    public void mostrarMiembrosPorEspecialidad(Especialidad tipo, GestionGenericaGimnasio gestionGym) {
        System.out.println("Miembros interesados en la especialidad: " + tipo);
        List<Miembro> todosMiembros = gestionGym.consultarPorClase(Miembro.class);

        for (Miembro miembro : todosMiembros) {
            if (miembro.getEntrenadorAsingado().getEspecialidad().equals(tipo.getEspecialidad())) {
                System.out.println(miembro);
            }
        }
    }




     */

    // Método para convertir un JSONObject en una instancia de Especialidad
    public static Especialidad fromJSONObject(JSONObject jsonObject) {

        String descripcion = jsonObject.getString("descripcion");
        // Convertir el String de especialidad en el enum eEspecialidad
        eEspecialidad especialidad = eEspecialidad.valueOf(jsonObject.getString("especialidad"));

        return new Especialidad(descripcion, especialidad);
    }


}

