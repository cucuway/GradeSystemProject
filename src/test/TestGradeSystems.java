package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;
import gradeClass.GradeSystems;

public class TestGradeSystems {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGradeSystemUpdateWeight() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"20 20 20 20 20 Y".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		try {
			GradeSystems gradeSystem = new GradeSystems();
			gradeSystem.updateWeights();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		String oldGrade = "舊配分\r\n    lab1        10%\r\n    lab2        10%\r\n    lab3        10%\r\n    mid-term    30%\r\n    final exam  40%\r\n";
		String cmdGrade = "輸入新配分\r\n    lab1            lab2            lab3            mid-term        final exam  ";
		String newGrade = "請確認新配分\r\n    lab1        20%\r\n    lab2        20%\r\n    lab3        20%\r\n    mid-term    20%\r\n    final exam  20%\r\n";
		String checkCmd = "以上正確嗎 ? Y (Yes) 或 N (No)\r\n";
		assertEquals((oldGrade + cmdGrade + newGrade + checkCmd).replaceAll(
				"\\s+", ""), outContent.toString().replaceAll("\\s+", ""));
		//'\r'使游標移到行首，'\n'是換行。通常用的Enter是兩個加起來。  string.replaceAll("\\s+","")可將字串中所有空白消除; 
		// \s 指的是空白字元，\s+ 是連續多個空白字元，要打成 "\\s+"，第一個反斜線類似跳脫字元。
	}

	@Test
	public void testShowNewRank() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"20 20 20 20 20 Y".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		try {
			GradeSystems gradeSystem = new GradeSystems();
			gradeSystem.showRank("962001051");
			gradeSystem.updateWeights();
			gradeSystem.showRank("962001051");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		String oldRank = "李威廷排名第22\r\n";
		String newRank = "李威廷排名第33\r\n" ;
		String oldGrade = "舊配分\r\n    lab1        10%\r\n    lab2        10%\r\n    lab3        10%\r\n    mid-term    30%\r\n    final exam  40%\r\n";
		String cmdGrade = "輸入新配分\r\n    lab1            lab2            lab3            mid-term        final exam  ";
		String newGrade = "請確認新配分\r\n    lab1        20%\r\n    lab2        20%\r\n    lab3        20%\r\n    mid-term    20%\r\n    final exam  20%\r\n";
		String checkCmd = "以上正確嗎 ? Y (Yes) 或 N (No)\r\n";
		assertEquals((oldRank+ oldGrade + cmdGrade + newGrade + checkCmd + newRank).replaceAll(
				"\\s+", ""), outContent.toString().replaceAll("\\s+", ""));
	}

}
