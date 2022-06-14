package Logic;

public class Technical extends Person {
	//attributes
	private String job;
		
	//getters
	public String getJob() {
		return job;
	}
			
	//setters
	public void setJob(String job) {
		this.job=job;
	}

	//constructor
	public Technical(String name, String lastName, String iDNumber, boolean isInfo, String kindOfPerson,
			String job) {
		super(name, lastName, iDNumber, isInfo, kindOfPerson);
		setJob(job);
	}		
}
