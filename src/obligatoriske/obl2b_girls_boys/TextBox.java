package obligatoriske.obl2b_girls_boys;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextBox extends JScrollPane {
	// Computed by Eclipse
	private static final long serialVersionUID = 3612327621468674005L;
	
	JTextArea txtArea;
	
	private void init() {
		this.add(txtArea);
		this.setViewportView(txtArea);
	}
	
	public TextBox(String init) {
		this.txtArea = new JTextArea(init);
		this.init();
	}
	public TextBox() {
		this.txtArea = new JTextArea();
		this.init();
	}
	
	public void addLine(String line) {
		this.txtArea.append("\n" + line);
	}
	
	public void addText(String text) {
		this.txtArea.append(text);
	}
}
