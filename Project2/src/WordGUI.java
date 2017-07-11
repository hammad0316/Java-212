import java.awt.GridLayout;

import javax.swing.*;        

/**
 * Take the two lists, and enter them on a text area
 * which sits upon a GUI
 * @author Hammad Ahmad
 *
 */
public class WordGUI {

	//constructor WordGUI which has its parameters passed in from Project2 class
	/**
	 * Calls method which creates and displays the GUI 
	 * and sends in the unordered and ordered list of the 
	 * nodes.
	 * @param unordered the un-alphabetized list of nodes
	 * @param ordered the alphabetized list of nodes 
	 */
	public WordGUI(WordList unordered, WordList ordered) {

		createAndShowGUI(unordered, ordered);

	}  

	// create and show the GUI with unsorted and sorted words displayed
	
	/**
	 * Create the GUI which will display two text areas 
	 * displaying both the unordered and ordered nodes
	 * 
	 * @param unordered the node before it is alphabetized
	 * @param ordered the node after being alphabetized
	 */
	private static void createAndShowGUI(WordList unordered, WordList ordered) {

		//Create and set up the window with correct grid layout alignment

		JFrame frame = new JFrame("Project 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize( 500,500);  //width, height);
		frame.setLocation(200,200); 
		frame.setLayout(new GridLayout(1,2));  //layout contains 1 row and 2 columns for both lists to be side by side

		// create first textArea where original and unsorted list will be placed

		JTextArea textArea = new JTextArea(20,20);
		textArea.setEditable(false);  
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane);
		textArea.append("Unsorted:" + "\n");

		// have temp set to getting the next node after the dummy node in the unordered list
		
		WordNode temp = unordered.getFirst().next();

		// go through unordered LinkedList until it hits null indicating that's the end, and have it displayed on textArea
		
		while(temp != null){
			textArea.append(temp.getData() + "\n");
			temp = temp.next();
		}

		// create second textArea where sorted list will be placed

		JTextArea textArea1 = new JTextArea(20,20);
		textArea1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		frame.getContentPane().add(scrollPane1);
		textArea1.append("Sorted:" + "\n");

		// have temp set to getting the next node after the dummy node in the ordered list

		temp = ordered.getFirst().next();

		// go through ordered LinkedList until it hits null indicating that's the end, and have it displayed on textArea
		
		while(temp != null){
			textArea1.append(temp.getData() + "\n");
			temp = temp.next();
		}

		//Display the window.

		frame.pack();
		frame.setVisible(true);

	}  // method createAndShowGUI

}  //class WordGUI