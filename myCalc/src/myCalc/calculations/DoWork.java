package myCalc.calculations;

import java.math.BigDecimal;
import java.math.MathContext;

public class DoWork {

	public BigDecimal calculate(BigDecimal num1, BigDecimal num2, char op) {
		
		switch(op) {
		case '+': 
			return num1.add(num2);
		case '-':
			return num1.subtract(num2);
		case '*':
			return num1.multiply(num2, MathContext.DECIMAL64);
		case '/':
			return num1.divide(num2, MathContext.DECIMAL64);
		case '%':
			return num1.remainder(num2, MathContext.DECIMAL64);
		case '!':
			return num1.add(num2).negate();
		default :
			return BigDecimal.ZERO;
		}
	}
}
