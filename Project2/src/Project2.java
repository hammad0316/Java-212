// Project2.java

import java.util.StringTokenizer;

	/**
	 * Reads words from a file and separates them
	 * according to space, new line, or commas and then
	 * arranges them alphabetically using a word node. 
	 * Then displays a GUI with two text area's which 
	 * display the unordered nodes on the left and ordered 
	 * on the right. 
	 * @author Hammad Ahmad
	 * 
	 */

public class Project2 {

	/** Name of the file */
	private static final String filename = "words.txt";  // file name that input should be read from

	public static void main(String[] args) {

		// create two lists, one for ordered and one for unordered
		
		WordList Unordered = new WordList(); 
		WordList Ordered = new WordList();
		
		// get input from file
		
		inputFromFile(filename, Unordered, Ordered); 
		
		// call WordGUI class to create GUI
		
		@SuppressWarnings("unused")
		WordGUI gui = new WordGUI(Unordered, Ordered);

	}  // method main
	
	/**
	 * Reads words from file, separates them and only stores them if they
	 * are words that contain only 3 letters and no numbers.
	 * @param filename the input text file name
	 * @param Unordered unordered list of words
	 * @param Ordered ordered list of words
	 */
	
	private static void inputFromFile(String filename, WordList Unordered, WordList Ordered){
		TextFileInput in = new TextFileInput(filename);
		String line = in.readLine();
		while (line != null ) {
			StringTokenizer st = new StringTokenizer(line, ",");
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();

				// checks which words are legal depending on your word class and prints it out to console 

				if(temp.length() != Word.WORD_SIZE || !isLegalWord(temp))	System.out.println(temp);  

				// which ever passes the if statement condition gets placed into the array

				else {
					Unordered.append(temp);
					Ordered.insert(temp);
				}
			}
			line = in.readLine();
		} // while 
		in.close();
		//return lengthFilled; 
	}  // method inputFromFile

	// makes sure it doesn't contain and numbers or characters and is an actual word
	
	/**
	 * Will check the string for whether or not it 
	 * contains all letters or some numbers.
	 * @param word String that will be checked 
	 * @return true if all characters in the word 
	 * 		are letters, false otherwise. 
	 */
	public static boolean isLegalWord(String word){

		for (int i = 0; i<word.length(); i++){
			if(!Character.isLetter(word.charAt(i))){
				return false;		
			} 
		} // for loop
		return true;
	} // method isLegalWord


} // class Project2
