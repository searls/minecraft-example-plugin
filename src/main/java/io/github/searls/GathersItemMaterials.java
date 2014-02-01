package io.github.searls;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class GathersItemMaterials {

	public List<Material> gather() {
		List<Material> items = new ArrayList<Material>();
		for(Material material : Material.values()) {
			if(!material.isBlock()) {
				items.add(material);
			}
		}
		return items;
	}

}
