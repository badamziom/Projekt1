package myCalc.interfaces;

public interface StringListener {
	public void initiate(boolean start);
	public void saveToFile(String text);
	public void setText(String text);
	public boolean isItReady();
}
