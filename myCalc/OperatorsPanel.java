package myCalc.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import myCalc.interfaces.CalculationListener;

public class OperatorsPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -2056623716068129959L;

	private CalculationListener calcListener;
	
	private JButton add;
	private JButton substract;
	private JButton multiply;
	private JButton divide;
	private JButton mod;
	private JButton minus;
	
	public OperatorsPanel() {
		
		add 		= new JButton("+");
		substract	= new JButton("-");
		multiply	= new JButton("*");
		divide		= new JButton("/");
		mod 		= new JButton("%");
		minus 		= new JButton("!");
		
		add.addActionListener(this);
		substract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		mod.addActionListener(this);
		minus.addActionListener(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.BOTH;
		
		/////////ROW 1
		gc.gridx = 0;
		gc.gridy = 0;
		//gc.insets = new Insets(-26, 0, 0, 0);
		add(add, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		//gc.insets = new Insets(-26, 8, 0, 0);
		add(substract, gc);
		
		/////////ROW 2
		gc.gridx = 0;
		gc.gridy = 1;
		//gc.insets = new Insets(0, -2, 0, 0);
		add(multiply, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		//gc.insets = new Insets(0, 9, 0, 0);
		add(divide, gc);
		
		/////////ROW 3
		gc.gridx = 0;
		gc.gridy = 2;
		//gc.insets = new Insets(0, 1, 0, 0);
		add(mod, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		//gc.insets = new Insets(0, 9, 0, 0);
		add(minus, gc);
	}

	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton)e.getSource();
		
		if (calcListener != null) {
			
			if (clicked == add) {
				calcListener.encodedCalc('+', true);
				
			} else if (clicked == substract) {
				calcListener.encodedCalc('-', true);
				
			} else if (clicked == multiply) {
				calcListener.encodedCalc('*', true);
				
			} else if (clicked == divide) {
				calcListener.encodedCalc('/', true);
				
			} else if (clicked == mod) {
				calcListener.encodedCalc('%', true);
				
			} else if (clicked == minus) {
				calcListener.encodedCalc('!', true);
			}
		}
	}
	
	public void setCalculationListener(CalculationListener listener) {
		this.calcListener = listener;
	}
}
