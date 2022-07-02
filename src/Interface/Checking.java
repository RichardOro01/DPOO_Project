package Interface;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;



import com.toedter.calendar.JDateChooser;

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
	public static void checkCI(String CI) throws CIException {
		if (!Utils.isNumeric(CI) || CI.length()!=11) {
			throw new CIException("El CI debe tener 11 d�gitos");
		}
	}
}
