package cn.stsniper.ch03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class Ex01InternalIterator {
	public static void main(String[] args) {
		Artist a1 = new Artist("Tom", "London");
		Artist a2 = new Artist("Christian", "London");
		Artist a3 = new Artist("Nicolas", "France");
		Artist a4 = new Artist("Bob", "America");
		
		List<Artist> allArtists = Stream.of(a1, a2, a3, a4)
										.collect(Collectors.toList());
		
		// Before java 1.8, use for each loop.
		// For循环使行为和方法混为一谈。
		// Ex 3-1
		int count = 0;
		for (Artist artist : allArtists) {
			if (artist.isFrom("London")) {
				count++;
			}
		}
		
		// Use iterator
		// Ex3-2
		Iterator<Artist> iterator = allArtists.iterator();
		while(iterator.hasNext()) {
			Artist artist = iterator.next();
			if (artist.isFrom("London")) {
				count++;
			}
		}
		
		// After Java 1.8, we use stream on collection:
		// Ex3-3
		long count1 = allArtists.stream()
								.filter(artist -> artist.isFrom("London"))
								.count();
		
		// Ex3-5
		allArtists.stream()
					.filter(artist -> {
						System.out.println(artist.getName());
						return artist.isFrom("London");
					})
					.count();
	}
}

class Artist {
	
	private String name;
	private String from;
	
	public Artist(String name, String from) {
		this.name = name;
		this.from = from;
	}

	public String getName() {
		return this.name;
	}
	
	public boolean isFrom(String from) {
		return StringUtils.equals(this.from, from);
	}
}
