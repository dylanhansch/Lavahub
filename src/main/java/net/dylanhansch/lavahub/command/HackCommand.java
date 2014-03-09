package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HackCommand implements CommandExecutor {
	private final Lavahub plugin;

	public HackCommand(Lavahub plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		sender.sendMessage(ChatColor.GREEN + "No hacky hacky!");
		return true;
	}

}
