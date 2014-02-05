package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HackCommand extends JavaPlugin implements CommandExecutor {
	public static Lavahub plugin;
	
	public HackCommand(Lavahub lavahub) {
		plugin = lavahub;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		Player player = (Player) sender;
		if(commandLable.equalsIgnoreCase("hack")){
			player.sendMessage(ChatColor.GREEN + "No hacky hacky.");
		}
		return true;
	}
}
