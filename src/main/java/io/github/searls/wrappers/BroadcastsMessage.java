package io.github.searls.wrappers;

import org.bukkit.Bukkit;

public class BroadcastsMessage {

	public void broadcast(String message) {
		Bukkit.getServer().broadcastMessage(message);
	}

}
