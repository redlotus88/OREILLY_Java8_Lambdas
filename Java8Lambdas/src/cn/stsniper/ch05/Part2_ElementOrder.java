package cn.stsniper.ch05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * The Class Part2_ElementOrder.
 *
 * @author W.Dragon
 * @since 2016-1-13 21:16:35
 */
public class Part2_ElementOrder {

	@Test
	public void ex5_1() {
		//顺序测试永远通过
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
		Assert.assertEquals(numbers, sameOrder);
	}
	
	@Test
	public void ex5_2() {
		Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 6, 2, 1));
		List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
		
		//该断言有时会失效
		Assert.assertEquals(Arrays.asList(4, 3, 2, 1), sameOrder);
	}
	
	@Test
	public void ex5_3() {
		//生成出现顺序
		Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 2, 1));
		List<Integer> sameOrder = numbers.stream().sorted().collect(Collectors.toList());
		
		Assert.assertEquals(Arrays.asList(1, 2, 3, 4), sameOrder);
	}
	
	@Test
	public void ex5_4() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> stillOrdered = numbers.stream().map(x -> x + 1).collect(Collectors.toList());
		
		//顺序得到了保留
		Assert.assertEquals(Arrays.asList(2, 3, 4, 5), stillOrdered);
		Set<Integer> unordered = new HashSet<>(numbers);
		List<Integer> stillUnordered = unordered.stream().map(x -> x + 1).collect(Collectors.toList());
		
		//顺序得不到保证
		Assert.assertThat(stillUnordered, Matchers.hasItem(2));
		Assert.assertThat(stillUnordered, Matchers.hasItem(3));
		Assert.assertThat(stillUnordered, Matchers.hasItem(4));
		Assert.assertThat(stillUnordered, Matchers.hasItem(5));
	}
}
