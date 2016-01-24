package cn.stsniper.ch05;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

// ex5_25
public class StringCollector implements Collector<String, StringCombiner, String> {
	
	private final String delim;
	private final String prefix;
	private final String suffix;
	
	public StringCollector(String delim, String prefix, String suffix) {
		this.delim = delim;
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	// ex5_26
	@Override
	public Supplier<StringCombiner> supplier() {
		return () -> new StringCombiner(delim, prefix, suffix);
	}

	// ex5_27
	@Override
	public BiConsumer<StringCombiner, String> accumulator() {
		return StringCombiner::add;
	}

	// ex5_28
	@Override
	public BinaryOperator<StringCombiner> combiner() {
		return StringCombiner::merge;
	}

	// ex5_29
	@Override
	public Function<StringCombiner, String> finisher() {
		return StringCombiner::toString;
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return Collections.emptySet();
	}
	
}
