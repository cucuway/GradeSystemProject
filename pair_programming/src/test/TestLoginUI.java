package test;

import static org.junit.Assert.*;
import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;
import gradeClass.Grades;
import gradeClass.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLoginUI {
	/**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  
	 */
	UI ui;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"962001051 E Q ".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		try {
			ui = new UI();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		String formatList = "輸入指令 1) G 顯示成績 (Grade)\n      2) R 顯示排名 (Rank)\n      3) W 更新配分 (Weight)\n      4) E 離開選單 (Exit)\n\r\n";

		assertEquals(("輸入ID或 Q (結束使用)？\r\nWelcome 李威廷\r\n" + formatList
				+ "輸入ID或 Q (結束使用)？\r\n結束了\r\n").replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
		//'\r'使游標移到行首，'\n'是換行。通常用的Enter是兩個加起來。  string.replaceAll("\\s+","")可將字串中所有空白消除; 
		// \s 指的是空白字元，\s+ 是連續多個空白字元，要打成 "\\s+"，第一個反斜線類似跳脫字元。
	}
}
