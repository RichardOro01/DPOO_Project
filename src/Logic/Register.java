package Logic;

import java.util.Date;

public class Register{
	//attributes
	private Date checkInDate;
	private Date checkOutDate;
	private Person person;
	
	//getters
	public Date getCheckInDate() {
		return checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public Person getPerson() {
		return person;
	}
	
	//setters
	public void setCheckInDate(Date checkInDate) {
		if(checkInDate.compareTo(checkOutDate)<0) 
			this.checkInDate=checkInDate;
		
	}
	
	public void setCheckOutDate(Date checkOutDate) {
		if(checkOutDate.compareTo(checkInDate)>0)
			this.checkOutDate = checkOutDate;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
		
	//constructor
	public Register(Date checkInDate, Date checkOutDate, Person person) {
		setCheckInDate(checkInDate);
		setCheckOutDate(checkOutDate);				
		setPerson(person);
	}
}
