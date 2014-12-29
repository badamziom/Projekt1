package myCalc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel {
	
	private JButton save;
	
	public OptionsPanel() {
		
		save = new JButton("Save");
		
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
}
