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
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.clearinventory")) {
				player.sendMessage(ChatColor.RED + "You do not have permission!");
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
				player.sendMessage(ChatColor.RED + "You do not have permission!");
				return true;
			} else {
				target.getInventory().clear();
				target.sendMessage(ChatColor.GOLD + "Your inventory was cleared by " + player.getName() + ".");
				player.sendMessage(ChatColor.GOLD + "You have cleared " + target.getName() + ChatColor.GOLD  + "'s inventory.");
				return true;
			}
			
		}
		return false;
		
	} 

}
