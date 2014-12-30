package myCalc;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultPanel extends JPanel {
	
	private JTextArea textArea;
	
	public ResultPanel() {
		
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		
		textArea.setEditable(false);
		Font font = textArea.getFont();
		float size = font.getSize() + 5.0f;			//TODO changeable
		textArea.setFont(font.deriveFont(size));
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String c) {
		textArea.append(c);
	}
	
	public void clrScr() {
		textArea.setText(null);
	}
}
