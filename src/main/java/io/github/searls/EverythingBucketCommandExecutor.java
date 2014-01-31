package io.github.searls;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EverythingBucketCommandExecutor implements CommandExecutor {

    private EverythingBucket plugin;

    public EverythingBucketCommandExecutor(EverythingBucket plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.getLogger().info("onCommand Reached in everything-bucket");

        if (command.getName().equalsIgnoreCase("command")) {
	    plugin.getLogger().info("command used");
            //do something
            return true;
        }
        return false;
    }
}
