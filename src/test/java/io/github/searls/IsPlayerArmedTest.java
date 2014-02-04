package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IsPlayerArmedTest {

	@InjectMocks IsPlayerArmed subject;

	@Mock Player player;
	@Mock ItemStack itemStack;

	@Before
	public void before() {
		when(player.getItemInHand()).thenReturn(itemStack);
	}

	@Test
	public void isArmedWithSwords() {
		assertTrue(isArmed(Material.WOOD_SWORD));
		assertTrue(isArmed(Material.STONE_SWORD));
		assertTrue(isArmed(Material.IRON_SWORD));
		assertTrue(isArmed(Material.GOLD_SWORD));
		assertTrue(isArmed(Material.DIAMOND_SWORD));
	}

	@Test
	public void isNotArmedWhenHoldingOtherThings() {
		assertFalse(isArmed(Material.EGG));
		assertFalse(isArmed(Material.DIAMOND_LEGGINGS));
		assertFalse(isArmed(Material.COBBLESTONE));
		assertFalse(isArmed(Material.SUGAR_CANE));
	}

	private boolean isArmed(Material m) {
		when(itemStack.getType()).thenReturn(m);
		return subject.is(player);
	}



}
