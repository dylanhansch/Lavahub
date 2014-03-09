package net.dylanhansch.lavahub.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.dylanhansch.lavahub.Lavahub;

public class ClearInventoryCommand implements CommandExecutor {
	private final Lavahub plugin;

	public ClearInventoryCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			if(args.length == 0){
				sender.sendMessage(ChatColor.RED + "Not executable by console!");
				return true;
			}
			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
			if(targetPlayer == null){
				sender.sendMessage(ChatColor.RED + "That player is not online!");
				return true;
			}
			if(args.length == 1){
				targetPlayer.getInventory().clear();
				targetPlayer.sendMessage(ChatColor.GOLD + "Your inventory was cleared by Console.");
				sender.sendMessage(ChatColor.GOLD + "You cleared " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s inventory.");
				return true;
			}
			if(args.length >= 2){
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
				return false;
			}
		}
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.clearinventory")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				player.getInventory().clear();
				player.sendMessage(ChatColor.GOLD + "You cleared your inventory.");
				return true;
			}
		}
		Player targetPlayer = plugin.getServer().getPlayer(args[0]);
		if(targetPlayer == null){
			player.sendMessage(ChatColor.RED + "That player is not online!");
			return true;
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.clearinventory.others")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				targetPlayer.getInventory().clear();
				targetPlayer.sendMessage(ChatColor.GOLD + "Your inventory was cleared by " + ChatColor.RESET + player.getDisplayName() + ChatColor.GOLD + ".");
				player.sendMessage(ChatColor.GOLD + "You cleared " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD  + "'s inventory.");
				return true;
			}
		}
		if(args.length >= 2){
			player.sendMessage(ChatColor.RED + "Too many arguments!");
			return false;
		}
		return false;
		
	} 

}
