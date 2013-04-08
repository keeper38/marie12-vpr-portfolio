package misc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Testing for palindromes.
 * TODO: Use only one text field
 */

public class Misc_Palindrome extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = -2672043284090602021L;
	JTextField txtLeft;
	JTextField txtRight;
	JButton btnCompare;
	
	public Misc_Palindrome() {
		class CompListener implements ActionListener {
			
			private boolean checkPalindrome(ArrayList<Character> left, ArrayList<Character> right) {
				boolean palindrome = true;
				if (left.size() == right.size()) {
					for (int i = 0; i < left.size(); i++) {
						if (left.get(i) != right.get(i)) {
							palindrome = false;
							i = left.size();
						}
					}
				}
				else {
					palindrome = false;
				}
				return palindrome;
			}
			
			public boolean isValidCharacter(Character o1) {
				boolean validity;
				
				// Currently the lazy way:
				if (Character.isLetter(o1)) validity = true;
				//else if (Character.isDigit(o1)) validity = true;
				else validity = false;
				
				return validity;
			}
			
			public void actionPerformed(ActionEvent e) {
				// Container for valid lower case letters
				ArrayList<Character> left = new ArrayList<Character>();
				ArrayList<Character> right = new ArrayList<Character>();
				
				// Extract letters
				for(int i = 0; i < txtLeft.getText().length(); i++) {
					if (isValidCharacter(txtLeft.getText().charAt(i))) {
						left.add(txtLeft.getText().toLowerCase().charAt(i));
					}
				}
				for(int i = txtRight.getText().length() - 1; i >= 0; i--) {
					if (isValidCharacter(txtRight.getText().charAt(i))) {
						right.add(txtRight.getText().toLowerCase().charAt(i));
					}
				}
				
				if (checkPalindrome(left, right)) {
					btnCompare.setBackground(Color.GREEN);
				}
				else {
					btnCompare.setBackground(Color.RED);
				}
			}
			
		}
		
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		txtLeft = new JTextField();
		txtLeft.setColumns(16);
		txtRight = new JTextField();
		txtRight.setColumns(16);
		btnCompare = new JButton("Compare");
		btnCompare.addActionListener(new CompListener());
		
		this.add(txtLeft);
		this.add(txtRight);
		this.add(btnCompare);
		
		
	}
}
