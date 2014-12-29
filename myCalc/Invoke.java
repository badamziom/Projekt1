package myCalc;

import javax.swing.SwingUtilities;

public class Invoke {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame("Calc");
			}
		}); 
	}
}
