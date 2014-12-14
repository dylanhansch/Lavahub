package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelwarpCommand implements CommandExecutor{
	private final Lavahub plugin;

	public DelwarpCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Error: Not executable by console!");
			return true;
		}
		
		Player player = (Player) sender;
		if(args.length == 0 || args.length >= 2){
			if(!sender.hasPermission("lavahub.delwarp")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.action");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Error: Not enough or too many arguments!");
				return false;
			}
		}
		
		if(args.length == 1){
			if(!sender.hasPermission("lavahub.delwarp")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.action");
				return true;
			}else{
				plugin.getConfig().getConfigurationSection("warps").set(args[0], null);
                plugin.saveConfig();
                player.sendMessage(ChatColor.GOLD + "Warp " + ChatColor.RESET + args[0] + ChatColor.GOLD + " removed.");
				return true;
			}
			
		}
		
		return false;
	}
}
