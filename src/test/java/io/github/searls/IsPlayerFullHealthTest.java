package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.bukkit.entity.Damageable;
import org.junit.Test;

public class IsPlayerFullHealthTest {

	IsPlayerFullHealth subject = new IsPlayerFullHealth();

	Damageable player = mock(Damageable.class);

	@Test
	public void fullWhenHealthEqualsMax() {
		when(player.getHealth()).thenReturn(4.0);
		when(player.getMaxHealth()).thenReturn(4.00000001);

		boolean result = subject.is(player);

		assertTrue(result);
	}

	@Test
	public void notFullWhenHealthLessThanMax() {
		when(player.getHealth()).thenReturn(4.0);
		when(player.getMaxHealth()).thenReturn(5d);

		boolean result = subject.is(player);

		assertFalse(result);
	}

}
