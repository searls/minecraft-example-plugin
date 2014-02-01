package io.github.searls;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GivesRandomItem {

	private GathersItemMaterials gathersItemMaterials = new GathersItemMaterials();
	private ChoosesRandomElement choosesRandomElement = new ChoosesRandomElement();

	public ItemStack give() {
		Material material = choosesRandomElement.choose(gathersItemMaterials.gather());
		return new ItemStack(material);
	}

}
