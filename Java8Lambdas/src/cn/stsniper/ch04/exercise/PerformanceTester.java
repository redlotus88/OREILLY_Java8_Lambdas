package cn.stsniper.ch04.exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import cn.stsniper.bean.Artist;
import cn.stsniper.bean.SampleData;

/**
 * The Class PerformanceTester.
 *
 * @author W.Dragon
 * @since 2016-1-11 22:51:14
 */
public class PerformanceTester implements Performance {
	
	@Test
	public void test() {
		Assert.assertEquals("The Beatles;John Lennon;Paul McCartney;George Harrison;Ringo Starr", 
				getAllMusicians().map(Object::toString).collect(Collectors.joining(";")));
		Assert.assertEquals("[The Beatles, John Lennon, Paul McCartney, George Harrison, Ringo Starr]", 
				getAllMusicians().collect(Collectors.toList()).toString());
	}

	@Override
	public String getName() {
		return "Tester";
	}

	@Override
	public Stream<Artist> getMusicians() {
		return Stream.of(SampleData.theBeatles);
	}
}
