package Logic;

public abstract class Person {
	
	//attributes
	protected String name;
	protected String lastName;
	protected String IDNumber;
	protected boolean isInfo;
	
	
	
	//getters
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public boolean isInfo() {
		return isInfo;
	}
	
		
	//setters
	public void setName(String name) {
		if(name.length()<=15)
			this.name = name;
	}
	
	public void setLastName(String lastName) {
		if(lastName.length()<=15)
			this.lastName = lastName;
	}
	
	public void setIDNumber(String IDNumber) {
		this.IDNumber = IDNumber;
	}
	
	public void setInfo(boolean isInfo) {
		this.isInfo = isInfo;
	}
	
	
	//constructor
	public Person(String name, String lastName, String iDNumber, boolean isInfo) {
		setName(name);
		setLastName(lastName);
		setIDNumber(IDNumber);
		setInfo(isInfo);
		
	}
	
	
}
