package net.dylanhansch.lavahub.command;

import net.dylanhansch.lavahub.Lavahub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor{
    private final Lavahub plugin;
    
    public SetSpawnCommand(Lavahub plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Not executable by console!");
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 0){
            if(!player.hasPermission("lavahub.setspawn")){
                player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
                return true;
            } else {
                plugin.getConfig().set("spawn.world", player.getLocation().getWorld().getName());
                plugin.getConfig().set("spawn.x", player.getLocation().getX());
                plugin.getConfig().set("spawn.y", player.getLocation().getY());
                plugin.getConfig().set("spawn.z", player.getLocation().getZ());
                plugin.getConfig().set("spawn.yaw", player.getLocation().getYaw());
                plugin.getConfig().set("spawn.pitch", player.getLocation().getPitch());
                plugin.saveConfig();
                player.sendMessage(ChatColor.GOLD + "Spawn set.");
                return true;
            }
        }
        if(args.length >= 1){
            if(!player.hasPermission("lavahub.setspawn")){
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
