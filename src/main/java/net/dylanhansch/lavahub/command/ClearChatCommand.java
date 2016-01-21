package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClearChatCommand implements CommandExecutor {
	private final Lavahub plugin;

	public ClearChatCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.clearchat")){
				sender.sendMessage(plugin.NO_PERMISSIONS_MSG);
				return true;
			}else{
				sender.sendMessage(plugin.NOT_ENOUGH_ARGS);
				return false;
			}
		}
		if(args.length == 1 && args[0].equalsIgnoreCase("me")){
			if(!sender.hasPermission("lavahub.clearchat")){
				sender.sendMessage(plugin.NO_PERMISSIONS_MSG);
				return true;
			}else{
				for(int i = 0; i < 25; i++)
					sender.sendMessage("");
				return true;
			}
		}else if(args.length == 1 && args[0].equalsIgnoreCase("all")){
			if(!sender.hasPermission("lavahub.clearchat.all")){
				sender.sendMessage(plugin.NO_PERMISSIONS_MSG);
				return true;
			}else{
				for(int i = 0; i < 25; i++)
					plugin.getServer().broadcastMessage("");
				return true;
			}
		}else if(args.length == 1){ // cannot end with else or rest of code cannot be reached
			return false;
		}
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.clearchat")){
				sender.sendMessage(plugin.NO_PERMISSIONS_MSG);
				return true;
			}else{
				sender.sendMessage(plugin.TOO_MANY_ARGS);
				return false;
			}
		}
		
		return true;
	}
}
