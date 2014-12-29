package myCalc;

public interface CalculationListener {
	public void encodedCalc(char calculation, boolean wasNumLast, boolean wasOperatorLast);
}
