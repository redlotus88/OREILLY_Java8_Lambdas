package cn.stsniper.ch05.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class Question1.
 *
 * @author W.Dragon
 * @since 2016-1-23 20:03:40
 */
public class Question1 {
	
	@Test
	public void ex1_a() {
		List<String> collected = Stream.of("a", "b", "hello")
									   .map(String::toUpperCase)
									   .collect(Collectors.toList());
		Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
	}
	
	@Test
	public void ex1_b() {
		Stream<Integer> collected = Stream.of(1, 2, 3);
		Assert.assertEquals(6, collected.reduce(0, Integer::sum).intValue());
	}
	
	@Test
	public void ex1_c() {
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
									   .flatMap(List<Integer>::stream)
									   .collect(Collectors.toList());
		Assert.assertEquals(Arrays.asList(1,2,3,4), together);
	}
	
	
}
