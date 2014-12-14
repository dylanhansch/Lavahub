package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetwarpCommand implements CommandExecutor {
	private final Lavahub plugin;

	public SetwarpCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Error: Not executable by console!");
			return true;
		}
		
		Player player = (Player) sender;
		if(args.length == 0 || args.length >= 2){
			if(!sender.hasPermission("lavahub.setwarp")){
                sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.setwarp");
                return true;
            }else{
            	sender.sendMessage(ChatColor.RED + "Error: Not enough or too many arguments!");
            	return false;
            }
		}
		
		if(args.length == 1){
			if(!sender.hasPermission("lavahub.setwarp")){
                sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.setwarp");
                return true;
            }else{
            	plugin.getConfig().set("warps." + args[0] + ".world", player.getLocation().getWorld().getName());
                plugin.getConfig().set("warps." + args[0] + ".x", player.getLocation().getX());
                plugin.getConfig().set("warps." + args[0] + ".y", player.getLocation().getY());
                plugin.getConfig().set("warps." + args[0] + ".z", player.getLocation().getZ());
                plugin.getConfig().set("warps." + args[0] + ".yaw", player.getLocation().getYaw());
                plugin.getConfig().set("warps." + args[0] + ".pitch", player.getLocation().getPitch());
                plugin.saveConfig();
                sender.sendMessage(ChatColor.GOLD + "Warp " + ChatColor.RESET + args[0] + ChatColor.GOLD + " set.");
                return true;
            }
		}
		
		return false;
	}

}
