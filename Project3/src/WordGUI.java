// WordGUI.java

import java.awt.GridLayout;
import javax.swing.*;        

/**
 * Take the two lists, and enter them on a text area
 * which sits upon a GUI
 * @author Hammad Ahmad
 *
 */
@SuppressWarnings("serial")
public class WordGUI extends JFrame {	
	
	//initialize both textArea's to add the sorted and unsorted lists
	/** Initialize first textArea for first list **/
	static JTextArea textArea;
	/** Initialize second textArea for second list **/
	static JTextArea textArea1;
	
	/**
	 * Create the GUI which will contain the file and everything else
	 * @param title Title of GUI 
	 * @param height Height of GUI
	 * @param width Width of GUI
	 */
	public WordGUI(String title, int height, int width) {
		setTitle(title);
		setSize(height,width);
		setLayout(new GridLayout(1,2));
		setLocation  (400,200);
		createFileMenu();
		createAndShowGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	} //constructor WordGUI

	// create and show the GUI with unsorted and sorted words displayed

	/**
	 * Create the GUI which will display two text areas 
	 * displaying both the unordered and ordered nodes
	 * 
	 * @param unordered the node before it is alphabetized
	 * @param ordered the node after being alphabetized
	 */
	private void createAndShowGUI() {
		
		// create first textArea where original and unsorted list will be placed

		textArea = new JTextArea(20,20);
		textArea.setEditable(false);  
		JScrollPane scrollPane = new JScrollPane(textArea);
		this.getContentPane().add(scrollPane);
		textArea.append("Unsorted:" + "\n");
		
		// create second textArea where sorted list will be placed

		textArea1 = new JTextArea(20,20);
		textArea1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		this.getContentPane().add(scrollPane1);
		textArea1.append("Sorted:" + "\n");

		//Display the window.

		this.pack();
		this.setVisible(true);

	}  // method createAndShowGUI
	
	/**
	 * Create method to start adding text to lists once the GUI
	 * is created.
	 * @param sorted Send in sorted list to sort and insert sorted words into
	 * @param unsorted Send in unsorted list to sort and insert unsorted words into
	 */
	public static void addText(SortedWordList sorted, UnsortedWordList unsorted) {
		WordNode temp = sorted.getFirst().next();
		
		// if length of list in the beginning is null, it'll go on to the next
		
		if (sorted.length > 1) 
			temp = sorted.getFirst().next();

		// go through unordered LinkedList until it hits null indicating that's the end, and have it displayed on textArea
		
		while(temp != null){
			textArea1.append(temp.getData().word + "\n");
			temp = temp.next();
		}

		// if length of list in the beginning is null, it'll go on to the next
		
		temp = unsorted.getFirst().next();
		
		if (unsorted.length > 1) 
			temp = unsorted.getFirst().next();

		// go through unordered LinkedList until it hits null indicating that's the end, and have it displayed on textArea
		
		while(temp != null){
			textArea.append(temp.getData().word + "\n");
			temp = temp.next();
		}
	} // method addText

	/**
	 * Add menu options to open a file and 
	 * quit the program.
	 */
	private void createFileMenu( ) {
		JMenuItem   item;
		JMenuBar    menuBar  = new JMenuBar();
		JMenu       fileMenu = new JMenu("File");
		FileMenuHandler fmh  = new FileMenuHandler(this);

		item = new JMenuItem("Open");    //Open...
		item.addActionListener( fmh );
		fileMenu.add( item );

		fileMenu.addSeparator();           //add a horizontal separator line

		item = new JMenuItem("Quit");       //Quit
		item.addActionListener( fmh );
		fileMenu.add( item );

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
	} // method createMenu

}  //class WordGUI