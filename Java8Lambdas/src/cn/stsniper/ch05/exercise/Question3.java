package cn.stsniper.ch05.exercise;

import org.junit.Assert;
import org.junit.Test;


/**
 * The Class Question3.
 *
 * @author W.Dragon
 * @since 2016-1-24 15:50:54
 */
public class Question3 {

	@Test
	public void fibonacci() {
		long elapsed = System.currentTimeMillis();
		long result = Fibonacci.fibonacci(50);
		System.out.println(result);
		System.out.println("执行时间为: " + (System.currentTimeMillis() - elapsed) + "ms");
		Assert.assertEquals(12586269025L, Fibonacci.fibonacci(50));
	}
	
}
