package exception;

/**
 * Exception thrown when invalid number of squares are given.
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class InvalidNumberOfSquaresException extends Exception {

	/**
	 * Default constructor.
	 * @param N Number of squares given.
	 */
	public InvalidNumberOfSquaresException(Integer N) {
		super("Invalid number of squares: " + N);
	}
	
	
}
