package Exceptions;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;



import com.toedter.calendar.JDateChooser;

import Logic.Office;
import Logic.Person;
import Logic.University;
import Utils.Utils;

public class Checking {
	public static void checkEmpty(JTextField text) throws EmptyTextFormException {
		if (text.getText().equals("")) {
			throw new EmptyTextFormException(text.getName());
		}
	}
	public static void checkNotSelected(JComboBox<Object> cb) throws NotSelectedException {
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
		int a=Integer.parseInt(CI.substring(0, 2));
		int m=Integer.parseInt(CI.substring(2, 4));
		int d=Integer.parseInt(CI.substring(4, 6));
		int century=Integer.parseInt(CI.substring(6, 7));
		if (century==9) {
			a+=1800;
		}else if (century <=5) {
			a+=1900;
		}else {
			a+=2000;
		}
		if((a < 1800) || (m < 1) || (m > 12) || (d < 1) || (d > 31))
			throw new CIException("El CI es inválido");
		else
		{
			if((a%4 != 0) && (m == 2) && (d > 28))      
				throw new CIException("El CI es inválido");
			else 
			{
				if ((((m == 4) || (m == 6) || (m == 9) || (m==11)) && (d>30)) || ((m==2) && (d>29)))
					throw new CIException("El CI es inválido");                                       
			}  
		} 

	}
	public static void checkFuture(String CI) throws CIException {
		if(Utils.calculateAgeByCI(CI)<0) {
			throw new CIException("El CI no puede ser del futuro");
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
	public static void checkDeletablePerson(Person p) throws DeletePersonException{
		for (Office off:University.getInstance().getComputerFac().getOffices()) {
			if (off.getSupervisor()==p) {
				throw new DeletePersonException("La persona es supervisora del local "+off.getID()+"\nDebe cambiar su supervisor antes de eliminarla");
			}
		}
	}
}
