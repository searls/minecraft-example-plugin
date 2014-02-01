package io.github.searls;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class DropsItem {

	public void drop(ItemStack item, Location location, World world) {
		world.dropItem(location, item);
	}

}
