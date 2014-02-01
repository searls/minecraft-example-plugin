package io.github.searls;

import static org.mockito.Mockito.*;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RandomCommandTest {
	@InjectMocks private RandomCommand subject;

	@Mock private DropsItem dropsItem;
	@Mock private GetsTarget getsTarget;
	@Mock private GivesRandomItem givesRandomItem;
	@Mock private SendsMessage sendsMessage;

	@Test
	public void dropsItemAndSendsMessage() {
		Player player = mock(Player.class);
		World world = mock(World.class);
		ItemStack item = mock(ItemStack.class);
		Location target = mock(Location.class);
		when(givesRandomItem.give()).thenReturn(item);
		when(getsTarget.get(player)).thenReturn(target);

		subject.run(player, world);

		verify(dropsItem).drop(item, target, world);
		verify(sendsMessage).send(player, item);
	}


}
