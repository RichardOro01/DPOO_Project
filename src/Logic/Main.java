package Logic;

import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		University u=new University();
		
		//persona prueba
		Professor p=new Professor("Pepe", "Antonio", "0102068706", true, null, null, null,  null);
		//oficinas de pruebas
		Office of1=new Office("1", null, p);
		Office of2=new Office("2", null, p);
		Office of3=new Office("3", null, p);
		u.getComputerFac().getOffices().add(of1);
		u.getComputerFac().getOffices().add(of2);
		u.getComputerFac().getOffices().add(of3);
		
		
		//visitas pruebas
		Date d=new Date(1655245926535L);//salida de todas
		of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
		of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
		of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
		of1.getRegister().add(new Register(new Date(1649959974000L),d,p));//14/4/2022
		of2.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
		of2.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
		of3.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
		of3.getRegister().add(new Register(new Date(1649959974000L),d,p));//14/4/2022
		
		System.out.println("Prueba Reporte 1. Escriba el mes (1-12): ");
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		System.out.println("Locales: ");
		for (Office o: u.officesWithMoreVisitByMonth(m)) {
			System.out.println(o.getID());
		}
	}

}
