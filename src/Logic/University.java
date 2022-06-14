package Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class University {
	//attributes
	private ArrayList<Person> staff;
	private Faculty computerFac;
	
	//getters
	public ArrayList<Person> getStaff() {
		return staff;
	}

	public Faculty getComputerFac() {
		return computerFac;
	}
	
	//constructor
	public University() {
		computerFac= new Faculty();
	}
	
	public ArrayList<Office> officesWithMoreVisitByMonth(int month){
		ArrayList<Office> offices=new ArrayList<Office>();
		if (month>=1 && month<=12) {
			int greater=0;
			for (Office o: computerFac.getOffices()) {
				int visits=0;
				for (Register r: o.getRegister()) {
					if (r.getCheckInDate().getMonth()+1==month) {
						visits++;
					}
				}
				if (visits>0) {
					if (visits>greater) {
						greater=visits;
						offices.clear();
						offices.add(o);
						
					}else if(visits==greater){
						offices.add(o);
					}
				}
			}
		}
		return offices;
	}
}
