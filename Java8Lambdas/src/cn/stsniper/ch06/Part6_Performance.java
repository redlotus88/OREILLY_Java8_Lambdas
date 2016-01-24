package cn.stsniper.ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;


/**
 * The Class Part6_Performance.
 *
 * @author W.Dragon
 * @since 2016-1-24 18:39:05
 */
public class Part6_Performance {
	
	@Test
	public void ex6_6() {
		Assert.assertEquals(10, addIntegers(Arrays.asList(1, 2, 3, 4)));
	}
	
	@Test
	public void testPerformance() {
		Integer[] numbers = generateInt(10000000);
		
		Collection<Integer> aList = new ArrayList<>();
		CollectionUtils.addAll(aList, numbers);
		Collection<Integer> lList = new LinkedList<>();
		CollectionUtils.addAll(lList, numbers);
		Collection<Integer> set = new HashSet<>();
		CollectionUtils.addAll(set, numbers);
		
		long elapsed = System.currentTimeMillis();
		System.out.println(aList.stream().parallel().mapToInt(i -> i).sum());
		System.out.println("ArrayList cost " + (System.currentTimeMillis() - elapsed) + " ms");
		
		elapsed = System.currentTimeMillis();
		System.out.println(lList.stream().parallel().mapToInt(i -> i).sum());
		System.out.println("LinkedList cost " + (System.currentTimeMillis() - elapsed) + " ms");
		
		elapsed = System.currentTimeMillis();
		System.out.println(set.stream().parallel().mapToInt(i -> i).sum());
		System.out.println("HashSet cost " + (System.currentTimeMillis() - elapsed) + " ms");
	}
	
	private int addIntegers(List<Integer> values) {
		return values.parallelStream()
					 .mapToInt(i -> i)
					 .sum();
	}
	
	private Integer[] generateInt(int number) {
		long elapsed = System.currentTimeMillis();
		try {
			return IntStream.range(0, number).boxed().toArray(Integer[]::new);
		} finally {
			System.out.println("Create int arrays cost " + (System.currentTimeMillis() - elapsed) + " ms");
		}
						
	}
}
