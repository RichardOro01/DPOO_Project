package Logic;

import java.util.ArrayList;

public class Access {
	

	private ArrayList<String> classification;
	private int hourIn;
	private int hourOut;

	public Access() {
		
		classification=new ArrayList<String>(); 
	}
	
	public ArrayList<String> getClassification() {
		return classification;
	}

	public void setClasifiaciones(ArrayList<String> classification) {
		this.classification = classification;
	}

	public int getHourIn() {
		return hourIn;
	}

	public void setHourIn(int hourIn) {
		this.hourIn = hourIn;
	}

	public int getHourOut() {
		return hourOut;
	}

	public void setHourOut(int hourOut) {
		this.hourOut = hourOut;
	}

}
