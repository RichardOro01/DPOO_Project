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
		if(project!=null&&!project.isEmpty()) 
			this.project = project;
		
	}
	
	//constructor
	public Specialist(String name, String lastName, String iDNumber, boolean isInfo,
			String project)  {
		super(name, lastName, iDNumber, isInfo);
		setProject(project);
	}
}
