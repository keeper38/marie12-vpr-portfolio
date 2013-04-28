package obligatoriske.obl3a_streams_polymorphism;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class MakePersonPanel extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 5671106010288716291L;
	
	private JPanel panel;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel saleryLabel;
	private JTextField saleryTextField;
	private JLabel idLabel;
	private JTextField idTextField;

	/**
	 * Create the panel.
	 */
	public MakePersonPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		this.panel = new JPanel();
		add(this.panel);
		this.panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.nameLabel = new JLabel("Name");
		this.panel.add(this.nameLabel);
		
		this.nameTextField = new JTextField();
		this.panel.add(this.nameTextField);
		this.nameTextField.setColumns(10);
		
		this.saleryLabel = new JLabel("Salery");
		this.panel.add(this.saleryLabel);
		
		this.saleryTextField = new JTextField();
		this.panel.add(this.saleryTextField);
		this.saleryTextField.setColumns(10);
		
		this.idLabel = new JLabel("Employee ID");
		this.panel.add(this.idLabel);
		
		this.idTextField = new JTextField();
		this.panel.add(this.idTextField);
		this.idTextField.setColumns(10);

	}
	
	public Person getPerson(){
		return new Person(Integer.parseInt(idTextField.getText()), 
				Double.parseDouble(saleryTextField.getText()), 
				nameTextField.getText());
	}

}
