package Clases;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Clase Usuario, esta clase ....
 */
public abstract class Usuario {

    //Atributos
    private String nombre;
    private String apellido;
    private String documento;
    private LocalDate fechaNacimiento;  //Ver

    //Constructor
    public Usuario(String nombre, String apellido, String documento, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Usuario() {

    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDocumento() {
        return documento;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }  //Ver

    //Equals && HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido) && Objects.equals(documento, usuario.documento) && Objects.equals(fechaNacimiento, usuario.fechaNacimiento);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, documento, fechaNacimiento);
    }

    //ToString
    @Override
    public String toString() {
        return "Usuario " +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", fechaNacimiento=" + fechaNacimiento;
    }

    //Metodos

    public int calcularEdad() {
        if (fechaNacimiento != null) {
            return Period.between(fechaNacimiento, LocalDate.now()).getYears();
        }
        return 0;
    }


}
