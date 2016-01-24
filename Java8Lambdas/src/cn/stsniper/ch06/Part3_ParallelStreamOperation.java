package cn.stsniper.ch06;

import org.junit.Assert;
import org.junit.Test;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.SampleData;
import cn.stsniper.bean.Track;

/**
 * The Class Part3_ParallelStreamOperation.
 *
 * @author W.Dragon
 * @since 2016-1-24 16:53:14
 */
public class Part3_ParallelStreamOperation {
	
	@Test
	public void ex6_1() {
		Assert.assertEquals(909, serialArraySum());
	}
	
	public int serialArraySum() {
		return SampleData.albums.flatMap(Album::getTracks)
								.mapToInt(Track::getLength)
								.sum();
	}
	
	@Test
	public void ex6_2() {
		Assert.assertEquals(909, parallelArraySum());
	}
	
	public int parallelArraySum() {
		return SampleData.albums.parallel().flatMap(Album::getTracks)
										   .mapToInt(Track::getLength)
										   .sum();
	}
}
