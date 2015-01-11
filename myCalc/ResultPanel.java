package myCalc.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import myCalc.interfaces.StringListener;

public class ResultPanel extends JPanel implements DocumentListener{

	private static final long serialVersionUID = 5822025834028765880L;
	
	private StringListener strListener;
	
	private static JTextArea textArea;
	
	public ResultPanel() {
		
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		
		textArea.getDocument().addDocumentListener(this);
		
		textArea.setEditable(false);
		Font font = textArea.getFont();
		float size = font.getSize() + 5.0f;
		textArea.setFont(font.deriveFont(size));
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String c) {
		textArea.append(c);
	}
	
	public void clrScr() {
		textArea.setText(null);
	}
	
	public static String getText() {
		return textArea.getText();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		
		if(this.strListener != null) {
			if(textArea != null) {
				strListener.setText(textArea.getText());
			} else {
				strListener.setText("null");
			}
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {

		/*if(this.strListener != null) {
			if(textArea != null) {
				strListener.setText(textArea.getText());
			} else {
				strListener.setText("null");
			}
		}*/
	}
	
	public void setStringListener(StringListener listener) {
		this.strListener = listener;
	}
}
