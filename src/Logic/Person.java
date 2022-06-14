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
	public String getKindOfPerson() {
		return kindOfPerson;
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
	
	public void setKindOfPerson(String kindOfPerson) {
		this.kindOfPerson = kindOfPerson;
	}
	//constructor
	public Person(String name, String lastName, String iDNumber, boolean isInfo,String kindOfPerson) {
		setName(name);
		setLastName(lastName);
		setIDNumber(IDNumber);
		setInfo(isInfo);
		setKindOfPerson(kindOfPerson);
	}
	
	
}
