package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ActionCommand implements CommandExecutor{
	public static Lavahub plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Not executable by console!");
			return true;
		}
		Player player = (Player) sender;
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.action")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Not enough arguments!");
				return false;
			}
		}
		if(args.length >= 1){
			if(!sender.hasPermission("lavahub.action")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				StringBuilder message = new StringBuilder("");
				for (String part : args){
					if(!message.toString().equals(""))
						message.append(" ");
					
					message.append(part);
				}
				Bukkit.getServer().broadcastMessage("* " + player.getDisplayName() + " " + message.toString());
				return true;
			}
			
		}
		return false;
	}
	

}
