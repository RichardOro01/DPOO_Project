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
		if(job!=null&&!job.isEmpty())
			this.job = job;
	}

	
	//constructor
	public Administrative(String name, String lastName, String iDNumber, boolean isInfo , String job) {
		super(name,lastName,iDNumber,isInfo);
		setJob(job);
	}
}
