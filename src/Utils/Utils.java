package Utils;

import java.awt.event.KeyEvent;

import java.util.Date;

import javax.swing.JTextField;

public class Utils {
	public static String[] addSeleccioneCB(String[] arr) {
		int tf=arr.length;
		String[] list= new String[tf+1];
		list[0]="<Seleccione>";
		for (int i=1;i<=tf;i++) {
			list[i]=arr[i-1];
		}
		return list;
	}
	
	@SuppressWarnings("deprecation")
	public static String formatDate(Date date) {
		String fDate= new String();
		fDate=date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900)+" "+(date.getHours()>=10?date.getHours():"0"+date.getHours())+":"+(date.getMinutes()>=10?date.getMinutes():"0"+date.getMinutes());
		return fDate;
	}
	
	public static String tpSpa2Eng(String tp) {
		String tpEng=null;
		switch (tp) {
		case "Directivo":
			tpEng="Executive";
			break;
		case "Administrativo":
			tpEng="Administrative";
			break;
		case "Profesor":
			tpEng="Professor";
			break;
		case "Especialista":
			tpEng="Specialist";
			break;
		case "Técnico":
			tpEng="Technical";
			break;
		case "Estudiante":
			tpEng="Student";
			break;
		default:
			break;
		}
		return tpEng;
	}
	
	public static String tpEng2Spa(String tp) {
		String tpEng=null;
		switch (tp) {
		case "Executive":
			tpEng="Directivo";
			break;
		case "Administrative":
			tpEng="Administrativo";
			break;
		case "Professor":
			tpEng="Profesor";
			break;
		case "Specialist":
			tpEng="Especialista";
			break;
		case "Technical":
			tpEng="Técnico";
			break;
		case "Student":
			tpEng="Estudiante";
			break;
		default:
			break;
		}
		return tpEng;
	}
	

	public static void onlyLetters(KeyEvent e, JTextField txtName, int size) {
		int key = e.getKeyChar();					
		boolean capitalLetters = key >= 65 && key <=90;
		boolean lowercase = key >=97 && key<=122;
		boolean spaceBar = key == 32;
		boolean accent = key >=225 || key==233 || key == 237 || key==243 || key==250 || key==193 || key==201 
				|| key==205 || key==211 || key==218;
		if(txtName.getText().length()>=size || (!(capitalLetters||lowercase||spaceBar||accent))) {
			e.consume();
		}
	}
	public static void onlyNumbers(KeyEvent e, JTextField txtName, int size) {
		int key = e.getKeyChar();
		boolean numbers = key >= 48 && key <= 57;
		if(txtName.getText().length()>size||!numbers) {
			e.consume();
		}
	}
	public static void characterLimit(KeyEvent e,JTextField txtName, int size) {
		if(txtName.getText().length()>size) {
			e.consume();
		}
	}
		
	public static boolean isNumeric(String strNum) {
		try {
	        Double.parseDouble(strNum);
	        return true;
	    } catch (Exception nfe) {
	        return false;
	    }
  
	}
	
	@SuppressWarnings("deprecation")
	public static int calculateAgeByCI(String CI) {
		int age=0;
		double agems;
		Date birth=new Date();
		Date actual=new Date();
		int year=Integer.parseInt(CI.substring(0, 2));
		int month=Integer.parseInt(CI.substring(2, 4));
		int day=Integer.parseInt(CI.substring(4, 6));
		int century=Integer.parseInt(CI.substring(6, 7));
		if (century==9) {
			year+=1800;
		}else if (century <=5) {
			year+=1900;
		}else {
			year+=2000;
		}
		birth.setYear(year-1900);
		birth.setMonth(month-1);
		birth.setDate(day);
		agems=actual.getTime()-birth.getTime();
		agems/=31536000000L;
		age=(int) Math.floor(agems);
		return age;
	}
}

