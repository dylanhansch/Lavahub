package net.dylanhansch.lavahub;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Lavahub extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Lavahub plugin;
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled.");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been enabled.");
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
	}
	
	// Ping Command
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(commandLable.equalsIgnoreCase("ping")){
			sender.sendMessage(getConfig().getString("ping-format"));
		}else if(commandLable.equalsIgnoreCase("hack")){
			sender.sendMessage(ChatColor.GREEN + "No hacky hacky!");
		}
		return true;
	}
}
