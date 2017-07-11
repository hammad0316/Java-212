/**
 * Class that sets word size and stores the word
 * @author Hammad Ahmad
 *
 */
public class Word {	
	
	/** Sets final length of letter in word that can be accepted */
	public static final int WORD_SIZE = 3;
	/** String word that the word class owns */
	public String word;
	
	/**
	 * Constructor for class Word which 
	 * creates a new word object with a string
	 * @param word String that will be stored as the word object
	 */
	public Word(String word) {
		this.word = word;
	}  //constructor word
}

