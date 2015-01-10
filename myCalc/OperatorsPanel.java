package myCalc.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {

	private static final long serialVersionUID = 5307792467600369271L;
	
	private JTextArea textArea;
	
	public TextPanel() {
		/*
		Dimension dim = getPreferredSize();
		dim.height = 83;
		dim.width = 300;
		setPreferredSize(dim);
		*/
		
		textArea = new JTextArea();
		setLayout(new BorderLayout());
	
		textArea.setEditable(false);
		
		Font font = textArea.getFont();
		float size = font.getSize() + 5.0f;			//TODO changeable
		textArea.setFont(font.deriveFont(size));
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(Character c) {
		textArea.append(c.toString());
	}
	
	public void clrScr() {
		textArea.setText(null);
	}
	
	public void deleteLastCharacter() {

		StringBuilder sb = new StringBuilder();
		sb.append(textArea.getText());
		sb.deleteCharAt(sb.length()-1);
		textArea.setText(sb.toString());
		sb.delete(0, sb.length());
	}
}
