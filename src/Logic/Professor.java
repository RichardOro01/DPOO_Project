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
	public void setTypeOfContract(String typeOfContract) {
		this.typeOfContract = typeOfContract;
	}
		
	//constructor
	public Professor(String name, String lastName, String iDNumber, boolean isInfo, String kindOfPerson,
			String department, String teachingCategory, String scientificCategory, String typeOfContract) {
		super(name, lastName, iDNumber, isInfo, kindOfPerson);
		setDepartment(department);
		setTeachingCategory(teachingCategory);
		setScientificCategory(scientificCategory);
		setTypeOfContract(typeOfContract);
	}
}