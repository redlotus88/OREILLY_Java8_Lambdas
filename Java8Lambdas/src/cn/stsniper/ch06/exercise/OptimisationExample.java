package cn.stsniper.ch06.exercise;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.log4j.chainsaw.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.RunnerException;


/**
 * Just run this class's main method and it will time benchmarks using the harness
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class OptimisationExample {

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {
                ".*OptimisationExample.*",
                "-wi",
                "10",
                "-i",
                "10",
                "-f",
                "1"
        };
        Main.main(args);
    }

    private List<Integer> linkedListOfNumbers;

    @Setup
    @Before
    public void init() {
        linkedListOfNumbers = new LinkedList<>();
        addNumbers(linkedListOfNumbers);

        // TODO: put any additional setup code here
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
                 .forEach(container::add);
    }

    @GenerateMicroBenchmark
    // BEGIN slowSumOfSquares
    public int slowSumOfSquares() {
        return linkedListOfNumbers.parallelStream()
                                  .map(x -> x * x)
                                  .reduce(0, (acc, x) -> acc + x);
    }
    // END slowSumOfSquares

    @GenerateMicroBenchmark
    public int fastSumOfSquares() {
    	return linkedListOfNumbers.parallelStream()
    							  .mapToInt(x -> x * x)
    							  .sum();
    }
    
    @Test
    public void test6_12() {
    	Assert.assertEquals(slowSumOfSquares(), fastSumOfSquares());
    }

}
