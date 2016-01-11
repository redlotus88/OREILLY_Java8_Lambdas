package cn.stsniper.ch04.exercise;

import java.util.stream.Stream;

import cn.stsniper.bean.Artist;

/** A Performance by some musicians - e.g., an Album or Gig. */
public interface Performance {

    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
    	return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
    }
    
    default Stream<Artist> getAllMusicians(Stream<Artist> artists) {
    	return artists.flatMap(artist -> {
    		if (artist.isSolo()) {
    			return Stream.of(artist);
    		} else {
    			return getAllMusicians(artist.getMembers());
    		}
    	});
    }
}