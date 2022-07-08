package Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import Logic.University;

public class SortByDate implements Comparator<ArrayList<Integer>>{

	@Override
	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
		Date date1=University.getInstance().getComputerFac().getOffices().get(o1.get(0)).getRegister().get(o1.get(1)).getCheckInDate();
		Date date2=University.getInstance().getComputerFac().getOffices().get(o2.get(0)).getRegister().get(o2.get(1)).getCheckInDate();
		return (int)Math.floor(date1.getTime()-date2.getTime());
	}
	
}
