package io.github.searls;

import io.github.searls.wrappers.BroadcastsMessage;

import javax.inject.Inject;

import org.bukkit.entity.Player;

public class GreetsPlayer {

	@Inject BroadcastsMessage broadcastsMessage;
	@Inject ComputesDurationSince computesDurationSince;

	public void greet(Player player) {
		long lastPlayed = player.getLastPlayed();
		if(lastPlayed == 0) {
			broadcastsMessage.broadcast("ZOMG! It's "+ player.getName()+"'s first time joining us! Welcome!");
		} else {
			Duration sinceLastPlayed = computesDurationSince.compute(lastPlayed);
			broadcastsMessage.broadcast("Welcome back, "+ player.getName()+"! It's been "+ sinceLastPlayed.number + " " + sinceLastPlayed.unitDescription() + " since you last joined us!");
		}
	}
}
