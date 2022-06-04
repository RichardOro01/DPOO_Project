package Logic;

public class Fact {
	//attributes
	private Fact checkInDate;
	private Fact checkOutDate;
	private Person person;
	
	//getters
	public Fact getCheckInDate() {
		return checkInDate;
	}
	public Fact getCheckOutDate() {
		return checkOutDate;
	}
	public Person getPerson() {
		return person;
	}
	
	//setters
	public void setCheckInDate(Fact checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	public void setCheckOutDate(Fact checkOutDate) {
		this.checkOutDate = checkOutDate;
	}	
}
