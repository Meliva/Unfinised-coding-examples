/**
 * Exceptions that happen in the controller layer should be encapsulated in this
 * exception.
 * 
 */
public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidatorException(String message) {
		super(message);
	}

}
