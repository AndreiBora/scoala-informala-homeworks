/**
 *  Implements the exeption that appears  when the user enters a unit of measurement that is not suported by the class.
 * @author Bora Andrei
 *
 */
public class UnknownDistanceFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2130178502279644813L;
	
	public UnknownDistanceFormatException(String message) {
		super(message);
	}

}
