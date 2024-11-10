package Clases;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Clase Empleado, esta clase es...
 */
public class Empleado  extends Usuario{

    //Atributos
    private int salario;
    private Date horario; // Ver como plasmar horarios

    //Constuctor
    public Empleado(String nombre, String apellido, String documento, LocalDate fechaNacimiento, int salario, Date horario) {
        super(nombre, apellido, documento, fechaNacimiento);
        this.salario = salario;
        this.horario = horario;
    }

    //Getters
    public int getSalario() {
        return salario;
    }
    public Date getHorario() {
        return horario;
    }

    //Equals && HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return salario == empleado.salario && Objects.equals(horario, empleado.horario);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salario, horario);
    }

    //ToString
    @Override
    public String toString() {
        return super.toString() +
                " Empleado " +
                "salario=" + salario +
                ", horario=" + horario ;
    }
}
