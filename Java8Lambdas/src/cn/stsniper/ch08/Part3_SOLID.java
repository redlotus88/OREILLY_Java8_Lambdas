package cn.stsniper.ch08;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;


/**
 * The Class Part3_SOLID.
 * 使用Lambda表达式的SOLID原则.
 *
 * @author W.Dragon
 * @since 2016-2-12 15:23:36
 */
public class Part3_SOLID {
	
	@Test
	public void ex8_37() {
		//使用集合流并行计算质数个数的程序
		Assert.assertEquals(25, countPrimes(100000));
	}
	
	public long countPrimes(int upTo) {
		long elapsed = System.currentTimeMillis();
		try {
//			return IntStream.range(2, upTo)
//							.parallel()
//							.filter(this::isPrime)
//							.peek(System.out::println)
//							.count();
			long total = 0;
			for (int i = 1; i < upTo; i++) {
				boolean isPrime = true;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
				
				if (isPrime) {
					total++;
				}
			}
			return total;
		} finally {
			System.out.println("Cost time: " + (System.currentTimeMillis() - elapsed));
		}
	}
	
	private boolean isPrime(int number) {
		return IntStream.range(2, (int) Math.sqrt(number) + 1)
						.allMatch(x -> (number % x) != 0);
	}
	 
}
