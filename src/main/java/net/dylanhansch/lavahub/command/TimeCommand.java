package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCommand implements CommandExecutor {
	private final Lavahub plugin;

	public TimeCommand(Lavahub plugin) {
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
				if(args[0].equalsIgnoreCase("day")){
					targetWorld.setTime(0);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "day" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("noon")){
					targetWorld.setTime(6000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "noon" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("night")){
					targetWorld.setTime(14000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "night" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
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
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.time");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.time");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("day")){
					world.setTime(0);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "day" + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("noon")){
					world.setTime(6000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "noon" + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("night")){
					world.setTime(14000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "night" + ChatColor.GOLD + ".");
					return true;
				}else{
					return false;
				}	
			}
		}
		World targetWorld = plugin.getServer().getWorld(args[1]);
		if(args.length == 2){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.time");
				return true;
			} else {
				if(targetWorld == null){
					sender.sendMessage(ChatColor.RED + "Error: That world does not excist!");
					return true;
				}
				if(args[0].equalsIgnoreCase("day")){
					targetWorld.setTime(0);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "day" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("noon")){
					targetWorld.setTime(6000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "noon" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("night")){
					targetWorld.setTime(14000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "night" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else{
					return false;
				}
			}
		}
		if(args.length >= 3){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.time");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		return false;
	}

}
