package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import io.github.searls.wrappers.QueriesPlayers;

import java.util.Arrays;
import java.util.Collection;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FiltersPlayersSeenSinceLastLoginTest {
	@InjectMocks FiltersPlayersSeenSinceLastLogin subject;

	@Mock QueriesPlayers queriesPlayers;

	@Mock Player player;
	@Mock OfflinePlayer otherPlayer1;
	@Mock OfflinePlayer otherPlayer2;
	@Mock OfflinePlayer otherPlayer3;

	@Test
	public void printsTimes() {
		when(queriesPlayers.offlinePlayers()).thenReturn(Arrays.asList(otherPlayer1, otherPlayer2, otherPlayer3));
		when(player.getLastPlayed()).thenReturn(50l);
		when(otherPlayer1.getLastPlayed()).thenReturn(100l);
		when(otherPlayer2.getLastPlayed()).thenReturn(75l);
		when(otherPlayer3.getLastPlayed()).thenReturn(25l);

		Collection<OfflinePlayer> result = subject.filter(player);

		assertTrue(result.contains(otherPlayer1));
		assertTrue(result.contains(otherPlayer2));
		assertFalse(result.contains(otherPlayer3));
	}
}
