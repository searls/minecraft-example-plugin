package io.github.searls;

import static org.mockito.Mockito.*;
import io.github.searls.wrappers.BroadcastsMessage;

import java.util.concurrent.TimeUnit;

import org.bukkit.entity.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GreetsPlayerTest {
	@InjectMocks private GreetsPlayer subject;

	@Mock private BroadcastsMessage broadcastsMessage;
	@Mock private ComputesDurationSince computesInterestingDuration;

	@Mock private Player player;

	@Before public void before() {
		when(player.getName()).thenReturn("Steve");
	}

	@Test
	public void greetsNewUsersForTheFirstTime() {
		when(player.getLastPlayed()).thenReturn(0l);

		subject.greet(player);

		verify(broadcastsMessage).broadcast("ZOMG! It's Steve's first time joining us! Welcome!");
	}

	@Test
	public void broadcastsInterestingDurationForExistingUsers() {
		Duration duration = new Duration(5, TimeUnit.MINUTES);
		when(player.getLastPlayed()).thenReturn(1l);
		when(computesInterestingDuration.compute(1l)).thenReturn(duration);

		subject.greet(player);

		verify(broadcastsMessage).broadcast("Welcome back, Steve! It's been 5 minutes since you last joined us!");
	}

}
