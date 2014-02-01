package io.github.searls;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RandomCommand {

	private GivesRandomItem givesRandomItem = new GivesRandomItem();
	private GetsTarget getsTarget = new GetsTarget();
	private DropsItem dropsItem = new DropsItem();
	private SendsMessage sendsMessage = new SendsMessage();

	public void run(Player player, World world) {
		ItemStack item = givesRandomItem.give();
		Location target = getsTarget.get(player);

		dropsItem.drop(item, target, world);
		sendsMessage.send(player, item);
	}

}
