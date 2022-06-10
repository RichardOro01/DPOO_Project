package Logic;

public class Administrative extends Person {
	//attributes
	private String job;
	
	//getters
	public String getJob() {
		return job;
	}

		
	//setters
	public void setJob(String job) {
		this.job = job;
	}

	
	//constructor
	public Administrative(String job, String name, String lastName, String iDNumber, boolean isInfo, String kindOfPerson) {
		super(name,lastName,iDNumber,isInfo,kindOfPerson);
		this.job = job;
	}
}
