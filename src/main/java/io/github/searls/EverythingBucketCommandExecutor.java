package io.github.searls;

import io.github.searls.commands.RandomCommand;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EverythingBucketCommandExecutor implements CommandExecutor {

	public EverythingBucketCommandExecutor(EverythingBucket plugin) {}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player && command.getName().equalsIgnoreCase("random")) {
			new RandomCommand().run((Player) sender, Arrays.asList(args));
			return true;
		} else {
			return false;
		}
	}
}
