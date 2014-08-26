package net.dylanhansch.lavahub.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.dylanhansch.lavahub.Lavahub;

public class HealCommand implements CommandExecutor {
	private final Lavahub plugin;

	public HealCommand(Lavahub plugin) {
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
				targetPlayer.setHealth((double)20);
				targetPlayer.setFoodLevel(20);
				sender.sendMessage(ChatColor.GOLD + "Healed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + ".");
				return true;
			}
			if(args.length >= 2){
				sender.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.heal")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.heal");
				return true;
			} else {
				player.setHealth((double)20);
				player.setFoodLevel(20);
				player.sendMessage(ChatColor.GOLD + "Healed.");
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
			if(!player.hasPermission("lavahub.heal.others")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.heal.others");
				return true;
			} else {
				targetPlayer.setHealth((double)20);
				targetPlayer.setFoodLevel(20);
				player.sendMessage(ChatColor.GOLD + "Healed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + ".");
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
