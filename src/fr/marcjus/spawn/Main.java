package fr.marcjus.spawn;

import org.bukkit.plugin.java.JavaPlugin;

import fr.marcjus.spawn.commands.CommandSetSpawn;
import fr.marcjus.spawn.commands.CommandSpawn;

public class Main extends  JavaPlugin{
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		getCommand("spawn").setExecutor(new CommandSpawn(this));
		getCommand("setspawn").setExecutor(new CommandSetSpawn(this));
	}

}
