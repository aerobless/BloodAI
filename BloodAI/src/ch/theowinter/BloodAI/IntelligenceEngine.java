package ch.theowinter.BloodAI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
		initBye();
	}

	/**
	 * @author theowinter 
	 * This method computes input and generates a response.
	 * @param playername 
	 */
	public String compute(String input, String playername) {
		ArrayList<String> possibleReactions = reactionMap.get(triggerMap.get(input));
		
		String reaction = choseRandom(possibleReactions);
		reaction = personalize(reaction, playername);
		MainBloodAI.demoOutput(input, reaction);
		return reaction;
	}

	public String personalize(String inputText, String playername) {
		String output;
		output = inputText.replace("%player%", playername);
		return output;
	}
	
	/**
	 * @author theowinter 
	 * Choses one random option from an array and returns that.
	 */
	public String choseRandom(ArrayList<String> inputArray){
		Random rand = new Random(); 
		int randomValue = rand.nextInt(inputArray.size());
		return inputArray.get(randomValue);
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
		greetingReactions.add("Hello %player%");
		greetingReactions.add("Hi %player%");
		greetingReactions.add("Howdy %player%");		
		reactionMap.put(1, greetingReactions);
	}
	
	public void initBye() {
		// TRIGGERS
		triggerMap.put("Bye", 2);
		triggerMap.put("Goodbye", 2);
		triggerMap.put("Cya", 2);
		triggerMap.put("ciao", 2);
		triggerMap.put("g2g", 2);
		triggerMap.put("Cya later", 2);
		
		// REACTIONS
		ArrayList<String> byeReactions = new ArrayList<String>();
		byeReactions.add("Cya later %player%");
		byeReactions.add("Bye %player%");
		byeReactions.add("Have fun %player%");
		byeReactions.add("Hope you'll be back soon %player%");
		reactionMap.put(2, byeReactions);
	}

}
