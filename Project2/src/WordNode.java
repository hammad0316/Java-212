/**
 * Creates a word node with a string and 
 * the reference to the next node
 * @author Hammad Ahmad
 *
 */
public class WordNode {
	/** String data that the word node holds */
	private String data;
	/** Next word node */
	private WordNode next;
	
	// create a constructor containing no arguments
	
	/**
	 * Starts off the data in the Node
	 */
	public WordNode(){
		data = "";
	} // constructor WordNode
	
	// create constructor containing one argument
	
	/**
	 * Constructor that will create a new word node
	 * @param data String that's going to be used to
	 * 		store in the node.
	 */
	public WordNode(String data)  {
		this.data = data;
	}  // constructor WordNode

	// create a method for setting instantiated variable next
	
	/**
	 * Sets the reference to the next word node in the word list
	 * @param a The word node that is going to be next
	 */
	public void setNext(WordNode a){
		next = a;
	} // method setNext

	// create a method for getting the  instantiated variable data since it is private
	
	/**
	 * Returns the string data for the word node
	 * @return The string data 
	 */
	public String getData(){
		return data;
	} // method getData
		
	// create a method to go on to next node in the list
	
	/**
	 * Finds the next word node in the list
	 * @return The next word node
	 */
	public WordNode next(){
		return next;
	} // method next
	
} // class WordNode
