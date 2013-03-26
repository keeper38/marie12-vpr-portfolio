package misc;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;

public class MiscPane extends JPanel {
	// Computed by Eclipse
	private static final long serialVersionUID = 3997926774368346711L;

	public MiscPane() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		Misc_Border2 border2 = new Misc_Border2();
		tabbedPane.addTab("Border2", null, border2, null);
		
		Misc_StringSplit stringsplit = new Misc_StringSplit();
		tabbedPane.addTab("String Split", null, stringsplit, null);
		
		Misc_Table table1 = new Misc_Table();
		tabbedPane.addTab("Table", null, table1, null);
	}
}
