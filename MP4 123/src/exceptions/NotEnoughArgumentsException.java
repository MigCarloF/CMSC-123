package exceptions;

public class NotEnoughArgumentsException extends Exception{

	private static final long serialVersionUID = -9208346096585638995L;

	public NotEnoughArgumentsException(String message) {
        super(message);
	}

	public NotEnoughArgumentsException() {}

}
