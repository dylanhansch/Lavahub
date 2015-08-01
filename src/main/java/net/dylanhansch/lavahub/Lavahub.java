package net.dylanhansch.lavahub;

import net.dylanhansch.lavahub.command.ActionCommand;
import net.dylanhansch.lavahub.command.BanCommand;
import net.dylanhansch.lavahub.command.ClearInventoryCommand;
import net.dylanhansch.lavahub.command.DelwarpCommand;
import net.dylanhansch.lavahub.command.GamemodeCommand;
import net.dylanhansch.lavahub.command.HealCommand;
import net.dylanhansch.lavahub.command.KickCommand;
import net.dylanhansch.lavahub.command.LavahubCommand;
import net.dylanhansch.lavahub.command.MuteCommand;
import net.dylanhansch.lavahub.command.PlayerCommand;
import net.dylanhansch.lavahub.command.RawmsgCommand;
import net.dylanhansch.lavahub.command.SetSpawnCommand;
import net.dylanhansch.lavahub.command.SetwarpCommand;
import net.dylanhansch.lavahub.command.SpawnCommand;
import net.dylanhansch.lavahub.command.TpCommand;
import net.dylanhansch.lavahub.command.TimeCommand;
import net.dylanhansch.lavahub.command.TphereCommand;
import net.dylanhansch.lavahub.command.UnbanCommand;
import net.dylanhansch.lavahub.command.UnmuteCommand;
import net.dylanhansch.lavahub.command.WarpCommand;
import net.dylanhansch.lavahub.command.WeatherCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Lavahub extends JavaPlugin implements Listener {
	
	@Override
	public void onDisable(){
	}
	
	@Override
	public void onEnable(){
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("action").setExecutor(new ActionCommand(this));
		getCommand("ban").setExecutor(new BanCommand(this));
		getCommand("clearinventory").setExecutor(new ClearInventoryCommand(this));
		getCommand("delwarp").setExecutor(new DelwarpCommand(this));
		getCommand("gamemode").setExecutor(new GamemodeCommand(this));
		getCommand("heal").setExecutor(new HealCommand(this));
		getCommand("kick").setExecutor(new KickCommand(this));
		getCommand("lavahub").setExecutor(new LavahubCommand(this));
		getCommand("mute").setExecutor(new MuteCommand(this));
		getCommand("player").setExecutor(new PlayerCommand(this));
		getCommand("rawmsg").setExecutor(new RawmsgCommand(this));
		getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
		getCommand("setwarp").setExecutor(new SetwarpCommand(this));
		getCommand("spawn").setExecutor(new SpawnCommand(this));
		getCommand("time").setExecutor(new TimeCommand(this));
		getCommand("teleport").setExecutor(new TpCommand(this));
		getCommand("tphere").setExecutor(new TphereCommand(this));
		getCommand("unban").setExecutor(new UnbanCommand(this));
		getCommand("unmute").setExecutor(new UnmuteCommand(this));
		getCommand("warp").setExecutor(new WarpCommand(this));
		getCommand("weather").setExecutor(new WeatherCommand(this));
	}

	public Location getSpawn(){
		return new Location(
                getServer().getWorld(getConfig().getString("spawn.world")),
                getConfig().getDouble("spawn.x"),
                getConfig().getDouble("spawn.y"),
                getConfig().getDouble("spawn.z"),
                (float) getConfig().getDouble("spawn.yaw"),
                (float) getConfig().getDouble("spawn.pitch")
            );
	}
	
	@EventHandler
	public boolean onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(this.getConfig().getBoolean("hub-features.resetpotions") == true){
			for(PotionEffect effect : player.getActivePotionEffects()){
			    player.removePotionEffect(effect.getType());
			}
		}else{
			return false;
		}
		if(this.getConfig().getBoolean("spawnonjoin") == true){
			player.teleport(getSpawn());
		}else{
			return false;
		}
		if(this.getConfig().getBoolean("hub-features.speedboost") == true){
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000000, 2));
		}else{
			return false;
		}
		if(this.getConfig().getBoolean("hub-features.jumpboost") == true){
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000000, 2));
			
		}else{
			return false;
		}
		
		return false;
	}
	
	@EventHandler
	public boolean onPlayerRespawn(PlayerRespawnEvent event){
		final Player player = event.getPlayer();
		
		event.setRespawnLocation(getSpawn());
		
        if(this.getConfig().getBoolean("hub-features.speedboost") == true){
        	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable(){

				@Override
				public void run() {
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000000, 2));
				}
        		
        	},1 );
        }else{
            return false;
        }
        if(this.getConfig().getBoolean("hub-features.jumpboost") == true){
        	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable(){

				@Override
				public void run() {
		            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000000, 2));
				}
        		
        	},1 );
        }else{
            return false;
        }
        return false;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		boolean muted = getConfig().getBoolean("players." + player.getName() + ".muted");
		
		if(muted == true){
			try{
				event.setCancelled(true);
			}catch(Exception e){
				event.setMessage(null);
			}
			player.sendMessage(ChatColor.RED + "You are muted!");
		}
	}
}
