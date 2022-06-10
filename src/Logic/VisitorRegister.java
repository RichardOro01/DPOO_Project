package Logic;

import java.util.Date;

public class VisitorRegister extends Register {
	//attributes
	private String area;
	private String motive;
	private String ID;
	
	//getters
	public String getArea() {
		return area;
	}
	
	public String getMotive() {
		return motive;
	}
	
	public String getID() {
		return ID;
	}
	
	//setters		
	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public void setArea(String area) {
		this.area = area;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	//constructor
	public VisitorRegister(Date checkInDate, Date checkOutDate, Person person) {
		super(checkInDate, checkOutDate, person);
		
	}
}
