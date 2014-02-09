package net.dylanhansch.lavahub;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	public static FileConfiguration config;
	static String mainDirectory = "plugins/Lavahub";
	public static File file = new File(mainDirectory + File.separator + "config.yml");
	public static void setup(FileConfiguration config) {
		new File(mainDirectory).mkdir();
		Config.config = config;
		if (config.get("ping-format")==null)config.set("ping-format", "Pong!");
		
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
