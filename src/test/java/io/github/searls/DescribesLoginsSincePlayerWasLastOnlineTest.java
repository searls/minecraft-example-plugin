package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DescribesLoginsSincePlayerWasLastOnlineTest {
	@InjectMocks DescribesLoginsSincePlayerWasLastOnline subject;

	@Mock ComputesDurationSince computesDurationSince;
	@Mock FiltersPlayersSeenSinceLastLogin filtersPlayersSeenSinceLastLogin;

	@Mock Player player;
	@Mock OfflinePlayer otherPlayer1;
	@Mock OfflinePlayer otherPlayer2;

	@Test
	public void printsTimes() {
		when(filtersPlayersSeenSinceLastLogin.filter(player)).thenReturn(Arrays.asList(otherPlayer1, otherPlayer2));
		when(otherPlayer1.getName()).thenReturn("Alice");
		when(otherPlayer1.getLastPlayed()).thenReturn(100l);
		when(otherPlayer2.getName()).thenReturn("Bob");
		when(otherPlayer2.getLastPlayed()).thenReturn(75l);
		when(computesDurationSince.compute(100l)).thenReturn(new Duration(2, TimeUnit.DAYS));
		when(computesDurationSince.compute(75l)).thenReturn(new Duration(3, TimeUnit.HOURS));

		String result = subject.describe(player);

		assertEquals(
				"Players logged in since you last logged out:\n" +
						"  * Alice (last seen 2 days ago)\n" +
						"  * Bob (last seen 3 hours ago)\n"
						, result);

	}

	@Test
	public void noUsersNoTimes() {
		when(filtersPlayersSeenSinceLastLogin.filter(player)).thenReturn(new ArrayList<OfflinePlayer>());

		String result = subject.describe(player);

		assertEquals("", result);
	}
}
