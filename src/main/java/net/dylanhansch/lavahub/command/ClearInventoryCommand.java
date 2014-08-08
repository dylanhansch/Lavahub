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
				sender.sendMessage(ChatColor.RED + "Error: Not executable by console!");
				return true;
			}
			@SuppressWarnings("deprecation")
			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
			if(targetPlayer == null){
				sender.sendMessage(ChatColor.RED + "Error: That player is not online!");
				return true;
			}
			if(args.length == 1){
				targetPlayer.getInventory().clear();
				sender.sendMessage(ChatColor.GOLD + "Cleared " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s inventory.");
				return true;
			}
			if(args.length >= 2){
				sender.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.clearinventory")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.clearinventory");
				return true;
			} else {
				player.getInventory().clear();
				player.sendMessage(ChatColor.GOLD + "Cleared your inventory.");
				return true;
			}
		}
		@SuppressWarnings("deprecation")
		Player targetPlayer = plugin.getServer().getPlayer(args[0]);
		if(targetPlayer == null){
			player.sendMessage(ChatColor.RED + "Error: That player is not online!");
			return true;
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.clearinventory.others")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.clearinventory.others");
				return true;
			} else {
				targetPlayer.getInventory().clear();
				player.sendMessage(ChatColor.GOLD + "Cleared " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD  + "'s inventory.");
				return true;
			}
		}
		if(args.length >= 2){
			player.sendMessage(ChatColor.RED + "Error: Too many arguments!");
			return false;
		}
		return false;
		
	}

}
