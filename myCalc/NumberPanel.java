package myCalc.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import myCalc.interfaces.CalculationListener;

public class NumberPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 2555302672523422797L;

	private CalculationListener calcListener;
	
	/////////ROW 1
	private JButton one;
	private JButton two;
	private JButton three;
	
	/////////ROW 2
	private JButton four;
	private JButton five;
	private JButton six;
	
	/////////ROW 3
	private JButton seven;
	private JButton eight;
	private JButton nine;
	
	/////////ROW 4
	private JButton zero;
	private JButton point;
	
	public NumberPanel() {
		
		/////////ROW 1
		one 	= new JButton("1");
		two 	= new JButton("2");
		three 	= new JButton("3");

		/////////ROW 2
		four 	= new JButton("4");
		five 	= new JButton("5");
		six 	= new JButton("6");
		
		/////////ROW 3
		seven 	= new JButton("7");
		eight 	= new JButton("8");
		nine 	= new JButton("9");
		
		/////////ROW 4
		zero 	= new JButton("0");
		point 	= new JButton(".");
		
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		
		zero.addActionListener(this);
		point.addActionListener(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		
		/////////ROW 1
		gc.gridx = 0;
		gc.gridy = 0;
		add(one, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(two, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		add(three, gc);
		
		/////////ROW 2
		gc.gridx = 0;
		gc.gridy = 1;
		add(four, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(five, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		add(six, gc);
		
		/////////ROW 3
		gc.gridx = 0;
		gc.gridy = 2;
		add(seven, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(eight, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(nine, gc);
		
		/////////ROW 4
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 3;
		add(zero, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(point, gc);
	}
	
	public void actionPerformed(ActionEvent e) {

		JButton clicked = (JButton)e.getSource();
		
		if (calcListener != null) {
			
			if (clicked == one) {
				calcListener.encodedCalc('1', false);
				
			} else if (clicked == two) {
				calcListener.encodedCalc('2', false);
				
			} else if (clicked == three) {
				calcListener.encodedCalc('3', false);
				
			} else if (clicked == four) {
				calcListener.encodedCalc('4', false);
				
			} else if (clicked == five) {
				calcListener.encodedCalc('5', false);
				
			} else if (clicked == six) {
				calcListener.encodedCalc('6', false);
				
			} else if (clicked == seven) {
				calcListener.encodedCalc('7', false);
				
			} else if (clicked == eight) {
				calcListener.encodedCalc('8', false);
				
			} else if (clicked == nine) {
				calcListener.encodedCalc('9', false);
				
			} else if (clicked == zero) {
				calcListener.encodedCalc('0', false);
				
			} else if (clicked == point) {
				calcListener.encodedCalc('.', false);
			}
		}
	}
	
	public void setCalculationListener(CalculationListener listener) {
		this.calcListener = listener;
	}
}
