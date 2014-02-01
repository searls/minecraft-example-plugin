package io.github.searls;

import javax.inject.Inject;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GivesRandomItem {

	@Inject GathersItemMaterials gathersItemMaterials;
	@Inject ChoosesRandomElement choosesRandomElement;

	public ItemStack give() {
		Material material = choosesRandomElement.choose(gathersItemMaterials.gather());
		return new ItemStack(material);
	}

}
