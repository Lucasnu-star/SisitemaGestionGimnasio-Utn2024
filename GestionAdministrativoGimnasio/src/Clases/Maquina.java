package Clases;

import Enums.eTIPOMAQUINA;

import java.util.Objects;

/**
 * Clase Maquina, esta clase..
 */
public final class Maquina {

    //Atributos
    private int id;
    private String nombre;
    private eTIPOMAQUINA tipoMaquina;
    private boolean estadoMaquina; // True o False

    //Constructor
    public Maquina(String nombre, eTIPOMAQUINA tipoMaquina, boolean estadoMaquina) {
        this.nombre = nombre;
        this.tipoMaquina = tipoMaquina;
        this.estadoMaquina = estadoMaquina;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public eTIPOMAQUINA getTipoMaquina() {
        return tipoMaquina;
    }

    public boolean isEstadoMaquina() {
        return estadoMaquina;
    }

    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoMaquina(eTIPOMAQUINA tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public void setEstadoMaquina(boolean estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

    //Equals && HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maquina maquina = (Maquina) o;
        return estadoMaquina == maquina.estadoMaquina && Objects.equals(nombre, maquina.nombre) && Objects.equals(tipoMaquina, maquina.tipoMaquina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoMaquina, estadoMaquina);
    }

    //ToString
    @Override
    public String toString() {
        return "Maquina " +
                "nombre=" + nombre + '\'' +
                ", tipoMaquina=" + tipoMaquina +
                ", estadoMaquina=" + estadoMaquina;
    }

    public void marcarComoDisponible(){
        setEstadoMaquina(true);
    }
}
