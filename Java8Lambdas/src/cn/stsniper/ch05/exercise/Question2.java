package cn.stsniper.ch05.exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import cn.stsniper.bean.Artist;


/**
 * The Class Question2.
 *
 * @author W.Dragon
 * @since 2016-1-23 20:28:26
 */
public class Question2 {
	
	@Test
	public void ex2_a() {
		Stream<String> names = Stream.of("John Lennon", "Paul Sutcliffe", "George Harrison",
				"Ringo Starr", "Pete Best", "Stuart Sutcliffe");
		
		List<Artist> artists = createArtistByName(names);
		
		Assert.assertEquals("Stuart Sutcliffe", LongestName.byReduce(artists).getName());
		Assert.assertEquals("Stuart Sutcliffe", LongestName.byCollecting(artists).getName());
	}
	
	@Test
	public void ex2_b() {
		Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
		
		Map<String, Long> counts = WordCount.countWords(names);
		String result = counts.keySet().stream()
								.sorted(Comparator.comparing((key) -> counts.get(key)).reversed())
								.map((key) -> key + " -> " + counts.get(key))
								.collect(Collectors.joining(", ", "[", "]"));
		Assert.assertEquals("[John -> 3, Paul -> 2, George -> 1]", result);
	}
	
	@Test
	public void ex2_c() {
		Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
		
		Map<String, List<String>> result = names.collect(new GroupingBy<String, String>(String::toString));
		Map<String, Integer> numbers = result.keySet().stream()
													  .collect(Collectors.toMap(String::toString, (str) -> result.get(str).size()));
		Assert.assertEquals(3, result.get("John").size());
		Assert.assertEquals(3, numbers.get("John").intValue());
	}
	
	private static List<Artist> createArtistByName(Stream<String> names) {
		return names.map(name -> new Artist(name, "")).collect(Collectors.toList());
	}
}
