package Logic;

public class Professor extends Person {
	//attributes
	private String department;
	private String teachingCategory;
	private String scientificCategory;
	private String typeOfContract;
	//getters
	public String getDepartment() {
		return department;
	}
	public String getTeachingCategory() {
		return teachingCategory;
	}
	public String getTypeOfContract() {
		return typeOfContract;
	}
	public String getScientificCategory() {
		return scientificCategory;
	}
	
	//setters
	public void setDepartment(String department) {
		this.department = department;
	}	
	public void setTeachingCategory(String teachingCategory) {
		this.teachingCategory = teachingCategory;
	}	
	public void setScientificCategory(String scientificCategory) {
		this.scientificCategory = scientificCategory;
	}
}