package cn.stsniper.ch04;

import java.util.IntSummaryStatistics;

import org.junit.Test;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.SampleData;

/**
 * The Class Part2_PrimaryType.
 * 
 * @author W.Dragon
 * @since 2016-1-10 01:09:57
 * @version 0.0.1-SNAPSHOT
 */
public class Part2_PrimaryType {
	
	@Test
	public void ex4_4() {
		printTrackLengthStatistics(SampleData.aLoveSupreme);
	}
	
	public static void printTrackLengthStatistics(Album album) {
		IntSummaryStatistics trackLengthStats = 
				album.getTracks()
					 .mapToInt(track -> track.getLength())
					 .summaryStatistics();
		System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d", 
							trackLengthStats.getMax(),
							trackLengthStats.getMin(),
							trackLengthStats.getAverage(),
							trackLengthStats.getSum());
	}
}
