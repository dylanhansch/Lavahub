package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
				Player targetPlayer = plugin.getServer().getPlayer(args[0]);
				String message = String.format("%s has been unbanned by %s.",
                        targetPlayer.getDisplayName() + ChatColor.GOLD,
                        ChatColor.RESET + sender.getName() + ChatColor.GOLD);
				
				sender.getServer().broadcastMessage(message);
				targetPlayer.setBanned(false);
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
