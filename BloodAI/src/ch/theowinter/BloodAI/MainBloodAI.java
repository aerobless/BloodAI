package ch.theowinter.BloodAI;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author theowinter
 *
 */
public class MainBloodAI extends JavaPlugin {
	
	//Development Settings:
	static boolean debug = true;

	@Override
	public void onEnable() {
		IntelligenceEngine ariyaa = new IntelligenceEngine();
		
		//TODO: Listener that actually gets chat events and feeds them to ariyaa
		
		getLogger().info("BloodAI successfully launched. Ariyaa's now alive :)!");
	}

	@Override
	public void onDisable() {
		getLogger().info("BloodStats successfully exited");
	}


	/**
	 * @author theowinter
	 * Demo Output is used to have a "pretend" chat conversation for debugging.
	 */
	public static void demoOutput(String input, String output) {
		if (debug == true) {
			System.out.println("---------------------------------------");
			System.out.println("User enters: " +input);
			System.out.println("Ariyaa answers: "+output);
		}
	}
}