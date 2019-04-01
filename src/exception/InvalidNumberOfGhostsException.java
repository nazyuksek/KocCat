package exception;
/**
 * Exception thrown when invalid number of ghosts are given.
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class InvalidNumberOfGhostsException extends Exception {

	
	/**
	 * Default constructor.
	 * @param numberOfGhosts Number of ghosts given.
	 */
	public InvalidNumberOfGhostsException(Integer numberOfGhosts) {
		super("Invalid number of ghosts: " + numberOfGhosts);
	}

}
