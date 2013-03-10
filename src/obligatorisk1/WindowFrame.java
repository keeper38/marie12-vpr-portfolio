/*
 * Portfolio:		marie12
 * License:			Marie Public License revision 1 (Found in the file "LICENSE")
 * Code quality:	Putrid
 * 
 * This code will be kept on GitHub under the user sdumarie12.
 * 
 * Contains obligatory assignments in accordingly named tabs.
 * A second JTabbedPane under the 'Miscellaneous' contains non-essential
 * assignments, such as testing, training and proof of concept.
 * 
 * Some fields and variables from ported projects has been renamed to them more
 * distinguishable from each other and avoid confusion.
 * 
 * I plan to move the components out into their own files in the future.
 * 
 * Possible current problems:
 * 		Naming - I have attempted to name everything properly, but there may still be some bad names
 * 		Almost everything under one file - I would have liked to separate it a little, but I'm new to WindowBuilder
 */

package obligatorisk1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class WindowFrame extends JFrame {
	// Computed by Eclipse
	private static final long serialVersionUID = -8917222429298875280L;
	
	private JPanel mainContentPane;
	private JTextField opg1a_inputField;
	private JTextField opg1a_outputField;
	private JButton opg1a_clear;
	private JButton opg1a_toUpper;
	private JButton opg1a_toLower;
	private JTabbedPane mainTabbedPane;
	private JPanel misc_border2_panel;
	private JScrollPane misc_border2_scrollPane;
	private JTextArea misc_border2_textArea;
	private JButton misc_border2_btnNorth;
	private JButton misc_border2_btnSouth;
	private JButton misc_border2_btnWest;
	private JButton misc_border2_btnEast;
	private JTabbedPane misc_border2_tabbedPane;
	private JPanel miscPane;
	private JPanel misc_stringsplit_panel;
	private JScrollPane misc_stringsplit_scrollPane;
	private JScrollPane misc_stringsplit_scrollPane_1;
	private JTextArea misc_stringsplit_textArea_input;
	private JTextArea misc_stringsplit_textArea_output;
	private JPanel misc_stringsplit_buttonPanel;
	private JTextField misc_stringsplit_textField_splitregex;
	private JButton misc_stringsplit_btnSplit;
	private JButton misc_stringsplit_btnClear;
	private NewJPanel opg1b_NewJPanel;
	private JScrollPane opg1b_scrollPane;
	private JTextArea opg1b_textArea;
	private JButton opg1b_btnOpenFile;
	private JLabel opg1b_lblStatus;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowFrame frame = new WindowFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void opg1_initComponents() {
		// Copied this method from the exam and made a few changes
		
		// Made this an inner class to contain it a little
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == opg1a_clear) {
					opg1a_inputField.setText("");
				}
				else if (e.getSource() == opg1a_toUpper) {
					opg1a_outputField.setText(opg1a_inputField.getText().toUpperCase());
				}
				else if (e.getSource() == opg1a_toLower) {
					opg1a_outputField.setText(opg1a_inputField.getText().toLowerCase());
				}
			}
			
		}
		
		// Used build in functions in Eclipse to make necessary declarations
		JPanel opg1a_Panel = new JPanel();
		opg1a_inputField = new JTextField();
		opg1a_inputField.setColumns(16);
		opg1a_outputField = new JTextField();
		opg1a_outputField.setColumns(16);
		
		opg1a_outputField.setEditable(false);
		opg1a_clear = new JButton("Clear");
		opg1a_clear.addActionListener(new ButtonListener());
		opg1a_toUpper = new JButton("Upper Case");
		opg1a_toUpper.addActionListener(new ButtonListener());
		opg1a_toLower = new JButton("Lower Case");
		opg1a_toLower.addActionListener(new ButtonListener());
		opg1a_Panel.add(opg1a_inputField);
		opg1a_Panel.add(opg1a_outputField);
		opg1a_Panel.add(opg1a_clear);
		opg1a_Panel.add(opg1a_toUpper);
		opg1a_Panel.add(opg1a_toLower);
		
		mainTabbedPane.add(opg1a_Panel);
		mainTabbedPane.setTitleAt(0, "opg 1a");
		
		opg1b_NewJPanel = new NewJPanel();
		mainTabbedPane.addTab("opg 1b", null, opg1b_NewJPanel, null);
		mainTabbedPane.setEnabledAt(1, true);
		opg1b_NewJPanel.setLayout(new BorderLayout(0, 0));
		
		opg1b_scrollPane = new JScrollPane();
		opg1b_NewJPanel.add(opg1b_scrollPane, BorderLayout.CENTER);
		
		opg1b_textArea = new JTextArea();
		opg1b_scrollPane.setViewportView(opg1b_textArea);
		
		opg1b_lblStatus = new JLabel("Status:");
		opg1b_NewJPanel.add(opg1b_lblStatus, BorderLayout.SOUTH);
		
		opg1b_btnOpenFile = new JButton("Open");
		opg1b_btnOpenFile.addActionListener(new BtnNewButtonActionListener());
		opg1b_NewJPanel.add(opg1b_btnOpenFile, BorderLayout.WEST);
		
		miscPane = new JPanel();
		mainTabbedPane.addTab("Miscellaneous", null, miscPane, null);
		miscPane.setLayout(new BoxLayout(miscPane, BoxLayout.X_AXIS));
		
		misc_border2_tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		miscPane.add(misc_border2_tabbedPane);
		
		misc_border2_panel = new JPanel();
		misc_border2_tabbedPane.addTab("Border2", null, misc_border2_panel, null);
		misc_border2_panel.setLayout(new BorderLayout(0, 0));
		
		misc_border2_scrollPane = new JScrollPane();
		misc_border2_panel.add(misc_border2_scrollPane, BorderLayout.CENTER);
		
		misc_border2_textArea = new JTextArea();
		misc_border2_textArea.setWrapStyleWord(true);
		misc_border2_textArea.setLineWrap(true);
		misc_border2_scrollPane.setViewportView(misc_border2_textArea);
		
		misc_border2_btnNorth = new JButton("North");
		misc_border2_btnNorth.addActionListener(new BtnNorthActionListener());
		misc_border2_panel.add(misc_border2_btnNorth, BorderLayout.NORTH);
		
		misc_border2_btnSouth = new JButton("South");
		misc_border2_btnSouth.addActionListener(new BtnSouthActionListener());
		misc_border2_panel.add(misc_border2_btnSouth, BorderLayout.SOUTH);
		
		misc_border2_btnWest = new JButton("West");
		misc_border2_btnWest.addActionListener(new BtnWestActionListener());
		misc_border2_panel.add(misc_border2_btnWest, BorderLayout.WEST);
		
		misc_border2_btnEast = new JButton("East");
		misc_border2_btnEast.addActionListener(new BtnEastActionListener());
		misc_border2_panel.add(misc_border2_btnEast, BorderLayout.EAST);
		
		misc_stringsplit_panel = new JPanel();
		misc_border2_tabbedPane.addTab("String Split", null, misc_stringsplit_panel, null);
		misc_border2_tabbedPane.setEnabledAt(1, true);
		misc_stringsplit_panel.setLayout(new BoxLayout(misc_stringsplit_panel, BoxLayout.X_AXIS));
		
		misc_stringsplit_scrollPane = new JScrollPane();
		misc_stringsplit_panel.add(misc_stringsplit_scrollPane);
		
		misc_stringsplit_textArea_input = new JTextArea();
		misc_stringsplit_textArea_input.setWrapStyleWord(true);
		misc_stringsplit_textArea_input.setLineWrap(true);
		misc_stringsplit_scrollPane.setViewportView(misc_stringsplit_textArea_input);
		
		misc_stringsplit_scrollPane_1 = new JScrollPane();
		misc_stringsplit_panel.add(misc_stringsplit_scrollPane_1);
		
		misc_stringsplit_buttonPanel = new JPanel();
		misc_stringsplit_buttonPanel.setPreferredSize(new Dimension(100, 18));
		misc_stringsplit_panel.add(misc_stringsplit_buttonPanel);
		
		misc_stringsplit_textField_splitregex = new JTextField();
		misc_stringsplit_textField_splitregex.setColumns(4);
		misc_stringsplit_textField_splitregex.setPreferredSize(new Dimension(80, 24));
		misc_stringsplit_buttonPanel.add(misc_stringsplit_textField_splitregex);
		misc_stringsplit_textField_splitregex.setColumns(6);
		
		misc_stringsplit_btnSplit = new JButton("Split");
		misc_stringsplit_btnSplit.setPreferredSize(new Dimension(80, 24));
		misc_stringsplit_btnSplit.addActionListener(new Misc_stringsplit_btnSplitActionListener());
		misc_stringsplit_buttonPanel.add(misc_stringsplit_btnSplit);
		
		misc_stringsplit_btnClear = new JButton("Clear");
		misc_stringsplit_btnClear.addActionListener(new Misc_stringsplit_btnClearActionListener());
		misc_stringsplit_btnClear.setPreferredSize(new Dimension(80, 24));
		misc_stringsplit_buttonPanel.add(misc_stringsplit_btnClear);
		
		misc_stringsplit_textArea_output = new JTextArea();
		misc_stringsplit_textArea_output.setWrapStyleWord(true);
		misc_stringsplit_textArea_output.setLineWrap(true);
		misc_stringsplit_scrollPane_1.setViewportView(misc_stringsplit_textArea_output);
	}

	/**
	 * Create the frame.
	 */
	public WindowFrame() {
		setTitle("Portfolio marie12 - 2013");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainContentPane = new JPanel();
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainContentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(mainContentPane);
		
		// Declaration moved out to the class, so the init method can access it
		mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainContentPane.add(mainTabbedPane, BorderLayout.CENTER);
		// The init method from the exam:
		opg1_initComponents();
	}

	private class BtnNorthActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			misc_border2_textArea.append("You clicked: North\n");
		}
	}
	private class BtnSouthActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			misc_border2_textArea.append("You clicked: South\n");
		}
	}
	private class BtnWestActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			misc_border2_textArea.append("You clicked: West\n");
		}
	}
	private class BtnEastActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			misc_border2_textArea.append("You clicked: East\n");
		}
	}
	private class Misc_stringsplit_btnSplitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String[] splittedText = misc_stringsplit_textArea_input.getText().split(misc_stringsplit_textField_splitregex.getText());
			misc_stringsplit_textArea_output.setText("");
			for (int i = 0; i < splittedText.length; i++) {
				// Append every element in the array followed by a new line
				misc_stringsplit_textArea_output.append(splittedText[i].concat("\n"));
			}
		}
	}
	private class Misc_stringsplit_btnClearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// Clear the view
			misc_stringsplit_textArea_input.setText("");
			misc_stringsplit_textArea_output.setText("");
			misc_stringsplit_textField_splitregex.setText("");
		}
	}
	private class BtnNewButtonActionListener implements ActionListener {
		private boolean isNumeric(String str) {
			// Check if every character in the string is numeric
			boolean numeric = true;
			for (int i = 0; i < str.length(); i++) {
				if (!Character.isDefined(str.charAt(i))) {
					numeric = false;
				}
			}
			
			return (numeric);
		}
		
		private boolean isValid(String[] fileLine) {
			boolean valid = false;
			
			// Every line must have a string and a number separated by a space
			if (fileLine.length == 2) {
				if (fileLine[0].length() > 0 && fileLine[1].length() > 0 && isNumeric(fileLine[1])) {
					valid = true;
				}
			}
			else {
				valid = false;
			}
			return (valid);
		}
		
		public void actionPerformed(ActionEvent arg0) {
			// Split with a space
			final String splitPattern = " ";
			int sum = 0;
			// Filter out .txt files
			FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text files", "txt");
			JFileChooser filechooser = new JFileChooser(".");
			// Be sure that one can only select files
			filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			// Limit one to only open text files
			filechooser.setFileFilter(fnef);
			// Show the dialog
			filechooser.showOpenDialog(null);
			Scanner sc;
			
			try {
				sc = new Scanner(filechooser.getSelectedFile());
				// Firstly, clear the text area
				opg1b_textArea.setText("");
				// For every line, check if it is valid and if so, write the data to the text are and add to sum
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] lineData = line.split(splitPattern);
					
					// If the line is valid, append the data and add number to sum
					if (isValid(lineData)) {
						opg1b_textArea.append(lineData[0] + "\t" + lineData[1]);
						// Only add new line if there are more lines in the document
						if (sc.hasNextLine()) {
							opg1b_textArea.append("\n");
						}
						sum = sum + Integer.decode(lineData[1]);
					}
					else {
						// TODO: Handle invalid lines
						// For now, just ignore it
					}
				}
				// When done, close the scanner and show the result
				sc.close();
				opg1b_lblStatus.setText(filechooser.getSelectedFile().getName() + " contains the sum of: " + sum);
			}
			catch (Exception ex) {/* TODO: Handle errors */}
		}
	}
}
