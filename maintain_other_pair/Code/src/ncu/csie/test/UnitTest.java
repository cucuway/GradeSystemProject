package ncu.csie.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ncu.csie.UI;
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
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals("輸入ID或 Q (結束使用)\r\n結束了\r\n", outContent.toString());

	}

	@Test
	public void testShowGrade1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("955002056\nG\nE\nQ".getBytes());
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
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002201\nG\nE\nQ".getBytes());
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
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002201\nR\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(53, myUI.aGradeSystem.showRank("985002201"));

	}

	@Test
	public void testShowRank2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002002\nR\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(15, myUI.aGradeSystem.showRank("985002002"));

	}

	@Test
	public void testUpdateWeights1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream(
				"985002002\nW\n20\n20\n20\n20\n20\nY\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.weights[0] == 20
				&& myUI.aGradeSystem.weights[1] == 20
				&& myUI.aGradeSystem.weights[2] == 20
				&& myUI.aGradeSystem.weights[3] == 20
				&& myUI.aGradeSystem.weights[4] == 20);
	}

	@Test
	public void testUpdateWeights2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream(
				"985002002\nW\n30\n20\n10\n5\n35\nY\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.weights[0] == 30
				&& myUI.aGradeSystem.weights[1] == 20
				&& myUI.aGradeSystem.weights[2] == 10
				&& myUI.aGradeSystem.weights[3] == 5
				&& myUI.aGradeSystem.weights[4] == 35);
	}

	@Test
	public void testContainsID1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.containsID("985002002") >= 0);
	}

	@Test
	public void testContainsID2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(false, myUI.aGradeSystem.containsID("123456") >= 0);
	}

	@Test(expected = NoSuchCommandExceptions.class)
	public void testException1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002002\nX\n".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
	}

	@Test(expected = NoSuchIDExceptions.class)
	public void testException2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("123456\n".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
	}

}
