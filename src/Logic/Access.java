package Logic;

import java.util.ArrayList;

public class Access {
	

	private ArrayList<String> clasifiaciones;
	private int hourIn;
	private int hourOut;

	public Access() {
		
		clasifiaciones=new ArrayList<String>(); 
	}
	
	public ArrayList<String> getClasifiaciones() {
		return clasifiaciones;
	}

	public void setClasifiaciones(ArrayList<String> clasifiaciones) {
		this.clasifiaciones = clasifiaciones;
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
