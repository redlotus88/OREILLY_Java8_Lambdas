package cn.stsniper.ch03;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import cn.stsniper.bean.Artist;

/**
 * The Class Part1_ExternalIteratorToInnerIterator.
 * 
 * @author W.Dragon
 * @since 2016-1-9 17:00:35
 * @version 0.0.1-SNAPSHOT
 */
public class Part1_ExternalIteratorToInnerIterator {
	
	List<Artist> allArtists;
	Artist a1 = new Artist("Tom", "London");
	Artist a2 = new Artist("Christian", "London");
	Artist a3 = new Artist("Nicolas", "France");
	Artist a4 = new Artist("Bob", "America");
	
	{
		allArtists = Stream.of(a1, a2, a3, a4)
				.collect(Collectors.toList());
	}
	
	@Test
	public void ex3_1() {
		//Before java 1.8, use for each loop. 
		//For循环使行为和方法混为一谈。
		int count = 0;
		for (Artist artist : allArtists) {
			if (artist.isFrom("London")) {
				count++;
			}
		}
		System.out.println("Ex3_1 count: " + count);
	}
	
	@Test
	public void ex3_2() {
		// Use iterator
		// Ex3-2
		int count = 0;
		Iterator<Artist> iterator = allArtists.iterator();
		while (iterator.hasNext()) {
			Artist artist = iterator.next();
			if (artist.isFrom("London")) {
				count++;
			}
		}
		System.out.println("Ex3_2 count: " + count);
	}
	
	@Test
	public void ex3_3() {
		// After Java 1.8, we use stream on collection:
		// Ex3-3
		long count = allArtists.stream()
								.filter(artist -> artist.isFrom("London"))
								.count();
		System.out.println("Ex3_3 count: " + count);
	}
	
	@Test
	public void ex3_4() {
		// 只过滤 不计数;
		allArtists.stream().filter(artist -> artist.isFrom("London"));
	}
	
	@Test
	public void ex3_5() {
		allArtists.stream()
					.filter(artist -> {
						System.out.println(artist.getName());
						return artist.isFrom("London");
					})
					.count();
	}
	
	@Test
	public void ex_3_6() {
		long count = allArtists.stream()
								.filter(artist -> {
									System.out.println(artist.getName());
									return artist.isFrom("London");
								})
								.count();
		System.out.println("Ex3_6 count: " + count);
	}
}
