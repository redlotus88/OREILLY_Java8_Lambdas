package cn.stsniper.ch02;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * The Class Part5_TypeInference.
 * 
 * @author W.Dragon
 * @since 2016-1-9 16:57:03
 * @version 0.0.1-SNAPSHOT
 */
public class Part5_TypeInference {

	public static void main(String[] args) {
		//Ex2-9
		Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
		Map<String, Integer> diamondWordCounts = new HashMap<>();
		
		//Ex2-10
		//Parameter Type infer.
		useHashMap(new HashMap<>());
		
		//Ex2-11
		Predicate<Integer> atLeast5 = x -> x > 5;
		
		//Ex2-13
		BinaryOperator<Long> addLongs = (x, y) -> x + y;
		
		//Ex2-14
		//Compile error, can't infer type.
		//BinaryOperator addLongs = (x, y) -> x + y;
	}
	
	private static void useHashMap(Map<String, String> values) {
		
	}
}
