package io.github.searls;

import java.util.concurrent.TimeUnit;

public class Duration {

	public long number;
	public TimeUnit unit;

	public Duration(long number, TimeUnit unit) {
		this.number = number;
		this.unit = unit;
	}

	public String unitDescription() {
		return unit.toString().toLowerCase();
	}

}
