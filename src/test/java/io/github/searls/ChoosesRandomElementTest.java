package io.github.searls;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import io.github.searls.wrappers.ListShuffler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class ChoosesRandomElementTest {

	@InjectMocks private ChoosesRandomElement subject = new ChoosesRandomElement();

	@Mock private ListShuffler listShuffler;

	@Test
	public void choosesRandomElement() {
		final List<String> list = new ArrayList<String>();
		list.add("not random");
		doAnswer(new Answer<Object>() {
			@Override public Object answer(InvocationOnMock invocation) throws Throwable {
				list.clear();
				list.add("random");
				return null;
			}}).when(listShuffler).shuffle(list);

		subject.choose(list);

		assertEquals("random", list.get(0));
	}
}
