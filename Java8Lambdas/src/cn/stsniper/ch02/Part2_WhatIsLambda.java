package cn.stsniper.ch02;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * The Class Part2_WhatIsLambda.
 * 
 * @author W.Dragon
 * @since 2016-1-9 16:51:36
 * @version 0.0.1-SNAPSHOT
 */
public class Part2_WhatIsLambda {
	
	public static void main(String[] args) {
		
		//Ex2-3: 编写Lambda表达式的不同形式
		//No arguments:
		Runnable noArgs = () -> System.out.println("Hello World");
		
		//One argument:
		ActionListener oneArg = event -> System.out.println("button clicked");
		
		//Multi statement
		Runnable multiStatement = () -> {
			System.out.print("Hello");
			System.out.println(" World");
		};
		
		//Binary Operator:
		BinaryOperator<Long> add = (x, y) -> x + y;
		
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
	}
}
