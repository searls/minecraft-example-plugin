package io.github.searls;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EverythingBucketCommandExecutor implements CommandExecutor {

	public EverythingBucketCommandExecutor(EverythingBucket plugin) {}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player && command.getName().equalsIgnoreCase("random")) {
			Player player = (Player) sender;
			new RandomCommand().run(player, player.getWorld());
			return true;
		} else {
			return false;
		}
	}
}
