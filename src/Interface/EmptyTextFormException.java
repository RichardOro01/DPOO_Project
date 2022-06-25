package Interface;

public class EmptyTextFormException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	public EmptyTextFormException(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public String getMsg() {
		return "Campo <"+name+"> vacío";
	}
	
}
