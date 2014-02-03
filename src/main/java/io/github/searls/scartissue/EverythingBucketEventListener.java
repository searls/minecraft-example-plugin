package io.github.searls.scartissue;

import io.github.searls.GreetsPlayer;

import javax.inject.Inject;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EverythingBucketEventListener implements Listener {

	@Inject GreetsPlayer greetsPlayer;

	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		greetsPlayer.greet(event.getPlayer());
	}
}
