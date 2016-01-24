import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.stsniper.bean.Artist;

public class Test {
	public static void main(String[] args) {
		Artist artist = createArtist(Artist::new);
		System.out.println(Stream.of(artist.getName(), artist.getNationality()).collect(Collectors.toList()));
	}
	
	public static Artist createArtist(BiFunction<String, String, Artist> biFun) {
		return biFun.apply("name", "nationality");
	}
}
