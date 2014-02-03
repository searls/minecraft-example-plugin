package io.github.searls.wrappers;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class QueriesPlayers {

	public List<OfflinePlayer> offlinePlayers() {
		return Arrays.asList(Bukkit.getServer().getOfflinePlayers());
	}

}
