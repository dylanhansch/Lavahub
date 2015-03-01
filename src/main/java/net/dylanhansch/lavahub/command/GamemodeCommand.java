package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

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
			if(args.length == 0){
				sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}
			if(args.length == 1){
				sender.sendMessage(ChatColor.RED + "Error: Not executable by console!");
				return false;
			}
			if(args.length == 2){
				@SuppressWarnings("deprecation")
				Player targetPlayer = plugin.getServer().getPlayer(args[1]);
				if(targetPlayer == null){
					sender.sendMessage(ChatColor.RED + "Error: That player is not online!");
					return true;
				}
				if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")){
					targetPlayer.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage(ChatColor.GOLD + "Set " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					targetPlayer.sendMessage("Your game mode has been updated");
					return true;
				}else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")){
					targetPlayer.setGameMode(GameMode.CREATIVE);
					sender.sendMessage(ChatColor.GOLD + "Set " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					targetPlayer.sendMessage("Your game mode has been updated");
					return true;
				}else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")){
					targetPlayer.setGameMode(GameMode.ADVENTURE);
					sender.sendMessage(ChatColor.GOLD + "Set " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					targetPlayer.sendMessage("Your game mode has been updated");
					return true;
				}else{
					return false;
				}
			}
			if(args.length >= 3){
				sender.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		Player player = (Player) sender;
		if(args.length == 0){
			if(!player.hasPermission("lavahub.gamemode")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.gamemode");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
				return false;
			}	
		}
		if(args.length == 1){
			if(!player.hasPermission("lavahub.gamemode")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.gamemode");
				return true;
			} else {
				if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")){
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage("Your game mode has been updated");
					return true;
				}else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")){
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage("Your game mode has been updated");
					return true;
				}else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")){
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage("Your game mode has been updated");
					return true;
				}else{
					return false;
				}
			}
		}
		@SuppressWarnings("deprecation")
		Player targetPlayer = plugin.getServer().getPlayer(args[1]);
		if(args.length == 2){
			if(!player.hasPermission("lavahub.gamemode.others")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.gamemode.others");
				return true;
			} else {
				if(targetPlayer == null){
					player.sendMessage(ChatColor.RED + "Error: That player is not online!");
					return true;
				}
				if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")){
					targetPlayer.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(ChatColor.GOLD + "Set " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "survival" + ChatColor.GOLD + ".");
					targetPlayer.sendMessage("Your game mode has been updated");
					return true;
				}else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")){
					targetPlayer.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.GOLD + "Set " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "creative" + ChatColor.GOLD + ".");
					targetPlayer.sendMessage("Your game mode has been updated");
					return true;
				}else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")){
					targetPlayer.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(ChatColor.GOLD + "Set " + ChatColor.RESET + targetPlayer.getDisplayName() + ChatColor.GOLD + "'s gamemode to " + ChatColor.RED + "adventure" + ChatColor.GOLD + ".");
					targetPlayer.sendMessage("Your game mode has been updated");
					return true;
				}else{
					return false;
				}
			}
		}
		if(args.length >= 3){
			if(!player.hasPermission("lavahub.gamemode")){
				player.sendMessage(ChatColor.DARK_RED + "You do not have lavahub.gamemode");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Error: Too many arguments!");
				return false;
			}
		}
		return false;
	}
}
