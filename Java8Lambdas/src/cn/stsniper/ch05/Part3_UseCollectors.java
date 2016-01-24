package cn.stsniper.ch05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.Artist;
import cn.stsniper.bean.SampleData;

/**
 * The Class Part3_UseCollectors.
 *
 * @author W.Dragon
 * @since 2016-1-13 21:32:26
 */
public class Part3_UseCollectors {

	@Test
	public void ex5_5() {
		// 使用toCollection, 用定制的集合收集元素
		Stream<String> stream = Stream.of("test1", "test2");
		TreeSet<String> result = stream.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(result);
	}
	
	@Test
	public void ex5_6() {
		// 找出成员最多的乐队
		Assert.assertEquals(SampleData.theBeatles, biggestGroup(SampleData.threeArtists()).get());
	}
	
	public Optional<Artist> biggestGroup(Stream<Artist> artists) {
		Function<Artist, Long> getCount = artist -> artist.getMembers().count();
		return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
	}
	
	@Test
	public void ex5_7() {
		// 找出一组专辑上曲目的平均数
		Assert.assertEquals(1.5d, averageNumberOfTracks(Arrays.asList(SampleData.aLoveSupreme, 
				SampleData.sampleShortAlbum)), 0.0d);
	}
	
	public double averageNumberOfTracks(List<Album> albums) {
		return albums.stream().collect(Collectors.<Album> averagingInt(album -> album.getTrackList().size()));
	}
	
	@Test
	public void ex5_8() {
		// 数据分块
		Map<Boolean, List<Artist>> parts = bandsAndSolo(SampleData.threeArtists());
		Assert.assertEquals(2, parts.get(Boolean.TRUE).size());
		Assert.assertEquals(1, parts.get(Boolean.FALSE).size());
	}
	
	public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
		// ex5_9
		return artists.collect(Collectors.<Artist> partitioningBy(Artist::isSolo));
	}
	
	@Test
	public void ex5_10() {
		// 数据分组
		Map<Artist, List<Album>> groupParts = albumsByArtist(SampleData.albums);
		Assert.assertNotNull(groupParts.get(SampleData.johnColtrane));
	}
	
	public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(album -> album.getMainMusician()));
	}
	
	@Test
	public void ex5_12() {
		// 字符串
		String result = SampleData.getThreeArtists().stream()
													.map(Artist::getName)
													.collect(Collectors.joining(",", "[", "]"));
		Assert.assertEquals("[John Coltrane,John Lennon,The Beatles]", result);
	}
	
	@Test
	public void ex5_14() {
		// 使用收集器计算每个艺术家的专辑数
		Map<Artist, Long> albums = numberOfAlbums(Stream.of(SampleData.aLoveSupreme, 
				SampleData.manyTrackAlbum, SampleData.sampleShortAlbum));
		Assert.assertEquals(new Long(3), albums.get(SampleData.johnColtrane));
	}
	
	public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(album -> album.getMainMusician(), Collectors.counting()));
	}
	
	@Test
	public void ex5_16() {
		// 使用收集器求每个艺术家的专辑名
		Map<Artist, List<String>> nameAlbums = nameOfAlbums(Stream.of(SampleData.aLoveSupreme, 
				SampleData.manyTrackAlbum, SampleData.sampleShortAlbum));
		Assert.assertEquals(3, nameAlbums.get(SampleData.johnColtrane).size());
	}
	
	public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(Album::getMainMusician, 
				Collectors.mapping(Album::getName, Collectors.toList())));
	}
	
	@Test
	public void ex5_17() {
		// 使用for循环和StringBuilder格式化艺术家姓名
		List<Artist> artists = SampleData.getThreeArtists();
		StringBuilder builder = new StringBuilder("[");
		for (Artist artist : artists) {
			if (builder.length() > 1) {
				builder.append(", ");
			}
			String name = artist.getName();
			builder.append(name);
		}
		builder.append("]");
		String result = builder.toString();
		Assert.assertEquals("[John Coltrane, John Lennon, The Beatles]", result);
	}
	
	@Test
	public void ex5_18() {
		// 使用forEach和StringBuilder格式化艺术家的姓名
		List<Artist> artists = SampleData.getThreeArtists();
		StringBuilder builder = new StringBuilder("[");
		artists.stream().map(Artist::getName)
						.forEach(name -> {
							if (builder.length() > 1) {
								builder.append(", ");
							}
							builder.append(name);
						});
		builder.append("]");
		String result = builder.toString();
		Assert.assertEquals("[John Coltrane, John Lennon, The Beatles]", result);
	}
	
	@Test
	public void ex5_19() {
		// 不要以为使用了reduce就能使代码更清晰。
		List<Artist> artists = SampleData.getThreeArtists();
		StringBuilder reduced = 
				artists.stream().map(Artist::getName)
								.reduce(new StringBuilder(), (builder, name) -> {
									if (builder.length() > 0) 
										builder.append(", ");
									
									builder.append(name);
									return builder;
								}, (left, right) -> left.append(right));
		reduced.insert(0, "[");
		reduced.append("]");
		String result = reduced.toString();
		Assert.assertEquals("[John Coltrane, John Lennon, The Beatles]", result);
	}
	
	@Test
	public void ex5_20() {
		// 使用reduce和StringCombiner类格式化艺术家姓名
		List<Artist> artists = SampleData.getThreeArtists();
		StringCombiner combined = artists.stream().map(Artist::getName)
												  .reduce(new StringCombiner(", ", "[", "]"), 
														  StringCombiner::add,
														  StringCombiner::merge);
		String result = combined.toString();
		Assert.assertEquals("[John Coltrane, John Lennon, The Beatles]", result);
	}
	
	@Test
	public void ex5_24() {
		List<Artist> artists = SampleData.getThreeArtists();
		String result = artists.stream().map(Artist::getName).collect(new StringCollector(", ", "[", "]"));
		Assert.assertEquals("[John Coltrane, John Lennon, The Beatles]", result);
	}
	
	@Test
	public void ex5_30() {
		// reducing是一种定制收集器的简便方式
		List<Artist> artists = SampleData.getThreeArtists();
		String result = artists.stream().map(Artist::getName)
										.collect(Collectors.reducing(
												new StringCombiner(", ", "[", "]"),
												name -> new StringCombiner(", ", "[", "]").add(name),
												StringCombiner::merge))
										.toString();
		Assert.assertEquals("[John Coltrane, John Lennon, The Beatles]", result);
	}
	
	@Test
	public void ex5_31() {
	}
	
	public Artist getArtist(String name) {
		Map<String, Artist> artistCache = new HashMap<>();
		
		// ex5_31
//		Artist artist = artistCache.get(name);
//		if (artist == null) {
//			artist = readArtistFromDB(name);
//			artistCache.put(name, artist);
//		}
		
		// ex5_32
		Artist artist = artistCache.computeIfAbsent(name, this::readArtistFromDB);
		return artist;
	}
	
	
	
	private Artist readArtistFromDB(String name) {
		return SampleData.georgeHarrison.getName().equals(name) ? SampleData.georgeHarrison : null;
	}
}