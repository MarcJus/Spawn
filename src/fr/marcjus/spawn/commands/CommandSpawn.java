package fr.marcjus.spawn.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import fr.marcjus.spawn.Main;

public class CommandSpawn implements CommandExecutor {
	
	private Main main;

	public CommandSpawn(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Configuration config = main.getConfig();
		if(sender instanceof Player){
			Player player = (Player) sender;
			World world = Bukkit.getWorld(main.getConfig().getString("spawn.world"));
			double x = config.getDouble("spawn.x");
			double y = config.getDouble("spawn.y");
			double z = config.getDouble("spawn.z");
			float yaw = config.getInt("spawn.yam");
			float pitch = config.getInt("spawn.pitch");
			Location loc = new Location(world, x, y, z, yaw, pitch);
			player.teleport(loc);
		}else{
			sender.sendMessage(config.getString("messages.deny").replace('&', '§'));
		}
		return false;
	}

}
