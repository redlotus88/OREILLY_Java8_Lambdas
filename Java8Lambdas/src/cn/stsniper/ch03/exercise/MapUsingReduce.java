package cn.stsniper.ch03.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * The Class MapUsingReduce.
 * 
 * @author W.Dragon
 * @since 2016-1-9 20:14:53
 * @version 0.0.1-SNAPSHOT
 */
public class MapUsingReduce {
	
	public static <T, R> List<R> map(Stream<T> input, Function<T, R> function) {
		return input.sequential().reduce(new ArrayList<R>(), 
				(List<R> list, T element) -> {
					list.add(function.apply(element));
					return list;
				}, 
				(list, list1) -> {return list;});
	}
}
