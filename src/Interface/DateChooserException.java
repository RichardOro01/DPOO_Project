package Interface;

public class DateChooserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	public DateChooserException(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public String getMsg() {
		return "Error en la fecha <"+name+">";
	}
}
