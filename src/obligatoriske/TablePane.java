package obligatoriske;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePane extends JScrollPane {
	// Computed by Eclipse
	private static final long serialVersionUID = 5492487579315840283L;
	
	private JTable table;
	private String[] columns;
	private Object[][] data;
	
	private void tableViewUpdate() {
		this.setViewportView(this.table);
	}
	
	public void setData(Object[][] data) {
		// Validate data, put it into the table and update the view
		
		// First check if there is at least one row of data
		if(data.length >= 1) {
			// If so, then check if the data is split in the same number of columns as the table already is
			if(data[0].length == this.table.getColumnCount()) {
				// Success! Make the table and update the view
				table = new JTable(data, this.columns);
				tableViewUpdate();
			}
			// Incorrect number of columns
			// Nothing happens
		}
		// No rows.
	}
	
	public TablePane(String[] columnnames, Object[][] datainput) {
		// TODO: Check if there are an equal number of 
		this.columns = columnnames;
		this.data = datainput;
		table = new JTable(data, this.columns);
		tableViewUpdate();
	}
}
