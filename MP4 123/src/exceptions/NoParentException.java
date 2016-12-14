package exceptions;

public class NoParentException extends Exception {
	private static final long serialVersionUID = -7761442588479764639L;

	public NoParentException(String message) {
        super(message);
	}
	
	public NoParentException() {}
}
