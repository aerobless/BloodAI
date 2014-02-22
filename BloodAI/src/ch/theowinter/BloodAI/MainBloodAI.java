package ch.theowinter.BloodAI;

import org.bukkit.plugin.java.JavaPlugin;

public class MainBloodAI extends JavaPlugin{	
	
	 @Override
	    public void onEnable(){
		 this.saveDefaultConfig();
	    }
	 
	    @Override
	    public void onDisable() {
		 	getLogger().info("BloodStats successfully exited");
	    }
	    
}