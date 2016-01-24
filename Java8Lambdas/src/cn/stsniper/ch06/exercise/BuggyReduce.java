package cn.stsniper.ch06.exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;


public class BuggyReduce {

	@Test
	public void ex6_11() {
		List<Integer> list = new LinkedList<Integer>();
		list = IntStream.range(1, 5).map(i -> i).boxed().collect(Collectors.toList());
		Assert.assertEquals(120, multiplyThrough(list));
	}
	
    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return 5 * linkedListOfNumbers.stream()
        						  	  .parallel()
        						  	  // 并行计算的初值必须是组合函数的恒等值。乘法的恒等值是1
        						  	  .reduce(1, (acc, x) -> x * acc);
    }

}
