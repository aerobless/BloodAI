package ch.theowinter.BloodAI;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestBloodAI {
	static String playername = "aerobless";
	IntelligenceEngine ariyaa = new IntelligenceEngine();

	@Test
	public void testAnswerGreeting(){
		boolean success = false;
		String answer = ariyaa.compute("hello", playername);
		if (answer.equals("Hello "+playername) || answer.equals("Hi "+playername) || answer.equals("Howdy "+playername)){
			success = true;
		}
		assertTrue(success);
	}
	
	@Test
	public void testAnswerBye(){
		boolean success = false;
		String answer = ariyaa.compute("Bye", playername);
		if (answer.equals("Cya later "+playername) || answer.equals("Bye "+playername) || answer.equals("Have fun "+playername)
				|| answer.equals("Hope you'll be back soon "+playername)){
			success = true;
		}
		assertTrue(success);
	}
	
	@Test
	public void testPersonalizer(){
		assertEquals(("Random String Text "+playername+" END OF SENTENCE!"), ariyaa.personalize("Random String Text %player% END OF SENTENCE!", playername));
	}
	
	@Test
	public void testChoseRandom(){
		ArrayList<String> testArray = new ArrayList<String>();
		testArray.add("test 1");
		testArray.add("test 2");
		testArray.add("test 3");
		String result1 ="same";
		String result2 ="same";
		String result3 ="same";
		boolean success = false;
		
		while (result1.equals(result2) && result2.equals(result3) && result3.equals(result1)) {
			result1 = ariyaa.choseRandom(testArray);
			result2 = ariyaa.choseRandom(testArray);
			result3 = ariyaa.choseRandom(testArray);
		}
		
		if (result1.equals(testArray.get(0)) || result1.equals(testArray.get(1)) || result1.equals(testArray.get(2))){
			success = true;
		}
		assertTrue(success);
	}

}
