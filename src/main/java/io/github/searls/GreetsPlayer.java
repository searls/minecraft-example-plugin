package io.github.searls;

import io.github.searls.wrappers.BroadcastsMessage;

import javax.inject.Inject;

import org.bukkit.entity.Player;

public class GreetsPlayer {

	@Inject BroadcastsMessage broadcastsMessage;
	@Inject DescribesPlayerLogin describesPlayerLogin;
	@Inject DescribesLoginsSincePlayerWasLastOnline describesLoginsSincePlayerWasLastOnline;
	@Inject DescribesOtherCurrentlyLoggedInPlayers describesOtherCurrentlyLoggedInPlayers;

	public void greet(Player player) {
		broadcastsMessage.broadcast(describesPlayerLogin.describe(player));
		broadcastsMessage.broadcast(describesLoginsSincePlayerWasLastOnline.describe(player));
		broadcastsMessage.broadcast(describesOtherCurrentlyLoggedInPlayers.describe(player, player.getWorld()));
	}


}
