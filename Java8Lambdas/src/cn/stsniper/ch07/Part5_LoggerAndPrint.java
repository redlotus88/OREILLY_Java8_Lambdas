package cn.stsniper.ch07;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.Artist;
import cn.stsniper.bean.SampleData;

/**
 * The Class Part5_LoggerAndPrint.
 * 日志和打印消息
 *
 * @author W.Dragon
 * @since 2016-1-30 20:46:23
 */
public class Part5_LoggerAndPrint {
	
	// Ex7-16 记录中间值，以便调试for循环
	@Test
	public void ex7_16() {
		Album album = SampleData.sampleShortAlbum;
		Set<String> nationalities = new HashSet<>();
		for (Artist artist : album.getMusicianList()) {
			if (artist.getName().startsWith("John")) {
				String nationality = artist.getNationality();
				System.out.println("Found nationality: " + nationality);
				nationalities.add(nationality);
			}
		}
		System.out.println(nationalities);
	}
	
	// Ex7-17 使用forEach记录中间值，这种方式有点幼稚
	@Test
	public void ex7_17() {
		Album album = SampleData.sampleShortAlbum;
		album.getMusicians().filter(artist -> artist.getName().startsWith("John"))
							.map(Artist::getNationality)
							.forEach(nationality -> System.out.println("Found: " + nationality));
		
		Set<String> nationalities = 
				album.getMusicians().filter(artist -> artist.getName().startsWith("The"))
									.map(Artist::getNationality)
									.collect(Collectors.<String> toSet());
		System.out.println(nationalities);
	}
	
	// Ex7-18 使用peek方法记录中间值
	@Test
	public void ex7_18() {
		Album album = SampleData.aLoveSupreme;
		Set<String> nationalities = 
				album.getMusicians().filter(artist -> artist.getName().startsWith("John"))
									.map(artist -> artist.getNationality())
									.peek(nation -> System.out.println("Found nationality: " + nation))
									.collect(Collectors.<String> toSet());
		System.out.println(nationalities);
	}
}
