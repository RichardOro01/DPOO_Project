package Utils;

import java.util.Date;

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
	
	public static String formatDate(Date date) {
		String fDate= new String();
		fDate=(date.getYear()+1900)+"/"+date.getMonth()+"/"+date.getDay()+" "+(date.getHours()>=10?date.getHours():"0"+date.getHours())+":"+(date.getMinutes()>=10?date.getMinutes():"0"+date.getMinutes());
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
	
}
