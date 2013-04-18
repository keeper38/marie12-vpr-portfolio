package obligatoriske.obl2b_girls_boys;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GirlsAndBoysPanel extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 8198080141455932899L;
	private JButton findCommonNames;
	TextBox txtField;
	
	public GirlsAndBoysPanel() {
		
		this.setLayout(new BorderLayout());
		
		
		this.findCommonNames = new JButton("Common Names");
		this.findCommonNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GirlsAndBoys(txtField);
			}
		});
		this.txtField = new TextBox();
		add(this.findCommonNames, BorderLayout.NORTH);
		add(this.txtField, BorderLayout.CENTER);
	}
}
