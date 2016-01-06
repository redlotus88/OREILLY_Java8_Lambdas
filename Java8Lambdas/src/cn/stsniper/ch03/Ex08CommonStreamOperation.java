package cn.stsniper.ch03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Ex08CommonStreamOperation {
	
	@Test
	public void example3_8() {
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
	public void example3_9() {
		// Ex3-9 map
		List<String> collected = new ArrayList<String>();
		collected = Stream.of("a", "b", "hello").map(str -> str.toUpperCase()).collect(Collectors.toList());
		assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
	}
	
	@Test
	public void example3_10() {
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
	public void example3_11() {
		// Functional programming style
		List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
												.filter(str -> Character.isDigit(str.charAt(0)))
												.collect(Collectors.toList());
		assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
	}
	
	@Test
	public void example3_12() {
		// Contain multiple stream
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
										.flatMap(numbers -> numbers.stream())
										.collect(Collectors.toList());
		assertEquals(Arrays.asList(1,2,3,4), together);
	}
	
	@Test
	public void example3_13() {
		List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
											new Track("Violets for Your Furs", 378),
											new Track("Time was", 451));
		Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();
		
		assertEquals(tracks.get(1), shortestTrack);
	}
}

class Track {
	private String name;
	private int length;
	
	public Track(String name, int length) {
		this.name = name;
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public String getName() {
		return name;
	}
}
