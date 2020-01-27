package me.moderator_man.ctp;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CoordsTP extends JavaPlugin
{
	public void onEnable()
	{
		System.out.println("CoordsTP enabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getLabel().equalsIgnoreCase("ctp"))
		{
			boolean allowed = sender.isOp() || sender.hasPermission("ctp.use");
			
			if (!allowed)
			{
				sender.sendMessage("You don't have permission to do that.");
				return true;
			}
			
			if (args.length < 3)
			{
				return false;
			}
			
			try
			{
				int x = Integer.parseInt(args[0]);
				int y = Integer.parseInt(args[1]);
				int z = Integer.parseInt(args[2]);
				
				Player player = (Player) sender;
				player.teleport(new Location(player.getWorld(), x, y, z));
				
				return true;
			} catch (NumberFormatException ex) {
				sender.sendMessage("Coordinates have to be numbers, you fool.");
				return true;
			}
		}
		
		return false;
	}
	
	public void onDisable()
	{
		System.out.println("CoordsTP disabled.");
	}
}
