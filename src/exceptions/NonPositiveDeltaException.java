package exceptions;

public class NonPositiveDeltaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NonPositiveDeltaException(String message) {
		super(message);
	}
}
