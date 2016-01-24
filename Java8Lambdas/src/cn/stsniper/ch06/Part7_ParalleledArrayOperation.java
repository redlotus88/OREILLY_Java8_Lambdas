package cn.stsniper.ch06;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * The Class Part7_ParalleledArrayOperation.
 *
 * @author W.Dragon
 * @since 2016-1-24 19:12:23
 */
public class Part7_ParalleledArrayOperation {
	
	// ex6_7
	public static double[] imperativeInitialize(int size) {
		double[] values = new double[size];
		for (int i = 0; i < values.length; i++) {
			values[i] = i;
		}
		return values;
	}
	
	// ex6_8
	public static double[] parallelIntialize(int size) {
		double[] values = new double[size];
		Arrays.parallelSetAll(values, (i) -> i);
		return values;
	}
	
	@Test
	public void ex6_9() {
		Arrays.stream(simpleMovingAverage(parallelIntialize(10), 3)).forEach(System.out::println);
	}
	
	// ex6_9
	public static double[] simpleMovingAverage(double[] values, int n) {
		double[] sums = Arrays.copyOf(values, values.length);
		Arrays.parallelPrefix(sums, Double::sum);
		int start = n - 1;
		return IntStream.range(start, sums.length)
						.mapToDouble(i -> {
							double prefix = i == start ? 0 : sums[i - n];
							return (sums[i] - prefix) / n;
						})
						.toArray();
	}
}
