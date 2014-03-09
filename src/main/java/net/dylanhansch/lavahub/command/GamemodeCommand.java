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
	private final Lavahub plugin;

	public GamemodeCommand(Lavahub plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(!(sender instanceof Player)){
			Player targetPlayer = plugin.getServer().getPlayer(args[1]);
			if(targetPlayer == null){
				sender.sendMessage(ChatColor.RED + "That player is not online!");
				return true;
			}
			if(args[0].equalsIgnoreCase("0")){
				targetPlayer.setGameMode(GameMode.SURVIVAL);
				targetPlayer.sendMessage(ChatColor.GOLD + "Console has changed your gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
				sender.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("survival")){
					targetPlayer.setGameMode(GameMode.SURVIVAL);
					targetPlayer.sendMessage(ChatColor.GOLD + "Console has changed your gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					sender.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					return true;
				}
			}
			if(args[0].equalsIgnoreCase("1")){
				targetPlayer.setGameMode(GameMode.CREATIVE);
				targetPlayer.sendMessage(ChatColor.GOLD + "Console has changed your gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
				sender.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("creative")){
					targetPlayer.setGameMode(GameMode.CREATIVE);
					targetPlayer.sendMessage(ChatColor.GOLD + "Console has changed your gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					sender.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					return true;
				}
			}
			if(args[0].equalsIgnoreCase("2")){
				targetPlayer.setGameMode(GameMode.ADVENTURE);
				targetPlayer.sendMessage(ChatColor.GOLD + "Console has changed your gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
				sender.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("adventure")){
					targetPlayer.setGameMode(GameMode.ADVENTURE);
					targetPlayer.sendMessage(ChatColor.GOLD + "Console has changed your gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					sender.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					return true;
				}
			}
		}
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
		Player targetPlayer = plugin.getServer().getPlayer(args[1]);
		if(args.length == 2){
			if(!player.hasPermission("lavahub.gamemode")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
				return true;
			} else {
				if(targetPlayer == null){
					player.sendMessage(ChatColor.RED + "That player is not online!");
					return true;
				}
				if(args[0].equalsIgnoreCase("0")){
					targetPlayer.setGameMode(GameMode.SURVIVAL);
					targetPlayer.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					player.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("survival")){
						targetPlayer.setGameMode(GameMode.SURVIVAL);
						targetPlayer.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
						player.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("1")){
					targetPlayer.setGameMode(GameMode.CREATIVE);
					targetPlayer.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					player.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("creative")){
						targetPlayer.setGameMode(GameMode.CREATIVE);
						targetPlayer.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
						player.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("2")){
					targetPlayer.setGameMode(GameMode.ADVENTURE);
					targetPlayer.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					player.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					return true;
				} else {
					if(args[0].equalsIgnoreCase("adventure")){
						targetPlayer.setGameMode(GameMode.ADVENTURE);
						targetPlayer.sendMessage(player.getDisplayName() + ChatColor.GOLD + " has changed your gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
						player.sendMessage(ChatColor.GOLD + "You have changed " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
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
