package Logic;

import java.util.ArrayList;

public class Office {
	//attributes
	private String ID;
	private String classification;
	private String supervisor;
	private ArrayList<Fact> data;
	
	//getters
	public String getID() {
		return ID;
	}
	
	public String getClassification() {
		return classification;
	}

	public String getSupervisor() {
		return supervisor;
	}
	
	public ArrayList<Fact> getData() {
		return data;
	}

	//setters
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	//constructor
	public Office(String iD, String classification, String supervisor, ArrayList<Fact> data) {
		ID = iD;
		this.classification = classification;
		this.supervisor = supervisor;
		this.data = data;
	}
	
}
