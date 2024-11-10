package Excepciones;
/**
 * Excepcion membresia expirada, esta excepcion...
 */
public class ExcepcionMembresiaExpirada extends RuntimeException {
    public ExcepcionMembresiaExpirada(String message) {
        super(message);
    }
}
