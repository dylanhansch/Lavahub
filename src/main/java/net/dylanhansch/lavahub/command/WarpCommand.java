package net.dylanhansch.lavahub.command;

import java.util.Iterator;
import java.util.Set;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
	private final Lavahub plugin;

	public WarpCommand(Lavahub plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			if(args.length != 0){
				sender.sendMessage(ChatColor.RED + "Error: Not executable by console!");
				return true;
			}else{
				Set<String> warps = plugin.getConfig().getConfigurationSection("warps").getKeys(false);
				StringBuilder warpsList = new StringBuilder();
				for (Iterator<String> it = warps.iterator(); it.hasNext();) {
					String warp = it.next();
					warpsList.append(warp);
					if (it.hasNext())
						warpsList.append(", ");
					else
						warpsList.append(".");
				}
				sender.sendMessage(ChatColor.GOLD + "Warps: " + ChatColor.RESET + warpsList.toString());
				return true;
			}
		}
		
		Player player = (Player) sender;
		if(args.length >= 2){
			if(!sender.hasPermission("lavahub.warp")){
                sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.warp");
                return true;
            }else{
            	sender.sendMessage(ChatColor.RED + "Error: Not enough or too many arguments!");
            	return false;
            }
		}
		
		if(args.length == 0){
			if(!sender.hasPermission("lavahub.warp")){
				sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.warp");
				return true;
			}else{
				Set<String> warps = plugin.getConfig().getConfigurationSection("warps").getKeys(false);
				StringBuilder warpsList = new StringBuilder();
				for (Iterator<String> it = warps.iterator(); it.hasNext();) {
					String warp = it.next();
					warpsList.append(warp);
					if (it.hasNext())
						warpsList.append(", ");
					else
						warpsList.append(".");
				}
				sender.sendMessage(ChatColor.GOLD + "Warps: " + ChatColor.RESET + warpsList.toString());
				return true;
			}
		}
		
		if(args.length == 1){
			if(!sender.hasPermission("lavahub.warp")){
                sender.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.warp");
                return true;
            }else{
            	if(plugin.getConfig().getString("warps." + args[0]) == null){
            		sender.sendMessage(ChatColor.RED + "Error: That warp does not exist.");
            		return true;
            	}else{
            		 World world = plugin.getServer().getWorld(plugin.getConfig().getString("warps." + args[0] + ".world"));
                     Double x = plugin.getConfig().getDouble("warps." + args[0] + ".x");
                     Double y = plugin.getConfig().getDouble("warps." + args[0] + ".y");
                     Double z = plugin.getConfig().getDouble("warps." + args[0] + ".z");
                     Float yaw = (float) plugin.getConfig().getDouble("warps." + args[0] + ".yaw");
                     Float pitch = (float) plugin.getConfig().getDouble("warps." + args[0] + ".pitch");
                     player.teleport(new Location(world, x, y, z, yaw, pitch));
                     return true;
            	}
            }
		}
		
		return false;
	}

}
