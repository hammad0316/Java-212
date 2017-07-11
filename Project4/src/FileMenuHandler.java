//FileMenuHandler.java

import java.util.regex.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;

import javax.swing.*;

/**
 * FileMenuHandler class which sets up JFileChooser and 
 * reads the file
 * @author Hammad Ahmad
 *
 */

public class FileMenuHandler implements ActionListener {

	/** Unsorted word list */
	private UnsortedWordList unsorted;
	/** Sorted word list */
	private SortedWordList sorted;
	/** JFrame that will be passed into constructor */
	JFrame jframe;
	/** The object that uses the pattern given to then find a match */
	Matcher regexMatcher;
	/** Pattern to check the regex with */
	Pattern checkRegex = Pattern.compile("^[A-Za-z]{3}$");

	/**
	 * Constructor which creates the JFrame
	 * @param jf JFrame parameter being sent into constructor
	 */
	public FileMenuHandler (JFrame jf) {
		jframe = jf;
	} // constructor FileMenuHandler

	/**
	 * Chooses what happens when either menu button is clicked or touched
	 */
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")) {
			//when user clicks cancel in file chooser, null pointer exception is caught and not printed to console
			try {
				ChoosingFile();
			}
			catch (NullPointerException x){ 
			}
			WordGUI.addText(sorted, unsorted);
		}
		else if (menuName.equals("Quit"))
			System.exit(0);
	} // method actionPerformed

	/**
	 * Utilizes JFileChooser to let user pick what text file they want
	 * to sort from
	 */
	public void ChoosingFile() {
		JFileChooser fd = new JFileChooser();
		fd.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //let them look through both directories and files
		fd.showOpenDialog(null);
		File f = fd.getSelectedFile(); //set selected file to file f which will be read
		unsorted = new UnsortedWordList();
		sorted = new SortedWordList();
		inputFromFile(f, unsorted, sorted, regexMatcher, checkRegex); //send in file, unsorted and sorted wordlist 
	} // method ChooseFile

	/**
	 * Reads words from file, separates them and only stores them if they
	 * are words that contain only 3 letters and no numbers.
	 * @param f the file that the user has chosen to read from
	 * @param unsorted unsorted list of words
	 * @param sorted sorted list of words
	 */
	private static void inputFromFile(File f, UnsortedWordList unsorted, SortedWordList sorted, Matcher regexMatcher, Pattern checkRegex){
		TextFileInput in = new TextFileInput(f);
		String line = in.readLine();
		while (line != null ) {
			StringTokenizer st = new StringTokenizer(line, ",");
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();
				
				/* checks which words are legal depending on your word class and prints it out to console 
				 * and throw IllegalWordException everytime the word isn't 3 letters or isn't all letters
				 */

				// uses the regular expression to check 

				regexMatcher = checkRegex.matcher( temp);
				
				// if regex has found a match to the patten, it will send the word through to the two lists
				
				if(regexMatcher.find()){
					unsorted.add(temp);
					sorted.add(temp);
				}//if 

				// which ever passes the if statement condition gets placed into the array
				
				else{
					System.out.print(temp + " ");  
					try {
						throw new IllegalWordException("isn't a legal word..."); //throw exception whenever the word isn't legal and 3
					} catch (IllegalWordException e) {
						System.out.println(e.getMessage()); //print out message that is sent into exception
					} //catch
				} // else
			}
			line = in.readLine();
		} // while 
		in.close();
	}  // method inputFromFile

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

} // class FileMenuHandler