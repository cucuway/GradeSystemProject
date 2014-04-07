package test;

/** ----------------------------------------------------------------------------------------------------------------------
 testCalculateTotalGrade 
 aGrade: ID 962001051 name李威廷 lab1 81  lab2 98  lab3 84  midTerm 90 finalExam 93

 case 1: lab1 0.1  lab2 0.1  lab3 0.1  midTerm 0.3  finalExam 0.4
 case 2: lab1 0.2  lab2 0.2  lab3 0.2  midTerm 0.2  finalExam 0.2
 case 3: lab1 0.1  lab2 0.1  lab3 0.0  midTerm 0.4  finalExam 0.4
 ------------------------------------------------------------------------------------------------------------------------- */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeClass.Grades;

public class TestCalculateTotalGrade {
	/**
	 * @uml.property  name="aGrade"
	 * @uml.associationEnd  
	 */
	Grades aGrade;

	@Before
	public void setUp() throws Exception {
		aGrade = new Grades();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCalculateTotalGrade1() {
		aGrade.lab1 = 81;
		aGrade.lab2 = 98;
		aGrade.lab3 = 84;
		aGrade.midTerm = 90;
		aGrade.finalExam = 93;
		float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
		assertEquals(aGrade.calculateTotalGrade(weights), 91);
	}

	@Test
	public void testCalculateTotalGrade2() {
		aGrade.lab1 = 81;
		aGrade.lab2 = 98;
		aGrade.lab3 = 84;
		aGrade.midTerm = 90;
		aGrade.finalExam = 93;
		float[] weights = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};
		assertEquals(aGrade.calculateTotalGrade(weights), 89);
	}
}
