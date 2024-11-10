package Clases;

import java.time.LocalDate;
import java.util.Date;

/**
 * Clase PersonalManteniento, esta clase ...
 */


public class PersonalMantenimiento extends Empleado {

    //Constructor
    public PersonalMantenimiento(String nombre, String apellido, String documento, LocalDate fechaNacimiento, int salario, Date horario) {
        super(nombre, apellido, documento, fechaNacimiento, salario, horario);
    }

    //ToString
    @Override
    public String toString() {
        return "PersonalMantenimiento " + super.toString();
    }


    //Metodos,  Ver metodo de esta clase


}
