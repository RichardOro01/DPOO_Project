package Exceptions;

public class CIException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public CIException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
