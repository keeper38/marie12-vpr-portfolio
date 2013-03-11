package obligatoriske;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Opg1a extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 8676106099146688741L;
	
	private JTextField txtInput;
	private JTextField txtOutput;
	private JButton btnClear;
	private JButton btnUpper;
	private JButton btnLower;
	
	public Opg1a() {
				class ButtonListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == btnClear) {
							txtInput.setText("");
							txtOutput.setText("");
						}
						else if (e.getSource() == btnUpper) {
							txtOutput.setText(txtInput.getText().toUpperCase());
						}
						else if (e.getSource() == btnLower) {
							txtOutput.setText(txtInput.getText().toLowerCase());
						}
					}
				}
		
		txtInput = new JTextField();
		txtInput.setColumns(16);
		add(txtInput);
		
		txtOutput = new JTextField();
		txtOutput.setEditable(false);
		txtOutput.setColumns(16);
		add(txtOutput);
		
		// ActionListener for the buttons
		ButtonListener bl = new ButtonListener();
		
		btnUpper = new JButton("Upper Case");
		btnUpper.addActionListener(bl);
		add(btnUpper);
		
		btnLower = new JButton("Lower Case");
		btnLower.addActionListener(bl);
		add(btnLower);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(bl);
		add(btnClear);
	}
}
