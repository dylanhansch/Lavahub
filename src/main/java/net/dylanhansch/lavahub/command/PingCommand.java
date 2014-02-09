package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Config;
import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PingCommand implements CommandExecutor {
	public static Lavahub plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		sender.sendMessage(Config.config.getString("ping-format"));
		return true;
	}

}
