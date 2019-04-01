package exception;

/**
 * Exception thrown when invalid square width is given.
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class InvalidSquareWidthException extends Exception {

	/**
	 * Default constructor.
	 * @param W Square width given.
	 */
	public InvalidSquareWidthException(Integer W) {
		super("Invalid square width exception: " + W);
	}
	
	
}
