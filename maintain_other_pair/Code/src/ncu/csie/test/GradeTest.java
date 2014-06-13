package ncu.csie.test;

import static org.junit.Assert.*;
import ncu.csie.model.Grades;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeTest {

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
		aGrade.setlab1(81);
		aGrade.setlab2(98);
		aGrade.setlab3(84);
		aGrade.setmidTerm(90);
		aGrade.setfinalExam(93);
		float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
		// 1. 手算 expected result (81*0.1+98*0.1+84*0.1+90*0.3+93*0.4=90.5四捨五入91)
		// 2. 呼叫 aGrade.calculateTotalGrade (weights) 算actual result
		// 3. assert equal of the two results
		aGrade.calculateTotalGrade(weights);
		assertEquals(aGrade.getTotalGrade(), 91);
	}
	
}
