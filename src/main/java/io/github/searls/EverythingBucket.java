package io.github.searls;

import javax.inject.Singleton;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.inject.Guice;
import com.google.inject.Injector;

@Singleton
public class EverythingBucket extends JavaPlugin {

	private EverythingBucketCommandExecutor commandExecutor;
	private EverythingBucketEventListener eventListener;

	public EverythingBucket() {
		Injector injector = Guice.createInjector();
		commandExecutor = injector.getInstance(EverythingBucketCommandExecutor.class);
		eventListener = injector.getInstance(EverythingBucketEventListener.class);
	}

	@Override
	public void onDisable() {}

	@Override
	public void onEnable() {
		getCommand("random").setExecutor(commandExecutor);
		getServer().getPluginManager().registerEvents(eventListener, this);
	}
}
