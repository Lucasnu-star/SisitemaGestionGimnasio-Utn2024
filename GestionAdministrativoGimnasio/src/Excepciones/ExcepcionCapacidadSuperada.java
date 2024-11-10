package Excepciones;
/**
 * Excepcion capacidad del gimnasio superada, esta excepcion...
 */
public class ExcepcionCapacidadSuperada extends RuntimeException {
  public ExcepcionCapacidadSuperada(String message) {
    super(message);
  }
}
