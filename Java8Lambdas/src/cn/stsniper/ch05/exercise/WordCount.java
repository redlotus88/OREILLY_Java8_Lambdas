package cn.stsniper.ch05.exercise;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
	
public class WordCount {

    public static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(Collectors.groupingBy(String::toString, TreeMap::new,
        				Collectors.mapping(String::toString, Collectors.counting())));
    }

}
