package io.github.searls;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class ComputesDurationSince {

	private static final List<TimeUnit> TIME_UNITS = Arrays.asList(TimeUnit.values());

	static {
		Collections.reverse(TIME_UNITS);
	}

	public Duration compute(long time) {
		for(TimeUnit unit : TIME_UNITS) {
			long number = unit.convert(System.currentTimeMillis() - time, TimeUnit.MILLISECONDS);
			if(number > 0) {
				return new Duration(number, unit);
			}
		}
		return new Duration(0, TimeUnit.NANOSECONDS);
	}

}
