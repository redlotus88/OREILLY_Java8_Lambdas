package cn.stsniper.ch06.exercise;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * The Class SerialToParallel.
 *
 * @author W.Dragon
 * @since 2016-1-24 19:40:13
 */
public class SerialToParallel {

	@Test
	public void ex6_10() {
		IntStream stream = IntStream.range(0, 10);
		long elapsed = System.currentTimeMillis();
		System.out.println("Sequential execution result: " + sequentialSumOfSquares(stream));
		System.out.println("Sequential exectuion time: " + (System.currentTimeMillis() - elapsed) + " ms");
		
		stream = IntStream.range(0, 10);
		elapsed = System.currentTimeMillis();
		System.out.println("Parallel execution result: " + sumOfSquares(stream));
		System.out.println("Parallel execution time: " + (System.currentTimeMillis() - elapsed) + " ms");
	}
	
    public static int sumOfSquares(IntStream range) {
    	return range.parallel().map(x -> x * x)
    						   .sum();
    }

    public static int sequentialSumOfSquares(IntStream range) {
    	return range.map(x -> x * x)
    				.sum();
    }

}
