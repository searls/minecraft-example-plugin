package io.github.searls;

import io.github.searls.wrappers.QueriesPlayers;

import java.util.Collection;

import javax.inject.Inject;

import org.bukkit.OfflinePlayer;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class FiltersPlayersSeenSinceLastLogin {

	@Inject QueriesPlayers queriesPlayers;

	public Collection<OfflinePlayer> filter(final OfflinePlayer currentPlayer) {
		return Collections2.filter(queriesPlayers.offlinePlayers(), new Predicate<OfflinePlayer>(){
			@Override public boolean apply(OfflinePlayer p) {
				return p.getLastPlayed() > currentPlayer.getLastPlayed();
			}
		});
	}

}
