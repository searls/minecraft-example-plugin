package io.github.searls;

import java.util.Collection;

import javax.inject.Inject;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;


public class DescribesLoginsSincePlayerWasLastOnline {

	@Inject ComputesDurationSince computesDurationSince;
	@Inject FiltersPlayersSeenSinceLastLogin filtersPlayersSeenSinceLastLogin;

	public String describe(Player realPlayer) {
		String description = "";
		Collection<OfflinePlayer> players = filtersPlayersSeenSinceLastLogin.filter(realPlayer);
		if(players.size() > 0) {
			description += "Players logged in since you last logged out:\n";
			for(OfflinePlayer player : players) {
				Duration lastSeen = computesDurationSince.compute(player.getLastPlayed());
				description += "  * " + player.getName() + " (last seen "+lastSeen.number+" "+lastSeen.unitDescription()+" ago)\n";
			}
		}
		return description;
	}

}
