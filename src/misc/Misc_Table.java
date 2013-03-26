package misc;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * First try using JTables. This example works only with four columns.
 * TODO: Restrict selection to one row at a time
 */

public class Misc_Table extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 8462364343373174179L;
	
	// The table itself
	private JTable table;
	
	// Column names
	private String[] colNames = {"One", "Two", "Three", "Four"};
	private JScrollPane scrollPane;
	
	// Adds a row to the bottom.
	private JButton btnAdd;
	
	// Adds a row above the selected. (Or at the bottom if no row is selected)
	private JButton btnAddAbove;
	
	// Removes the selected row. (Or the bottom one if no row is selected)
	private JButton btnRemove;

	public Misc_Table() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
		
		scrollPane = new JScrollPane();
		add(scrollPane);
		add(buttonPane);
		
		// Empty set of test data (We start with one row in the table)
		Object[][] data = {{null, null, null, null}};
		
		table = new JTable(data, colNames);
		scrollPane.setViewportView(table);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new BtnAddActionListener());
		buttonPane.add(btnAdd);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new BtnRemoveActionListener());
		
		btnAddAbove = new JButton("Add Above");
		btnAddAbove.addActionListener(new BtnAddAboveActionListener());
		buttonPane.add(btnAddAbove);
		buttonPane.add(btnRemove);
	}
	
	private void updateTable(Object[][] data, String[] collumnNames) {
		// Takes the data, puts it into the table and updates the ScrollPane
		table = new JTable(data, collumnNames);
		scrollPane.setViewportView(table);
	}
	
	private void updateTable(Object[][] data) {
		// Takes the data, puts it into the table and updates the ScrollPane
		// Does not need name input
		int collumnCount = table.getColumnModel().getColumnCount();
		String[] collumnNames = new String[collumnCount];
		
		for(int i = 0; i < collumnCount; i++) {
			collumnNames[i] = table.getColumnName(i);
		}
		
		table = new JTable(data, collumnNames);
		scrollPane.setViewportView(table);
	}
	
	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// Adds a row to the table
			Object[][] somedata = new Object[table.getRowCount()+1][table.getColumnCount()];
			for(int i = 0; i<somedata.length - 1; i++) {
				for(int u = 0; u<somedata[i].length; u++) {
					somedata[i][u] = table.getValueAt(i, u);
				}
			}
			
			if(somedata.length > 0) {
				somedata[somedata.length-1] = new Object[somedata[0].length];
				updateTable(somedata);
			}
		}
	}
	
	private class BtnRemoveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// Removes the selected row from the table
			// If no row is selected, the bottom one will be removed
			
			if(table.getRowCount() == 0) return;
			
			Object[][] somedata = new Object[table.getRowCount()-1][table.getColumnCount()];
			boolean skiprow = false;
			for(int i = 0; i<somedata.length; i++) {
				if(table.isRowSelected(i)) skiprow = true;
				
				if(skiprow) {
					for(int u = 0; u<somedata[i].length; u++) {
						somedata[i][u] = table.getValueAt(i+1, u);
					}
				}
				else {
					for(int u = 0; u<somedata[i].length; u++) {
						somedata[i][u] = table.getValueAt(i, u);
					}
				}
			}
			updateTable(somedata);
		}
	}
	private class BtnAddAboveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Adds a row to the table above the selected row
			// If no row is selected, a the new row will just be added to the bottom
			
			Object[][] somedata = new Object[table.getRowCount()+1][table.getColumnCount()];
			boolean newrow = false; // Set to true if we reach a selected row
			for(int i = 0; i<somedata.length - 1; i++) {
				
				if(table.isRowSelected(i) && !newrow) {
					newrow = true;
					somedata[i] = new Object[somedata[0].length];
				}
				
				if(!newrow) {
					for(int u = 0; u<somedata[i].length; u++) {
						somedata[i][u] = table.getValueAt(i, u);
					}
				}
				else {
					for(int u = 0; u<somedata[i].length; u++) {
						somedata[i+1][u] = table.getValueAt(i, u);
					}
				}
			}
			
			if(somedata.length > 0 && !newrow) {
				somedata[somedata.length-1] = new Object[somedata[0].length];
				updateTable(somedata);
			}
			else if(somedata.length > 0) {
				updateTable(somedata);
			}
		}
	}
}
