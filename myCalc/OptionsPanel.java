package myCalc.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import myCalc.interfaces.StringListener;

public class OptionsPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 4444387810876942859L;
	
	private StringListener strListener;
	private JButton save;
	
	public OptionsPanel() {
		
		save = new JButton("Save");
		
		save.addActionListener(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.SOUTH;
		add(save, gc);	
	}
	
	public void setStringListener(StringListener listener) {
		this.strListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton)e.getSource();
		
		if(this.strListener != null) {
			if(clicked == save) {
				this.strListener.initiate(true);
			}
		}
	}
}
