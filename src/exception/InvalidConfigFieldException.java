package exception;

/**
 * Exception thrown when an invalid configuration field is given to {@link util.Utils#askForInput(String s) askForInput(String s)}.
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class InvalidConfigFieldException extends Exception {

	/**
	 * Default constructor.
	 * @param field Non-existent field in configuration.
	 */
	public InvalidConfigFieldException(String field) {
		super("Field: " + field + " does not exist in Config.");
	}
	
}
