import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;        

public class WordGUI {

	//constructor WordGUI which has its parameters passed in from Project1 class
	
	public WordGUI(ArrayList<Word> words, ArrayList<Word> arrayList) {
		
		createAndShowGUI(words, arrayList);
	
	}  
	
	// create and show the GUI with unsorted and sorted words displayed

	private static void createAndShowGUI(ArrayList<Word> words, ArrayList<Word> words2) {
	
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
		
		// have textArea read and output the original unsorted list
		
		for(int i=0; i<words.size(); i++) {
			textArea.append(words.get(i).word + "\n");			
		}

		// create second textArea where sorted list will be placed
		
		JTextArea textArea1 = new JTextArea(20,20);
		textArea1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		frame.getContentPane().add(scrollPane1);
		textArea1.append("Sorted:" + "\n");
		
		// have textArea read and output the sorted list

		for(int i=0; i<words2.size(); i++) {
			
			textArea1.append(words2.get(i).word + "\n");			
		
		}
	
		//Display the window.
		
		frame.pack();
		frame.setVisible(true);
		
	}  // method createAndShowGUI

}  //class WordGUI