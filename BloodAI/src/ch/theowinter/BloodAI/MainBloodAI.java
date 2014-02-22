package ch.theowinter.BloodAI;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author theowinter
 *
 */
public class MainBloodAI extends JavaPlugin {
	static boolean debug = true;

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
	}

	@Override
	public void onDisable() {
		getLogger().info("BloodStats successfully exited");
	}

	/**
	 * @author theowinter 
	 * This method computes input and generates a response.
	 */
	public static String compute(String input) {

		
		
		demoOutput(input, "Hello");
		return "Hello";
	}

	/**
	 * @author theowinter
	 * Demo Output is used to have a "pretend" chat conversation for debugging.
	 */
	public static void demoOutput(String input, String output) {
		if (debug == true) {
			System.out.println("User enters: " +input);
			System.out.println("Ariyaa answers: "+output);
		}
	}
}