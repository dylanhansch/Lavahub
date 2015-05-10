package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnmuteCommand implements CommandExecutor {
	private final Lavahub plugin;

	public UnmuteCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		@SuppressWarnings("deprecation")
		Player player = plugin.getServer().getPlayer(args[0]);
		if(sender.hasPermission("lavahub.unmute")){
			if(args.length == 1){
				if(player.isOnline()){
					if(plugin.mutedPlayers.containsKey(player.getName())){
						plugin.mutedPlayers.remove(player.getName());
						return true;
					}else{
						sender.sendMessage(ChatColor.RED + "Player already unmuted.");
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
			sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.unmute");
			return true;
		}
	}
}
