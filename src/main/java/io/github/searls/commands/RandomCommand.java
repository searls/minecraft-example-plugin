package io.github.searls.commands;

import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RandomCommand {

	@SuppressWarnings("deprecation")
	public void run(Player player, List<String> args) {		
		Location target = player.getTargetBlock(null, 200).getLocation();		
		Material material = getRandomItemType();
		player.getWorld().dropItem(target, new ItemStack(material));
		player.sendMessage("Have a random "+ material.name());
	}	
	
	private Material getRandomItemType() {
		Material randomMaterial;
		do {
			Material[] materials = Material.values();
			randomMaterial = materials[new Random().nextInt(materials.length)];
		} while(randomMaterial.isBlock());
		return randomMaterial;
	}
	
}
