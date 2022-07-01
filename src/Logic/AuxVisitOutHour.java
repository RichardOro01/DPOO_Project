package Logic;

import java.util.Date;

public class AuxVisitOutHour {
	private Person person;
	private Date dateIn;
	private Date dateOut;
	private Date dateInMust;
	private Date dateOutMust;
	
	public AuxVisitOutHour(Person person, Date dateIn, Date dateOut, Date dateInMust, Date dateOutMust) {
		super();
		this.person = person;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.dateInMust = dateInMust;
		this.dateOutMust = dateOutMust;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	public Date getDateInMust() {
		return dateInMust;
	}
	public void setDateInMust(Date dateInMust) {
		this.dateInMust = dateInMust;
	}
	public Date getDateOutMust() {
		return dateOutMust;
	}
	public void setDateOutMust(Date dateOutMust) {
		this.dateOutMust = dateOutMust;
	}
	
}
