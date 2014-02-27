package net.dylanhansch.lavahub.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.dylanhansch.lavahub.Lavahub;

public class ClearInventoryCommand implements CommandExecutor {
	public static Lavahub plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			Player target = Bukkit.getServer().getPlayer(args[0]);
			target.getInventory().clear();
			target.sendMessage(ChatColor.GOLD + "Your inventory was cleared by Console.");
			sender.sendMessage(ChatColor.GOLD + "You cleared " + target.getDisplayName() + ChatColor.GOLD + "'s inventory.");
			return true;
		}
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.clearinventory")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				player.getInventory().clear();
				player.sendMessage(ChatColor.GOLD + "You have cleared your inventory.");
				return true;
			}
		}
		Player target = Bukkit.getServer().getPlayer(args[0]);
		if(target == null){
			player.sendMessage(ChatColor.RED + "That player is not online!");
			return true;
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.clearinventory.others")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				target.getInventory().clear();
				target.sendMessage(ChatColor.GOLD + "Your inventory was cleared by " + player.getDisplayName() + ".");
				player.sendMessage(ChatColor.GOLD + "You have cleared " + target.getDisplayName() + ChatColor.GOLD  + "'s inventory.");
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
