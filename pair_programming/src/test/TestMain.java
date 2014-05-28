package test;

import static org.junit.Assert.*;
import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;
import gradeClass.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMain {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testErrorID() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"1234567890".getBytes());
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		Main.main(null);// 因為在main(String args[])中有傳參數的地方，這邊沒有參數要傳，所以放null
		assertEquals("輸入ID或 Q (結束使用)？\r\nID錯了!\r\n".replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
		//'\r'使游標移到行首，'\n'是換行。通常用的Enter是兩個加起來。  string.replaceAll("\\s+","")可將字串中所有空白消除; 
		// \s 指的是空白字元，\s+ 是連續多個空白字元，要打成 "\\s+"，第一個反斜線類似跳脫字元。
	}
	@Test
	public void testErrorCommand() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"962001051 K".getBytes());
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		Main.main(null);
		String formatList = "輸入指令 1) G 顯示成績 (Grade)\n      2) R 顯示排名 (Rank)\n      3) W 更新配分 (Weight)\n      4) E 離開選單 (Exit)\n\r\n";
		String welcomeString = "Welcome 李威廷\r\n";
		String cmdHeader = "輸入ID或 Q (結束使用)？\r\n";
		String exceptedAC =cmdHeader + welcomeString + formatList + "指令錯了!\r\n"; 
		assertEquals(exceptedAC.replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
		
	}
}
