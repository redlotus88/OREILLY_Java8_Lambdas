package cn.stsniper.ch03.exercise;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import cn.stsniper.bean.Artist;
import cn.stsniper.bean.SampleData;

/**
 * The Class Question2.
 * 
 * @author W.Dragon
 * @since 2016-1-9 21:53:29
 * @version 0.0.1-SNAPSHOT
 */
public class Question2 {
	
	// 修改如下代码，将外部迭代变成内部迭代
//	int totalMembers = 0;
//	for (Artist artist : artists) {
//		Stream<Artist> members = artist.getMembers();
//		totalMembers += members.count();
//	}
	
	@Test
	public void test() {
		List<Artist> artists = SampleData.getThreeArtists();
		int totalMembers = artists.stream()
								  .mapToInt(artist -> artist.getMembers()
										  					.collect(Collectors.toList()).size())
								  .reduce((acc, element) -> acc + element)
								  .getAsInt();
		System.out.println("Total member : " + totalMembers);
	}
}
