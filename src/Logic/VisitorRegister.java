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

	public void setID(String ID) {
		this.ID = ID;
	}
	
	//constructor
	public VisitorRegister(Date checkInDate, Date checkOutDate, Person person, String area, String motive, String ID) {
		super(checkInDate, checkOutDate, person);
		setMotive(motive);
		setArea(area);
		setID(ID);
	}
}
