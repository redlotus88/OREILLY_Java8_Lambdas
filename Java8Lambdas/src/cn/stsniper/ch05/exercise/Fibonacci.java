package cn.stsniper.ch05.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class Fibonacci.
 *
 * @author W.Dragon
 * @since 2016-1-23 20:27:00
 */
public class Fibonacci {

	private static Map<Integer, Long> cache = new HashMap<>();
	static {
		cache.put(0, 0L);
		cache.put(1, 1L);
		cache.put(2, 1L);
	}
	
    public Fibonacci() {
    }

    public static long fibonacci(int x) {
		long value = cache.computeIfAbsent(x, (number) -> {
        	System.out.println("calculating Fibonacci(" + number + ")");
        	return fibonacci(number - 1) + fibonacci(number - 2);
        });
        cache.putIfAbsent(x, value);
        return value;
    }

}
