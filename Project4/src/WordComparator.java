//WordComparator.java

import java.util.Comparator;
 /**
  * Compares two words together lexicographically 
  * @author Hammad Ahmad
  *
  */
public class WordComparator implements Comparator <Word>  {
   public int compare(Word word1, Word word2) {
      return word1.word.compareTo(word2.word);
   }
} //WordComparator
