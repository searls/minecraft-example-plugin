package io.github.searls;

import static org.mockito.Mockito.*;
import io.github.searls.wrappers.BroadcastsMessage;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GreetsPlayerTest {
	@InjectMocks private GreetsPlayer subject;

	@Mock BroadcastsMessage broadcastsMessage;
	@Mock DescribesPlayerLogin describesPlayerLogin;
	@Mock DescribesLoginsSincePlayerWasLastOnline describesLoginsSincePlayerWasLastOnline;
	@Mock DescribesOtherCurrentlyLoggedInPlayers describesOtherCurrentlyLoggedInPlayers;

	@Mock Player player;
	@Mock World world;

	@Test
	public void describesStuff() {
		when(player.getWorld()).thenReturn(world);
		when(describesPlayerLogin.describe(player)).thenReturn("FOO");
		when(describesLoginsSincePlayerWasLastOnline.describe(player)).thenReturn("BAR");
		when(describesOtherCurrentlyLoggedInPlayers.describe(player, world)).thenReturn("BAZ");

		subject.greet(player);

		verify(broadcastsMessage).broadcast("FOO");
		verify(broadcastsMessage).broadcast("BAR");
		verify(broadcastsMessage).broadcast("BAZ");
	}
}
