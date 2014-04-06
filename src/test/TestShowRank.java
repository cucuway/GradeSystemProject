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
import gradeClass.UI;

public class TestShowRank {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginShowRank() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"962001051 R E Q ".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		try {
			UI ui = new UI();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		String formatList = "輸入指令 1) G 顯示成績 (Grade)\n      2) R 顯示排名 (Rank)\n      3) W 更新配分 (Weight)\n      4) E 離開選單 (Exit)\n\r\n";
		String expectRank = "李威廷排名第 22\r\n";
		String cmdHeader = "輸入ID或 Q (結束使用)？\r\n";
		String endFooter = "結束了\r\n";
		assertEquals(cmdHeader + "Welcome 李威廷\r\n" + formatList + expectRank
				+ formatList + cmdHeader + endFooter, outContent.toString());
	}

}
