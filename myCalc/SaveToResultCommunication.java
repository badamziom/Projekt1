package myCalc.saving;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import myCalc.interfaces.StringListener;

public class SaveToResultCommunication implements StringListener{
	
	private File outputFile;
	
	private String text;
	
	public SaveToResultCommunication(File outputFile) {
		this.outputFile = outputFile;
	}

	public void initiate(boolean start) {
	
		if(start) {
			saveToFile(text);
		}
	}

	public void saveToFile(String text) {
		
		if(isItReady()) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

				bw.write(text);
				bw.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Nope");
		}
	}
	
	public boolean isItReady() {
		
		if(this.text == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
