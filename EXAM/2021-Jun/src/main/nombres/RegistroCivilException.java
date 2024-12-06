package main.nombres;

public class RegistroCivilException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public RegistroCivilException() {
        super();
    }
    public RegistroCivilException(String exception) {
        super(exception);
    }
}
