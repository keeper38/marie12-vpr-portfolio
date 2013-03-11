package misc;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Misc_StringSplit extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 8323570929868024497L;

	private JTextField txtSplitRegex;
	
	private JTextArea txtInput;
	private JTextArea txtOutput;
	
	private JButton btnSplit;
	private JButton btnClear;
	
	public Misc_StringSplit() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scPaneInput = new JScrollPane();
		add(scPaneInput);
		
		txtInput = new JTextArea();
		txtInput.setWrapStyleWord(true);
		txtInput.setLineWrap(true);
		scPaneInput.add(txtInput);
		scPaneInput.setViewportView(txtInput);
		
		JScrollPane scPaneOutput = new JScrollPane();
		add(scPaneOutput);
		
		txtOutput = new JTextArea();
		txtOutput.setWrapStyleWord(true);
		txtOutput.setLineWrap(true);
		scPaneOutput.add(txtOutput);
		scPaneOutput.setViewportView(txtOutput);
		
		JPanel ControlPanel = new JPanel();
		ControlPanel.setPreferredSize(new Dimension(100, 18));
		add(ControlPanel);
		
		txtSplitRegex = new JTextField();
		txtSplitRegex.setPreferredSize(new Dimension(80, 24));
		txtSplitRegex.setColumns(4);
		ControlPanel.add(txtSplitRegex);
		
		btnSplit = new JButton("Split");
		btnSplit.addActionListener(new BtnSplitActionListener());
		btnSplit.setPreferredSize(new Dimension(80, 24));
		ControlPanel.add(btnSplit);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new BtnClearActionListener());
		btnClear.setPreferredSize(new Dimension(80, 24));
		ControlPanel.add(btnClear);
	}

	private class BtnSplitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] splittedText = txtInput.getText().split(txtSplitRegex.getText());
			txtOutput.setText("");
			for (int i = 0; i < splittedText.length; i++) {
				// Append every element in the array followed by a new line
				txtOutput.append(splittedText[i].concat("\n"));
			}
		}
	}
	private class BtnClearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Clear the view
			txtInput.setText("");
			txtOutput.setText("");
			txtSplitRegex.setText("");
		}
	}
}
