package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ActionCommand implements CommandExecutor{
	private final Lavahub plugin;

	public ActionCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.action")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.action");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		if(args.length >= 1){
			if(!sender.hasPermission("lavahub.action")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.action");
				return true;
			} else {
				StringBuilder message = new StringBuilder("");
				for (String part : args){
					if(!message.toString().equals(""))
						message.append(" ");
					
					message.append(part);
				}
				String name = sender.getName();
				if (sender instanceof Player)
					name = ((Player) sender).getDisplayName();
				plugin.getServer().broadcastMessage(String.format("* %s %s", name, message));
				return true;
			}
			
		}
		return false;
	}
	

}
