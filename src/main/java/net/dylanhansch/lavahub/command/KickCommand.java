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
		Player targetPlayer = plugin.getServer().getPlayer(args[0]);
		if(targetPlayer == null){
			sender.sendMessage(ChatColor.RED + "Error: That player is not online!");
			return true;
		}
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
				plugin.getServer().broadcastMessage(sender.getServer().getPlayer(args[0]).getDisplayName() + ChatColor.GOLD + " has been kicked by " + ChatColor.RESET + sender.getName() + ChatColor.GOLD + " for: " + ChatColor.RESET + "You have been kicked.");
				sender.getServer().getPlayer(args[0]).kickPlayer("You have been kicked.");
				return true;
			}
		}
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.kick")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.kick");
				return true;
			}else{
				StringBuilder kickReason = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    if (i > 1)
                        kickReason.append(' ');
                    kickReason.append(args[i]);
                }
                String reason = kickReason.toString();
                String message = String.format("%s has been kicked by %s for: %s.",
                                    targetPlayer.getDisplayName() + ChatColor.GOLD,
                                    ChatColor.RESET + sender.getName() + ChatColor.GOLD,
                                    ChatColor.RESET + reason);

                sender.getServer().broadcastMessage(message);
                targetPlayer.kickPlayer(kickReason.toString());
                return true;
			}
		}
		return false;
	}
}
