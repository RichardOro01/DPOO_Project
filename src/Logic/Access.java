package Logic;

public class Access {
	//attributes
	private String office;
	private String hour;
	
	
	//getters
	public String getOffice() {
		return office;
	}
	public String getHour() {
		return hour;
	}
	
	
	//setters
	public void setOffice(String office) {
		this.office = office;
	}	
	public void setHour(String hour) {
		this.hour = hour;
	}
		
	//constructor
	public Access(String office, String hour) {
		this.office = office;
		this.hour = hour;
	}
	
}
