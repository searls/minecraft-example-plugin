package io.github.searls;

import javax.inject.Inject;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class AttacksZeldaStyle {

	@Inject GetsTarget getsTarget;
	@Inject IsPlayerArmed isPlayerArmed;
	@Inject IsPlayerFullHealth isPlayerFullHealth;

	public void attack(Player player, World world) {
		if(isPlayerArmed.is(player) && isPlayerFullHealth.is(player)) {
			world.strikeLightning(getsTarget.get(player));
		}
	}

}
