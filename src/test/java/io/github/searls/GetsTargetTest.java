package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.junit.Test;


public class GetsTargetTest {

	private GetsTarget subject = new GetsTarget();

	@Test
	public void findsTargetOnPlayer() {
		Player player = mock(Player.class);
		Location target = mock(Location.class);
		Block block = mock(Block.class);
		when(block.getLocation()).thenReturn(target);
		when(player.getTargetBlock(null, 200)).thenReturn(block);

		Location result = subject.get(player);

		assertEquals(target, result);
	}

}
