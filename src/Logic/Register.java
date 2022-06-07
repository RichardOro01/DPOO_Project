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
		this.checkInDate = checkInDate;
	}
	
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
		
	//constructor
	public Register(Date checkInDate, Date checkOutDate, Person person) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.person = person;
	}
}
