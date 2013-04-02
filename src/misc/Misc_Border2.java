package misc;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Misc_Border2 extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = -1339452772867563669L;
	
	JTextArea txtOutput;
	
	public Misc_Border2() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scPaneCenter = new JScrollPane();
		add(scPaneCenter, BorderLayout.CENTER);
		
		txtOutput = new JTextArea();
		scPaneCenter.setViewportView(txtOutput);
		
		JButton btnNorth = new JButton("North");
		btnNorth.addActionListener(new BtnNorthActionListener());
		add(btnNorth, BorderLayout.NORTH);
		
		JButton btnSouth = new JButton("South");
		btnSouth.addActionListener(new BtnSouthActionListener());
		add(btnSouth, BorderLayout.SOUTH);
		
		JButton btnWest = new JButton("West");
		btnWest.addActionListener(new BtnWestActionListener());
		add(btnWest, BorderLayout.WEST);
		
		JButton btnEast = new JButton("East");
		btnEast.addActionListener(new BtnEastActionListener());
		add(btnEast, BorderLayout.EAST);
	}

	private class BtnNorthActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtOutput.append("You clicked: North\n");
		}
	}
	private class BtnSouthActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtOutput.append("You clicked: South\n");
		}
	}
	private class BtnWestActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtOutput.append("You clicked: West\n");
		}
	}
	private class BtnEastActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtOutput.append("You clicked: East\n");
		}
	}
}
