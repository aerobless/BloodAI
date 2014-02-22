package ch.theowinter.BloodAI;

import java.util.ArrayList;
import java.util.HashMap;

public class IntelligenceEngine {
	//Basic Bot Information
	String botName = "Ariyaa";
	String serverName = "bCloud Gaming";
	
	//Bot Trigger & Reaction Maps
	HashMap<String, Integer> triggerMap = new HashMap<String, Integer>();
	HashMap<Integer, ArrayList<String>> reactionMap = new HashMap<Integer, ArrayList<String>>();
	
	
	/**
	 * @author theowinter 
	 * Initialize the engine with a set of phrases and parameters
	 */
	public IntelligenceEngine() {
		initGreetings();	
	}

	
	/**
	 * @author theowinter 
	 * This method computes input and generates a response.
	 * @param playername 
	 */
	public String compute(String input, String playername) {
		ArrayList<String> possibleReactions = reactionMap.get(triggerMap.get(input));

		String reaction = possibleReactions.get(0);
		
		MainBloodAI.demoOutput(input, reaction);
		return reaction;
	}
	
	public void initGreetings() {
		// TRIGGERS
		triggerMap.put("Hello", 1);
		triggerMap.put("Hi", 1);
		triggerMap.put("Greetings", 1);
		triggerMap.put("Hiya", 1);
		triggerMap.put("Howdy", 1);
		triggerMap.put("Hey", 1);
		triggerMap.put("Good day", 1);
		
		// REACTIONS
		ArrayList<String> greetingReactions = new ArrayList<String>();
		greetingReactions.add("Hello");
		greetingReactions.add("Hi");
		greetingReactions.add("Howdy");		
		reactionMap.put(1, greetingReactions);
	}

}
