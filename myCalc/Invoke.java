package myCalc.invoke;

import javax.swing.SwingUtilities;

import myCalc.gui.MainFrame;

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
