package Logic;

import java.util.ArrayList;

public class University {
	//attributes
	private ArrayList<Person> staff;
	private Faculty computerFac;
	
	//getters
	public ArrayList<Person> getStaff() {
		return staff;
	}

	public Faculty getComputerFac() {
		return computerFac;
	}
	
	//constructor
	public University() {
		computerFac= new Faculty();
	}
	
	public ArrayList<Office> officesWithMoreVisitByMonth(int month){
		ArrayList<Office> offices=new ArrayList<Office>();
		if (month>=1 && month<=12) {
			int greater=0;
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
		return offices;
	}
	
	public ArrayList<Access> getAccess(Person person) {
		ArrayList<Access> acc= new ArrayList<Access>();
		switch (person.getClass().getSimpleName()) {
			case "Executive":
			case "Administrative":
				Access aa=new Access();
				aa.getClasifiaciones().add("*");
				aa.setHourIn(person.isInfo()?-1:8);
				aa.setHourOut(person.isInfo()?-1:12);
				acc.add(aa);
				break;
			case "Professor":
				Access ab=new Access();
				ab.getClasifiaciones().add("Local de estudiantes");
				ab.getClasifiaciones().add("Local de profesores");
				ab.getClasifiaciones().add("Aula");
				ab.getClasifiaciones().add("Laboratorio");
				ab.setHourIn(person.isInfo()?-1:8);
				ab.setHourOut(person.isInfo()?-1:12);
				acc.add(ab);
				Access ac=new Access();
				ac.getClasifiaciones().add("Local del decano");
				ac.getClasifiaciones().add("Local del vicedecano");
				ac.getClasifiaciones().add("Local de especialistas");
				ac.getClasifiaciones().add("Local de área administrativa");
				ac.getClasifiaciones().add("Local de jefe de departamento");
				ac.setHourIn(8);
				ac.setHourOut(person.isInfo()?17:12);
				acc.add(ac);
				break;
			case "Specialist":
			case "Technical":	
				Access ad=new Access();
				ad.getClasifiaciones().add("Laboratorios");
				ad.getClasifiaciones().add("Local de profesores");
				ad.getClasifiaciones().add("Local de estudiantes");
				ad.getClasifiaciones().add("Local de especialistas");
				ad.setHourIn(person.isInfo()?-1:8);
				ad.setHourOut(person.isInfo()?-1:12);
				acc.add(ad);
				Access ae=new Access();
				ae.getClasifiaciones().add("Local del decano");
				ae.getClasifiaciones().add("Local del vicedecano");
				ae.getClasifiaciones().add("Local de profesores");
				ae.getClasifiaciones().add("Local de área administrativa");
				ae.getClasifiaciones().add("Local de jefe de departamento");
				ae.setHourIn(8);
				ae.setHourOut(person.isInfo()?17:12);
				acc.add(ae);
			case "Student":
				Access af=new Access();
				af.getClasifiaciones().add("Local de estudiantes");
				af.getClasifiaciones().add("Local de profesores");
				af.getClasifiaciones().add("Aula");
				af.getClasifiaciones().add("Laboratorio");
				af.setHourIn(person.isInfo()?-1:8);
				af.setHourOut(person.isInfo()?-1:12);
				acc.add(af);


				
		}
		return acc;
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
}
