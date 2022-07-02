package Interface;

public class DateChooserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String msg;
	public DateChooserException(String name) {
		this.name=name;
		this.msg="Error en la fecha <"+name+">";
	}
	public DateChooserException(int code) {
		if (code==1) {
			this.msg="Fecha de salida refiere a antes de la de entrada";
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getMsg() {
		return msg;
	}
}
