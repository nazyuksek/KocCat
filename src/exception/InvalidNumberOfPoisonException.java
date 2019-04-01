package exception;
/**
 * Exception thrown when invalid number of poison are given.
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class InvalidNumberOfPoisonException extends Exception {

	/**
	 * Default constructor.
	 * @param numberOfPoison Number of poison given.
	 */
	public InvalidNumberOfPoisonException(Integer numberOfPoison) {
		super("Invalid number of poison: " + numberOfPoison);
	}

}
