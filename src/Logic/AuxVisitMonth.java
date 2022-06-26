package Logic;

import java.util.ArrayList;

public class AuxVisitMonth {
	private int visits;
	private ArrayList<Office> offices;
	public AuxVisitMonth(int visits, ArrayList<Office> offices) {
		super();
		this.visits = visits;
		this.offices = offices;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public ArrayList<Office> getOffices() {
		return offices;
	}
	public void setOffices(ArrayList<Office> offices) {
		this.offices = offices;
	}
	
}
