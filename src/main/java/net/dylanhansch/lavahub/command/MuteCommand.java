package net.dylanhansch.lavahub.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.dylanhansch.lavahub.Lavahub;

public class MuteCommand implements CommandExecutor{
	private final Lavahub plugin;

	public MuteCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		@SuppressWarnings("deprecation")
		Player player = plugin.getServer().getPlayer(args[0]);
		if(sender.hasPermission("lavahub.mute")){
			if(args.length == 1){
				if(player.isOnline()){
					if(!plugin.mutedPlayers.containsKey(player.getName())){
						plugin.mutedPlayers.put(player.getName(), null);
						return true;
					}else{
						sender.sendMessage(ChatColor.RED + "Player already muted.");
						return true;
					}
				}else{
					sender.sendMessage(ChatColor.RED + "Player not online.");
					return true;
				}
			}else{
				sender.sendMessage(ChatColor.RED + "Invalid syntax.");
				return false;
			}
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.mute");
			return true;
		}
	}
}
