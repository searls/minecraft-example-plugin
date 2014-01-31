package io.github.searls;

import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class EverythingBucketEventListener implements Listener {

	private EverythingBucket plugin;

	public EverythingBucketEventListener(EverythingBucket plugin) {
		this.plugin = plugin;
	}

	// This is just one possible event you can hook.
	// See http://jd.bukkit.org/apidocs/ for a full event list.

	// All event handlers must be marked with the @EventHandler annotation 
	// The method name does not matter, only the type of the event parameter
	// is used to distinguish what is handled.

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Bukkit.getServer().broadcastMessage("Mr. " + event.getPlayer().getName() + " placed " + event.getBlock().getType() + " at " + event.getBlock().getLocation());
	}
}
