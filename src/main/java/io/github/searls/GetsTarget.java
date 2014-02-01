package io.github.searls;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class GetsTarget {

	public Location get(Player player) {
		return player.getTargetBlock(null, 200).getLocation();
	}

}
