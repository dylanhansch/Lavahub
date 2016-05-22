package net.dylanhansch.lavahub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.dylanhansch.lavahub.command.*;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Lavahub extends JavaPlugin implements Listener {
	
	public final HashMap<String, ArrayList<Block>> deafenedPlayers = new HashMap<>();
	
	// Error messages
	public final String NO_PERMISSIONS_MSG = ChatColor.DARK_RED + "You do not have permission to execute this command.";
	public final String TOO_MANY_ARGS = ChatColor.RED + "Too many arguments!";
	public final String NOT_ENOUGH_ARGS = ChatColor.RED + "Not enough arguments!";
	
	@Override
	public void onDisable(){
	}
	
	@Override
	public void onEnable(){
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("action").setExecutor(new ActionCommand(this));
		getCommand("clearchat").setExecutor(new ClearChatCommand(this));
		getCommand("deafen").setExecutor(new DeafCommand(this));
		getCommand("lavahub").setExecutor(new LavahubCommand(this));
		getCommand("mute").setExecutor(new MuteCommand(this));
		getCommand("rawmsg").setExecutor(new RawmsgCommand(this));
		getCommand("undeafen").setExecutor(new UndeafCommand(this));
		getCommand("unmute").setExecutor(new UnmuteCommand(this));
	}
	
	@EventHandler
	public boolean onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
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
	}
}
