package obligatoriske;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Opg2a extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 8949817496531625354L;
	
	// Controls
	private JButton btnRead;
	private ButtonGroup bgOptions;
	private JRadioButton rbSortName, rbSortCircumference, rbSortArea, rbSortAddress, rbSortAddrDensity;
	
	//private JTable table;
	private String[] colNames;
	
	public Opg2a() {
		class Listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRead) {
					// Read button
				}
				
				else if(e.getSource() == rbSortName) {
					// Sort by name
				}
				
				else if(e.getSource() == rbSortCircumference) {
					// Sort by circumference
				}
				
				else if(e.getSource() == rbSortArea) {
					// Sort by area
				}
				
				else if(e.getSource() == rbSortAddress) {
					// Sort by address total
				}
				
				else if(e.getSource() == rbSortAddrDensity) {
					// Sort by address density
				}
			}
		}
		
		this.setLayout(new BorderLayout());
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
		
		bgOptions = new ButtonGroup();
		
		rbSortName = new JRadioButton("Name");
		rbSortCircumference = new JRadioButton("Circumference");
		rbSortArea = new JRadioButton("Area");
		rbSortAddress = new JRadioButton("Address Total");
		rbSortAddrDensity = new JRadioButton("Address Density");
		
		bgOptions.add(rbSortName);
		bgOptions.add(rbSortCircumference);
		bgOptions.add(rbSortArea);
		bgOptions.add(rbSortAddress);
		bgOptions.add(rbSortAddrDensity);
		
		buttonPane.add(rbSortName);
		buttonPane.add(rbSortCircumference);
		buttonPane.add(rbSortArea);
		buttonPane.add(rbSortAddress);
		buttonPane.add(rbSortAddrDensity);
		
		String[] cols = {"Name", "Circumference", "Area", "Address Total", "Address Density"};
		
		this.add(buttonPane, BorderLayout.WEST);
		this.add(new TablePane(cols), BorderLayout.CENTER);
	}
}
