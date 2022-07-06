package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Office {
	//attributes
	private String ID;
	private String classification;
	private Person supervisor;
	private ArrayList<Register> register;
	
	//getters
	public String getID() {
		return ID;
	}
	
	public String getClassification() {
		return classification;
	}

	public Person getSupervisor() {
		return supervisor;
	}
	
	public ArrayList<Register> getRegister() {
		return register;
	}

	//setters
	public void setClassification(String classification) {
		if(classification!=null&&!classification.isEmpty())
			this.classification = classification;
	}
	public void setSupervisor(Person supervisor) {
		if(supervisor.isInfo) { 
			if(!(supervisor instanceof Student) && !(supervisor instanceof Technical) ) {
				this.supervisor=supervisor;
			}
		}
	}
	public void setID(String ID) {
		this.ID = ID;
	}

	
	//constructor
	public Office(String ID, String classification, Person supervisor) {
		setID(ID);
		setClassification(classification);
		setSupervisor(supervisor);
		register = new ArrayList<Register>();
	}
	
	public ArrayList<Date> sortDate(){
		ArrayList<Date> result = new ArrayList<Date>();
		for(Register r: register) {
			result.add(r.getCheckInDate());
		}
		Collections.sort(result);
		return result;				
	}
	
	public ArrayList<Register> sortRegister(){
		ArrayList<Register> temporary = new ArrayList<Register>();
		for(Date d: sortDate()) {
			for(Register r: register) {
				if((r.getCheckInDate().equals(d))&&!temporary.contains(r)){
					temporary.add(r);
				}
			}
		}
		register.clear();
		register.addAll(temporary);
		return register;
	}
}
