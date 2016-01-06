package cn.stsniper.ch02;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Ex10TypeInfer {

	public static void main(String[] args) {
		// Parameter Type infer.
		useHashMap(new HashMap<>());
		
		Predicate<Integer> atLeast5 = x -> x > 5;
		
		BinaryOperator<Long> addLongs = (x, y) -> x + y;
		
		// Compile error, can't infer type.
		//BinaryOperator addLongs = (x, y) -> x + y;
	}
	
	private static void useHashMap(Map<String, String> values) {
		
	}
}
