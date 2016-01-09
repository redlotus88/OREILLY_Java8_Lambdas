package cn.stsniper.ch03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import cn.stsniper.bean.Track;

/**
 * The Class Part3_CommonStreamOperation.
 * 
 * @author W.Dragon
 * @since 2016-1-9 18:06:06
 * @version 0.0.1-SNAPSHOT
 */
public class Part3_CommonStreamOperation {
	
	@Test
	public void ex3_8() {
		// Ex3-8 collect
		List<String> collected = Stream.of("a", "b", "c")
										.collect(Collectors.toList());
		assertEquals(Arrays.asList("a", "b", "c"), collected);
		
		collected = new ArrayList<String>();
		for (String string : Arrays.asList("a", "b", "hello")) {
			String uppercaseString = string.toUpperCase();
			collected.add(uppercaseString);
		}
		assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
	}
	
	@Test
	public void ex3_9() {
		// Ex3-9 map
		List<String> collected = new ArrayList<String>();
		collected = Stream.of("a", "b", "hello").map(str -> str.toUpperCase()).collect(Collectors.toList());
		assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
	}
	
	@Test
	public void ex3_10() {
		// Iterator condition.
		List<String> beginningWithNumbers = new ArrayList<String>();
		for (String value : Arrays.asList("a", "1abc", "abc1")) {
			if (Character.isDigit(value.charAt(0))) {
				beginningWithNumbers.add(value);
			}
		}
		
		assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
	}
	
	@Test
	public void ex3_11() {
		// Functional programming style
		List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
												.filter(str -> Character.isDigit(str.charAt(0)))
												.collect(Collectors.toList());
		assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
	}
	
	@Test
	public void ex3_12() {
		// Contain multiple stream
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
										.flatMap(numbers -> numbers.stream())
										.collect(Collectors.toList());
		assertEquals(Arrays.asList(1,2,3,4), together);
	}
	
	@Test
	public void ex3_13() {
		List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
											new Track("Violets for Your Furs", 378),
											new Track("Time was", 451));
		Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();
		
		assertEquals(tracks.get(1), shortestTrack);
	}
	
	@Test
	public void ex3_14() {
		// Common Pattern.
		List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
											new Track("Violets for Your Furs", 378),
											new Track("Time Was", 451));
		Track shortestTrack = tracks.get(0);
		for (Track track : tracks) {
			if (track.getLength() < shortestTrack.getLength()) {
				shortestTrack = track;
			}
		}

		Assert.assertEquals(tracks.get(1), shortestTrack);
	}
	
	@Test
	public void ex3_15() {
		//Reduce 模式
//		Object accumulator = initialValue;
//		for (Object element : collection) {
//			accumulator = combine(accumulator, element);
//		}
	}
	
	@Test
	public void ex3_16() {
		//实际工作环境中，不应使用这样的方式来求和。参考IntSummaryStatistics, ex4-4
		int count = Stream.of(1, 2, 3)
						.reduce(0, (acc, element) -> acc + element);
		Assert.assertEquals(6, count);
	}
	
	@Test
	public void ex3_17() {
		//ex3_16中reduce操作的展开：
		BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
		int count = accumulator.apply(
				accumulator.apply(
						accumulator.apply(0, 1), 
						2), 
				3);
	}
	
	@Test
	public void ex3_18() {
		// 使用命令式编程方式求和
		int acc = 0;
		for (Integer element : Arrays.asList(1, 2, 3)) {
			acc = acc + element;
		}
		Assert.assertEquals(6, acc);
	}
}
