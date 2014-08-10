package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommand implements CommandExecutor {
	private final Lavahub plugin;

	public PlayerCommand(Lavahub plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.player")) {
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.player");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		@SuppressWarnings("deprecation")
		Player targetPlayer = plugin.getServer().getPlayer(args[0]);
		if(args.length == 1){
			if(!sender.hasPermission("lavahub.player")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.player");
				return true;
			}else{
				if(targetPlayer == null){
					sender.sendMessage(ChatColor.RED + "Error: That player is not online!");
					return true;
				}else{
					sender.sendMessage("== " + targetPlayer.getDisplayName() + " ==");
					sender.sendMessage(ChatColor.GOLD + "Health: " + ChatColor.RESET + targetPlayer.getHealth());
					sender.sendMessage(ChatColor.GOLD + "Hunger: " + ChatColor.RESET + targetPlayer.getFoodLevel());
					sender.sendMessage(ChatColor.GOLD + "Level: " + ChatColor.RESET + targetPlayer.getLevel());
					sender.sendMessage(ChatColor.GOLD + "IP: " + ChatColor.RESET + targetPlayer.getAddress());
					sender.sendMessage(ChatColor.GOLD + "World: " + ChatColor.RESET + targetPlayer.getWorld());
					sender.sendMessage(ChatColor.GOLD + "Last Played: " + ChatColor.RESET + targetPlayer.getLastPlayed());
					sender.sendMessage(ChatColor.GOLD + "Joined: " + ChatColor.RESET + targetPlayer.getFirstPlayed());
					return true;
				}
			}
		}
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.player")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.player");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		return false;
	}

}
