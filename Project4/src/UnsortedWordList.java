// UnsortedWordList.java

/**
 * Takes in all strings sent in and stores
 * them in the unsorted WordList
 * @author Hammad Ahmad
 *
 */
public class UnsortedWordList extends WordList{

	/**
	 * Creates unsorted word list
	 */
	public UnsortedWordList() {
		WordNode ln = new WordNode();
		first = ln;
		last = ln;
		length = 0;
	} // constructor UnsortedWordList
	
	/**
	 * Adds all words to list regardless of order
	 * @param s String that will be added to word list
	 */
	@Override
	public void add(String s) {
		WordNode n = new WordNode(s);
		last.setNext(n);
		last = n;
		length++;		
	} // method add
	
}