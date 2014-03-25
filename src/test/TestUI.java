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

	public void login() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"962001051".getBytes());
		System.setIn(inContent);
		ui = new UI();
	}

	@Test
	public void testLogin() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		login();
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"E".getBytes());
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setIn(inContent);
		// System.setIn(inContent);
		// System.setOut(new PrintStream(outContent));
		System.out.println(outContent.toString());
		assertEquals("WTF", outContent.toString());

	}
}
