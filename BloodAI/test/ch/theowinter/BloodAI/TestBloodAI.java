package ch.theowinter.BloodAI;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class TestBloodAI {
	static String playername = "aerobless";
	IntelligenceEngine ariyaa = new IntelligenceEngine();
	
	@Test
	public void testAnswerGreeting(){
		assertEquals("Hello",ariyaa.compute("Hello", playername));

	}
	/*
	@Test
	public void testWhatsTheTime(){
		DateFormat df = DateFormat.getDateTimeInstance (DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale ("en", "EN"));
		String formattedDate = df.format (new Date ());
		assertEquals("It's currently "+formattedDate, ariyaa.compute("What's the time?", playername));
	}*/
}
