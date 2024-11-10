package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Gimnasio, esta clase ...
 */


public class Gimnasio {

    //Atributos
    private String nombreGimnasio;
    private String direccionGimnasio;
    private int capacidadGimnasio;
    private List<Especialidad> especialidadesGimnasio;

    //Constructores
    public Gimnasio(String nombreGimnasio, int capacidadGimnasio, String direccionGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
        this.capacidadGimnasio = capacidadGimnasio;
        this.direccionGimnasio = direccionGimnasio;
        this.especialidadesGimnasio =  new ArrayList<>();  // Ver
    }
    public Gimnasio() {
    }

    //Getters
    public String getNombreGimnasio() {
        return nombreGimnasio;
    }
    public String getDireccionGimnasio() {
        return direccionGimnasio;
    }
    public int getCapacidadGimnasio() {
        return capacidadGimnasio;
    }
    public List<Especialidad> getEspecialidadesGimnasio() {
        return especialidadesGimnasio;
    }

    //Setters
    public void setNombreGimnasio(String nombreGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
    }
    public void setDireccionGimnasio(String direccionGimnasio) {
        this.direccionGimnasio = direccionGimnasio;
    }
    public void setCapacidadGimnasio(int capacidadGimnasio) {
        this.capacidadGimnasio = capacidadGimnasio;
    }
    public void setEspecialidadesGimnasio(List<Especialidad> especialidadesGimnasio) {
        this.especialidadesGimnasio = especialidadesGimnasio;
    }

    //HashCode && Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gimnasio gimnasio = (Gimnasio) o;
        return capacidadGimnasio == gimnasio.capacidadGimnasio && Objects.equals(nombreGimnasio, gimnasio.nombreGimnasio) && Objects.equals(direccionGimnasio, gimnasio.direccionGimnasio) && Objects.equals(especialidadesGimnasio, gimnasio.especialidadesGimnasio);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombreGimnasio, direccionGimnasio, capacidadGimnasio, especialidadesGimnasio);
    }

    //ToString
    @Override
    public String toString() {
        return "Gimnasio " +
                "  nombreGimnasio='" + nombreGimnasio + '\'' +
                ", direccionGimnasio='" + direccionGimnasio + '\'' +
                ", capacidadGimnasio=" + capacidadGimnasio +
                ", especialidadesGimnasio=" + especialidadesGimnasio;
    }

    //Metodos

}
