// WordList.java

/**
 * Creates a linked list of words with an abstract class
 * which connects to two other classes which will add the words
 * into the two sorted and unsorted lists
 * @author Hammad Ahmad
 *
 */

public abstract class WordList {

	/** First word of the word node */
	protected WordNode first;
	/** Last word of the word node */
	protected WordNode last;
	/** The length of the word node */
	protected int length;

	/**
	 * Lets user get the instantiated variable length which is 
	 * set to private
	 * @return the instantiated variable length
	 */
	public int getLength() {
		return length;
	} // method getLength

	/**
	 * Starts off the list and stores the first 
	  * dummy word node as the first node in the list
	 */
	public WordList(){
		WordNode ln = new WordNode();
		first = ln;
		last = ln;
		length = 0;
	} // method WordList
	
	/**
	 * Call abstract methods to add the words into list
	 * @param s String that will be added to the lists
	 */
	abstract public void add(String s);
	
	/**
	 * Lets the user get the instantiated variable, first, which 
	 * is set to private
	 * @return The first node in the list
	 */
	public WordNode getFirst() {
		return first;
	} // method getFirst

} // class WordList
