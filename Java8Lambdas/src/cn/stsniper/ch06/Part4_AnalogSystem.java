package cn.stsniper.ch06;

import java.util.Map;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class Part4_AnalogSystem {

	public static final Integer N = 100000000;
	
	@Test
	public void ex6_3() {
		long elapsed = System.currentTimeMillis();
		System.out.println(parallelDiceRolls());
		System.out.println("Execution time: " + (System.currentTimeMillis() - elapsed) + " ms");
	}
	
	public Map<Integer, Double> parallelDiceRolls() {
		return IntStream.range(0, N)
						.parallel()
						.mapToObj(twoDiceThrows())
						.collect(Collectors.groupingBy(side -> side, Collectors.summingDouble(n -> 1.0 / N)));
	}
	
	public IntFunction<Integer> twoDiceThrows() {
		// x是第N次，与方法体无关。
		return (x)-> new Random().nextInt(35) + 2;
	}
	
}
