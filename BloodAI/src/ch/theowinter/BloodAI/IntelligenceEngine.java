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
	HashMap<String, ArrayList<String>> conversationState = new HashMap<String, ArrayList<String>>();
	
	
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
		String sanetizedInput = input.toLowerCase();
		String reaction = "";

		triggerConversation(sanetizedInput, playername);

		//Continuing converation
		if (conversationState.containsKey(playername)){
			//TODO: actual convo stuff
		}
		//Normal reactions on correct sentences
		else {
			ArrayList<String> possibleReactions = reactionMap.get(triggerMap.get(sanetizedInput));
			reaction = choseRandom(possibleReactions);	
		}
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
	
	/**
	 * @author theowinter 
	 * trigger conversation with the bot.
	 * @return 
	 */
	public void triggerConversation(String input, String playername){
		//TODO: make more triggers possible
		if (input.equals("ariyaa")){
			ArrayList<String> conversationParams = new ArrayList<String>();
			conversationParams.add("new");
			conversationParams.add("neutral");
			conversationState.put(playername, conversationParams);
		}
		else if(input.equals("ariyaa shutup") && conversationState.containsKey(playername)){
			conversationState.remove(playername);
		}
	}
	
	public void initGreetings() {
		// TRIGGERS
		triggerMap.put("hello", 1);
		triggerMap.put("hi", 1);
		triggerMap.put("greetings", 1);
		triggerMap.put("hiya", 1);
		triggerMap.put("howdy", 1);
		triggerMap.put("hey", 1);
		triggerMap.put("good day", 1);
		
		// REACTIONS
		ArrayList<String> greetingReactions = new ArrayList<String>();
		greetingReactions.add("Hello %player%");
		greetingReactions.add("Hi %player%");
		greetingReactions.add("Howdy %player%");		
		reactionMap.put(1, greetingReactions);
	}
	
	public void initBye() {
		// TRIGGERS
		triggerMap.put("bye", 2);
		triggerMap.put("goodbye", 2);
		triggerMap.put("cya", 2);
		triggerMap.put("ciao", 2);
		triggerMap.put("g2g", 2);
		triggerMap.put("cya later", 2);
		
		// REACTIONS
		ArrayList<String> byeReactions = new ArrayList<String>();
		byeReactions.add("Cya later %player%");
		byeReactions.add("Bye %player%");
		byeReactions.add("Have fun %player%");
		byeReactions.add("Hope you'll be back soon %player%");
		reactionMap.put(2, byeReactions);
	}

}
