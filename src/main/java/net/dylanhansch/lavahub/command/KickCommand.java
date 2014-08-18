package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {
	private final Lavahub plugin;

	public KickCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.kick")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.kick");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
		}
		if(args.length == 1){
			if(!sender.hasPermission("lavahub.kick")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.kick");
				return true;
			}else{
				Player targetPlayer = plugin.getServer().getPlayer(args[0]);
				if(targetPlayer == null){
					sender.sendMessage(ChatColor.RED + "Error: That player is not online!");
					return true;
				}
				String message = String.format("%s has been kicked by %s for: %s",
                        ChatColor.RED + targetPlayer.getName() + ChatColor.GOLD,
                        ChatColor.GREEN + sender.getName() + ChatColor.GOLD,
                        ChatColor.RESET + "You have been kicked.");
				
				targetPlayer.kickPlayer("You have been kicked.");
				sender.getServer().broadcastMessage(message);
				return true;
			}
		}
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.kick")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.kick");
				return true;
			}else{
				Player targetPlayer = plugin.getServer().getPlayer(args[0]);
				if(targetPlayer == null){
					sender.sendMessage(ChatColor.RED + "Error: That player is not online!");
					return true;
				}
				StringBuilder kickReason = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    if (i > 1)
                        kickReason.append(' ');
                    kickReason.append(args[i]);
                }
                String reason = kickReason.toString();
                String message = String.format("%s has been kicked by %s for: %s",
                		ChatColor.RED + targetPlayer.getName() + ChatColor.GOLD,
                        ChatColor.GREEN + sender.getName() + ChatColor.GOLD,
                        ChatColor.RESET + reason);
                targetPlayer.kickPlayer(kickReason.toString());
                sender.getServer().broadcastMessage(message);
                return true;
			}
		}
		return false;
	}
}
