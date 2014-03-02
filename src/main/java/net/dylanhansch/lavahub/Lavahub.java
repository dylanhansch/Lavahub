package net.dylanhansch.lavahub;

import java.util.logging.Logger;

import net.dylanhansch.lavahub.command.ActionCommand;
import net.dylanhansch.lavahub.command.ClearInventoryCommand;
import net.dylanhansch.lavahub.command.GamemodeCommand;
import net.dylanhansch.lavahub.command.HackCommand;
import net.dylanhansch.lavahub.command.PingCommand;
import net.dylanhansch.lavahub.command.RawmsgCommand;
import net.dylanhansch.lavahub.command.SayCommand;
import net.dylanhansch.lavahub.command.TimeCommand;

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
		
		Config.setup(getConfig());
		
		getCommand("action").setExecutor(new ActionCommand());
		getCommand("clearinventory").setExecutor(new ClearInventoryCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("hack").setExecutor(new HackCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("rawmsg").setExecutor(new RawmsgCommand());
		getCommand("say").setExecutor(new SayCommand());
		getCommand("time").setExecutor(new TimeCommand());
	}
	
}
