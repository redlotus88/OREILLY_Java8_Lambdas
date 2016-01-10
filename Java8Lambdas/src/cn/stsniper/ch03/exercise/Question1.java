package cn.stsniper.ch03.exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.Artist;
import cn.stsniper.bean.SampleData;


/**
 * The Class Question1.
 * 
 * @author W.Dragon
 * @since 2016-1-9 20:14:53
 * @version 0.0.1-SNAPSHOT
 */
public class Question1 {
	
	@Test
	public void Ex1_a() {
		List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
		Assert.assertEquals(21, addUp(list.stream()));
	}
	
	public int addUp(Stream<Integer> numbers) {
		return numbers.reduce((acc, element) -> acc + element).get().intValue();
	}
	
	@Test
	public void Ex1_b() {
		List<String> list = getArtistsNameAndNationality(SampleData.getThreeArtists());
		list.stream().forEach(str -> System.out.println(str));
	}
	
	public List<String> getArtistsNameAndNationality(List<Artist> artists) {
		return artists.stream()
					  .map(artist -> "Name: " + artist.getName() + ", From: " + artist.getNationality())
					  .collect(Collectors.toList());
	}
	
	@Test
	public void Ex1_c() {
		List<Album> all = Stream.of(SampleData.aLoveSupreme, SampleData.manyTrackAlbum, SampleData.sampleShortAlbum)
								.collect(Collectors.toList());
		List<Album> results = getAlbumsAtMostThreeTracks(all);
		results.stream().forEach(result -> System.out.println(result));
	}
	
	public List<Album> getAlbumsAtMostThreeTracks(List<Album> albums) {
		return albums.stream()
					 .filter(album -> album.getTrackList().size() <= 3)
					 .collect(Collectors.toList());
	}
	
}
