package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;
import net.dylanhansch.lavahub.utility.GetTPS;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatsCommand implements CommandExecutor {
	private final Lavahub plugin;

	public StatsCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!sender.hasPermission("lavahub.stats")){
			sender.sendMessage(plugin.NO_PERMISSIONS_MSG);
			return true;
		}else{
			if(args.length != 0){
				sender.sendMessage(plugin.TOO_MANY_ARGS);
				return false;
			}else{
				plugin.updateMemoryStats();
				final int[] uptime = plugin.getCurrentServerUptime();
				
				sender.sendMessage(ChatColor.GOLD + "Uptime: " + ChatColor.GREEN + uptime[3] + " day(s), " + uptime[2] + " hour(s), " + 
						uptime[1] + " minute(s), and " + uptime[0] + " second(s)");
				sender.sendMessage(ChatColor.GOLD + "TPS: " + ChatColor.GREEN + String.format("%.2f", GetTPS.getTPS()));
				sender.sendMessage(ChatColor.GOLD + "Total memory: " + ChatColor.GREEN + String.format("%.2f", plugin.totalMemory) + " MB");
				sender.sendMessage(ChatColor.GOLD + "Allocated memory: " + ChatColor.GREEN + String.format("%.2f", plugin.maxMemory) + " MB");
				sender.sendMessage(ChatColor.GOLD + "Free memory: " + ChatColor.GREEN + String.format("%.2f", plugin.freeMemory) + " MB");
				return true;
			}
		}
	}
}
