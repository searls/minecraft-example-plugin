package io.github.searls;

import org.bukkit.plugin.java.JavaPlugin;

public class EverythingBucket extends JavaPlugin {

	private EverythingBucketCommandExecutor commandExecutor = new EverythingBucketCommandExecutor(this);
	private EverythingBucketEventListener eventListener = new EverythingBucketEventListener(this);

	@Override
	public void onDisable() {}

	@Override
	public void onEnable() {
		getCommand("random").setExecutor(commandExecutor);
		getServer().getPluginManager().registerEvents(eventListener, this);
	}
}
