package io.github.searls;

import io.github.searls.wrappers.ListShuffler;

import java.util.List;

import javax.inject.Inject;

public class ChoosesRandomElement {

	@Inject ListShuffler listShuffler;

	public <T extends Object> T choose(List<T> items) {
		listShuffler.shuffle(items);
		return items.get(0);
	}

}
