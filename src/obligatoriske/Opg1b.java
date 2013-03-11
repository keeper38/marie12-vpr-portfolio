package obligatoriske;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Opg1b extends NewJPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 905139171670743384L;
	
	JScrollPane scrollPane;
	JTextArea txtData;
	JLabel lblStatus;
	JButton btnLoad;
	
	private class btnOpen_Listener implements ActionListener {
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
			int chooserErrorCode = filechooser.showOpenDialog(null);
			Scanner sc;
			if (chooserErrorCode == 0) {
				try {
					sc = new Scanner(filechooser.getSelectedFile());
					// Firstly, clear the text area
					txtData.setText("");
					// For every line, check if it is valid and if so, write the data to the text are and add to sum
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						String[] lineData = line.split(splitPattern);
						
						// If the line is valid, append the data and add number to sum
						if (isValid(lineData)) {
							txtData.append(lineData[0] + "\t" + lineData[1]);
							// Only add new line if there are more lines in the document
							if (sc.hasNextLine()) {
								txtData.append("\n");
							}
							sum = sum + Integer.decode(lineData[1]);
						}
						else {
							// TODO: Handle invalid lines
							// For now, just ignore them
						}
					}
					// When done, close the scanner and show the result
					sc.close();
					lblStatus.setText(filechooser.getSelectedFile().getName() + " contains the sum of: " + sum);
				}
				catch (Exception ex) {/* TODO: Handle errors */}
			}
			else {
				// User pressed Cancel or something
			}
		}
	}
	
	public Opg1b() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		txtData = new JTextArea();
		scrollPane.add(txtData);
		scrollPane.setViewportView(txtData);
		
		lblStatus = new JLabel("Status:");
		add(lblStatus, BorderLayout.SOUTH);
		
		btnLoad = new JButton("Open");
		btnLoad.addActionListener(new btnOpen_Listener());
		add(btnLoad, BorderLayout.WEST);
	}
}
