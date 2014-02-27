package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
	public static Lavahub plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.gamemode")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				return false;
			}	
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.gamemode")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("0")){
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(ChatColor.GOLD + "You changed your own gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("survival")){
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(ChatColor.GOLD + "You changed your own gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("1")){
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.GOLD + "You changed your own gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("creative")){
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage(ChatColor.GOLD + "You changed your own gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("2")){
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(ChatColor.GOLD + "You changed your own gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("adventure")){
						player.setGameMode(GameMode.ADVENTURE);
						player.sendMessage(ChatColor.GOLD + "You changed your own gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
						return true;
					}
				}
			}
		}
		Player target = Bukkit.getServer().getPlayer(args[1]);
		if(args.length == 2){
			if(!player.hasPermission("lavahub.gamemode")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				if(target == null){
					player.sendMessage(ChatColor.RED + "That player is not online!");
					return true;
				}
				if(args[0].equalsIgnoreCase("0")){
					target.setGameMode(GameMode.SURVIVAL);
					target.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					player.sendMessage(ChatColor.GOLD + "You have changed " + player.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("survival")){
						target.setGameMode(GameMode.SURVIVAL);
						target.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
						player.sendMessage(ChatColor.GOLD + "You have changed " + player.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("1")){
					target.setGameMode(GameMode.CREATIVE);
					target.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					player.sendMessage(ChatColor.GOLD + "You have changed " + player.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("creative")){
						target.setGameMode(GameMode.CREATIVE);
						target.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
						player.sendMessage(ChatColor.GOLD + "You have changed " + player.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("2")){
					target.setGameMode(GameMode.ADVENTURE);
					target.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					player.sendMessage(ChatColor.GOLD + "You have changed " + player.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("adventure")){
						target.setGameMode(GameMode.ADVENTURE);
						target.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
						player.sendMessage(ChatColor.GOLD + "You have changed " + player.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
						return true;
					}
				}
			}
		}
		if(args.length >= 3){
			if(!player.hasPermission("lavahub.gamemode")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Too many arguments!");
				return false;
			}	
		}
		
		return false;
	}

}
