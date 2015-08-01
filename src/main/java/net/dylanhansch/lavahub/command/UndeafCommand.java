package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UndeafCommand implements CommandExecutor {
	private final Lavahub plugin;

	public UndeafCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		@SuppressWarnings("deprecation")
		Player player = plugin.getServer().getPlayer(args[0]);
		boolean deafened = plugin.getConfig().getBoolean("players." + player.getName() + ".deafened");
		
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.undeafen")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.undeafen");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		
		if(args.length == 1){
			if(!sender.hasPermission("lavahub.undeafen")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.undeafen");
				return true;
			}else{
				if(player.isOnline()){
					if(deafened == true){
						plugin.getConfig().set("players."+ player.getName() + ".deafened", false);
						plugin.saveConfig();
						plugin.deafenedPlayers.remove(player.getName());
						sender.sendMessage(ChatColor.GREEN + player.getName() + " has been undeafened.");
						player.sendMessage(ChatColor.RED + "You have been undeafened!");
						return true;
					}else{
						sender.sendMessage(ChatColor.RED + "Player already undeafened.");
						return true;
					}
				}else{
					sender.sendMessage(ChatColor.RED + "Player not online.");
					return true;
				}
			}
		}
		
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.undeafen")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.undeafen");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		
		return false;
	}
}
