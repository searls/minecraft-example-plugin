package io.github.searls;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EverythingBucketCommandExecutor implements CommandExecutor {

	public EverythingBucketCommandExecutor(EverythingBucket plugin) {}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player && command.getName().equalsIgnoreCase("random")) {
			Player player = (Player) sender;
			Location target = player.getTargetBlock(null, 200).getLocation();

			Material randomMaterial;
			do {
				Material[] materials = Material.values();
				randomMaterial = materials[new Random().nextInt(materials.length)];
			} while(randomMaterial.isBlock());

			player.getWorld().dropItem(target, new ItemStack(randomMaterial));
			player.sendMessage("Have a random "+ randomMaterial.name());
			return true;
		} else {
			return false;
		}
	}
}
