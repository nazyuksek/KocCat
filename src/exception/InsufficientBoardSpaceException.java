package exception;

/**
 * Exception thrown when there is not enough space on the board to place additional entities.
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class InsufficientBoardSpaceException extends Exception {

	/**
	 * Default constructor.
	 */
	public InsufficientBoardSpaceException() {
		super("Not enough space on the board.");
	}

	
}
