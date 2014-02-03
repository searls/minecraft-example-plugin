package io.github.searls;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;


public class ComputesDurationSinceTest {

	private ComputesDurationSince subject = new ComputesDurationSince();

	@Test
	public void givesDaysWhenDaysHavePassed() {
		long threeDays = 1000 * 60 * 60 * 24 * 3;

		Duration duration = subject.compute(System.currentTimeMillis() - threeDays);

		assertEquals(3, duration.number);
		assertEquals(TimeUnit.DAYS, duration.unit);
		assertEquals("days", duration.unitDescription());
	}

	@Test
	public void givesHoursWhenDaysHaveNotPassed() {
		long twentyThreeHours = 1000 * 60 * 60 * 23;

		Duration duration = subject.compute(System.currentTimeMillis() - twentyThreeHours);

		assertEquals(23, duration.number);
		assertEquals(TimeUnit.HOURS, duration.unit);
		assertEquals("hours", duration.unitDescription());
	}

	@Test
	public void givesZeroNanoSecondsInWorstCase() {
		long futureTimes = System.currentTimeMillis() + 1000;

		Duration duration = subject.compute(futureTimes);

		assertEquals(0, duration.number);
		assertEquals(TimeUnit.NANOSECONDS, duration.unit);
		assertEquals("nanoseconds", duration.unitDescription());
	}

}
