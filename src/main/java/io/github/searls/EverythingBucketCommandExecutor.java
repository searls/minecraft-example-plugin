package io.github.searls;

import javax.inject.Inject;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EverythingBucketCommandExecutor implements CommandExecutor {

	@Inject RandomCommand randomCommand;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player && command.getName().equalsIgnoreCase("random")) {
			Player player = (Player) sender;
			randomCommand.run(player, player.getWorld());
			return true;
		} else {
			return false;
		}
	}
}
