package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SayCommand implements CommandExecutor{
	private final Lavahub plugin;

	public SayCommand(Lavahub plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.say")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Not enough arguments!");
				return false;
			}
		}
		if(args.length >= 1){
			if(!sender.hasPermission("lavahub.say")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				StringBuilder message = new StringBuilder("");
				for (String part : args){
					if(!message.toString().equals(""))
						message.append(" ");
					
					message.append(part);
				}
				plugin.getServer().broadcastMessage(String.format("\u00A75Console> \u00A7d%s", message.toString()));
				return true;
			}
			
		}
		return false;
	}
	
}
