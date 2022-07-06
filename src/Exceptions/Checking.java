package Exceptions;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;



import com.toedter.calendar.JDateChooser;

import Logic.University;
import Utils.Utils;

public class Checking {
	public static void checkEmpty(JTextField text) throws EmptyTextFormException {
		if (text.getText().equals("")) {
			throw new EmptyTextFormException(text.getName());
		}
	}
	public static void checkNotSelected(JComboBox cb) throws NotSelectedException {
		String selected=(String)cb.getSelectedItem();
		if (selected.equals("<Seleccione>")) {
			throw new NotSelectedException(cb.getName());
		}
	}
	public static void checkDate(JDateChooser date) throws DateChooserException{
		if (date.getDate()==null) {
			throw new DateChooserException(date.getName());
		}
	}
	public static void checkDateAfterDate(Date entrada, Date salida) throws DateChooserException {
		if (entrada.compareTo(salida)>=0) {
			throw new DateChooserException(1);
		}
	}
	public static void monthGreaterMonth(int n1, int n2) throws DateChooserException {
		if (n1>n2) {
			throw new DateChooserException(2);
		}
	}
	public static void ageGreaterAge(int n1, int n2) throws DateChooserException {
		if (n1>n2) {
			throw new DateChooserException(3);
		}
	}
	
	public static void checkCI(String CI) throws CIException {
		if (!Utils.isNumeric(CI) || CI.length()!=11) {
			throw new CIException("El CI debe tener 11 dígitos");
		}
	}
	public static void checkExistingCI(String CI) throws CIException {
		if (University.getInstance().getPersonByID(CI)!=null) {
			throw new CIException("Ya existe una persona con el CI");
		}
	}
	public static void checkExistingLocalID(String id) throws LocalException{
		if (University.getInstance().getOfficeById(id)!=null) {
			throw new LocalException("Ya existe un local con esa ID");
		}
	}
}
