package io.github.searls;

import org.bukkit.entity.Damageable;

public class IsPlayerFullHealth {

	public boolean is(Damageable player) {
		return Math.abs(player.getMaxHealth() - player.getHealth()) < 0.1;
	}

}
