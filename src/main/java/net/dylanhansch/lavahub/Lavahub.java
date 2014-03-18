package net.dylanhansch.lavahub;

import net.dylanhansch.lavahub.command.RawmsgCommand;
import net.dylanhansch.lavahub.command.SayCommand;
import net.dylanhansch.lavahub.command.SetSpawnCommand;
import net.dylanhansch.lavahub.command.SpawnCommand;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class Lavahub extends JavaPlugin {

	@Override
	public void onDisable() {
	}
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		getCommand("rawmsg").setExecutor(new RawmsgCommand(this));
		getCommand("say").setExecutor(new SayCommand(this));
		getCommand("spawn").setExecutor(new SpawnCommand(this));
		getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
	}

	public Location getSpawn() {
		return new Location(
                getServer().getWorld(getConfig().getString("spawn.world")),
                getConfig().getDouble("spawn.x"),
                getConfig().getDouble("spawn.y"),
                getConfig().getDouble("spawn.z"),
                (float) getConfig().getDouble("spawn.yaw"),
                (float) getConfig().getDouble("spawn.pitch")
            );
	}

}

