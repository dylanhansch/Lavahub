package net.dylanhansch.lavahub;

import java.util.logging.Logger;

import net.dylanhansch.lavahub.command.HackCommand;
import net.dylanhansch.lavahub.command.PingCommand;

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
		
		getCommand("hack").setExecutor(new HackCommand());
		getCommand("ping").setExecutor(new PingCommand());
		
	}
	
}
