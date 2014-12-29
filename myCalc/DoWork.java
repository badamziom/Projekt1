package myCalc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DoWork {
	
	private LinkedList<Character> operators;
	private LinkedList<Character> charNumbers;
	private LinkedList<Integer> numbers;
	private Set<Character> numSet;
	private Set<Character> opsSet;
	
	private boolean swap = false;
	private int lastIndex = 0;
	
	public DoWork() {
		
		operators = new LinkedList<Character>();
		charNumbers = new LinkedList<Character>();
		numbers = new LinkedList<Integer>();
		
		numSet = new HashSet<Character>();
		numSet.add('1');
		numSet.add('2');
		numSet.add('3');
		numSet.add('4');
		numSet.add('5');
		numSet.add('6');
		numSet.add('7');
		numSet.add('8');
		numSet.add('9');
		numSet.add('0');
		
		opsSet = new HashSet<Character>();
		opsSet.add('+');
		opsSet.add('-');
		opsSet.add('*');
		opsSet.add('/');
		opsSet.add('%');
		opsSet.add('!');
	}
	
	public void addOperator(char c) {
		
		this.swap = true;
		operators.add(c);
	}
	
	public void addNumber(char c) {
		
		if (swap) {
			StringBuilder sb = new StringBuilder();
			for(int x = lastIndex; x < charNumbers.size(); x++) {
				
				if(numSet.contains(charNumbers.get(x))) {
					sb.append(charNumbers.get(x));
					
				} else if(opsSet.contains(charNumbers.get(x))) {
					numbers.add(Integer.parseInt(sb.toString()));
					lastIndex = x;
					break;
				}
			}
		}
		charNumbers.add(c);
		this.swap = false;
	}
	
	public void calculate () {
		
		long result = 0;
		int firstNum = numbers.get(0);
		for(int x = 0; x < operators.size(); x++) {
			
			switch (operators.get(x)) {
			case '+': {
				if(x != 0) {
					result += numbers.get(x+1);
				} else {
					result += firstNum + numbers.get(x);
				}
			}
			case '-': {
				if(x != 0) {
					result -= numbers.get(x+1);
				} else {
					result -= firstNum - numbers.get(x);
				}
			}
			}
		}
	}
}
