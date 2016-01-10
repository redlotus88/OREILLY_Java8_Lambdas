package cn.stsniper.ch03.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * The Class FilterUsingReduce.
 * 
 * @author W.Dragon
 * @since 2016-1-9 20:14:53
 * @version 0.0.1-SNAPSHOT
 */
public class FilterUsingReduce {
	
	/**
	 * Filter.
	 *
	 * @param <T> the generic type
	 * @param input the input
	 * @param predicate the predicate
	 * @return the list
	 */
	public static <T> List<T> filter(Stream<T> input, Predicate<T> predicate) {
		return input.sequential().reduce(new ArrayList<T>(), 
				(List<T> list, T element) -> {
					if (predicate.test(element)) {
						list.add(element);
					}
					return list;
				},
				(list, list1) -> { return list; });
	}
}
