// SortedWordList.java

/**
 * Extends WordList and sorts words alphabetically
 * and enters them into list
 * @author Hammad Ahmad
 *
 */
public class SortedWordList extends WordList{

	/**
	 * Creates the sorted word list
	 */
	public SortedWordList() {
		WordNode ln = new WordNode();
		first = ln;
		last = ln;
		length = 0;
	} //constructor SortedWordList
	
	
	@Override
	/**
	 * Adds words to list alphabetically 
	 * @param s String that is passed in to get added into list
	 */
	public void add(String s) {
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
					while(next != null && s.compareTo(next.getData().word) >= 0){
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
	} // method add
	
} // SortedWordList
