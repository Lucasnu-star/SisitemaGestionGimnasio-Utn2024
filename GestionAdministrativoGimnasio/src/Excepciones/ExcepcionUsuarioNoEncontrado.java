package Excepciones;
/**
 * Excepcion usuario no encontrado, esta excepcion...
 */
public class ExcepcionUsuarioNoEncontrado extends RuntimeException {
    public ExcepcionUsuarioNoEncontrado(String message) {
        super(message);
    }
}
