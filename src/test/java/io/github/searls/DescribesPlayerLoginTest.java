package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.TimeUnit;

import org.bukkit.entity.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DescribesPlayerLoginTest {
	@InjectMocks private DescribesPlayerLogin subject;

	@Mock private ComputesDurationSince computesInterestingDuration;

	@Mock private Player player;

	@Before public void before() {
		when(player.getName()).thenReturn("Steve");
	}


	@Test
	public void greetsNewUsersForTheFirstTime() {
		when(player.getLastPlayed()).thenReturn(0l);

		String result = subject.describe(player);

		assertEquals("ZOMG! It's Steve's first time joining us! Welcome!", result);
	}

	@Test
	public void broadcastsInterestingDurationForExistingUsers() {
		Duration duration = new Duration(5, TimeUnit.MINUTES);
		when(player.getLastPlayed()).thenReturn(1l);
		when(computesInterestingDuration.compute(1l)).thenReturn(duration);

		String result = subject.describe(player);

		assertEquals("Welcome back, Steve! It's been 5 minutes since you last joined us!", result);
	}


}