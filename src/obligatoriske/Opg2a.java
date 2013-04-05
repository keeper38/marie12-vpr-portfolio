/*
 * This class is a panel that visualises information on Danish islands
 * provided by a special file.
 * 
 * Current state: Working, but needs a little work
 * 
 * TODO: Clean and comment the code
 * TODO: Trying to sort without loaded data results in exceptions
 * TODO: Resize on selecting this tab, to make the column names visible
 * TODO: Scanner won't read Danish special characters
 * TODO: Sort on names by default, when data is successfully loaded
 * TODO: Make more TODOs
 */

package obligatoriske;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Opg2a extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 8949817496531625354L;
	
	// Controls
	private JButton btnRead;
	private ButtonGroup bgOptions;
	private JRadioButton rbSortName, rbSortCircumference, rbSortArea, rbSortAddrTotal, rbSortAddrDensity;
	
	// Data
	private ArrayList<DanishIsland> loadedData; // To hold the formatted data
	private Object[][] islandDataArray;	// To hold the parsed data
	
	// Home made panel with table and functions for updating the table (Bad code)
	private TablePane tpData;
	// The names of the columns
	private final String[] COLNAMES = {"Name", "Circumference", "Area", "Address Total", "Address Density"};
	
	// ------------------------------ Methods ------------------------------ //
	
	private Object[][] dataToArray(ArrayList<DanishIsland> data) {
		
		// Then we make an 2D Object array and parse the lines into it
		Object[][] parseddata = new Object[data.size()][];
		int i = 0;
		for (DanishIsland island : data) {
			parseddata[i] = island.toArray();
			i++;
		}
		
		return parseddata;
	}
	
	// Sorts the data
	private void sortData(int compmode) {
		IslandComparator comp = new IslandComparator(compmode);
		Collections.sort(loadedData, comp);
		tpData.setData(dataToArray(loadedData));
	}
	
	// Constructor
	public Opg2a() {
		class Listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRead) {
					// Read button
					
					// Filter out .txt files
					FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text files", "txt");
					JFileChooser filechooser = new JFileChooser(".");
					// Be sure that one can only select files
					filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					// Limit one to only open text files
					filechooser.setFileFilter(fnef);
					// Show the dialog
					int chooserErrorCode = filechooser.showOpenDialog(null);

					Scanner sc;
					if (chooserErrorCode == 0) {
						try {
							// Load the file into a string
							sc = new Scanner(filechooser.getSelectedFile());
							loadedData = new ArrayList<DanishIsland>();
							
							String holder[];
							
							// This will hold the island data for initialisation
							String name;
							double circumference, area;
							int addresstotal, addressdensity;
							
							while (sc.hasNextLine()) {
								holder = sc.nextLine().split(";");
								if(holder.length == 5) {
									// This should probably be in its own try{}
									name = holder[0];
									circumference = Double.parseDouble(holder[1]);
									area = Double.parseDouble(holder[2]);
									addresstotal = Integer.parseInt(holder[3]);
									addressdensity = Integer.parseInt(holder[4]);
									loadedData.add(new DanishIsland(name, circumference, area, addresstotal, addressdensity));
								}
							}

							// When done, close the scanner and show the result
							sc.close();
							
							// Now we parse the data and save it in memory
							islandDataArray = dataToArray(loadedData);
							if(islandDataArray.length > 1) {
								// We do not want to parse an empty dataset to the table
								tpData.setData(islandDataArray);
							}
						}
						catch (Exception ex) {/* TODO: Handle errors */}
					}
					else {
						// User pressed Cancel or something
					}
				}
				
				else if(e.getSource() == rbSortName) {
					// Sort by name
					sortData(IslandComparator.COMPARE_NAME);
				}
				
				else if(e.getSource() == rbSortCircumference) {
					// Sort by circumference
					sortData(IslandComparator.COMPARE_CIRCUMFERENCE);
				}
				
				else if(e.getSource() == rbSortArea) {
					// Sort by area
					sortData(IslandComparator.COMPARE_AREA);
				}
				
				else if(e.getSource() == rbSortAddrTotal) {
					// Sort by address total
					sortData(IslandComparator.COMPARE_ADDRESSTOTAL);
				}
				
				else if(e.getSource() == rbSortAddrDensity) {
					// Sort by address density
					sortData(IslandComparator.COMPARE_ADDRESSDENSITY);
				}
			}
		}
		
		Listener al = new Listener();
		
		this.setLayout(new BorderLayout());
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
		
		bgOptions = new ButtonGroup();
		
		rbSortName = new JRadioButton("Name");
		rbSortCircumference = new JRadioButton("Circumference");
		rbSortArea = new JRadioButton("Area");
		rbSortAddrTotal = new JRadioButton("Address Total");
		rbSortAddrDensity = new JRadioButton("Address Density");
		
		rbSortName.addActionListener(al);
		rbSortCircumference.addActionListener(al);
		rbSortArea.addActionListener(al);
		rbSortAddrTotal.addActionListener(al);
		rbSortAddrDensity.addActionListener(al);
		
		bgOptions.add(rbSortName);
		bgOptions.add(rbSortCircumference);
		bgOptions.add(rbSortArea);
		bgOptions.add(rbSortAddrTotal);
		bgOptions.add(rbSortAddrDensity);
		
		buttonPane.add(rbSortName);
		buttonPane.add(rbSortCircumference);
		buttonPane.add(rbSortArea);
		buttonPane.add(rbSortAddrTotal);
		buttonPane.add(rbSortAddrDensity);
		
		btnRead = new JButton("Read");
		btnRead.addActionListener(al);
		buttonPane.add(btnRead);
		
		Object[][] startdata = {{"", "", "", "", ""}};
		
		this.add(buttonPane, BorderLayout.WEST);
		tpData = new TablePane(COLNAMES, startdata);
		this.add(tpData, BorderLayout.CENTER);
	}
}
