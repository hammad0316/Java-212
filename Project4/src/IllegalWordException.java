//IllegalWordException.java

/**
 * Create new IllegalWordException which extends IllegalArgumentException
 * that will be thrown everytime it is called.
 * @author Hammad Ahmad
 *
 */
@SuppressWarnings("serial")
public class IllegalWordException extends IllegalArgumentException {

	public IllegalWordException (String message){
		super(message);
	} //constructor IllegalWordException
}
