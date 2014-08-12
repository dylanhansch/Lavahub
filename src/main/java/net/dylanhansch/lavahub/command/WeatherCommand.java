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
			if(args.length == 0){
				sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
			if(args.length == 1){
				sender.sendMessage(ChatColor.RED + "Error: Not executable by console!");
				return false;
			}
			if(args.length == 2){
				World targetWorld = plugin.getServer().getWorld(args[1]);
				if(targetWorld == null){
					sender.sendMessage(ChatColor.RED + "Error: That world does not excist!");
					return true;
				}
				if(args[0].equalsIgnoreCase("rain") || args[0].equalsIgnoreCase("storm")){
					targetWorld.setStorm(true);
					targetWorld.setWeatherDuration(12000);
					sender.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "storm " + ChatColor.GOLD + "in " + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("sun")){
					targetWorld.setStorm(false);
					targetWorld.setWeatherDuration(12000);
					sender.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "clear " + ChatColor.GOLD + "in " + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("thunder")){
					targetWorld.setThundering(true);
					targetWorld.setThunderDuration(12000);
					sender.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "thunder" + ChatColor.GOLD + "in" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
					return true;
				}else{
					return false;
				}
			}
			if(args.length >= 3){
				sender.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		Player player = (Player) sender;
		World world = player.getWorld();
		if(args.length == 0){
			if(!player.hasPermission("lavahub.weather")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.weather");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.weather")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.weather");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("rain") || args[0].equalsIgnoreCase("storm")){
					world.setStorm(true);
					world.setWeatherDuration(12000);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "storm" + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("sun")){
					world.setStorm(false);
					world.setWeatherDuration(12000);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "clear" + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("thunder")){
					world.setThundering(true);
					world.setThunderDuration(12000);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "thunder" + ChatColor.GOLD + ".");
					return true;
				}else{
					return false;
				}
			}
		}
		World targetWorld = plugin.getServer().getWorld(args[1]);
		if(args.length == 2){
			if(!player.hasPermission("lavahub.weather")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.weather");
				return true;
			} else {
				if(targetWorld == null){
					player.sendMessage(ChatColor.RED + "Error: That world does not excist!");
					return true;
				}
				if(args[0].equalsIgnoreCase("rain") || args[0].equalsIgnoreCase("storm")){
					targetWorld.setStorm(true);
					targetWorld.setWeatherDuration(12000);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "storm " + ChatColor.GOLD + "in " + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("sun")){
					targetWorld.setStorm(false);
					targetWorld.setWeatherDuration(12000);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "clear " + ChatColor.GOLD + "in " + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("thunder")){
					targetWorld.setThundering(true);
					targetWorld.setThunderDuration(12000);
					player.sendMessage(ChatColor.GOLD + "Weather changed to " + ChatColor.RED + "thunder" + ChatColor.GOLD + "in" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + ".");
					return true;
				}else{
					return false;
				}
			}
		}
		if(args.length >= 3){
			if(!player.hasPermission("lavahub.weather")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.weather");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		return false;
	}
}
