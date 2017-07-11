/*
	Hammad Ahmad
	Lab Section 11D (11066)
	
 */
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
read from a file and output the words alphabetically and seperates them if they are on a new line or seperated by
commas
*/
public class Project1 {

	private static final String filename = "words.txt";  // file name that input should be read from

	public static void main(String[] args) {

		ArrayList<Word> words = new ArrayList<Word>();  // create new array to store words read from file
		inputFromFile(filename, words); 
		WordGUI gui = new WordGUI(words, sort(words));

	}  // method main

	 // sorts the array alphabetically using selection sort
	private static ArrayList<Word> sort(ArrayList<Word> word){

		int start = 0;  // initialize starting point of array for selection sort
		Word min;  // initialize the variable which is going to be use to find the minimum in each pass
		int minIndex;  // keeps track of index of the minimum, to know where it is and bring it to the front
		ArrayList<Word> sorted = (ArrayList<Word>) word.clone();  // copy the original to not write over it

		// outer loop, loops through the array n times to sort each element one by one

		for (int i = 0; i<sorted.size(); i++){
			min = sorted.get(i);
			minIndex = start;

			// inner loop, loops through the inner subarray which has yet to be sorted

			for(int j = start + 1; j < sorted.size(); j++){
				if (sorted.get(j).word.compareTo(min.word) < 0){
					min = sorted.get(j);
					minIndex = j;
				}
			}  // inner loop

			// loop that swaps the minimum to where it belongs

			for(int j = minIndex; j > start; j--) {
				Word temp = sorted.get(j);
				sorted.set(j, sorted.get(j - 1));
				sorted.set(j - 1, temp);
			}  // swapping loop

			start++;  // increment start to know where to start from each time

		}  // outer loop
		return sorted;

	}  // method sort

	// makes sure it doesn't contain and numbers or characters and is an actual word
	
	public static boolean isLegalWord(String word){
		
		for (int i = 0; i<word.length(); i++){
			if(!Character.isLetter(word.charAt(i))){
				return false;		
			}
		}
		return true;
	}
	
	/* method that will read lines from file, tokenize and seperate the lines whether they 
	have a comma or not and store them into the array if they are legal
	*/
	
	private static void inputFromFile(String filename, ArrayList<Word> words){
		TextFileInput in = new TextFileInput(filename);
		//int lengthFilled = 0;
		String line = in.readLine();
		while (line != null ) {
			StringTokenizer st = new StringTokenizer(line, ",");
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();

				// checks which words are legal depending on your word class and prints it out to console 

				if(temp.length() != Word.WORD_SIZE || !isLegalWord(temp))	System.out.println(temp);  

				// which ever passes the if statement condition gets placed into the array

				else words.add(new Word(temp)); 
			}
			line = in.readLine();
		} // while 
		in.close();
		//return lengthFilled; 
	}  // method inputFromFile

}  // class Project1
