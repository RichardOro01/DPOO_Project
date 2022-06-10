package Logic;

public class Executive extends Person{
	//attributes
	private String position;
	private String area;
	
	//getters
	public String getPosition() {
		return position;
	}
	public String getArea() {
		return area;
	}
	
	//constructor
	public Executive(String name, String lastName, String iDNumber, boolean isInfo, String kindOfPerson,
			String position, String area) {
		super(name, lastName, iDNumber, isInfo,kindOfPerson);
		this.position = position;
		this.area = area;
	}
	
}
