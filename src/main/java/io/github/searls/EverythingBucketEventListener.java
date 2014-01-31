package io.github.searls;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EverythingBucketEventListener implements Listener {

	public EverythingBucketEventListener(EverythingBucket plugin) {}

	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		long lastPlayed = player.getLastPlayed();
		if(lastPlayed == 0) {
			Bukkit.getServer().broadcastMessage("ZOMG! It's "+ player.getName()+"'s first time joining us! Welcome!");
		} else {
			long hoursSinceLastPlayed = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - lastPlayed);
			Bukkit.getServer().broadcastMessage("Welcome back, "+ player.getName()+"! It's been "+ hoursSinceLastPlayed + " hours since you last joined us!");
		}
	}
}
