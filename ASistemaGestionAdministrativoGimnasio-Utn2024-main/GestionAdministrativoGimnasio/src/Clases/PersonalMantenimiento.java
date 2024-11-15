package Clases;

import java.time.LocalDate;
import java.util.Date;

/**
 * Clase PersonalManteniento, esta clase ...
 */


public final class PersonalMantenimiento extends Empleado {

    //Constructor
    public PersonalMantenimiento(String nombre, String apellido, String documento, LocalDate fechaNacimiento, int salario, String horario) {
        super(nombre, apellido, documento, fechaNacimiento, salario, horario);
    }

    public PersonalMantenimiento() {
    }

    //ToString
    @Override
    public String toString() {
        return "PersonalMantenimiento " + super.toString();
    }


    //Metodos,  Ver metodo de esta clase

    public void arreglarMaquina(Maquina maquina) {
        if (maquina != null) {
            System.out.println("Reparando la máquina: " + maquina.getNombre());
            maquina.marcarComoDisponible();
        } else {
            System.out.println("La máquina proporcionada no es válida.");
        }
    }

}
