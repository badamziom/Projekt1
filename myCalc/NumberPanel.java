package myCalc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NumberPanel extends JPanel implements ActionListener {
	
	private CalculationListener calcListener;
	private ArrayList<Character> numbers;
	
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
		
		numbers = new ArrayList<Character>();
		
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
				numbers.add('1');
				calcListener.encodedCalc('1', true, false);
				
			} else if (clicked == two) {
				numbers.add('2');
				calcListener.encodedCalc('2', true, false);
				
			} else if (clicked == three) {
				numbers.add('3');
				calcListener.encodedCalc('3', true, false);
				
			} else if (clicked == four) {
				numbers.add('4');
				calcListener.encodedCalc('4', true, false);
				
			} else if (clicked == five) {
				numbers.add('5');
				calcListener.encodedCalc('5', true, false);
				
			} else if (clicked == six) {
				numbers.add('6');
				calcListener.encodedCalc('6', true, false);
				
			} else if (clicked == seven) {
				numbers.add('7');
				calcListener.encodedCalc('7', true, false);
				
			} else if (clicked == eight) {
				numbers.add('8');
				calcListener.encodedCalc('8', true, false);
				
			} else if (clicked == nine) {
				numbers.add('9');
				calcListener.encodedCalc('9', true, false);
				
			} else if (clicked == zero) {
				numbers.add('0');
				calcListener.encodedCalc('0', true, false);
				
			} else if (clicked == point) {
				numbers.add('.');
				calcListener.encodedCalc('.', true, false);
			}
		}
	}
	
	public void setCalculationListener(CalculationListener listener) {
		this.calcListener = listener;
	}
}
