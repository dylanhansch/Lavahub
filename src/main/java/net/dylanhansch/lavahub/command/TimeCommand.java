package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCommand implements CommandExecutor{
	private final Lavahub plugin;

	public TimeCommand(Lavahub plugin){
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		// Sending as console
		if(!(sender instanceof Player)){
			if(args.length == 0 || args.length >= 4){
				sender.sendMessage(ChatColor.RED + "Error: Not enough or too many arguments!");
				return false;
			}
			if(args.length == 1){
				sender.sendMessage(ChatColor.RED + "Error: Not executable by console!");
				return false;
			}
			if(args.length == 2){
				World targetWorld = plugin.getServer().getWorld(args[1]);
				if(targetWorld == null){
					sender.sendMessage(ChatColor.RED + "Error: That world does not excist!");
					return true;
				}
				if(args[0].equalsIgnoreCase("day")){
					targetWorld.setTime(0);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "day" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("noon")){
					targetWorld.setTime(6000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "noon" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("night")){
					targetWorld.setTime(14000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "night" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else{
					return false;
				}
			}
			if(args.length == 3){
				World targetWorld = plugin.getServer().getWorld(args[2]);
				if(targetWorld == null){
					sender.sendMessage(ChatColor.RED + "Error: That world does not excist!");
					return true;
				}
				if(args[0].equalsIgnoreCase("set")){
					long ticks;
					try{
						ticks = Long.parseLong(args[1]);
					}catch(NumberFormatException e){
						sender.sendMessage(ChatColor.RED + "Error: The tick value must be a whole number");
						return false;
					}
					targetWorld.setTime(ticks);
					sender.sendMessage(ChatColor.GOLD + "Changed ticks to " + ChatColor.RED + args[1] + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else{
					return false;
				}
			}
		}
		
		// Change current world time
		Player player = (Player) sender;
		World world = player.getWorld();
		if(args.length == 0 || args.length >= 4){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.time");
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "Error: Not enough or too many arguments!");
				return false;
			}
		}
		
		if(args.length == 1){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.time");
				return true;
			}else{
				if(args[0].equalsIgnoreCase("day")){
					world.setTime(0);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "day" + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("noon")){
					world.setTime(6000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "noon" + ChatColor.GOLD + ".");
					return true;
				}else if(args[0].equalsIgnoreCase("night")){
					world.setTime(14000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "night" + ChatColor.GOLD + ".");
					return true;
				}else{
					return false;
				}	
			}
		}
		
		// Change other world time
		World targetWorld = plugin.getServer().getWorld(args[1]);
		if(args.length == 2){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.time");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("day") || args[0].equalsIgnoreCase("noon") || args[0].equalsIgnoreCase("night")){
					if(targetWorld == null){
						sender.sendMessage(ChatColor.RED + "Error: That world does not excist!");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("day")){
					targetWorld.setTime(0);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "day" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("noon")){
					targetWorld.setTime(6000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "noon" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("night")){
					targetWorld.setTime(14000);
					sender.sendMessage(ChatColor.GOLD + "Changed time to " + ChatColor.RED + "night" + ChatColor.GOLD + " in '" + ChatColor.RED + targetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else if(args[0].equalsIgnoreCase("set")){
					long ticks;
					try{
						ticks = Long.parseLong(args[1]);
					}catch(NumberFormatException e){
						sender.sendMessage(ChatColor.RED + "Error: The tick value must be a whole number");
						return false;
					}
					world.setTime(ticks);
					sender.sendMessage(ChatColor.GOLD + "Changed ticks to " + ChatColor.RED + args[1] + ChatColor.GOLD + ".");
					return true;
				}else{
					return false;
				}
			}
		}
		
		// For setting ticks in a supplied world only
		World tickTargetWorld = plugin.getServer().getWorld(args[2]);
		if(args.length == 3){
			if(!player.hasPermission("lavahub.time")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.time");
				return true;
			}else{
				if(tickTargetWorld == null){
					sender.sendMessage(ChatColor.RED + "Error: That world does not excist!");
					return true;
				}
				if(args[0].equalsIgnoreCase("set")){
					long ticks;
					try{
						ticks = Long.parseLong(args[1]);
					}catch(NumberFormatException e){
						sender.sendMessage(ChatColor.RED + "Error: The tick value must be a whole number");
						return false;
					}
					tickTargetWorld.setTime(ticks);
					sender.sendMessage(ChatColor.GOLD + "Changed ticks to " + ChatColor.RED + args[1] + ChatColor.GOLD + " in '" + ChatColor.RED + tickTargetWorld.getName() + ChatColor.GOLD + "'.");
					return true;
				}else{
					return false;
				}
			}
		}
		
		return false;
	}

}
