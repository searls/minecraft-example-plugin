package io.github.searls;

import io.github.searls.wrappers.ListShuffler;

import java.util.List;

public class ChoosesRandomElement {

	private ListShuffler listShuffler = new ListShuffler();

	public <T extends Object> T choose(List<T> items) {
		listShuffler.shuffle(items);
		return items.get(0);
	}

}
