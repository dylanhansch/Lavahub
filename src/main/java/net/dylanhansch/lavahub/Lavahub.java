package net.dylanhansch.lavahub;

import net.dylanhansch.lavahub.command.ActionCommand;
import net.dylanhansch.lavahub.command.ClearInventoryCommand;
import net.dylanhansch.lavahub.command.GamemodeCommand;
import net.dylanhansch.lavahub.command.HackCommand;
import net.dylanhansch.lavahub.command.PingCommand;
import net.dylanhansch.lavahub.command.RawmsgCommand;
import net.dylanhansch.lavahub.command.SayCommand;
import net.dylanhansch.lavahub.command.TimeCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class Lavahub extends JavaPlugin {

	@Override
	public void onDisable() {
	}
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		getCommand("action").setExecutor(new ActionCommand(this));
		getCommand("clearinventory").setExecutor(new ClearInventoryCommand(this));
		getCommand("gamemode").setExecutor(new GamemodeCommand(this));
		getCommand("hack").setExecutor(new HackCommand(this));
		getCommand("ping").setExecutor(new PingCommand(this));
		getCommand("rawmsg").setExecutor(new RawmsgCommand(this));
		getCommand("say").setExecutor(new SayCommand(this));
		getCommand("time").setExecutor(new TimeCommand(this));
	}
}

