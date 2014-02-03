package io.github.searls;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class DescribesOtherCurrentlyLoggedInPlayers {

	public String describe(Player currentPlayer, World world) {
		String description = "";
		if(world.getPlayers().size() > 0) {
			description += "Other players currently online:\n";
			for(Player player : world.getPlayers()) {
				description += "  * "+player.getName() + "\n";
			}
		}
		return description;
	}

}
