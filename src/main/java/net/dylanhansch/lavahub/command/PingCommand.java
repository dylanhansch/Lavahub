package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PingCommand implements CommandExecutor {
	private final Lavahub plugin;

	public PingCommand(Lavahub plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		sender.sendMessage(plugin.getConfig().getString("ping-format"));
		return true;
	}

}
