package myCalc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DoWork {

    private LinkedList<Double> numbers;
    private LinkedList<Character> operators;

    private Set<Character> numSet;
    private Set<Character> opsSet;

    public DoWork() {

        numbers = new LinkedList<Double>();
        operators = new LinkedList<Character>();

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
        numSet.add('.');

        opsSet = new HashSet<Character>();
        opsSet.add('+');
        opsSet.add('-');
        opsSet.add('*');
        opsSet.add('/');
        opsSet.add('%');
        opsSet.add('!');
    }

    public BigDecimal calculate(String chain) {

        BigDecimal result = BigDecimal.ZERO;
        StringBuilder sb = new StringBuilder();
        int x = 1;

        for (int i = 0; i < chain.length(); i++) {

            if (numSet.contains(chain.charAt(i))) {
                sb.append(chain.charAt(i));
                if (i + 1 == chain.length()) {
                    numbers.add(Double.parseDouble(sb.toString()));
                    sb.delete(0, sb.length());
                }
            } else {
                numbers.add(Double.parseDouble(sb.toString()));
                operators.add(chain.charAt(i));
                sb.delete(0, sb.length());
            }
        }

        result = BigDecimal.valueOf(numbers.get(0));
        Boolean negate = false;

        for (char op : operators) {
            switch (op) {
                case '+':
                    result = result.add(BigDecimal.valueOf(numbers.get(x)));
                    break;
                case '-':
                    result = result.subtract(BigDecimal.valueOf(numbers.get(x)));
                    break;
                case '*':
                    result = result.multiply(BigDecimal.valueOf(numbers.get(x)), MathContext.DECIMAL64);
                    break;
                case '/':
                    result = result.divide(BigDecimal.valueOf(numbers.get(x)), MathContext.DECIMAL64);
                    break;
                case '%':
                    result = result.remainder(BigDecimal.valueOf(numbers.get(x)), MathContext.DECIMAL64);
                    break;
                case '!':
                    negate = !negate;
                    break;
                default:
                    break;
            }
            x++;
        }
        if (negate) {
            result.negate();
        }
        result.stripTrailingZeros();
        return result;
    }
}
