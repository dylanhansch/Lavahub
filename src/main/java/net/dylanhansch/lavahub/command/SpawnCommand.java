package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor{
    private final Lavahub plugin;

    public SpawnCommand(Lavahub plugin) { // this is a constructor that takes one parameter
    	this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Not executable by console!");
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 0){
            if(!player.hasPermission("lavahub.spawn")){
                player.sendMessage(ChatColor.DARK_RED + "No permission.");
                return true;
            } else {
                player.teleport(plugin.getSpawn());
                player.sendMessage(ChatColor.GOLD + "Teleporting..");
                return true;
            }
        }
        Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
        if(args.length == 1){
            if(!player.hasPermission("lavahub.spawn")){
                player.sendMessage(ChatColor.DARK_RED + "No permission.");
                return true;
            } else {
                targetPlayer.teleport(plugin.getSpawn());
                targetPlayer.sendMessage(ChatColor.GOLD + "You got teleported to spawn by " + ChatColor.RESET +  player.getDisplayName());
                return true;
            }
            
        }
        if(args.length >= 2){
            if(!player.hasPermission("lavahub.spawn")){
                player.sendMessage(ChatColor.DARK_RED + "No permission.");
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments!");
                return true;
            }
        }
        return false;
    }
}