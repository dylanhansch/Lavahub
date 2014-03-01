package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCommand implements CommandExecutor {
	public static Lavahub plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		Player player = (Player) sender;
		World world = player.getWorld();
		if(args.length == 0){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				return false;
			}
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("day")){
					world.setTime(0);
					Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.GOLD + " has changed the time to " + ChatColor.RED + "day" + ChatColor.GOLD + ".");
					return true;
				}
				if(args[0].equalsIgnoreCase("noon")){
					world.setTime(6000);
					Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.GOLD + " has changed the time to " + ChatColor.RED + "noon" + ChatColor.GOLD + ".");
					return true;
				}
				if(args[0].equalsIgnoreCase("night")){
					world.setTime(14000);
					Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.GOLD + " has changed the time to " + ChatColor.RED + "night" + ChatColor.GOLD + ".");
					return true;
				}
				
			}
			
		}
		if(args.length == 2){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				
			}
		}
		if(args.length >= 3){
			if(!player.hasPermission("lavahub.time")){
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
