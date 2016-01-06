package cn.stsniper.ch02;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class Ex03ExampleInLambda {
	
	public static void main(String[] args) {
		
		// No arguments:
		Runnable noArgs = () -> System.out.println("Hello World");
		
		// One argument:
		ActionListener oneArg = event -> System.out.println("button clicked");
		
		// Multi statement
		Runnable multiStatement = () -> {
			System.out.print("Hello");
			System.out.println(" World");
		};
		
		// Binary Operator:
		BinaryOperator<Long> add = (x, y) -> x + y;
		
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
	}
}
