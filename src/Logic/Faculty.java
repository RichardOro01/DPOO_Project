package Logic;

import java.util.ArrayList;
import java.util.Collections;

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
	
	public ArrayList<String> orderAlphabetically(){
		ArrayList<String> result = new ArrayList<String>();
		for(Office o: offices) {
			result.add(o.getID());
		}
		Collections.sort(result);
		return result;				
	}
	
	public void sortOfficeAlphabetically(){
		ArrayList<Office> temporary = new ArrayList<Office>();
		for(String n: orderAlphabetically()) {
			for(Office o : offices) {
				if((o.getID().equalsIgnoreCase(n))){
					temporary.add(o);
				}
			}
		}
		offices.clear();
		offices.addAll(temporary);
	}
}
