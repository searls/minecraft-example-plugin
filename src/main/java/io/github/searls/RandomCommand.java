package io.github.searls;

import javax.inject.Inject;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RandomCommand {

	@Inject GivesRandomItem givesRandomItem;
	@Inject GetsTarget getsTarget;
	@Inject DropsItem dropsItem;
	@Inject SendsMessage sendsMessage;

	public void run(Player player, World world) {
		ItemStack item = givesRandomItem.give();
		Location target = getsTarget.get(player);

		dropsItem.drop(item, target, world);
		sendsMessage.send(player, item);
	}

}
