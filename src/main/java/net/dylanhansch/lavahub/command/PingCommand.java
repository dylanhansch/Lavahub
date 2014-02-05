package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class PingCommand extends JavaPlugin implements CommandExecutor{
	public static Lavahub plugin;
	
	public PingCommand(Lavahub lavahub) {
		plugin = lavahub;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(commandLable.equalsIgnoreCase("ping")){
			sender.sendMessage(getConfig().getString("ping-format"));
		}
		return true;
	}
}
