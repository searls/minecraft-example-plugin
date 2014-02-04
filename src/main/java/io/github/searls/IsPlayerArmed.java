package io.github.searls;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class IsPlayerArmed {

	private static final List<Material> WEAPONS = new ArrayList<Material>();

	static {
		WEAPONS.add(Material.WOOD_SWORD);
		WEAPONS.add(Material.STONE_SWORD);
		WEAPONS.add(Material.IRON_SWORD);
		WEAPONS.add(Material.GOLD_SWORD);
		WEAPONS.add(Material.DIAMOND_SWORD);
	}

	public boolean is(Player player) {
		return WEAPONS.contains(player.getItemInHand().getType());
	}

}
