package io.github.searls;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AttacksZeldaStyleTest {
	@InjectMocks AttacksZeldaStyle subject;

	@Mock GetsTarget getsTarget;
	@Mock IsPlayerArmed isPlayerArmed;
	@Mock IsPlayerFullHealth isPlayerFullHealth;

	@Mock Player player;
	@Mock World world;
	@Mock Location location;

	@Before public void happyPath() {
		when(isPlayerArmed.is(player)).thenReturn(true);
		when(isPlayerFullHealth.is(player)).thenReturn(true);
	}

	@Test public void attacksLightningWhenArmedAndFullHealth() {
		when(getsTarget.get(player)).thenReturn(location);

		subject.attack(player, world);

		verify(world).strikeLightning(location);
	}

	@Test public void doesNotStrikeLightningWhenUnarmed() {
		when(isPlayerArmed.is(player)).thenReturn(false);

		subject.attack(player, world);

		verify(world, never()).strikeLightning(any(Location.class));
	}

	@Test public void doesNotStrikeLightningWhenNotFullHealth() {
		when(isPlayerFullHealth.is(player)).thenReturn(false);

		subject.attack(player, world);

		verify(world, never()).strikeLightning(any(Location.class));
	}

}
