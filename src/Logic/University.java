package Logic;

import java.util.ArrayList;
import java.util.Date;

public class University {
	//attributes
	private ArrayList<Person> staff;
	private Faculty computerFac;
	private static University instance;
	//getters
	public ArrayList<Person> getStaff() {
		return staff;
	}
	
	public static University getInstance() {
		if(instance==null) {
			instance = new University();
		}
		return instance;
	}

	public Faculty getComputerFac() {
		return computerFac;
	}
	
	//constructor
	private University() {
		computerFac= new Faculty();
		staff=new ArrayList<Person>();
	}
	
	public AuxVisitMonth officesWithMoreVisitByMonth(int month){
		AuxVisitMonth aux;
		ArrayList<Office> offices=new ArrayList<Office>();
		int greater=0;
		if (month>=1 && month<=12) {
			
			for (Office o: computerFac.getOffices()) {
				int visits=0;
				for (Register r: o.getRegister()) {
					if (r.getCheckInDate().getMonth()+1==month) {
						visits++;
					}
				}
				if (visits>0) {
					if (visits>greater) {
						greater=visits;
						offices.clear();
						offices.add(o);
						
					}else if(visits==greater){
						offices.add(o);
					}
				}
				
			}
			
		}
		aux=new AuxVisitMonth(greater, offices);
		return aux;
	}
	
	public ArrayList<Access> getAccess(Person person) {
		ArrayList<Access> acc= new ArrayList<Access>();
		switch (person.getClass().getSimpleName()) {
			case "Executive":
			case "Administrative":
				Access aa=new Access();
				aa.getClassification().add("*");
				aa.setHourIn(person.isInfo()?-1:8);
				aa.setHourOut(person.isInfo()?-1:12);
				acc.add(aa);
				break;
			case "Professor":
				Access ab=new Access();
				ab.getClassification().add("Local de estudiantes");
				ab.getClassification().add("Local de profesores");
				ab.getClassification().add("Aula");
				ab.getClassification().add("Laboratorio");
				ab.setHourIn(person.isInfo()?-1:8);
				ab.setHourOut(person.isInfo()?-1:12);
				acc.add(ab);
				Access ac=new Access();
				ac.getClassification().add("Local del decano");
				ac.getClassification().add("Local del vicedecano");
				ac.getClassification().add("Local de especialistas");
				ac.getClassification().add("Local de área administrativa");
				ac.getClassification().add("Local de jefe de departamento");
				ac.setHourIn(8);
				ac.setHourOut(person.isInfo()?17:12);
				acc.add(ac);
				break;
			case "Specialist":
			case "Technical":	
				Access ad=new Access();
				ad.getClassification().add("Laboratorios");
				ad.getClassification().add("Local de profesores");
				ad.getClassification().add("Local de estudiantes");
				ad.getClassification().add("Local de especialistas");
				ad.setHourIn(person.isInfo()?-1:8);
				ad.setHourOut(person.isInfo()?-1:12);
				acc.add(ad);
				Access ae=new Access();
				ae.getClassification().add("Local del decano");
				ae.getClassification().add("Local del vicedecano");
				ae.getClassification().add("Local de profesores");
				ae.getClassification().add("Local de área administrativa");
				ae.getClassification().add("Local de jefe de departamento");
				ae.setHourIn(8);
				ae.setHourOut(person.isInfo()?17:12);
				acc.add(ae);
				break;
			case "Student":
				Access af=new Access();
				af.getClassification().add("Local de estudiantes");
				af.getClassification().add("Local de profesores");
				af.getClassification().add("Aula");
				af.getClassification().add("Laboratorio");
				af.setHourIn(person.isInfo()?-1:8);
				af.setHourOut(person.isInfo()?-1:12);
				acc.add(af);
				break;				
		}
		return acc;
	}
	
	public Person getPersonByFullName(String fullName) {
		Person person=null;
		for (Person p: staff) {
			String name=new String();
			name=p.getName()+" "+p.getLastName();
			if (name.equals(fullName))
				person=p;
		}
		return person;
	}
	
	public Office getOfficeById(String id) {
		Office office=null;
		for (Office o: getComputerFac().getOffices()) {
			if (o.getID().equals(id)){
					office=o;
			}
		}
		return office;
	}
	
	public ArrayList<ArrayList<Person>> visitOutOfTime(String typePerson){
		ArrayList<ArrayList<Person>> persons= new ArrayList<ArrayList<Person>>();
		for (Office o: computerFac.getOffices()) {
			ArrayList<Person> aux=new ArrayList<Person>();
			for (Register r: o.getRegister()) {
				String nameClass=r.getPerson().getClass().getSimpleName();
				if (typePerson.equals(nameClass)) {
					ArrayList<Access> a=new ArrayList<Access>();
					a=getAccess(r.getPerson());
					for (Access acc: a) {
						if (r.getCheckInDate().getHours()+1<acc.getHourIn() || r.getCheckOutDate().getHours()+1>acc.getHourOut()) {
							if (!aux.contains(r.getPerson())){
								aux.add(r.getPerson());
							}
						}
					}
				}
			}
			persons.add(aux);
		}
		return persons;
	}



	public double averageVisitsInMonthPerVisitor(int month1, int month2, String typePerson) {		
		int assis=0;
		for(Office o: computerFac.getOffices()) {
			for(Register r: o.getRegister()) {
				if(r.getPerson().getClass().getSimpleName().equalsIgnoreCase(typePerson) && 
						(r.getCheckInDate().getMonth()+1>=month1 && r.getCheckInDate().getMonth()+1<= month2)) {
					assis++;
				}
			}	
		}		
		return ((double)assis/(month2-month1+1));
	}
	
	public ArrayList<ArrayList<Person>> getVisitByAgeRange(int age1, int age2){
		ArrayList<ArrayList<Person>> list=new ArrayList<ArrayList<Person>>();
		for(Office o: computerFac.getOffices()) {
			ArrayList<Person> list2 = new ArrayList<Person>();
			for(Register r: o.getRegister()) {
				int age=r.getPerson().calculateAge();
				if (age>=age1 && age<=age2 && !list2.contains(r.getPerson())) {
					list2.add(r.getPerson());
				}
			}
			list.add(list2);
		}		 
		return list;
	}
	//datos automaticos para DPOO
	
	public void automaticData() {
		
		//personas
		Executive d=new Executive("Raul","Gonzales","70022446543",true,"Decano","Decanato");
		Administrative a=new Administrative("Marla","Campos","59032336533",false,"Secretaria");
		Professor p=new Professor("Sergio", "Marquina", "69012126563", true,"Departamento 1", "Titular","Doctor","Determinado");
		Specialist s=new Specialist("Susana","Hernandez","86041516553",true,"proyecto SIGENU");
		Technical t=new Technical("Carlos","Pacheco","82050206583",true,"Plaza 1");
		Student e=new Student("Aitana","Rodriguez","01102166523",true,2,2);
		
		//oficinas
		Office of1=new Office("0110", "Local de decano", d);
		Office of2=new Office("0210", "Local de servidores", a);
		Office of3=new Office("0310", "Local de profesores", p);
		Office of4=new Office("0410", "Local de estudiantes", p);
		
		//registros
		of1.getRegister().add(new Register(new Date(1654077600000L),new Date(1654084800000L),d)); //fecha de entrada:  1/6/2022-10:00am  || fecha de salida: 1/6/2022-12:00pm 
		of1.getRegister().add(new Register(new Date(1654164000000L),new Date(1654171200000L),a)); //fecha de entrada:  2/6/2022-10:00am  || fecha de salida: 2/6/2022-12:00pm
		of1.getRegister().add(new Register(new Date(1654250400000L),new Date(1654257600000L),d)); //fecha de entrada:  3/6/2022-10:00am  || fecha de salida: 3/6/2022-12:00pm
		of2.getRegister().add(new Register(new Date(1647252000000L),new Date(1647259200000L),s)); //fecha de entrada:  14/3/2022-10:00am || fecha de salida: 14/3/2022-12:00pm
		of2.getRegister().add(new Register(new Date(1647338400000L),new Date(1647345600000L),t)); //fecha de entrada:  15/3/2022-10:00am || fecha de salida: 15/3/2022-12:00pm
		of2.getRegister().add(new Register(new Date(1647439200000L),new Date(1647453600000L),s)); //fecha de entrada:  16/3/2022-14:00pm || fecha de salida: 16/3/2022-18:00pm
		of3.getRegister().add(new Register(new Date(1652688000000L),new Date(1652716800000L),p)); //fecha de entrada:  16/5/2022-08:00am || fecha de salida: 16/5/2022-16:00pm
		of3.getRegister().add(new Register(new Date(1652778000000L),new Date(1652806800000L),t)); //fecha de entrada:  17/5/2022-09:00am || fecha de salida: 17/5/2022-17:00pm
		of3.getRegister().add(new Register(new Date(1652871600000L),new Date(1652886000000L),a)); //fecha de entrada:  18/5/2022-11:00am || fecha de salida: 18/5/2022-15:00pm
		of4.getRegister().add(new Register(new Date(1645434000000L),new Date(1645477200000L),e)); //fecha de entrada:  21/2/2022-09:00am || fecha de salida: 21/2/2022-21:00pm || excede fecha de salida 
		of4.getRegister().add(new Register(new Date(1645516800000L),new Date(1645531200000L),p)); //fecha de entrada:  22/2/2022-08:00am || fecha de salida: 22/2/2022-12:00pm
		of4.getRegister().add(new Register(new Date(1645603200000L),new Date(1645621200000L),e)); //fecha de entrada:  23/2/2022-08:00am || fecha de salida: 23/2/2022-13:00pm		
	}
	
	//datos automaticos para casos pruebas en JUnit
	
	public void automaticDataForMethod2(int manyOffice, int manyRegister) {
		
		//persona prueba
		Professor p=new Professor("Pepe", "Antonio", "01022068706", true, null, null, null,  null);
		
		//oficinas de prueba
		if (manyOffice == 0) {//una sola oficina
			Office of1 = new Office("1",null,p);
			Date d=new Date(1655245926535L);//salida de todas
			// visitas de pruebas
			if(manyRegister==1) {//solo un registro
				of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
				University.getInstance().getComputerFac().getOffices().add(of1);
			}else if(manyRegister>1) {//cuatro registros
				of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022 
				of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
				of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
				of1.getRegister().add(new Register(new Date(1649959974000L),d,p));//14/4/2022
				
				University.getInstance().getComputerFac().getOffices().add(of1);
			}
		}else{//para probar mas de una oficina
			Office of1=new Office("1", null, p);
			Office of2=new Office("2", null, p);
			Office of3=new Office("3", null, p);
			Date d=new Date(1655245926535L);//salida de todas
			of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022 
			of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
			of1.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
			of1.getRegister().add(new Register(new Date(1649959974000L),d,p));//14/4/2022
			of2.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
			of2.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
			of3.getRegister().add(new Register(new Date(1647281574000L),d,p));//14/3/2022
			of3.getRegister().add(new Register(new Date(1649959974000L),d,p));//14/4/2022
			
			University.getInstance().getComputerFac().getOffices().add(of1);
			University.getInstance().getComputerFac().getOffices().add(of2);
			University.getInstance().getComputerFac().getOffices().add(of3);

		}
		
	}
	public void automaticDataForMethod1(int test) {
		if(test==0) {
			Professor p=new Professor("Pepe", "Antonio", "01022068706", true, null, null, null,  null);
			Office of1=new Office("0110", null, p);
			University.getInstance().getComputerFac().getOffices().add(of1);	
		}else if(test>0) {
			Professor p=new Professor("Pepe", "Antonio", "01022068706", true, null, null, null,  null);
			Office of1=new Office("1", null, p);
			University.getInstance().getComputerFac().getOffices().add(of1);
		}else {
			University.getInstance();
		}
	}
	
}	
