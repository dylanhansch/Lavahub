package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Config;
import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor{
	public static Lavahub plugin;
	
	public PingCommand(Lavahub lavahub) {
		plugin = lavahub;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		Player player = (Player) sender;
		if(commandLable.equalsIgnoreCase("ping")){
			player.sendMessage(Config.config.getString("ping-format"));
		}
		return false;
	}
}
