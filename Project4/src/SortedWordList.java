// SortedWordList.java

import java.util.*;


/**
 * Extends WordList and sorts words alphabetically
 * and enters them into list
 * @author Hammad Ahmad
 *
 */
public class SortedWordList extends WordList{

	/** TreeMap which will store the words */
	TreeMap<Word, Integer> wordTreeMap;

	/**
	 * Creates the sorted word list that the words will soon be sent in to
	 */
	public SortedWordList() {
		wordTreeMap = new TreeMap<>(new WordComparator()); //make treemap used word comparator to directly list words in order
		WordNode ln = new WordNode();
		first = ln;
		last = ln;
		length = 0;
	} //constructor SortedWordList

	@Override
	/**
	 * Adds words to list alphabetically 
	 * @param s String that is passed in to get added into tree map
	 */
	public void add(String s) {

		Word q = new Word(s); //create a new Word with String s

		int counter = 1; //counter for amount of times the map coutains a certain word

		// increment each time a douplicate comes up 
		if(wordTreeMap.containsKey(q)){
			counter = wordTreeMap.get(q) + 1;
		} //if

		//start sending words into tree map

		wordTreeMap.put(q, counter);	

	} // method add

	/**
	 * Get method for to get the wordTreeMap
	 * @return wordTreeMap
	 */
	public TreeMap getwordTreeMap(){
		return wordTreeMap;
	} // method getwordTreeMap

} // SortedWordList
