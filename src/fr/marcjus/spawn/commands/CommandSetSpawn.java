package fr.marcjus.spawn.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import fr.marcjus.spawn.Main;

public class CommandSetSpawn implements CommandExecutor {

	private Main main;

	public CommandSetSpawn(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Location loc = player.getLocation();
			Configuration config = main.getConfig();
			config.set("spawn.x", loc.getX());
			config.set("spawn.y", loc.getY());
			config.set("spawn.z", loc.getZ());
			config.set("spawn.yaw", loc.getYaw());
			config.set("spawn.pitch", loc.getPitch());
			config.set("spawn.world", loc.getWorld().getName());
			player.sendMessage(config.getString("messages.setspawn").replace('&', '§'));
			main.saveConfig();
		} else {
			sender.sendMessage(main.getConfig().getString("messages.deny").replace('&', '§'));
		}
		return false;
	}

}
