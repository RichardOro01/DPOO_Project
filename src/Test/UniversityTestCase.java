package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logic.University;

public class UniversityTestCase {
	
	private University uni;

	@Before
	public void setUp() throws Exception {
		this.uni=University.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		this.uni=null;
	}

	@Test
	public void testAverageVisitsInMonthPerVisitorOneOfficeEmpty() {
		uni=University.getInstance();
		//iniciarlizar con una oficina y ningun registro
		uni.automaticData(0, 0);
		assertTrue(0.0==uni.averageVisitsInMonthPerVisitor(3, 4, "Professor"));
		uni.getComputerFac().getOffices().clear();
		}
	
	@Test
	public void testAverageVisitsInMonthPerVisitorOneOfficeOneRegister() {
		uni=University.getInstance();
		//iniciarlizar con una oficina y cuatro registros
		uni.automaticData(0, 1);
		assertTrue(0.5==uni.averageVisitsInMonthPerVisitor(3, 4, "Professor"));
		uni.getComputerFac().getOffices().clear();
	}
	
	@Test
	public void testAverageVisitsInMonthPerVisitorOneOfficeOneManyRegister() {
		uni=University.getInstance();
		//iniciarlizar con una oficina y un registro
		uni.automaticData(0, 2);
		assertTrue(2.0==uni.averageVisitsInMonthPerVisitor(3, 4, "Professor"));
		uni.getComputerFac().getOffices().clear();
	}
	
	@Test
	public void testAverageVisitsInMonthPerVisitorManyOffice() {
		uni=University.getInstance();
		//tres oficinas y ocho registro
		uni.automaticData(1, 2);
		assertTrue(4.0==uni.averageVisitsInMonthPerVisitor(3, 4, "Professor"));
		uni.getComputerFac().getOffices().clear();
	}
	

}
