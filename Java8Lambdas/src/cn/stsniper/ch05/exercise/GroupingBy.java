package cn.stsniper.ch05.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

	private final static Set<Characteristics> characteristics = new HashSet<>();
    static {
        characteristics.add(Characteristics.IDENTITY_FINISH);
    }
	
    private final Function<? super T, ? extends K> classifier;

    public GroupingBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;  
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
//        return (acc, element) -> {
//        	List<T> list = acc.get(classifier.apply(element));
//        	if (list == null) {
//        		list = new ArrayList<>();
//        		acc.put(classifier.apply(element), list);
//        	}
//        	list.add(element);
//        };
    	return (map, element) -> {
            K key = classifier.apply(element);
            List<T> elements = map.computeIfAbsent(key, k -> new ArrayList<>());
            elements.add(element);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
//        return (combiner1, combiner2) -> {
//        	combiner1.putAll(combiner2);
//        	return combiner1;
//        };
    	return (left, right) -> {
            right.forEach((key, value) -> {
                left.merge(key, value, (leftValue, rightValue) -> {
                    leftValue.addAll(rightValue);
                    return leftValue;
                });
            });
            return left;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
    	return (map) -> map;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
