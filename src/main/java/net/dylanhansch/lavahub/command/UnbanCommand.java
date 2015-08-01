package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnbanCommand implements CommandExecutor {
	private final Lavahub plugin;

	public UnbanCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.ban")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.ban");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		
		if(args.length == 1){
			if(!sender.hasPermission("lavahub.ban")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.ban");
				return true;
			}else{
				OfflinePlayer targetPlayer = plugin.getServer().getOfflinePlayer(args[0]);
				if(targetPlayer == null){
					sender.sendMessage(ChatColor.RED + "Error: That player does not excist!");
					return true;
				}
				String message = String.format("%s has been unbanned by %s.",
                        ChatColor.RED + targetPlayer.getName() + ChatColor.GOLD,
                        ChatColor.GREEN + sender.getName() + ChatColor.GOLD);
				
				sender.getServer().broadcastMessage(message);
				plugin.getConfig().set("players." + targetPlayer.getName() + ".banned", false);
				plugin.getConfig().set("players." + targetPlayer.getName() + ".banreason", null);
				plugin.saveConfig();
				return true;
			}
		}
		
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.ban")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.ban");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
                return true;
			}
		}
		
		return false;
	}
}
