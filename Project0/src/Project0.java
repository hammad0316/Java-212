/*
	Hammad Ahmad
	Lab Section 11D (11066)
	
 */
import javax.swing.JOptionPane;
/*
	ask user for a sentence and find out how many capital E's and lowercase e's
	are in the sentence and convey it back to the user.
*/
public class Project0 {
	   public static void main(String[] args) {
		   while (true){
			   String sentence = JOptionPane.showInputDialog("Input a sentence please");
			   
			   //if user enters the "stop" in any way possible, program will exit
			   if (sentence.equalsIgnoreCase("Stop") == true) {
				   System.exit(0); 
			   }
			   
			   int uppercounter = 0;
			   int lowercounter = 0;
			   
			   //check each letter for capital and lowercase
			   for (int i = 0; i < sentence.length(); i++){ 
				   if (sentence.charAt(i) == 'E'){
				   		uppercounter++; 
				   }
				   else if (sentence.charAt(i) == 'e'){
					   lowercounter++; 
				   }
			   }
			   
			   JOptionPane.showMessageDialog(null, "Number of upper case e's: " + uppercounter + "\n" + "Number of lower case e's: " + lowercounter);
		   }
	   }
}