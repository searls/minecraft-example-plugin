package io.github.searls;

import static org.mockito.Mockito.*;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;



public class DropsItemTest {

	private DropsItem subject = new DropsItem();

	@Test
	public void dropsTheItemAtALocation() {
		ItemStack item = mock(ItemStack.class);
		Location location = mock(Location.class);
		World world = mock(World.class);

		subject.drop(item, location, world);

		verify(world).dropItem(location, item);
	}

}
