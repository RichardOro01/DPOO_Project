package Logic;

public class Executive extends Person{
	//attributes
	private String position;
	private String area;
	
	//setters
	public void setPosition(String position) {
		if(position!=null&&!position.isEmpty())
			this.position = position;
	}
	public void setArea(String area) {
		if(area!=null&&!area.isEmpty())
			this.area = area;
	}
	
	//getters
	public String getPosition() {
		return position;
	}
	public String getArea() {
		return area;
	}
	
	//constructor
	public Executive(String name, String lastName, String iDNumber, boolean isInfo,
			String position, String area) {
		super(name, lastName, iDNumber, isInfo);
		setPosition(position);
		setArea(area);
	}
	
}
