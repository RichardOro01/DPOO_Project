package Logic;

import java.util.ArrayList;

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
		this.classification = classification;
	}
	public void setSupervisor(Person supervisor) {
		if(supervisor.isInfo) { 
			if(!(supervisor instanceof Student) && !(supervisor instanceof Technical) ) {
				this.supervisor=supervisor;
			}
		}
	}
	
	//constructor
	public Office(String iD, String classification, Person supervisor) {
		ID = iD;
		this.classification = classification;
		this.supervisor = supervisor;
		register = new ArrayList<Register>();
	}
	
}
