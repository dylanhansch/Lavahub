package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TphereCommand implements CommandExecutor {
	private final Lavahub plugin;

	public TphereCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Error: Command cannot be executed by console.");
			return true;
		}
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.tphere")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.tphere");
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		@SuppressWarnings("deprecation")
		Player targetPlayer = plugin.getServer().getPlayer(args[0]);
		if(args.length == 1){
			if(!player.hasPermission("lavahub.tphere")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.tphere");
				return true;
			}else{
				if(targetPlayer == null){
					sender.sendMessage(ChatColor.RED + "Error: That player is not online!");
					return true;
				}else{
					player.sendMessage(ChatColor.GOLD + "Teleporting..");
					targetPlayer.teleport(player);
					targetPlayer.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has teleported you to them.");
					return true;
				}
			}
		}
		if(args.length >= 2){
			if(!player.hasPermission("lavahub.tphere")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.tphere");
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		return false;
	}

}
