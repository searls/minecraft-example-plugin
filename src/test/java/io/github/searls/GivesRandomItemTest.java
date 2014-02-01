package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GivesRandomItemTest {

	@InjectMocks private GivesRandomItem subject;

	@Mock private ChoosesRandomElement choosesRandomElement;
	@Mock private GathersItemMaterials gathersItemMaterials;

	@Test
	public void returnsRandomItem() {
		Material material = Material.APPLE;
		List<Material> materials = Arrays.asList(Material.APPLE);
		when(gathersItemMaterials.gather()).thenReturn(materials);
		when(choosesRandomElement.choose(materials)).thenReturn(material);

		ItemStack result = subject.give();

		assertEquals(material, result.getType());
	}

}
