package cn.stsniper.ch03;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.SampleData;

/**
 * The Class Part4_RefactorCode.
 * 
 * @author W.Dragon
 * @since 2016-1-9 18:56:23
 * @version 0.0.1-SNAPSHOT
 */
public class Part4_RefactorCode {
	
	
	
	@Test
	public void ex3_19() {
		List<Album> albums = Stream.of(SampleData.aLoveSupreme, SampleData.manyTrackAlbum, SampleData.sampleShortAlbum).collect(toList());
		Set<String> trackNames = new HashSet<String>();
//		Set<String> longTracks = 
//				albums.stream().<Track> flatMap(album -> album.getTrackList().stream())
//								.filter(track -> track.getLength() > 60)
//								.map(track -> track.getName())
//								.collect(toSet());
		// Ex3-22
		albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.forEach(name -> trackNames.add(name));
		
		Assert.assertTrue(CollectionUtils.isEqualCollection(trackNames, findLongTracks(albums)));
	}
	
	// The code to refactor.
//	public Set<String> findLongTracks(List<Album> albums) {
//		Set<String> trackNames = new HashSet<String>();
//		for (Album album : albums) {
//			for (Track track : album.getTrackList()) {
//				if (track.getLength() > 60) {
//					String name = track.getName();
//					trackNames.add(name);
//				}
//			}
//		}
//		return trackNames;
//	}
	
	public Set<String> findLongTracks(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTracks())
								.filter(track -> track.getLength() > 60)
								.map(track -> track.getName())
								.collect(toSet());
	}
}
