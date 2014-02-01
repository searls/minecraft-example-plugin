package io.github.searls;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SendsMessage {

	public void send(Player player, ItemStack item) {
		player.sendMessage("Have a random " + item.getType());
	}

}
