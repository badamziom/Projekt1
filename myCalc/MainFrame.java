package myCalc.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import myCalc.calculations.DoWork;
import myCalc.interfaces.CalculationListener;
import myCalc.saving.SaveToResultCommunication;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = -7220987384328102003L;
	
	private TextPanel calcArea;
	private NumberPanel numberButtons;
	private ResultPanel resultArea;
	private OptionsPanel options;
	private OperatorsPanel operatorsPanel;
	private JButton submitButton;
	
	private File file;
	
	private SaveToResultCommunication saveToResComm;
	
	private StringBuilder sb;
	private StringBuilder sb2;
	
	private BigDecimal currentResult;
	private BigDecimal currentResult2;
	private LinkedList<BigDecimal> numList;
	
	private char nextOperator;
	private char currentOperator;
	
	private boolean wasOL1;
	private boolean wasOL2;
	private boolean firstNum;
	
	private int listIterator;

	public MainFrame(String title) {
		
		super(title);
		
		calcArea = new TextPanel();
		numberButtons = new NumberPanel();
		resultArea = new ResultPanel();
		options = new OptionsPanel();
		operatorsPanel = new OperatorsPanel();
		submitButton = new JButton("Submit");
		
		file = new File("Wynik.txt");
		
		saveToResComm = new SaveToResultCommunication(file);
		
		currentResult = BigDecimal.ZERO;
		currentResult2 = BigDecimal.ZERO;
		
		numList = new LinkedList<BigDecimal>();
		
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		
		wasOL1 = false;
		wasOL2 = false;
		firstNum = true;
		
		listIterator = 1;
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			System.out.println("Nimbus L&F not found");
		}
		
		options.setStringListener(saveToResComm);
		resultArea.setStringListener(saveToResComm);
		
		operatorsPanel.setCalculationListener(new CalculationListener() {
			
			public void encodedCalc(char calculation, boolean wasOperatorLast) {
				
				sb2.delete(0, sb2.length());
				
				if(wasOL1) {
					wasOL2 = true;
				}
				if(wasOperatorLast) {
					wasOL1 = true;
				}
				if(wasOL1 && !wasOL2) {
					calcArea.appendText(calculation);
					sb.append(calculation);
				}
				if(wasOL1 && wasOL2) {
					calcArea.deleteLastCharacter();
					sb.deleteCharAt(sb.length()-1);
					calcArea.appendText(calculation);
					sb.append(calculation);
				}
				
				if(!firstNum) {
					
					DoWork dw = new DoWork();
					currentOperator = nextOperator;
					
					nextOperator = sb.charAt(sb.length() - 1);
					sb.deleteCharAt(sb.length() - 1);

					numList.add(new BigDecimal(sb.toString()));
					sb.delete(0, sb.length());
					
					currentResult = dw.calculate(currentResult, numList.get(listIterator), currentOperator);
					listIterator++;
					
					resultArea.clrScr();
					resultArea.appendText(currentResult.toString());
				}
				else {
					nextOperator = sb.charAt(sb.length() - 1);
					sb.deleteCharAt(sb.length() - 1);

					numList.add(new BigDecimal(sb.toString()));
					
					currentResult = new BigDecimal(sb.toString());
					sb.delete(0, sb.length());
					firstNum = false;
				}
			}
		});
		
		numberButtons.setCalculationListener(new CalculationListener() {
			
			public void encodedCalc(char calculation, boolean wasOperatorLast) {
				
				if(!wasOperatorLast) {
					wasOL1 = false;
					wasOL2 = false;
				}
				
				calcArea.appendText(calculation);
				sb.append(calculation);
				sb2.append(calculation);
				
				if(!firstNum) {
					
					DoWork dw = new DoWork();
					
					currentResult2 = dw.calculate(currentResult, new BigDecimal(sb2.toString()), nextOperator);
					
					resultArea.clrScr();
					resultArea.appendText(currentResult2.toString());
				}
				else {
					resultArea.clrScr();
					resultArea.appendText(sb.toString());
				}

			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				calcArea.clrScr();
				numList.removeAll(numList);
				firstNum = true;
				wasOL1 = false;
				wasOL2 = false;
				listIterator = 1;
				currentResult = BigDecimal.ZERO;
				currentResult2 = BigDecimal.ZERO;
				sb.delete(0, sb.length());
				sb2.delete(0, sb2.length());
				//resultArea.clrScr();
			}
		});
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		/////////ROW 1
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0; 
		gc.ipady = 83;
		gc.anchor = GridBagConstraints.NORTH;
		add(calcArea, gc);
		
		/////////ROW 2
		gc.ipady = 5;
		gc.gridx = 0;
		gc.gridy = 1;
		add(resultArea, gc);
		
		/////////ROW 3
		gc.gridx = 0;
		gc.gridy = 2;
		add(submitButton, gc);
		
		/////////ROW 4
		gc.ipady = 0;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 3;
		add(numberButtons, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(operatorsPanel, gc);
		
		/////////ROW 5
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 4;
		add(options, gc);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}
}
