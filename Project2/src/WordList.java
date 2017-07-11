/**
 * Creates a linked list of words
 * @author Hammad Ahmad
 *
 */
public class WordList {

	/** First word of the word node */
	private WordNode first;
	/** Last word of the word node */
	private WordNode last;
	/** The length of the word node */
	private int length;


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
	 * Keeps adding nodes to the list 
	 * irrelevant to their alphabetized order.
	 * @param s String that is being appended as a word node
	 */
	public void append (String s) {
		WordNode n = new WordNode(s);
		last.setNext(n);
		last = n;
		length++;
	} // method append
	
	/**
	 * Insert nodes into the list in alphabetical order
	 * @param s String that is being inserted as a word node
	 */
	public void insert(String s){
		// create a WordNode for a new node that is being inserted
		WordNode n = new WordNode(s);
		// get references to previous and next nodes to loop through the list
		WordNode prev = getFirst();
		WordNode next = getFirst().next();
		// initially check if the list is empty, if it is, insert as a first node in the list
		if (next == null) {
			prev.setNext(n);
			last = n;
		} else {
			//loop through each next node until the spot where the string needs to go is found
			while(next != null && s.compareTo(next.getData()) >= 0){
				prev = next;
				next = prev.next();
			} // while
		} // else
		// check if you're inserting it at the end and update last if so
		if (next == null) {
			last = n;
		} else {
			n.setNext(next);
		} // else
		prev.setNext(n);
		length++;
	} // method insert

	/**
	 * Lets the user get the instantiated variable, first, which 
	 * is set to private
	 * @return The first node in the list
	 */
	public WordNode getFirst() {
		return first;
	} // method getFirst

} // class WordList
