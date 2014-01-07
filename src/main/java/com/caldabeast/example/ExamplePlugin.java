
package com.caldabeast.example;

import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author CalDaBeast
 */
public class ExamplePlugin extends JavaPlugin{

	@Override
	public void onEnable(){
		ExampleCommander commander = new ExampleCommander();
		commander.registerSubcommand(new ExampleExternalSubcommand());
		getCommand("test").setExecutor(commander);         //you must still register all commands in the plugin.yml
		getCommand("test").setTabCompleter(commander);     //or the server will throw a NullPointerException.
		getLogger().log(Level.INFO, "Loaded /test command");
	}
	
}
