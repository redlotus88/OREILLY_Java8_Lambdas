package cn.stsniper.ch04;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * The Class Part3_OverloadResolution.
 * 
 * @author W.Dragon
 * @since 2016-1-10 22:35:05
 * @version 0.0.1-SNAPSHOT
 */
public class Part3_OverloadResolution {

	@Test
	public void ex4_5() {
		overloadedMethod("abc");
	}

	@Test
	public void ex4_7() {
		overloadedMethod((x, y) -> x + y);
	}
	
	@Test
	public void ex4_9() {
		// Compile error
//		overloadedMethod((x) -> true);
		overloadedMethod((long x) -> true);
	}

	// Ex4-6
	private static void overloadedMethod(Object o) {
		System.out.println("Object");
	}

	private static void overloadedMethod(String s) {
		System.out.println("String");
	}
	
	// Ex4-8
	private static void overloadedMethod(BinaryOperator<Integer> lambda) {
		System.out.println("BinaryOperator");
	}

	private static void overloadedMethod(IntegerBiFunction lambda) {
		System.out.println("IntegerBinaryOperator");
	}

	private interface IntegerBiFunction extends BinaryOperator<Integer> {

	}
	
	// Ex4-9
	@FunctionalInterface
	private interface IntPredicate {
		boolean test(long value);
	}
	
	private void overloadedMethod(Predicate<Integer> predicate) {
		System.out.println("Predicate");
	}
	
	private void overloadedMethod(IntPredicate predicate) {
		System.out.println("IntPredicate");
	}
}
