package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCommand implements CommandExecutor {
	private final Lavahub plugin;

	public TpCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Error: Not executable by console!");
			return true;
		}
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.tp")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.tp");
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		if(args.length == 1){
			@SuppressWarnings("deprecation")
			Player targetPlayer = plugin.getServer().getPlayer(args[0]);
			if(!player.hasPermission("lavahub.tp")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.tp");
				return true;
			}else{
				if(targetPlayer == null){
					sender.sendMessage(ChatColor.RED + "Error: That player is not online!");
					return true;
				}else{
					player.sendMessage(ChatColor.GOLD + "Teleporting..");
					player.teleport(targetPlayer);
					return true;
				}
			}
		}
		if(args.length == 2){
			@SuppressWarnings("deprecation")
			Player targetPlayer = plugin.getServer().getPlayer(args[0]);
			@SuppressWarnings("deprecation")
			Player targetPlayer1 = plugin.getServer().getPlayer(args[1]);
			if(!player.hasPermission("lavahub.tp.others")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.tp.others");
				return true;
			}else{
				if(targetPlayer == null || targetPlayer1 == null){
					sender.sendMessage(ChatColor.RED + "Error: One or more of those players are not online!");
					return true;
				}else{
					targetPlayer.sendMessage(ChatColor.GOLD + "You've been teleported to " + targetPlayer1.getDisplayName() + ChatColor.GOLD + " by " + player.getDisplayName() + ChatColor.GOLD + ".");
					targetPlayer.teleport(targetPlayer1);
					return true;
				}
			}
		}
		if(args.length >= 3){
			if(!player.hasPermission("lavahub.tp")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.tp");
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		return false;
	}

}
