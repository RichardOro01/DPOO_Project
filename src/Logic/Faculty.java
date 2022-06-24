package Logic;

import java.util.ArrayList;

public class Faculty {
	//attributes
	private ArrayList<Office> offices;

	//getters
	public ArrayList<Office> getOffices() {
		return offices;
	}
	
	//constructor
	public Faculty() {
		offices = new ArrayList<Office>();
	}
}
