package ncu.csie.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import ncu.csie.UI;
import ncu.csie.exceptions.DuplicateExceptions;
import ncu.csie.exceptions.NoSuchCommandExceptions;
import ncu.csie.exceptions.NoSuchIDExceptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	UI myUI = null;
	ByteArrayOutputStream outContent = null;
	ByteArrayInputStream inContent = null;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		myUI = null;
	}

	@Test
	public void testFinishMsg() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals("輸入ID或 Q (結束使用)\r\n結束了\r\n", outContent.toString());

	}

	@Test
	public void testShowGrade1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("955002056\nG\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(
				"許文馨成績： lab1：     88　\n\tlab2：     92　\n\tlab3：     88　\n\tmid-term :  98　\n\tfinal exam：91　\n\ttotal grade : 93\n",
				myUI.aGradeSystem.showGrade("955002056"));

	}

	@Test
	public void testShowGrade2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("985002201\nG\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(
				"蘇亮成績： lab1：     81　\n\tlab2：     91　\n\tlab3：     85　\n\tmid-term :  84　\n\tfinal exam：90　\n\ttotal grade : 87\n",
				myUI.aGradeSystem.showGrade("985002201"));

	}

	@Test
	public void testShowRank1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("985002201\nR\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(53, myUI.aGradeSystem.showRank("985002201"));

	}

	@Test
	public void testShowRank2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("985002002\nR\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(15, myUI.aGradeSystem.showRank("985002002"));

	}

	@Test
	public void testUpdateWeights1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream(
				"985002002\nW\n20\n20\n20\n20\n20\nY\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.weights[0] == 0.20f
				&& myUI.aGradeSystem.weights[1] == 0.20f
				&& myUI.aGradeSystem.weights[2] == 0.20f
				&& myUI.aGradeSystem.weights[3] == 0.20f
				&& myUI.aGradeSystem.weights[4] == 0.20f);
	}

	@Test
	public void testUpdateWeights2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream(
				"985002002\nW\n30\n20\n10\n5\n35\nY\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.weights[0] == 0.30f
				&& myUI.aGradeSystem.weights[1] == 0.20f
				&& myUI.aGradeSystem.weights[2] == 0.10f
				&& myUI.aGradeSystem.weights[3] == 0.05f
				&& myUI.aGradeSystem.weights[4] == 0.35f);
	}

	@Test
	public void testContainsID1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.containsID("985002002") >= 0);
	}

	@Test
	public void testContainsID2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(false, myUI.aGradeSystem.containsID("123456") >= 0);
	}

	@Test(expected = NoSuchCommandExceptions.class)
	public void testException1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("985002002\nX\n".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
	}

	@Test(expected = NoSuchIDExceptions.class)
	public void testException2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream("123456\n".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
	}

	@Test
	public void testUpdateWeights3() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream(
				"985002002\nG\nW\n20\n20\n20\n20\n20\nY\nG\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(
				92,
				myUI.aGradeSystem.aList.get(
						myUI.aGradeSystem.containsID("985002002"))
						.getTotalGrade());
	}

	@Test(expected = DuplicateExceptions.class)
	public void testAddStudentDup() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream(
				"985002002\nA\n985002002\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
	}
	
	@Test
	public void testAddStudent() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream(
				"985002002\nA\n995002903\n張一二\n90\n70\n80\n60\n50\nyes\nQ\n995002903\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assert(Arrays.equals(new int[]{90, 70, 80, 60, 50}, myUI.aGradeSystem.aList.get(
				myUI.aGradeSystem.containsID("995002903")).gradeArray()));
	}

	@Test
	public void testModify() throws NoSuchIDExceptions,
			NoSuchCommandExceptions, DuplicateExceptions {

		inContent = new ByteArrayInputStream(
				"985002002\nM\n962001044\nno\nyes\n90\nno\nno\nno\nQ\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(90, 
		myUI.aGradeSystem.aList.get(
				myUI.aGradeSystem.containsID("962001044")).getlab2());
	}

}
