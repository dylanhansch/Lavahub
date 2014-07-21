package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RawmsgCommand implements CommandExecutor {
	private final Lavahub plugin;

	public RawmsgCommand(Lavahub plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.rawmsg")){
				sender.sendMessage(ChatColor.DARK_RED + "No permission.");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Not enough arguments!");
				return false;
			}
		}
		if(args.length >= 1){
			if(!sender.hasPermission("lavahub.rawmsg")){
				sender.sendMessage(ChatColor.DARK_RED + "No permission.");
				return true;
			} else {
				StringBuilder message = new StringBuilder("");
				for (String part : args){
					if(!message.toString().equals(""))
						message.append(" ");
					message.append(part);
				}
				plugin.getServer().broadcastMessage(message.toString());
				return true;
			}
			
		}
		return false;
	}
}
