package Laboral;

public class DatosNoCorrectosException extends Exception {
    /**
     * Se llama a esta excepción en el caso que haya algún
     * dato erróneo en {@link Empleado}.
     */
    public DatosNoCorrectosException(String message) {
        super(message);
    }
}
