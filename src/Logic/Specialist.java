package Logic;

public class Specialist extends Person {
	//attributes
	private String project;

	//getters
	public String getProject() {
		return project;
	}

	//setters
	public void setProject(String project) {
		this.project = project;
	}
	
	//constructor
	public Specialist(String name, String lastName, String iDNumber, boolean isInfo, Access access, String kindOfPerson,
			String project) {
		super(name, lastName, iDNumber, isInfo, access, kindOfPerson);
		this.project = project;
	}
}
