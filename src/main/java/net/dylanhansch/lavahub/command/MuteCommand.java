package net.dylanhansch.lavahub.command;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.dylanhansch.lavahub.Lavahub;

public class MuteCommand implements CommandExecutor{
	private final Lavahub plugin;

	public MuteCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		@SuppressWarnings("deprecation")
		OfflinePlayer targetPlayer = plugin.getServer().getOfflinePlayer(args[0]);
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.mute")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.mute");
				return true;
			}else{
				Set<String> mutes = plugin.getConfig().getConfigurationSection("players").getKeys(false);
				StringBuilder muteList = new StringBuilder();
				for (Iterator<String> it = mutes.iterator(); it.hasNext();) {
					String muted = it.next();
					muteList.append(muted);
					if (it.hasNext())
						muteList.append(", ");
					else
						muteList.append(".");
				}
				sender.sendMessage(ChatColor.GOLD + "Muted players: " + ChatColor.RESET + muteList.toString());
				return true;
			}
		}
		
		if(args.length == 1){
			if(!sender.hasPermission("lavahub.mute")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.mute");
				return true;
			}else{
				if(targetPlayer == null){
					sender.sendMessage("ChatColor.RED" + "Error: Player does not exist.");
					return true;
				}else{
					plugin.getConfig().set("players." + args[0] + ".muted", true);
	                plugin.saveConfig();
	                sender.sendMessage(ChatColor.RESET + args[0] + ChatColor.GOLD + " muted.");
	                if(targetPlayer.isOnline()){
	                	((CommandSender) targetPlayer).sendMessage(ChatColor.RED + "You have been muted.");
	                	return true;
	                }
	                return true;
				}
			}
		}
		
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.mute")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.mute");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		
		return false;
	}

}
