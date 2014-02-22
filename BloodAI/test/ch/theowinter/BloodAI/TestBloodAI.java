package ch.theowinter.BloodAI;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestBloodAI {
	@Test
	public void answerGreeting(){
		//Pretty dumb test
		assertEquals("Hello",MainBloodAI.compute("Hello"));
	}
}
