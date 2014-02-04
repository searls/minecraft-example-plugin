package io.github.searls.scartissue;

import io.github.searls.GreetsPlayer;
import io.github.searls.AttacksZeldaStyle;

import javax.inject.Inject;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EverythingBucketEventListener implements Listener {

	@Inject GreetsPlayer greetsPlayer;
	@Inject AttacksZeldaStyle attacksZeldaStyle;

	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		greetsPlayer.greet(event.getPlayer());
	}

	@EventHandler
	public void strikeLightningWhenSwingingSword(PlayerAnimationEvent event) {
		attacksZeldaStyle.attack(event.getPlayer(), event.getPlayer().getWorld());
	}


}
