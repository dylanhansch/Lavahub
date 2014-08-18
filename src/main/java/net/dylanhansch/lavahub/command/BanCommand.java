package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BanCommand implements CommandExecutor {
	private final Lavahub plugin;

	public BanCommand(Lavahub plugin) {
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
				OfflinePlayer targetPlayer = plugin.getServer().getOfflinePlayer(args[0]);
				String message = String.format("%s has been banned by %s for: %s",
						ChatColor.RED + targetPlayer.getName() + ChatColor.GOLD,
						ChatColor.GREEN + sender.getName() + ChatColor.GOLD,
						ChatColor.RESET + "You have been banned.");
					
				sender.getServer().broadcastMessage(message);
				if(!(sender.getServer().getPlayer(args[0]) == null)){
					sender.getServer().getPlayer(args[0]).kickPlayer(ChatColor.RED + "Banned: " + ChatColor.RESET + "You have been banned. \n " +
							"Appeal to dylan@dylanhansch.net");
				}
				targetPlayer.setBanned(true);
				return true;
			}
		}
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.ban")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.ban");
				return true;
			}else{
				OfflinePlayer targetPlayer = plugin.getServer().getOfflinePlayer(args[0]);
				StringBuilder banReason = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    if (i > 1)
                        banReason.append(' ');
                    banReason.append(args[i]);
                }
                String reason = banReason.toString();
                String message = String.format("%s has been banned by %s for: %s.",
                                    ChatColor.RED + targetPlayer.getName() + ChatColor.GOLD,
                                    ChatColor.GREEN + sender.getName() + ChatColor.GOLD,
                                    ChatColor.RESET + reason);

                sender.getServer().broadcastMessage(message);
                if(!(sender.getServer().getPlayer(args[0]) == null)){
					sender.getServer().getPlayer(args[0]).kickPlayer(ChatColor.RED + "Banned: " + ChatColor.RESET + banReason.toString() + "\n" + 
							"Appeal to dylan@dylanhansch.net");
				}
				targetPlayer.setBanned(true);
				return true;
			}
		}
		return false;
	}

}
