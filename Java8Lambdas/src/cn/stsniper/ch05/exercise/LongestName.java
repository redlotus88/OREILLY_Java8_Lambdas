package cn.stsniper.ch05.exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import cn.stsniper.bean.Artist;

/**
 * The Class LongestName.
 *
 * @author W.Dragon
 * @since 2016-1-23 20:27:32
 */
public class LongestName {

	private static Comparator<Artist> byNameLength = Comparator.comparing((artist) -> artist.getName().length());
	
    public static Artist byReduce(List<Artist> artists) {
//    	return artists.stream().reduce(null, (artist1, artist2) -> {
//    		if (artist1 == null) {
//    			return artist2;
//    		}
//    		return artist1.getName().length() < artist2.getName().length() ? artist2 : artist1;
//    	});
    	return artists.stream().reduce((artist1, artist2) -> {
    		return byNameLength.compare(artist1, artist2) >= 0 ? artist1 : artist2;
    	}).orElseThrow(RuntimeException::new);
    }

    public static Artist byCollecting(List<Artist> artists) {
//    	return artists.stream().collect(Collectors.reducing(
//    			(artist1, artist2) -> {
//    	    		if (artist1 == null) {
//    	    			return artist2;
//    	    		}
//    	    		return artist1.getName().length() < artist2.getName().length() ? artist2 : artist1;
//    			})).get();
    	return artists.stream().collect(Collectors.maxBy(byNameLength)).orElseThrow(RuntimeException::new);
    }

}
