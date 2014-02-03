package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DescribesOtherCurrentlyLoggedInPlayersTest {

	@InjectMocks private DescribesOtherCurrentlyLoggedInPlayers subject;

	@Mock World world;
	@Mock Player realPlayer;
	@Mock Player otherPlayer;

	@Test
	public void shouldListThem() {
		when(world.getPlayers()).thenReturn(Arrays.asList(otherPlayer));
		when(otherPlayer.getName()).thenReturn("FOO");

		String result = subject.describe(realPlayer, world);

		assertEquals(
				"Other players currently online:\n"+
						"  * FOO\n"
						, result);
	}

	@Test
	public void noUsersNoList() {
		when(world.getPlayers()).thenReturn(new ArrayList<Player>());

		String result = subject.describe(realPlayer, world);

		assertEquals("", result);
	}

}
