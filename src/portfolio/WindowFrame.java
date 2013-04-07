/*
 * Portfolio:		marie12
 * License:			Marie Public License revision 1 (Found in the file "LICENSE")
 * Version:			0.1
 * Code quality:	Putrid
 * 
 * This code will be kept on GitHub under the user sdumarie12.
 * 
 * Contains obligatory assignments in accordingly named tabs.
 * A second JTabbedPane under the 'Miscellaneous' contains non-essential
 * assignments, such as testing, training and proof of concept.
 * 
 * Some fields and variables from ported projects has been renamed to them more
 * distinguishable from each other and avoid confusion.
 * 
 * Possible current problems:
 * 		Naming - I have attempted to name everything properly, but there may still be some bad names
 * 		Irregular use of ActionListeners - Inner classes, one or more buttons? I plan to normalize this
 */

package portfolio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class WindowFrame extends JFrame {
	// Computed by Eclipse
	private static final long serialVersionUID = -8917222429298875280L;
	
	public static WindowFrame accessor;
	
	private JPanel mainContentPane;
	private JTabbedPane mainTabbedPane;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowFrame frame = new WindowFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowFrame() {
		// This way, all classes can access the window functions
		// I know this is probably an unholy violation of all good programming practices
		WindowFrame.accessor = this;
		setTitle("Portfolio marie12 - 2013");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainContentPane = new JPanel();
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainContentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(mainContentPane);
		setMinimumSize(new Dimension(450, 300));
		
		mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainContentPane.add(mainTabbedPane, BorderLayout.CENTER);
		
		// Add obligatory tabs
		mainTabbedPane.addTab("opg1a", null, new obligatoriske.Opg1a(), null);
		mainTabbedPane.addTab("opg1b", null, new obligatoriske.Opg1b(), null);
		mainTabbedPane.addTab("opg2a", null, new obligatoriske.Opg2a(), null);
		mainTabbedPane.addTab("opg2b", null, new obligatoriske.Opg2b(), null);
		
		// Add miscellaneous tabs (All under one tab)
		mainTabbedPane.addTab("Miscellaneus", null, new misc.MiscPane(), null);
	}
	
}
