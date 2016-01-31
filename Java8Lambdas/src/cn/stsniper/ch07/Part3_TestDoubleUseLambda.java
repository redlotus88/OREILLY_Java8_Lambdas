package cn.stsniper.ch07;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.OrderDomain;

/**
 * The Class Part3_TestDoubleUseLambda.
 * 在测试替身时使用Lambda表达式
 *
 * @author W.Dragon
 * @since 2016-1-30 20:26:21
 */
public class Part3_TestDoubleUseLambda {
	
	@Test
	public void canCountFeatures() {
		OrderDomain order = new OrderDomain(asList(
				newAlbum("Exile on Main st."),
				newAlbum("Beggars Banquet"),
				newAlbum("Aftermath"),
				newAlbum("Let it Bleed")
				));
		Assert.assertEquals(8, order.countFeature(album -> 2));
	}
	
	public static Album newAlbum(String name) {
		return new Album(name, emptyList(), emptyList());
	}
	
	// Ex7-15
	@Test
	public void useMockito() {
		List<String> list = mock(List.class);
		List<String> otherList = Arrays.asList("a", "b", "hello");
		when(list.size()).thenAnswer(inv -> otherList.size());
		Assert.assertEquals(3, list.size());
	}
}
