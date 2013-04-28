package obligatoriske;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import obligatoriske.obl3a_streams_polymorphism.*;

public class Opg3a extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = -2229854961780918407L;
	
	// Fields
	private JButton btnMakePerson;
	private JButton btnReadText;
	private JButton btnReadData;
	private JButton btnReadObj;
	
	// Action listener
	private class ReadListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FileIOInterface fileIO = null;
			if (e.getSource() == btnReadText) {
				// Read text file
				fileIO = new TextFileIO();
			}
			else if (e.getSource() == btnReadData) {
				// Read data file
				fileIO = new DataFileIO();
			}
			else if (e.getSource() == btnReadObj) {
				// Read object file
			}
			try {
				ArrayList<Person> list = (ArrayList<Person>) fileIO.getPersonList();
				for (int i = 0; i<list.size(); i++) System.out.println(list.get(i));
			}
			catch (NullPointerException ex) {
				System.err.println("Error: Could not generate list");
				System.err.println(ex.toString());
			}
			catch (Exception ex2) {
				System.err.println("Something really weird is going on! :O");
				System.err.println(ex2.toString());
				ex2.printStackTrace();
			}
		}
	}
	private class WriteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnMakePerson) {
				// Make person
				MakePersonPanel mpp = new MakePersonPanel();
				int optReturnVal = JOptionPane.showConfirmDialog(null, mpp, "Make person", JOptionPane.OK_CANCEL_OPTION);
				if (optReturnVal == 0) {
					// In case a user inputs faulty data
					try {
						new TextFileIO().addPerson(mpp.getPerson());
						new DataFileIO().addPerson(mpp.getPerson());
						new ObjectFileIO().addPerson(mpp.getPerson());
					}
					catch (Exception ex) {
						System.out.println("You may have entered faulty information");
					}
				}
				else {
					// User cancelled or something
				}
			}
		}
		
	}
	
	// Methods
	
	public Opg3a() {
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setLayout(new GridLayout(2, 2, 50, 50));
		
		btnMakePerson = new JButton("Make person");
		btnReadText = new JButton("Read text file");
		btnReadData = new JButton("Read data file");
		btnReadObj = new JButton("Read object file");
		
		btnMakePerson.addActionListener(new WriteListener());
		ReadListener listener = new ReadListener();
		btnReadText.addActionListener(listener);
		btnReadData.addActionListener(listener);
		btnReadObj.addActionListener(listener);
		
		setBackground(Color.WHITE);
		btnMakePerson.setBackground(Color.RED);
		btnReadText.setBackground(Color.RED);
		btnReadData.setBackground(Color.RED);
		btnReadObj.setBackground(Color.RED);
		btnMakePerson.setForeground(Color.WHITE);
		btnReadText.setForeground(Color.WHITE);
		btnReadData.setForeground(Color.WHITE);
		btnReadObj.setForeground(Color.WHITE);
		
		add(btnMakePerson);
		add(btnReadText);
		add(btnReadData);
		add(btnReadObj);
	}
}
