package Logic;

import java.util.Date;

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
	public String getFullName() {
		return name+" "+lastName;
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
	
	public int calculateAge() {
		int age=0;
		long agems;
		Date birth=new Date();
		Date actual=new Date();
		int year=Integer.parseInt(getIDNumber().substring(0, 2));
		int month=Integer.parseInt(getIDNumber().substring(2, 4));
		int day=Integer.parseInt(getIDNumber().substring(4, 6));
		int century=Integer.parseInt(getIDNumber().substring(6, 7));
		if (century==9) {
			year+=1800;
		}else if (century <=5) {
			year+=1900;
		}else {
			year+=2000;
		}
		birth.setYear(year-1900);
		birth.setMonth(month);
		birth.setDate(day);
		agems=actual.getTime()-birth.getTime();
		age=(int)(agems/31536000000L);
		return age;
	}
	
	
	//constructor
	public Person(String name, String lastName, String iDNumber, boolean isInfo) {
		setName(name);
		setLastName(lastName);
		setIDNumber(iDNumber);
		setInfo(isInfo);
		
	}
	
	
}
