package io.github.searls;

import static org.mockito.Mockito.*;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;


public class SendsMessageTest {

	private SendsMessage subject = new SendsMessage();

	@Test
	public void sendsMessageWithItemName() {
		Player player = mock(Player.class);
		ItemStack item = mock(ItemStack.class);
		when(item.getType()).thenReturn(Material.TORCH);

		subject.send(player, item);

		verify(player).sendMessage("Have a random " + Material.TORCH);
	}

}
