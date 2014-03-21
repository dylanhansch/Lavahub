package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LavahubCommand implements CommandExecutor {
	private final Lavahub plugin;

	public LavahubCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!sender.hasPermission("lavahub.reload")){
			sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
			return true;
		}else{
			plugin.reloadConfig();
			sender.sendMessage(ChatColor.GOLD + "Reloaded Lavahub configuration from disk.");
			return true;
		}
	}
}
