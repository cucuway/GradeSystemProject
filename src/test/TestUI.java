package test;

import static org.junit.Assert.*;
import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;
import gradeClass.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUI {
	UI ui;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExit() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"Q".getBytes());
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		ui = new UI();
		assertEquals("輸入ID或 Q (結束使用)？\r\n結束了\r\n", outContent.toString());
	}
}
