package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommand implements CommandExecutor {
	private final Lavahub plugin;

	public WeatherCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			World targetWorld = plugin.getServer().getWorld(args[1]);
			if(args[0].equalsIgnoreCase("rain") || args[0].equalsIgnoreCase("storm")){
				targetWorld.setStorm(true);
				sender.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "Storm " + ChatColor.GOLD + "in " + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
				return true;
			}
			if(args[0].equalsIgnoreCase("clear")){
				targetWorld.setStorm(false);
				targetWorld.setWeatherDuration(50);
				sender.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "Clear " + ChatColor.GOLD + "in " + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
				return true;
			}
		}
		Player player = (Player) sender;
		World world = player.getWorld();
		if(args.length == 0){
			if(!player.hasPermission("lavahub.weather")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				return false;
			}
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.weather")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("rain") || args[0].equalsIgnoreCase("storm")){
					world.setStorm(true);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "Storm" + ChatColor.GOLD + ".");
					return true;
				}
				if(args[0].equalsIgnoreCase("clear")){
					world.setStorm(false);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "Clear" + ChatColor.GOLD + ".");
					return true;
				}
			}
		}
		World targetWorld = plugin.getServer().getWorld(args[1]);
		if(args.length == 2){
			if(!player.hasPermission("lavahub.weather")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("rain") || args[0].equalsIgnoreCase("storm")){
					targetWorld.setStorm(true);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "Storm " + ChatColor.GOLD + "in " + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
					return true;
				}
				if(args[0].equalsIgnoreCase("clear")){
					targetWorld.setStorm(false);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "Clear " + ChatColor.GOLD + "in " + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
					return true;
				}
			}
		}
		if(args.length >= 3){
			if(!player.hasPermission("lavahub.weather")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Too many arguments!");
				return false;
			}
		}
		return false;
	}
}
