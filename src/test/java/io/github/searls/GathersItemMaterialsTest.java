package io.github.searls;

import static org.junit.Assert.*;

import java.util.List;

import org.bukkit.Material;
import org.junit.Test;


public class GathersItemMaterialsTest {

	private GathersItemMaterials subject = new GathersItemMaterials();

	@Test
	public void getsNonBlockMaterials() {

		List<Material> result = subject.gather();

		assertFalse(result.contains(Material.COBBLESTONE));
		assertTrue(result.contains(Material.BAKED_POTATO));
	}

}
