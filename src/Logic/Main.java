package Logic;

import java.util.Date;
import java.util.Scanner;

import Interface.Login;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		University.getInstance();		
		Login.main(null);
//		//persona prueba
//		Professor p=new Professor("Pepe", "Antonio", "01022068706", true, null, null, null,  null);
//		
//		//oficinas de pruebas
//		Office of1=new Office("1", null, p);
//		Office of2=new Office("2", null, p);
//		Office of3=new Office("3", null, p);
//		University.getInstance().getComputerFac().getOffices().add(of1);
//		u.getComputerFac().getOffices().add(of2);
//		u.getComputerFac().getOffices().add(of3);
//		
//		
//		//visitas pruebas
//		Date d=new Date(1655245926535L);//salida de todas
//		of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022 
//		of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
//		of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
//		of1.getRegister().add(new Register(new Date(1649959974000L),d,p));//14/4/2022
//		of2.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
//		of2.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
//		of3.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
//		of3.getRegister().add(new Register(new Date(1649959974000L),d,p));//14/4/2022
//		
//		System.out.println("Prueba Reporte 1. Escriba el mes (1-12): ");
//		Scanner s=new Scanner(System.in);
//		int m=s.nextInt();
//		System.out.println("Locales: ");
//		
//		for (Office o: u.officesWithMoreVisitByMonth(m)) {
//			System.out.println(o.getID());
//		}
//				
//		System.out.println("Prueba Reporte 2. Escriba el tipo de persona para saber cuántos violaron el horario de acceso: ");
//		Scanner ss=new Scanner(System.in);
//		String tp=ss.nextLine();
//		ArrayList<ArrayList<Person>> persons= new ArrayList<ArrayList<Person>>();
//		
//		persons=u.visitOutOfTime(tp);
//			
//		for (int i=0; i< persons.size(); i++) {
//			for (int j=0; j<persons.get(i).size();j++) {
//				System.out.println("Local "+i+": "+persons.get(i).get(j).getName()+" "+persons.get(i).get(j).getLastName());
//			}
//		}	
//				
//		System.out.println("Prueba reporte 3. Introduzca el primer mes del rango de meses para saber el promedio de visitas");
//		int month1=s.nextInt();
//		System.out.println("Introduzca el segundo mes del rango de meses para saber el promedio de visitas");
//		int month2=s.nextInt();
//		System.out.println("Introduca el tipo de visitante del que desea conocer los datos");
//		String typePerson = ss.nextLine();		
//		double result= u.averageVisitsInMonthPerVisitor(month1, month2, typePerson);
//		System.out.println("El promedio de visitas en este rango de meses es de: "+result);
//		
//		System.out.println("Prueba reporte 4. Introduzca la edad inicial");
//		int age1=s.nextInt();
//		System.out.println("Prueba reporte 4. Introduzca la edad final");
//		int age2=s.nextInt();
//		persons=u.getVisitByAgeRange(age1, age2);
//		for (int i=0; i< persons.size(); i++) {
//			for (int j=0; j<persons.get(i).size();j++) {
//				System.out.println("Local "+i+": "+persons.get(i).get(j).getName()+" "+persons.get(i).get(j).getLastName());
//			}
//		}	
//		
//			
//		ss.close();
//		s.close();
	}	
}
