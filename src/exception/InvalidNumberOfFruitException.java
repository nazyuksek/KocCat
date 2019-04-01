package exception;

/**
 * Exception thrown when invalid number of fruits are given.
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class InvalidNumberOfFruitException extends Exception {

	/**
	 * Default constructor.
	 * @param numberOfFruit Number of fruits given.
	 */
	public InvalidNumberOfFruitException(Integer numberOfFruit) {
		super("Invalid number of fruits: " + numberOfFruit);
	}

}
