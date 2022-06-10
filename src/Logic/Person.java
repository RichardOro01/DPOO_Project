package Logic;

public abstract class Person {
	
	//attributes
	protected String name;
	protected String lastName;
	protected String IDNumber;
	protected boolean isInfo;
	protected String kindOfPerson;
	
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
		this.name = name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	
	public void setInfo(boolean isInfo) {
		this.isInfo = isInfo;
	}
		
	//constructor
	public Person(String name, String lastName, String iDNumber, boolean isInfo,String kindOfPerson) {
		this.name = name;
		this.lastName = lastName;
		this.IDNumber = iDNumber;
		this.isInfo = isInfo;
		this.kindOfPerson = kindOfPerson;
	}
	
	
}
