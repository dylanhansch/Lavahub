package net.dylanhansch.lavahub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.dylanhansch.lavahub.command.ActionCommand;
import net.dylanhansch.lavahub.command.BanCommand;
import net.dylanhansch.lavahub.command.ClearChatCommand;
import net.dylanhansch.lavahub.command.ClearInventoryCommand;
import net.dylanhansch.lavahub.command.DeafCommand;
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
import net.dylanhansch.lavahub.command.StatsCommand;
import net.dylanhansch.lavahub.command.TpCommand;
import net.dylanhansch.lavahub.command.TimeCommand;
import net.dylanhansch.lavahub.command.TphereCommand;
import net.dylanhansch.lavahub.command.UnbanCommand;
import net.dylanhansch.lavahub.command.UndeafCommand;
import net.dylanhansch.lavahub.command.UnmuteCommand;
import net.dylanhansch.lavahub.command.WarpCommand;
import net.dylanhansch.lavahub.command.WeatherCommand;
import net.dylanhansch.lavahub.utility.GetTPS;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Lavahub extends JavaPlugin implements Listener {
	
	public final HashMap<String, ArrayList<Block>> deafenedPlayers = new HashMap<>();
	
	// Error messages
	public final String NO_PERMISSIONS_MSG = ChatColor.DARK_RED + "You do not have permission to execute this command.";
	public final String TOO_MANY_ARGS = ChatColor.RED + "Too many arguments!";
	public final String NOT_ENOUGH_ARGS = ChatColor.RED + "Not enough arguments!";
	
	// Variables for StatsCommand
	public double totalMemory, allocatedMemory, usedMemory, freeMemory;
	private long uptime;
	
	@Override
	public void onDisable(){
	}
	
	@Override
	public void onEnable(){
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("action").setExecutor(new ActionCommand(this));
		getCommand("ban").setExecutor(new BanCommand(this));
		getCommand("clearchat").setExecutor(new ClearChatCommand(this));
		getCommand("clearinventory").setExecutor(new ClearInventoryCommand(this));
		getCommand("deafen").setExecutor(new DeafCommand(this));
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
		getCommand("stats").setExecutor(new StatsCommand(this));
		getCommand("time").setExecutor(new TimeCommand(this));
		getCommand("teleport").setExecutor(new TpCommand(this));
		getCommand("tphere").setExecutor(new TphereCommand(this));
		getCommand("unban").setExecutor(new UnbanCommand(this));
		getCommand("undeafen").setExecutor(new UndeafCommand(this));
		getCommand("unmute").setExecutor(new UnmuteCommand(this));
		getCommand("warp").setExecutor(new WarpCommand(this));
		getCommand("weather").setExecutor(new WeatherCommand(this));
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new GetTPS(), 100L, 1L);
		uptime = System.currentTimeMillis();
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
		
		if(this.getConfig().getBoolean("players." + player.getName() + ".deafened") == true){
			if(!deafenedPlayers.containsKey(player.getName())){
				this.deafenedPlayers.put(player.getName(), null);
			}
		}
		
		return false;
	}
	
	@EventHandler
	public boolean onPlayerLogin(PlayerLoginEvent event){
		Player player = event.getPlayer();
		boolean banned = getConfig().getBoolean("players." + player.getName() + ".banned");
		String banreason = getConfig().getString("players." + player.getName() + ".banreason");
		
		if(banned == true){
			//event.getPlayer().kickPlayer(ChatColor.DARK_RED + "Banned: " + ChatColor.RESET + banreason);
			event.disallow(null, ChatColor.RED + "Banned: " + ChatColor.RESET + banreason + "\n" + "Appeal to dylan@dylanhansch.net");
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
		
		// Don't allow muted players to send messages
		if(muted == true){
			try{
				event.setCancelled(true);
			}catch(Exception e){
				event.setMessage(null);
			}
			player.sendMessage(ChatColor.RED + "You are muted!");
		}
		
		// Don't send to deaf players
		List<Player> plrs = new ArrayList<Player>();
		for(Player plr : getServer().getOnlinePlayers()){
			if(deafenedPlayers.containsKey(plr.getName())){
				plrs.add(plr);
			}
		}
		for(Player plr : plrs){
			event.getRecipients().remove(plr);
		}
		
		// Colorize text
		if(event.getPlayer().hasPermission("lavahub.color")){
			String colorizedMessage = event.getMessage().replaceAll("&([0-9a-fl-oA-FL-O])", ChatColor.COLOR_CHAR + "$1");
			event.setMessage(colorizedMessage);
		}
	}
	
	public int[] getCurrentServerUptime(){
		final int[] i = new int[4];
		long l = System.currentTimeMillis() - this.uptime;
		i[3] = (int)(l / 86400000L);
		l -= i[3] * 86400000L;
		i[2] = (int)(l / 3600000L);
		l -= i[2] * 3600000;
		i[1] = (int)(l / 60000L);
		l -= i[1] * 60000L;
		i[0] = (int)(l / 1000L);
		return i;
	}
	
	public synchronized void updateMemoryStats(){
		totalMemory = Runtime.getRuntime().maxMemory() / 1048576D;
		allocatedMemory = Runtime.getRuntime().totalMemory() / 1048576D;
		usedMemory = totalMemory - (Runtime.getRuntime().freeMemory() / 1048576D);
		freeMemory = allocatedMemory - usedMemory;
	}
}
