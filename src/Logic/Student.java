package Logic;

public class Student extends Person{
	//attributes
	private String year;
	private String group;
	
	//getters
	public String getYear() {
		return year;
	}
	public String getGroup() {
		return group;
	}
	
	
	//setters
	public void setYear(String year) {
		this.year = year;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	//constructor
	public Student(String name, String lastName, String iDNumber, boolean isInfo, Access access, String kindOfPerson,
			String year, String group) {
		super(name, lastName, iDNumber, isInfo, access, kindOfPerson);
		this.year = year;
		this.group = group;
	}
}
