package Logic;



public class Student extends Person{
	//attributes
	private int year;
	private int group;
	
	//getters
	public int getYear() {
		return year;
	}
	public int getGroup() {
		return group;
	}
	
	
	//setters
	public void setYear(int year)  {
		if(year>=1 && year<=4) 
			this.year = year;
		
	}
	public void setGroup(int group) {
		if(group>=1 && group<=4) 
			this.group = group;
		
	}
	
	//constructor
	public Student(String name, String lastName, String iDNumber, boolean isInfo,
			int year, int group) {
		super(name, lastName, iDNumber, isInfo);	
		setYear(year);		
		setGroup(group);
		
	}
}
