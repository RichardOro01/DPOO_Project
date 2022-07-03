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
		uni.automaticDataForMethod2(0, 0);
		assertTrue(0.0==uni.averageVisitsInMonthPerVisitor(3, 4, "Professor"));
		uni.getComputerFac().getOffices().clear();
		}
	
	@Test
	public void testAverageVisitsInMonthPerVisitorOneOfficeOneManyRegister() {
		uni=University.getInstance();
		//iniciarlizar con una oficina y un registro
		uni.automaticDataForMethod2(0, 1);
		assertTrue(0.5==uni.averageVisitsInMonthPerVisitor(3, 4, "Professor"));
		uni.getComputerFac().getOffices().clear();
	}
	
	@Test
	public void testAverageVisitsInMonthPerVisitorOneOfficeOneRegister() {
		uni=University.getInstance();
		//iniciarlizar con una oficina y dos registros
		uni.automaticDataForMethod2(0, 2);
		assertTrue(1.0==uni.averageVisitsInMonthPerVisitor(3, 4, "Professor"));
		uni.getComputerFac().getOffices().clear();
	}
		
	@Test
	public void testAverageVisitsInMonthPerVisitorManyOffice() {
		uni=University.getInstance();
		//tres oficinas y ocho registro
		uni.automaticDataForMethod2(1, 2);
		assertTrue(4.0==uni.averageVisitsInMonthPerVisitor(3, 4, "Professor"));
		uni.getComputerFac().getOffices().clear();
	}
	
	@Test
	public void testGetOfficeByIdFound(){
		uni=University.getInstance();
		uni.automaticDataForMethod1(0);
		assertEquals(uni.getComputerFac().getOffices().get(0),uni.getOfficeById("0110"));
		uni.getComputerFac().getOffices().clear();
	}
	
	@Test
	public void testGetOfficeByIdNotFound(){
		uni=University.getInstance();
		uni.automaticDataForMethod1(1);
		assertEquals(null,uni.getOfficeById("0110"));
		uni.getComputerFac().getOffices().clear();
	}
	
	@Test
	public void testGetOfficeByIdNoOffice(){
		uni=University.getInstance();
		uni.automaticDataForMethod1(-1);
		assertEquals(null,uni.getOfficeById("0110"));
		uni.getComputerFac().getOffices().clear();
	}
	
}
