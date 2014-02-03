package io.github.searls;

import javax.inject.Inject;

import org.bukkit.entity.Player;

public class DescribesPlayerLogin {

	@Inject ComputesDurationSince computesDurationSince;

	public String describe(Player player) {
		long lastPlayed = player.getLastPlayed();
		if(lastPlayed == 0) {
			return "ZOMG! It's "+ player.getName()+"'s first time joining us! Welcome!";
		} else {
			Duration sinceLastPlayed = computesDurationSince.compute(lastPlayed);
			return "Welcome back, "+ player.getName()+"! It's been "+ sinceLastPlayed.number + " " + sinceLastPlayed.unitDescription() + " since you last joined us!";
		}
	}

}
