package test;

import static org.junit.Assert.*;
import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;
import gradeClass.Main;
import gradeClass.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testMain {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExit() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"1234567890".getBytes());
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		Main.main(null);
		assertEquals("輸入ID或 Q (結束使用)？\r\nID錯了!\r\n", outContent.toString());
	}

}
